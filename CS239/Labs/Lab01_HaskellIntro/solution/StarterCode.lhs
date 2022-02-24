A sample Haskell module for courses at CSB|SJU.

Authors J. Andrew Whitford Holey and Lynn R. Ziegler;
last modified August, 2015.

A function to square a number

>	square n = n * n


A function to double a number

>	double n =  2 * n


A function to compute the maximum of two numbers

>	max2a v1 v2
>	    | v1 > v2	= v1
>	    | otherwise	= v2

Here is another function to compute the maximum of two numbers

>	max2b v1 v2 = if(v1>v2) then v1 else v2


A recursive function to compute the largest common divisor of two integers

>	lcd m 0 = m
>	lcd 0 n = n
>	lcd m n = lcd n (mod m n)


A recursive function to apply a function to a list of arguments

>	applyIt f [] = []
>	applyIt f (x:l) = (f x):(applyIt f l)


A recursive function to apply a list of functions to an argument

>	applyThem [] x = []
>	applyThem (f:l) x = (f x):(applyThem l x)


======================
Lab 1 Part 3 Solutions
======================

A function to raise a number to the fourth power
Author JAWH

>	fourth1 n = square (square n)
>	fourth2 n = square n * square n


A function to raise a number to the eighth power
Author JAWH

>	eighth1 n = square (square (square n))
>	eighth2 n = fourth1 n * fourth2 n


======================
Lab 1 Part 4 Solutions
======================

>	a  = 1	
>	b  = -5
>	c  = 6
>	r1 = (-b + sqrt (square b - 4 * a * c)) / (2 * a)

If square b - 4 * a * c is negative, r1 is NaN (not a number).


=================================
Lab 1 Part 5 Function 1 Solutions
=================================

>	quadpoly a b c x = a * square x + b * x + c

>	poly1 x = quadpoly 3.0 (-25.0) 7.0 x

  *Main> poly1 (-5.0)
  207.0
  *Main> poly1 (-4.0)
  155.0
  *Main> poly1 (-3.0)
  109.0
  *Main> poly1 (-2.0)
  69.0
  *Main> poly1 (-1.0)
  35.0
  *Main> poly1 0.0
  7.0
  *Main> poly1 1.0
  -15.0
  *Main> poly1 2.0
  -31.0
  *Main> poly1 3.0
  -41.0
  *Main> poly1 4.0
  -45.0
  *Main> poly1 5.0
  -43.0

  There is a 0 for poly1 between 0.290 and 0.291.


=================================
Lab 1 Part 5 Function 2 Solutions
=================================

>	cubicpoly a b c d x = a * x^3 + b * x^2 + c * x + d

>	poly2 x = cubicpoly 1.0 0.0 0.0 (-5.359375) x

  *Main> poly2 (-5.0)
  -130.359375
  *Main> poly2 (-4.0)
  -69.359375
  *Main> poly2 (-3.0)
  -32.359375
  *Main> poly2 (-2.0)
  -13.359375
  *Main> poly2 (-1.0)
  -6.359375
  *Main> poly2 0.0
  -5.359375
  *Main> poly2 1.0
  -4.359375
  *Main> poly2 2.0
  2.640625
  *Main> poly2 3.0
  21.640625
  *Main> poly2 4.0
  58.640625
  *Main> poly2 5.0
  119.640625

  There is 0 for poly2 at exactly 1.75


=================================
Lab 1 Part 5 Function 3 Solutions
=================================

  Either of the following versions of triangle:

>	triangle a b c
>	  | (a == b) && (b == c)             = "Equilateral"
>	  | (a == b) || (a == c) || (b == c) = "Isoceles"
>	  | otherwise                        = "Scalene"

	triangle a b c =
	  if (a == b) && (b == c)                  then "Equilateral"
	  else if (a == b) || (a == c) || (b == c) then "Isoceles"
	  else						                              "Scalene"

