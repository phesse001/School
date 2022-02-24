#include <stdio.h>
#include <stdlib.h>

int main()
{
  /*
First, s1 is declared to be of type “char *”. Then s1 is set to point at the literal string "Hello". This
literal string is part of the program code; it can’t be changed. The assignment simply sets s1 to point to this
constant string. You can read from this memory, hence print out the string, but not write to it.
Second, s2 is declared to be an array of 80 chars.
Third, s3 is declared to be of type “char *”, but then we malloc() 80 bytes of memory, and set s3 to
point to it.
The only practical difference between s2 and s3 is than s2’s memory is on the stack, whereas s3’s memory
is on the heap. If we wanted to, we could subsequently re-assign pointer s3 to point to some other memory,
but we can’t do this with s2 because of the way it’s declared.
  */
  char *s1;
  char s2[80];
  char *s3;
  s1 = "Hello";
  s3 = malloc(80);
  printf("Enter fleem:\n");
  fgets(s2, 80, stdin);
  printf("Enter fleem:\n");
  fgets(s3, 80, stdin);
  printf("%s %s %s\n", s1, s2, s3);

 if(*s2 == *s3)
 {
   printf("poop stink!\n");
 }
 else
 {
   printf("no poop stink\n");
 }
  free(s3);
}
