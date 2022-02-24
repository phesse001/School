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

/* OpenMP API */
#include <omp.h>

/* printf, fopen, fclose, fscanf, scanf */
#include <stdio.h>

/* EXIT_SUCCESS, malloc, calloc, free, qsort */
#include <stdlib.h>

#include <mpi.h>

#define MPI_SIZE_T MPI_UNSIGNED_LONG

struct distance_metric {
  size_t viewer_id;
  double distance;
};

int
main(int argc, char * argv[]) {
  size_t n, m;
  int ret, p, rank;
  int * sc;
  int * dis;
  double * rating;

  /* Initialize MPI environment. */
  ret = MPI_Init(&argc, &argv);
  assert(MPI_SUCCESS == ret);

  /* Get size of world communicator. */
  ret = MPI_Comm_size(MPI_COMM_WORLD, &p);
  assert(ret == MPI_SUCCESS);

  /* Get my rank. */
  ret = MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  assert(ret == MPI_SUCCESS);

  /* Validate command line arguments. */
  assert(2 == argc);
  if(0 == rank)
  {
  /* ... */
  char const * const fn = argv[1];

  /* Validate input. */
  assert(fn);

  /* Open file. */
  FILE * const fp = fopen(fn, "r");
  assert(fp);

  /* Read file. */
  fscanf(fp, "%zu %zu", &n, &m);

  /* Allocate memory. */
  rating = malloc(n * m * sizeof(*rating));

  /* Check for success. */
  assert(rating);

  for (size_t i = 0; i < n; i++) {
    for (size_t j = 0; j < m; j++) {
      fscanf(fp, "%lf", &rating[i * m + j]);
    }
  }

  /* Close file. */
  int const ret = fclose(fp);
  assert(!ret);

}
  //send out n and m
  ret = MPI_Bcast(&n, 1, MPI_SIZE_T, 0, MPI_COMM_WORLD);
  assert(MPI_SUCCESS == ret);
  ret = MPI_Bcast(&m, 1, MPI_SIZE_T, 0, MPI_COMM_WORLD);
  assert(MPI_SUCCESS == ret);

  //send rating to each process

  /* Compute base number of viewers. */
  size_t const base = 1 + ((n - 1) / p); // ceil(n / p)

  /* Compute local number of viewers. */
  size_t const ln = (rank + 1) * base > n ? n - rank * base : base;

  if(0 != rank)
  {
    rating = malloc(ln * m * sizeof(*rating));
    assert(rating);
  }

  if(0 == rank)
  {
    sc = malloc(p * sizeof(*sc));
    assert(sc);

    dis = malloc(p * sizeof(*dis));
    assert(dis);

    for (int r = 0; r < p; r++) {
      size_t rn = (r + 1) * base > n ? n - r * base : base;
      dis[r] = r * base * m;
      sc[r] = m * rn;
    }
  }

    ret = MPI_Scatterv(rating, sc, dis, MPI_DOUBLE, rating, base * m, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    assert(MPI_SUCCESS == ret);
    if(0 == rank)
    {
      free(sc);
      free(dis);
    }

  /* Allocate more memory. */
  double * const urating = malloc((m-1) * sizeof(*urating));

  /* Check for success. */
  assert(urating);

  if(0 == rank)
  {
  /* Get user input. */
  for (size_t j = 0; j < m - 1; j++) {
    printf("Enter your rating for movie %zu: ", j + 1);
    scanf("%lf", &urating[j]);
  }
  }
  ret = MPI_Bcast(urating, m-1, MPI_DOUBLE, 0, MPI_COMM_WORLD);
  assert(MPI_SUCCESS == ret);

  double const ts = omp_get_wtime();

  /* Allocate more memory. */
  //double prob[10] = { 0.0 };
  double * prob = malloc(ln * sizeof(*prob));

  /* Compute probabilities */
  for (int k = 0; k < 10; k++) {
    size_t sum = 0;
    for (size_t i = 0; i < ln; i++) {
      sum += (rating[i * m + 4] == k / 2.0);
    }
    prob[k] = sum;
  }

  //gather results...
  int * rcounts;
  int * rdis;
  double * all_prob;

  if(0 == rank)
  {
    rcounts = malloc(p * sizeof(*rcounts));
    assert(rcounts);
    rdis = malloc(p * sizeof(*rdis));
    assert(rdis);
    all_prob = malloc(10 * sizeof(*all_prob));
    assert(all_prob);

    for (int r = 0; r < p; r++) {
      size_t rn = (r + 1) * base > n ? n - r * base : base;
      rcounts[r] = rn;
      rdis[r] = r * base;
    }
  }

    ret = MPI_Gatherv(prob, ln, MPI_DOUBLE, all_prob, rcounts, rdis, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    assert(MPI_SUCCESS == ret);

    if(rank == 0)
    {
      free(rcounts);
      free(rdis);
    }

  /* Allocate more memory. */
  double * const cprob = calloc((m - 1) * 10, sizeof(*cprob));

  /* Check for success. */
  assert(cprob);

  /* Compute conditional probabilities. */
  for (size_t j = 0; j < m - 1; j++) {
    for (int k = 0; k < 10; k++) {
      size_t sum = 0;
      for (size_t i = 0; i < ln; i++) {
        sum += (urating[j] == rating[i * m + j] && rating[i * m + 4] == (k + 1) / 2.0);
      }
      cprob[j * 10 + k] = sum;
    }
  }

  /* Finalize computation of conditional probabilities. */
  for (size_t j = 0; j < m - 1; j++) {
    for (int k = 0; k < 10; k++) {
      cprob[j * 10 + k] /= prob[k];
    }
  }

  /* Finalize computation of probabilities. */
  for (int k = 0; k < 10; k++) {
    prob[k] /= n;
  }

#if 0
  for (int k = 0; k < 10; k++) {
    printf("prob[%d] = %lf\n", k, prob[k]);
  }
  for (size_t j = 0; j < m - 1; j++) {
    for (int k = 0; k < 10; k++) {
      printf("cprob[%zu | %.1lf] = %lf\n", j, (k + 1) / 2.0, cprob[j * 10 + k]);
    }
  }
#endif

  /* Allocate more memory. */
  double pred[10] = { 0.0 };

  /* Compute predictions. */
  for (int k = 0; k < 10; k++) {
    pred[k] = prob[k];
    for (size_t j = 0; j < m - 1; j++) {
      pred[k] *= cprob[j * 10 + k];
    }
  }

#if 0
  for (int k = 0; k < 10; k++) {
    printf("pred[%d] = %lf\n", k, pred[k]);
  }
#endif

  /* Compute maximum prediction. */
  double maxpred = isnan(pred[0]) ? 0.0 : pred[0];
  double maxrat  = 0.0;
  for (int k = 1; k < 10; k++) {
    if (pred[k] > maxpred && !isnan(pred[k])) {
      maxpred = pred[k];
      maxrat  = (k + 1) / 2.0;
    }
  }

  double const te = omp_get_wtime();

  /* Output elapsed time. */
  printf("It took %fs to compute the prediction.\n", te - ts);

  /* Output prediction. */
  printf("The predicted rating for movie five is %.1lf.\n", maxrat);

  /* Deallocate memory. */
  free(rating);
  free(urating);
  free(cprob);
  ret = MPI_Finalize();
  assert(MPI_SUCCESS == ret);
  return EXIT_SUCCESS;
}
