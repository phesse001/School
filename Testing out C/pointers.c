#include <stdio.h>
#include <stdlib.h>

int main()
{
  int x = 0;
  int *p;
  p = &x;
  int *p2;
  p2 = &x;
  *p2 = 69;

  printf("The address of x is %d\n", p);
  printf("x is %d\n", *p);

  char word[5] = "hello";
  char *test = word;
  printf("test ascii: %d\n",*test);
  printf("test word: %s\n",test);
  printf("test address: %d\n", &test);
  printf("%s\n",word);
}
