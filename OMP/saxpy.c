/* EXIT_SUCCESS, rand */
#include <stdlib.h>

/* strtol */
#include <stdio.h>

#include <omp.h>

int
main(int argc, char *argv[]) {
  /* Get array size from command line */
  int n = strtol(argv[1], NULL, 10);

  /* Allocate memory */
  double * const x = malloc(n * sizeof(*x));
  double * const y = malloc(n * sizeof(*y));

  /* Populate with random values */
  double const a = rand();
  for (int i = 0; i < n; i++) {
    x[i] = rand();
    y[i] = rand();
  }

double const ts = omp_get_wtime();
# pragma omp parallel num_threads(4)
{
  #pragma omp for
  /* Compute y = a * x + y */
  for (int i = 0; i < n; i++) {
    y[i] = a * x[i] + y[i];
  }
}
double const te = omp_get_wtime();
printf("elapsed time %lf\n",te-ts);
  /* Free memory */
  free(x);
  free(y);

  return EXIT_SUCCESS;
}
