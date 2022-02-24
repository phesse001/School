/* EXIT_SUCCESS, rand */
#include <stdlib.h>

/* strtol */
#include <stdio.h>

/* memcpy */
#include <string.h>

#include <omp.h>

int
main(int argc, char *argv[]) {
  /* Get array size from command line */
  int n = strtol(argv[1], NULL, 10);

  /* Allocate memory */
  double * const a = malloc(n * sizeof(*a));
  double * const b = malloc(n * sizeof(*b));
  double * const c = malloc(n * sizeof(*c));

  /* Populate with random values */
  for (int i = 0; i < n; i++) {
    a[i] = rand();
  }

  /* Copy a into b */
  memcpy(b, a, n * sizeof(*a));
  memcpy(c, a, n * sizeof(*a));


  /* Find minimum (the sane way) */
  for (int i = 0; i < n; i++) {
    if (a[i] < a[0]) {
      a[0] = a[i];
    }
  }

  /* Find minimum (the other way) */

  for (int i = 1; i < n; i *= 2) {
#   pragma omp parallel for num_threads(4)
    for (int j = 0; j < n; j += 2 * i) {
      if (j + i < n && b[j + i] < b[j]) {
        b[j] = b[j + i];
      }
    }
  }

  //the omp way
  double m = c[0];
  // min is the operator
  #pragma omp parallel for reduction(min:m)
  for (int i = 0; i < n; i++) {
    if (c[i] < m) {
      m = c[i];
    }
  }

  printf("minimum the sane way is %lf\n", a[0]);
  printf("minimum the other way is %lf\n", b[0]);
  printf("minimum the omp way is %lf\n", m);

  /* Free memory */
  free(a);
  free(b);

  return EXIT_SUCCESS;
}
