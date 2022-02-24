module declaration is the interface for the set data type

10/14/19 Patrick Hesse

> module StarterCode
>   ( empty
>   , singleton
>   , fromList
>   , isSubsetOf
>   , member
>   , size
>   , union
>   , intersection
>   , difference
>   ) where

Define the Set data type with a single constructor

> newtype Set a = Set [a]

=========
Instances
=========

Define Set as a showable type

> instance Show a => Show (Set a) where
>   show (Set ys) = "{" ++ (showList ys)
>     where showList :: Show a => [a] -> [Char]
>           showList []     = "}"
>           showList (x:[]) = (show x) ++ "}"
>           showList (x:xs) = (show x) ++ "," ++ (showList xs)

============
Constructors
============

The empty set.

> empty :: Set a
> empty = Set []

Create a singleton set.

> singleton :: a -> Set a
> singleton x = Set [x]

Create a set from a list of elements.

> fromList :: Eq a => [a] -> Set a
> fromList xs = Set (cleanList xs)
>   where cleanList :: Eq a => [a] -> [a]
>         cleanList [] = []
>         cleanList (x:xs)
>           | elem x xs = cleanList xs
>           | otherwise = x : (cleanList xs)

=====
Query
=====

Is one set a subset of another?

> isSubsetOf :: Eq a => Set a -> Set a -> Bool
> isSubsetOf (Set (x:xs)) b = x `member` b && isSubsetOf (Set xs) b
> isSubsetOf (Set []) b = True


Is the element in the set?

> member :: Eq a => a -> Set a -> Bool
> member a (Set xs)
>	|elem a xs == True = True
>	|otherwise = False

The number of elements in the set.

> size :: Set a -> Int
> size (Set xs) = length xs

=========
Operators
=========

The union of two sets --- a new set containing all the elements of either of two
existing sets.

> theList :: Eq a => [a] -> Set a
> theList xs = Set (list xs)
>	where list :: Eq a => [a] -> [a]
>	      list [] = []
>	      list (x:xs)
>	      	| elem x xs = list xs
>	      	| otherwise = x : (list xs)

> union :: Eq a => Set a -> Set a -> Set a
> union (Set s1) (Set s2) = theList(s1++s2)

The intersection of two sets --- a new set containing all the elements of both
of two existing sets.

> intersection :: Eq a => Set a -> Set a -> Set a
> intersection (Set s1) (Set s2) = Set(listIntersection s1 s2)

> listIntersection [] [] = []
> listIntersection (l:l1) [] = []
> listIntersection [] l2 = []
> listIntersection (l:l1) l2
>	|l `elem` l2 = [l] ++ listIntersection l1 l2
>   |otherwise = listIntersection l1 l2 

The difference of two sets --- a new set containing all the elements in the
first set that are not in the second set.

> listDifference :: Eq a => [a]-> [a] -> [a]
> listDifference [] s1 = []
> listDifference (x:xs) s1
>	| x `elem` s1 = listDifference xs s1
>	| otherwise = [x] ++ listDifference xs s1

> difference :: Eq a => Set a -> Set a -> Set a
> difference (Set a) (Set b) = Set(listDifference a b)

The Cartesian product of two sets --- a new set containing all pairs of elements
(a,b) where a is in the first set and b is in the second set.

> listCartesianProduct [] [] = []
> listCartesianProduct (a:l1) (b:l2) = [(a,b) | a <- l1, b <- l2]

> cartesianProduct :: Set a -> Set b -> Set (a,b)
> cartesianProduct (Set s1) (Set s2) = Set(listCartesianProduct s1 s2)
