#include <errno.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <limits.h>
#include <signal.h>
#include <setjmp.h>
#define FFLAG (O_WRONLY | O_CREAT | O_TRUNC)
#define FMODE (S_IRUSR | S_IWUSR)
#define QUIT_STRING "q"
#define CHDIR "cd"
#define BLANK_STRING " "

char PROMPT_STRING[100] = "";

int makeargv(const char *s, const char *delimiters, char ***argvp) {
	int error;
	int i;
	int numtokens;
	const char *snew;
	char *t;
	if ((s == NULL) || (delimiters == NULL) || (argvp == NULL)) {
		errno = EINVAL;
		return -1;
	}
	*argvp = NULL;
	snew = s + strspn(s, delimiters);
	/* snew is real start of string */
	if ((t = malloc(strlen(snew) + 1)) == NULL)
		return -1;
	strcpy(t, snew);
	numtokens = 0;
	if (strtok(t, delimiters) != NULL)
		/* count the number of tokens in s */
		for (numtokens = 1; strtok(NULL, delimiters) != NULL; numtokens++) ;
		/* create argument array for ptrs to the tokens */
	if ((*argvp = malloc((numtokens + 1)*sizeof(char *))) == NULL) {
		error = errno;
		free(t);
		errno = error;
		return -1;
	}
	/* insert pointers to tokens into the argument array */
	if (numtokens == 0)
		free(t);
	else {
		strcpy(t, snew);
		**argvp = strtok(t, delimiters);
		for (i = 1; i < numtokens; i++)
			*((*argvp) + i) = strtok(NULL, delimiters);
	}
	*((*argvp) + numtokens) = NULL;
	/* put in final NULL pointer */
	return numtokens;
}

int parseandredirectin(char *cmd) {
	int error;
	int infd;
	char *infile;
	/* redirect standard input if '<' */
	if ((infile = strchr(cmd, '<')) == NULL)
		return 0;
	*infile = 0;
	/* take everything after '<' out of cmd */
	infile = strtok(infile + 1, " \t");
	if (infile == NULL)
		return 0;
	if ((infd = open(infile, O_RDONLY)) == -1)
		return -1;
	if (dup2(infd, STDIN_FILENO) == -1) {
		error = errno;
		/* make sure errno is correct */
		close(infd);
		errno = error;
		return -1;
	}
	return close(infd);
}

int parseandredirectout(char *cmd) {
	int error;
	int outfd;
	char *outfile;
	/* redirect standard output if '>' */
	if ((outfile = strchr(cmd, '>')) == NULL)
		return 0;
	*outfile = 0;
	/* take everything after '>' out of cmd */
	outfile = strtok(outfile + 1, " \t");
	if (outfile == NULL)
		return 0;
	if ((outfd = open(outfile, FFLAG, FMODE)) == -1)
		return -1;
	if (dup2(outfd, STDOUT_FILENO) == -1) {
		error = errno;
		/* make sure errno is correct */
		close(outfd);
		errno = error;
		return -1;
	}
	return close(outfd);
}

void executeredirect(char *s, int in, int out)
{
	char **chargv;
	char *pin;
	char *pout;

	if (in && ((pin = strchr(s, '<')) != NULL) && out && ((pout = strchr(s, '>')) != NULL) && (pin > pout) ) {
		if (parseandredirectin(s) == -1) { /* redirect input is last on line */
			perror("Failed to redirect input");
			return;
		}
		in = 0;
	}
	if (out && (parseandredirectout(s) == -1))
		perror("Failed to redirect output");
	else if (in && (parseandredirectin(s) == -1))
		perror("Failed to redirect input");
	else if (makeargv(s, " \t", &chargv) <= 0)
		fprintf(stderr,"Failed to parse command line\n");
	else {
		execvp(chargv[0], chargv);
		perror("Failed to execute command");
	}
	exit(1);
}


static void perror_exit(char *s) {
	perror(s);
	exit(1);
}

static void set_prompt()
{
	char buf[100];
	getcwd(buf,100);

	//first clear prompt
	memset(PROMPT_STRING,0,strlen(PROMPT_STRING));
	strcat(PROMPT_STRING,"[ ");
	strcat(PROMPT_STRING, buf);
	strcat(PROMPT_STRING, " ]");
	strcat(PROMPT_STRING, " > ");
}


