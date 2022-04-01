#include <stdio.h>
#include <string.h>

void unused()
{
  printf("You can't get here!\n");
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
  char name[20];

  printf("Enter your name: ");
  readstr(name);
  printf("The length of your name is: %lu\n", strlen(name));
  printf("Your name is: %s\n", name);
}
