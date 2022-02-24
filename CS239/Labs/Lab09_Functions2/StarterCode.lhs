> module StarterCode where

Recurrence relation F(n)

> relF 1 = 5
> relF n =(relF (n-1)) + 3*n - 2

Recurrence relation G(n)

> relG 0 = 3
> relG n = (relG (n-1)) + 2*n + 4

Recurrence relation H(n)

> relH 0 = 2
> relH n = (relH (n-1)) + 3 * n^2 - 4*n +1

Recurrence relation J(n)

> relJ 1 = 1
> relJ n = (relJ (n-1)) +n^2 - 2*n +1

Recurrence relation L(n)

> relL 1 = 1
> relL n = 2 * (relL (div n 2)) + n

Recurrence relation Q(n)

> relQ 0 = 0
> relQ n = (relQ (n-1)) + n^3

Recurrence relation T(n)

> relT 1 = 1
> relT n = 2* (relT (n-1)) + 1
