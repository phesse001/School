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
#define FFLAG (O_WRONLY | O_CREAT | O_TRUNC)
#define FMODE (S_IRUSR | S_IWUSR)
#define PROMPT_STRING "ush2>>"
#define QUIT_STRING "q"
#define BLANK_STRING " "

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

void executecmd(char *incmd) {
	char **chargv;
	if (parseandredirectout(incmd) == -1)
		perror("Failed to redirect output");
	else if (parseandredirectin(incmd) == -1)
		perror("Failed to redirect input");
	else if (makeargv(incmd, " \t", &chargv) <= 0)
		fprintf(stderr, "Failed to parse command line\n");
	else {
		execvp(chargv[0], chargv);
		perror("Failed to execute command");
	}
	exit(1);
}

int main (void) {
	pid_t childpid;
	char inbuf[MAX_CANON];
	int len;

	for( ; ; ) {
		if (fputs(PROMPT_STRING, stdout) == EOF)
			continue;
		if (fgets(inbuf, MAX_CANON, stdin) == NULL)
			continue;
		len = strlen(inbuf);
		if (inbuf[len - 1] == '\n')
			inbuf[len - 1] = 0;
		if (strcmp(inbuf, QUIT_STRING) == 0)
			break;
		if ((childpid = fork()) == -1)
			perror("Failed to fork child");
		else if (childpid == 0) {
			executecmd(inbuf);
			return 1;
		} else
		wait(NULL);
	}
	return 0;
}