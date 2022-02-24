/* omp_get_thread_num */
#if defined(_OPENMP)
#include <omp.h>
#endif

/* EXIT_SUCCESS */
#include <stdlib.h>

/* strtol */
#include <stdio.h>

int
main(int argc, char *argv[]) {
  /* Get number of threads from command line */
  int thread_count = strtol(argv[1], NULL, 10);

# pragma omp parallel num_threads(thread_count)
  {
    #if defined(_OPENMP)
    int my_rank = omp_get_thread_num();

    printf("Hello from thread %d of %d\n", my_rank, thread_count);
    #else
    int my_rank = 0;

    printf("Hello from thread %d of %d\n", my_rank, 1);
    #endif
  }

  return EXIT_SUCCESS;
}
