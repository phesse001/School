Haskell Simulation of the Monte Hall problem

The selectDoor* and selectSwitch* functions are by J. A. Whitford Holey,
December 7, 2015.
The remaining code is by __________________________
(working with _______________________).



>   import System.Random

******* The following four functions are utility functions   *******
******* needed to support the two functions below them.      *******
******* You don't need to understand the code of these four. *******

>   fact m n
>       |n == 0 = fact m (-1)
>       |m > n = 1
>       |otherwise = n * fact m (n-1)

>   permutation n r = fact (n - r + 1) n

>   c1 n r
>       |r > n/2 = (fact (r+1) n) / (fact 1 (n-r)) 
>       |otherwise = (fact (n-r+1) (n))/(fact 1 r)

>   c2 n r
>       |r == 0 || r == n = 1
>       |r > 0 || n > r   = c2 (n-1) r + c2 (n-1) (r-1)
>       |otherwise = 0

The selectDoorGen function returns a tuple containing pseudo-random Int,
selected from { 1, 2, 3 } and a new generatpr, using the specified generator.

>   selectDoorGen :: RandomGen rg => rg -> (Int, rg)
>   selectDoorGen gen = 
>     let (num, newGen) = random gen
>     in  (num `mod` 3 + 1, newGen)

The selectDoorsGen function returns an infinite list pseudo-random Ints,
selected from { 1, 2, 3 }, using the specified generator.

>   selectDoorsGen :: RandomGen rg => rg -> [Int]
>   selectDoorsGen gen =
>     let (num, newGen) = selectDoorGen gen
>         rest          = selectDoorsGen newGen
>     in  num : rest

The selectSwitchGen function returns a tuple containing a pseudo-random Bool
and a new generator, using the specified generator.

>   selectSwitchGen :: RandomGen rg => rg -> (Bool, rg)
>   selectSwitchGen gen = random gen

The selectSwitchesGen function returns an infinite list pseudo-random Bools,
using the specified generator.

>   selectSwitchesGen :: RandomGen rg => rg -> [Bool]
>   selectSwitchesGen gen =
>     let (switch, newGen) = selectSwitchGen gen
>         rest          = selectSwitchesGen newGen
>     in  switch : rest



******* Use the following two functions to generate            *******
******* random lists of door numbers or switches.              *******
******* Use different seed values to generate different lists. *******

The selectDoors function returns a list of n pseudo-random Ints,
selected from { 1, 2, 3 }, using the specified seed.

>   selectDoors :: Int -> Int -> [Int]
>   selectDoors n seed = take n (selectDoorsGen (mkStdGen seed))


The selectSwitches function returns a list of n pseudo-random Bools,
selected from { 1, 2, 3 }, using the specified seed.

>   selectSwitches :: Int -> Int -> [Bool]
>   selectSwitches n seed = take n (selectSwitchesGen (mkStdGen seed))

>   makeTuple a b c = (a,b,c)

>   makeTupleList [] [] [] = []
>   makeTupleList (x:xs) (y:ys) (z:zs) = (x, y, z) : (makeTupleList xs ys zs)

>   isWin (chosen,car,switch)
>       |chosen == car && switch == False = True
>       |chosen /= car && switch == True = True
>       |otherwise = False

>   isSwitch (chosen,car,switch)
>       |switch == True = True
>       |otherwise = False

>   isWinWithSwitch (chosen,car,switch)
>       |chosen /= car && switch == True = True
>       |otherwise = False

>   countWins [] = 0
>   countWins (x:xs)
>       |isWin x == True = 1  + countWins xs
>       |otherwise = countWins xs

>   countSwitches [] = 0
>   countSwitches (x:xs)
>       |isSwitch x == True = 1  + countSwitches xs
>       |otherwise = countSwitches xs

>   countWinsWithSwitches [] = 0
>   countWinsWithSwitches (x:xs)
>       |isWinWithSwitch x == True = 1  + countWinsWithSwitches xs
>       |otherwise = countWinsWithSwitches xs

>   doorL1 = (selectDoors 2000 43)
>   doorL2 = (selectDoors 2000 22)
>   switchL = (selectSwitches 2000 36)
>   bigList = makeTupleList doorL1 doorL2 switchL
