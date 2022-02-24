#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct distance_metric{
  size_t viewer_id;
  double distance;
};

static int cmp(void const *ap, void const *bp)
{
  struct distance_metric const a = *(struct distance_metric*)ap;
  struct distance_metric const b = *(struct distance_metric*)bp;

  return a.distance < b.distance ? -1 : 1;
}

void run(char f[], int k_similar)
{
  FILE * const fptr = fopen(f, "r");
  if(fptr == NULL)
  {
    printf("Cannot open file\n");
    exit(0);
  }
  unsigned rows,cols;
  //read two unsigned ints
  fscanf(fptr, "%u %u",&rows,&cols);
  printf("%u %u\n", rows, cols);
  double *arr1 = malloc(rows*cols*sizeof(double));
  double *inputs = malloc(cols*sizeof(double));
  for (size_t j = 0; j < cols; j++)
  {
    printf("Enter your rating for movie %d: ", j + 1);
    scanf("%lf", &inputs[j]);
  }
  //transforms 2d array to 1d array, reads corresponding elements into array
  for(size_t i = 0; i < rows*cols; i++)
  {
    fscanf(fptr, "%lf", &arr1[i]);
  }
  fclose(fptr);
  #if 0
  double mdarray[rows];
  for(size_t i = 0; i < rows; i++)
  {
    double md = 0;
    for(size_t j = 0; j < cols; j++)
    {
      md += fabs(inputs[j] - arr1[i*cols+j]);
    }
    mdarray[i] = md;
    md = 0;
  }

  double smallest = mdarray[0];
  int index=1;
  for(size_t i = 1; i < rows; i++)
  {
    if(mdarray[i] < smallest)
    {
      smallest = mdarray[i];
      index = i+1;
    }
  }
  printf("\nThe most similar viewer was %d and the distance calculated was %lf\n",index,smallest);
  int offset = 5 *index;
  printf("\nThe predicted rating for movie 5 is %lf\n",arr1[offset]);
  #endif
  //qsort implementation using struct
  //create new array to hold each struct
  struct distance_metric * const mdarray2 = malloc(rows*sizeof(*mdarray2));
  for(size_t i = 0; i < rows; i++)
  {
    mdarray2[i].viewer_id = i;
    for(size_t j = 0; j < cols; j++)
    {
      mdarray2[i].distance += fabs(inputs[j] - arr1[i*cols+j]);
    }
  }

  qsort(mdarray2,rows,sizeof(*mdarray2),cmp);

  printf("Viewer ID  Movie Five  Distance\n---------------------------------");

  //output k k_similar
  double sum = 0;
  for(size_t i = 0; i < k_similar; i++)
  {
    sum += arr1[mdarray2[i].viewer_id * 5];
    printf("\n       %d     %.1lf        %.1lf\n",mdarray2[i].viewer_id+1,arr1[mdarray2[i].viewer_id * 5],mdarray2[i].distance);
  }
  printf("---------------------------------\n");
  printf("The predicted rating for movie five is %.1lf\n",sum/k_similar);

  free(arr1);
  free(inputs);
  free(mdarray2);
}


int main(int argc, char *argv[])
{
  char *file = argv[1];
  int num_sim_viewers = atoi(argv[2]);
  run(file,num_sim_viewers);
}
