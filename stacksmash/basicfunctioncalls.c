#include <stdio.h>

void shuffle(int a, int b, int c, int d)
{
  int temp = a;

  a = b;
  b = c;
  c = d;
  d = temp;
}

int scramble(int x, int y)
{
  shuffle(x+1, y+1, x, y);
  return x + y;
}

int main()
{
  int firstInput, secondInput;
  scanf("%d", &firstInput);
  scanf("%d", &secondInput);

  int z = scramble(firstInput, secondInput);
  printf("Result: %d\n", z);
}
