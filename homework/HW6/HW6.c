#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void step1()
{
  printf("Completed step 1!\n");
}

void step2()
{
  printf("Completed step 2!\n");
}

int readstr(char* buf)
{
  // as below, plenty big buffer
  char read_name[20];
  gets(read_name);
  strcpy(buf, read_name);
  return 0;
}

int main()
{
  // 20 characters should be long enough for a name...
  char* name = malloc(20 * sizeof(char));

  printf("Enter your name: ");
  readstr(name);
  printf("The length of your name is: %lu\n", strlen(name));
  printf("Your name is: %s\n", name);
}