void executecmd(char *cmds) {
	int child;
	int count;
	int fds[2];int i;
	char **pipelist;

	count = makeargv(cmds, "|", &pipelist);
	if (count <= 0) {
		fprintf(stderr, "Failed to find any commands\n");
		exit(1);
	}
	for (i = 0; i < count - 1; i++) {
		/* handle all but last*/
		if (pipe(fds) == -1)
			perror_exit("Failed to create pipes");
		else if ((child = fork()) == -1)
			perror_exit("Failed to create process to run command");
		else if (child) {
			if (dup2(fds[1], STDOUT_FILENO) == -1)
				perror_exit("Failed to connect pipeline");
			if (close(fds[0]) || close(fds[1]))
				perror_exit("Failed to close needed files");
			executeredirect(pipelist[i], i==0, 0);
			exit(1);
		}
		if (dup2(fds[0], STDIN_FILENO) == -1)
			perror_exit("Failed to connect last component");
		if (close(fds[0]) || close(fds[1]))
			perror_exit("Failed to do final close");
	}
	executeredirect(pipelist[i], i==0, 1);
	//set_prompt();
	/* handle the last */
	exit(1);
}

int signalsetup(struct sigaction *def, sigset_t *mask, void (*handler)(int)) {
	struct sigaction catch;

	catch.sa_handler = handler; /* Set up signal structures */
	def->sa_handler = SIG_DFL;
	catch.sa_flags = 0;
	def->sa_flags = 0;
	if ((sigemptyset(&(def->sa_mask)) == -1) ||
		(sigemptyset(&(catch.sa_mask)) == -1) ||
		(sigaddset(&(catch.sa_mask), SIGINT) == -1) ||
		(sigaddset(&(catch.sa_mask), SIGQUIT) == -1) ||
		(sigaction(SIGINT, &catch, NULL) == -1) ||
		(sigaction(SIGQUIT, &catch, NULL) == -1) ||
		(sigemptyset(mask) == -1) ||
		(sigaddset(mask, SIGINT) == -1) ||
		(sigaddset(mask, SIGQUIT) == -1))
	{
		return -1;
	}
	return 0;
}

static sigjmp_buf jumptoprompt;
static volatile sig_atomic_t okaytojump = 0;

/* ARGSUSED */
static void jumphd(int signalnum) {
	if (!okaytojump) return;
	okaytojump = 0;
	siglongjmp(jumptoprompt, 1);
}
int main (void) {
	set_prompt();
	sigset_t blockmask;
	pid_t childpid;
	struct sigaction defhandler;
	int len;
	char inbuf[MAX_CANON];
	if (signalsetup(&defhandler, &blockmask, jumphd) == -1) {
		perror("Failed to set up shell signal handling");return 1;
	}
	for( ; ; ) {
		if ((sigsetjmp(jumptoprompt, 1)) && (fputs("\n", stdout) == EOF) )
			continue;
		wait(NULL);
		okaytojump = 1;
		if (fputs(PROMPT_STRING, stdout) == EOF)
			continue;
		if (fgets(inbuf, MAX_CANON, stdin) == NULL)
			continue;
		len = strlen(inbuf);
		if (inbuf[len - 1] == '\n')
			inbuf[len - 1] = 0;
		if (strcmp(inbuf, QUIT_STRING) == 0)
			break;
		char cd[2] = "";
		int i;
		for(i = 0; i < 2; i++)
		{
			char tmp[2];
			tmp[0] = inbuf[i];
			tmp[1] = '\0';
			strcat(cd, tmp);
		}
		if(strcmp(cd, CHDIR) == 0)
		{
			char path[100] = "";
			// create path to change to
			for(i = 3; i < len; i++)
			{
				char tmp[2];
				tmp[0] = inbuf[i];
				tmp[1] = '\0';
				strcat(path, tmp);
			}
			//printf("%s\n", path);
			chdir(path);
			set_prompt();
			continue;
		}
		if (sigprocmask(SIG_BLOCK, &blockmask, NULL) == -1)
			perror("Failed to block signals");
		if ((childpid = fork()) == -1)
			perror("Failed to fork");
		else if (childpid == 0) {
			if ((sigaction(SIGINT, &defhandler, NULL) == -1) ||
				(sigaction(SIGQUIT, &defhandler, NULL) == -1) ||
				(sigprocmask(SIG_UNBLOCK, &blockmask, NULL) == -1)) {
				perror("Failed to set signal handling for command ");
				return 1;
			}
			executecmd(inbuf);
			return 1;
		}
		if (sigprocmask(SIG_UNBLOCK, &blockmask, NULL) == -1)
			perror("Failed to unblock signals");
	}
	return 0;
}