StarterCode.lhs

Haskell Code for CSCI 239, Lab 2

Andrew Whitford Holey
August, 2015
Tabs replaced with spaces September, 2016

Collect functions into a module for testing

> module StarterCode where

List of truth values

> truthList :: [Bool]
> truthList =  [True, False]


Map truth values for functions of one boolean variable

> mapTruth1 :: (Bool -> a) -> [a]
> mapTruth1 f = map f truthList


Map truth values for functions of two boolean variables

> mapTruth2 :: (Bool -> Bool -> a) -> [a]
> mapTruth2 f = mapThem2Them (map f truthList) truthList

Map truth values for functions of three boolean variables

> mapTruth3 :: (Bool -> Bool -> Bool -> a) -> [a]
> mapTruth3 f = mapThem2Them (mapThem2Them (map f truthList)
>                                          truthList)
>                            truthList

Map truth values for functions of four boolean variables

> mapTruth4 :: (Bool -> Bool -> Bool -> Bool -> a) -> [a]
> mapTruth4 f = mapThem2Them (mapThem2Them (mapThem2Them (map f truthList)
>                                                        truthList)
>                                          truthList)
>                            truthList

Map a list of functions to a list of parameters

> mapThem2Them :: [t -> a] -> [t] -> [a]
> mapThem2Them [] xs     = []
> mapThem2Them fs []     = []
> mapThem2Them (f:fs) xs = mapOnto f xs (mapThem2Them fs xs)


Map a function and a list of parameters onto an existing list of return values

> mapOnto :: (t -> a) -> [t] -> [a] -> [a]
> mapOnto f [] ys        = ys
> mapOnto f (x:xs) ys    = (f x) : mapOnto f xs ys


This function is an example of the kind of function you can apply mapTruth3 to;
it shows a simple boolean expression implemented as a Haskell function

> test3 :: Bool -> Bool -> Bool -> Bool
> test3 x y z = (x && y) || (not x && z)

Part 3

> prop3_1 p q = not p && q || p && not q

> prop3_2 p q r = p || not q && r

> prop3_3 p q r = (p || q) && (not p || r)

> prop3_4 p q r s = (p || not q) && (r || not s)

Part 4

> implies p q = not p || q

> iff p q = (p && q) || (not p && not q)

> prop4_1 p q r s = (p `implies` q) `iff` (r `implies` s)

Part 5

> predictSky clear day
>    |clear && day = "You can see the sun, but not any stars"
>    |not clear && day || not clear && not day = "You can see neither the sun nor any stars"
>    |clear && not day = "You cannot see the sun but you can see the stars"



