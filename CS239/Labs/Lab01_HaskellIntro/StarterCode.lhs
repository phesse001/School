A sample Haskell module for courses at CSB|SJU.

Authors J. Andrew Whitford Holey and Lynn R. Ziegler,
based on FirstLiterate.lhs from Simon Thompson, The Craft of Functional Programming;
last modified August, 2015.
Tabs replaced with spaces September 5, 2016.

A function to square a number

>    square n = n * n


A function to double a number

>    double n =  2 * n


A function to compute the maximum of two numbers

>    max2a v1 v2
>        | v1 > v2    = v1
>        | otherwise  = v2

Here is another function to compute the maximum of two numbers

>    max2b v1 v2 = if (v1>v2) then v1 else v2


A recursive function to compute the largest common divisor of two integers

>    lcd m 0 = m
>    lcd 0 n = n
>    lcd m n = lcd n (mod m n)


A recursive function to apply a function to a list of arguments

>    applyIt f []    = []
>    applyIt f (x:l) = (f x):(applyIt f l)


A recursive function to apply a list of functions to an argument

>    applyThem [] x    = []
>    applyThem (f:l) x = (f x):(applyThem l x)

A function that computes the fourth power of its argument by calling square twice

>    fourth n = square n * square n

A function that computes the eighth power of its argument by calling fourth twice

>    eighth n = square (fourth n)

Part 4

>    a = 1
>    b = -5
>    c = 6
>    r = (-b + sqrt(square b-4*a*c))/(2*a)

A function that computes the value of a quadratic polynomial

>    quadpoly :: Num a => a -> a -> a -> a -> a
>    quadpoly a b c x = a * square x + b * x + c

A function that uses the quadpoly to evaluate a polynomial 3x^2-25x+7

>    poly1 x = quadpoly 3 (-25) 7 x

A function that cubes its argument

>    cube x = x * x * x

A function that evaluates the cubic polynomial ax^3+bx^2+cx+d

>    cubicpoly :: Num a => a -> a -> a -> a -> a -> a
>    cubicpoly a b c d x = a * cube x + b * square(x) + c * x + d

A function that uses the cubic poly function to evaluate the polynomial x3 − 5.359375

>    poly2 x = cubicpoly 1 0 0 (-5.359375) x

A function that takes three parameters a,b,c and computes whether a triangle is equalateral, isoceles, or scalene.

>    triangle a b c  
>      |a == b && b == c = "equalateral"
>      |a /= b && a /= c && b /= c = "scalene"
>      |otherwise = "isoceles"



