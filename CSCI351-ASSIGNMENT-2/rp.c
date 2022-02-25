/*
Copyright (c) 2016-2020 Jeremy Iverson

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

/* assert */
#include <assert.h>

/* fabs */
#include <math.h>

/* printf, fopen, fclose, fscanf, scanf */
#include <stdio.h>

/* EXIT_SUCCESS, malloc, calloc, free, qsort */
#include <stdlib.h>

struct distance_metric {
  size_t viewer_id;
  double distance;
};

int
main(int argc, char * argv[])
{
  size_t n, m;

  /* Validate command line arguments. */
  assert(2 == argc);

  /* ... */
  char const * const fn = argv[1];

  /* Validate input. */
  assert(fn);

  /* Open file. */
  FILE * const fp = fopen(fn, "r");
  assert(fp);

  /* Read file. */
  fscanf(fp, "%zu %zu", &m, &n);

  /* Allocate memory. */
  double * const rating = malloc(n * m * sizeof(*rating));

  /* Check for success. */
  assert(rating);

  for (size_t i = 0; i < m; i++) {
    for (size_t j = 0; j < n; j++) {
      fscanf(fp, "%lf", &rating[i * n + j]);
    }
  }

  /* Close file. */
  int const ret = fclose(fp);
  assert(!ret);

  /* Allocate more memory. */
  double * const urating = malloc(n * sizeof(*urating));

  /* Check for success. */
  assert(urating);

  /* Get user input. */
  for (size_t j = 0; j < n - 1; j++) {
    printf("Enter your rating for movie %zu: ", j + 1);
    scanf("%lf", &urating[j]);
  }

  /* Allocate more memory. */
  double prob[10] = { 0.0 };

  /* Compute probabilities that the fifth movie is .5, 1, 1.5... for a viewer*/
  for (int k = 0; k < 10; k++) {
    for (size_t i = 0; i < m; i++) {
      //rating[i * n + 4] checks the fifth rating for each viewer,
      //sees if it is equal to .5, 1, 1.5,...
      prob[k] += (rating[i * n + 4] == (k + 1) / 2.0);
    }
  }

  /* Finalize computation of probabilities. */
  for (int k = 0; k < 10; k++) {
    prob[k] /= m;
  }

  int index = 0;
  double *prob_totals = malloc((n-1)*m*sizeof(*prob_totals));
  int *rating_totals = malloc(10*sizeof(*rating_totals));
  double count = 0;

  for(size_t j = 0; j < n-1; j++)
  {
    for(size_t l = 0; l < 10; l++)
    {
      count = 0;
    for(size_t i = 0; i < m; i++)
    {
      if(urating[j] == rating[i*n + j] && rating[(i*n) + 4] == (l + 1) / 2.0)
      {
        count += 1;
      }
    }
    prob_totals[index] = count;
    index += 1;
  }
  }

  for(size_t j = 0; j < 10; j++)
  {
    int total = 0;
    for(size_t i = 0; i < m; i++)
    {
      //movie 5
      if(rating[i*5 + 4] == (j + 1) / 2.0)
      {
        total += 1;
      }
    }
    rating_totals[j] = total;
  }

  //finalize probs
  int z = 0;
  for (int k = 0; k < 40; k++) {
    if(z == 10)
    {
      z = 0;
    }
    prob_totals[k] /= rating_totals[z];
    z += 1;
  }


  double *predictions = malloc(10*sizeof(*predictions));
  double prediction = 0.0;
  for(size_t i = 0; i < 10; i++)
  {
    prediction = prob[i] * prob_totals[i] * prob_totals[i+10] * prob_totals[i+20] *prob_totals[i+30];
    predictions[i] = prediction;
    prediction = 0.0;
  }


  int max = 0;
  for (int k = 1; k < 10; k++) {
    if(predictions[k] > predictions[max])
    {
      max = k;
    }
    //printf("prediction[%d] = %lf\n", k, predictions[k]);
  }

  /* Output prediction. */
  printf("The predicted rating for movie five is %.1lf\n", (max + 1) / 2.0);

  /* Deallocate memory. */
  free(rating);
  free(urating);

  return EXIT_SUCCESS;
}
