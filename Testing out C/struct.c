#include <stdio.h>
#include <stdlib.h>
#define MAXLEN 80

struct element
{
  //data structure that holds a value and a pointer to the next element
  int value;
  struct element *next;
};

int main()
{
  struct element *head = NULL;
  struct element *p;

  while(1)
  {
    int number;
    char buffer[MAXLEN];
    struct element *new_element;
    printf("Enter an integer: ");
    fgets(buffer,MAXLEN,stdin);

    if(feof(stdin))
    {
      printf("Finished \n");
      break;
    }
    number = atoi(buffer);
    new_element = malloc(sizeof(struct element));
    new_element->value = number;
    //sets next to null and sets head(first element) to this "new element"
    new_element->next = head;
    head = new_element;
  }

  p = head;
  while(p != NULL)
  {
    printf("Value: %d\n",p->value);
    p = p->next;
  }
}
