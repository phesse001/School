#include <limits.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#define PROMPT_STRING "ush2>>"
#define QUIT_STRING "q"
#define CHDIR "cd"
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

void executecmd(char *incmd)
{
	char **chargv;
	if (makeargv(incmd, BLANK_STRING, &chargv) <= 0) {
		fprintf(stderr, "Failed to parse command line\n");
		exit(1);
	}
	execvp(chargv[0], chargv);
	perror("Failed to execute command");
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
		char cd[2] = "";
		int i;
		for(i = 0; i < 2; i++)
		{
			strcat(cd, inbuf[i]);
		}
		if(strcmp(cd, CHDIR) == 0)
		{
			char path[100] = "";
			// create path to change to
			for(i = 2; i < len; i++)
			{
				strcat(path, inbuf[i]);
			}
			printf("%s\n", path);
		}
		if ((childpid = fork()) == -1)
			perror("Failed to fork child");
		else if (childpid == 0) {
			executecmd(inbuf);
			return 1;
		} 
		else
		{
			wait(NULL);
		}
	}
	return 0;
}