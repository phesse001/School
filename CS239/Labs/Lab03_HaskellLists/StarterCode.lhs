StarterCode.lhs

Haskell Code for CSCI 239, Lab 3

> module StarterCode where

Count the number of elements in a list.

> count :: Num a => [t] -> a
> count []     = 0
> count (x:xs) = 1 + (count xs)

Count the number of times an element occurs in a list.

> elemCount :: (Eq a1, Num a) => a1 -> [a1] -> a
> elemCount elem []     = 0
> elemCount elem (x:xs)
>   | elem == x         = 1 + (elemCount elem xs)
>   | otherwise         = elemCount elem xs

Return a list of numbers starting at n, increasing by one, up to m.

> range :: (Num a, Ord a) => a -> a -> [a]
> range n m
>   | n > m     = []
>   | otherwise = n : (range (n + 1) m)

Part 2

> list2_1 = [(-10) .. 10]
> list2_2 = [19,17 .. 1]
> list2_3 = ['a' .. 'z']
> list2_4 = ['A' .. 'Z']
> list2_5 = ['A' .. 'z']
> list2_6 = ['a' .. 'Z']
> list2_7 = [0,(1/3) .. 4]

Part 3

> list3_1 = [1 .. 5] ++ [5,4 .. 1]
> list3_2 = ['A'.. 'Z'] ++ ['a' .. 'z']
> list3_3 = ['A' .. 'Z'] ++ ['a' .. 'z'] ++ ['0' .. '9']

Part 4

> list4_1 = [n^2 | n <- [1 .. 20]]
> list4_2 = [sqrt(n) | n <- [1 .. 10]]
> list4_3 = [2^n | n <- [0 .. 40]]
> list4_4 = [n * (pi)/4 | n <- [0 .. 8]]

Part 5

> list5_1 = [(n/3)| n <- [0 .. 12]]
> list5_2 = [n | n <- [1 .. 20], n `mod` 3 == 0 || n `mod` 2 == 0]
> list5_3 = [n | n <- ['a' .. 'z'], n /= 'a', n /= 'e', n /= 'i', n /= 'o', n /= 'u']

Part 6

> list6_1 = [ (n, m, n * m) | n <- [ 0 .. 4 ], m <- [ 0 .. 4 ]]
> list6_2 = [ (n, sqrt n) | n <- [ 0 .. 10 ]]
> list6_3 = [ (n/10, log (n/10)) | n <- [ 10 .. 30]]

Part 7

> mySum :: Num a => [a] -> a
> mySum [] = 0
> mySum (x:xs) = x + (mySum xs)

> myMean [] = 0
> myMean a = (mySum a)/(count a)

> vowelCount1 []  = 0
> vowelCount1 (x:xs) = elemCount 'a' (x:xs) + elemCount 'e' (x:xs) + elemCount 'i' (x:xs) + elemCount 'o' (x:xs) + elemCount 'u' (x:xs)

> vowelCount2 [] = 0
> vowelCount2 ('a':xs) = 1 + vowelCount2 xs
> vowelCount2 ('e':xs) = 1 + vowelCount2 xs
> vowelCount2 ('i':xs) = 1 + vowelCount2 xs
> vowelCount2 ('o':xs) = 1 + vowelCount2 xs
> vowelCount2 ('u':xs) = 1 + vowelCount2 xs
> vowelCount2 (x:xs) = vowelCount2 xs

> squaresDown n
>   | n < 1 = []
>   | otherwise = [ n^2 | n <- [n,(n-1)  .. 1]]

> negList :: Num a => [a] -> [a]
> negList [] = []
> negList (x:xs) = [-x] ++ [ (-n) | n <- xs]



