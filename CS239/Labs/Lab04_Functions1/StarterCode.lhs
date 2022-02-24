StarterCode.lhs

Haskell Code for CSCI 239, Lab 4

> module StarterCode where

This function determines whether one of its two parameters divides the other.
Both parameters can not be zero. The type will be determined in lab.

> oneDividesTheOther 0 0 = False
> oneDividesTheOther n 0 = True
> oneDividesTheOther n m = n `mod` m == 0 || m `mod` n == 0

This function returns the minimum element in a non-empty list of ordinal values.

> minList :: Ord a => [a] -> a
> minList (x:[])  = x
> minList (x:xs)
>   | x < minRest = x
>   | otherwise   = minRest
>   where minRest = minList xs

This function sorts a list of ordinal values. It uses to auxiliary functions
splitList and mergeLists, which must be implemented before this function can be
compiled. NOTE: ADD A > SIGN TO THE BEGINNING OF EACH OF THE LINES OF THE
FUNCTION TO MAKE IT VISIBLE TO THE COMPILER. (You may then remove this note.)

    mergeSort :: Ord a => [a] -> [a]
    mergeSort []     = []
    mergeSort (x:[]) = x:[]
    mergeSort (x:xs) =
      mergeLists sl1 sl2
      where
        (l1, l2) = splitList (x:xs)
        sl1      = mergeSort l1
        sl2      = mergeSort l2


> quadRoots1 a b c = ((-b + sqrt(b^2 - 4*a*c)) / (2*a),(-b - sqrt(b^2 - 4*a*c)) / (2*a))

> quadRoots2 a b c = ( (-b + sqrt(b^2 - 4*a*c) / (2*a),0),(-b -sqrt(b^2 - 4*a*c) / (2*a),0))

> quadRoots3 a b c
>	| (b^2)-(4*a*c) < 0 = ( ( (-b / (2*a))
>                           , sqrt (4*a*c-b^2) / (2*a) )
>                        ,  ( (-b / (2*a))
>                           , (-sqrt(4*a*c-b^2)) / (2*a) ) )
>	| otherwise = quadRoots2 a b c

> maxList :: Ord a => [a] -> a
> maxList (x:[])  = x
> maxList (x:xs)
>   | x > maxRest = x
>   | otherwise   = maxRest
>   where maxRest = maxList xs

> median1st3 :: Ord a => [a] -> a
> median1st3 (x:[])  = x
> median1st3 (x:y:[])  = x
> median1st3 (x:y:z:xs)
>	| (z >= x) && (x >= y) || (y >= x) && (x >= z) = x
>	| (x >= y) && (y >= z) || (z >= y) && (y >= x) = y
>	| (y >= z) && (z >= x) || (x >= z) && (z >= y) = z

> medianAll3s :: Ord a => [a] -> [a]
> medianAll3s [] = []
> medianAll3s (x:[])  = [x]
> medianAll3s (x:y:[])  = [x]
> medianAll3s (x:y:z:xs) = median1st3 (x:y:z:xs) :  (medianAll3s xs)

> medianOfMedian3s [] = []
> medianOfMedian3s (x:[]) = [x]
> medianOfMedian3s (x:y:[])  = [x]
> medianOfMedian3s (x:y:z:xs) = medianOfMedian3s (medianAll3s (x:y:z:xs))

> splitList [] = ([], [])
> splitList (x:[]) = ([x], [])
> splitList (x:y:xs) = ([x] ++ l1, [y] ++ l2)
>	where (l1,l2) = splitList xs

> mergeLists [] [] = []
> mergeLists (x:l1) []= (x:l1)
> mergeLists [] (y:l2) = (y:l2)
> mergeLists (x:l1) (y:l2)
>	| x < y = ([x] ++ mergeLists l1 ([y] ++ l2))
>	| x >= y = ([y] ++ mergeLists l2 ([x] ++ l1))

> mergeSort :: Ord a => [a] -> [a]
> mergeSort []     = []
> mergeSort (x:[]) = x:[]
> mergeSort (x:xs) =
>   mergeLists sl1 sl2
>   where
>     (l1, l2) = splitList (x:xs)
>     sl1      = mergeSort l1
>     sl2      = mergeSort l2

