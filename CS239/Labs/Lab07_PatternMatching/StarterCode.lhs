Here is a Haskell function implementing the Fibonacci function from its
definition in the lab writeup, using pattern matching

> fibonacci :: (Eq a, Num a, Num a1) => a -> a1
> fibonacci 0 = 1
> fibonacci 1 = 1
> fibonacci n = fibonacci (n - 1) + fibonacci (n - 2)

> ackermann:: (Eq a, Num a, Eq a1, Num a1) => a -> a1 -> a1
> ackermann 0 n = n+1
> ackermann m 0 = ackermann (m-1) 1
> ackermann m n = (ackermann (m-1)) (ackermann m (n-1))


1.)
zygomaticotemporal
zygomaxillare
zygomaxillary
Zygophyllaceae
Zygopteraceae
Zygosaccharomyces
[phesse001@vplincsci014 107 ~]$ egrep 'a.*a' /usr/share/dict/linux.words

2.)
baaskaap
baaskaaps
raadzaal
Saaremaa
staatsraad
[phesse001@vplincsci014 110 ~]$ egrep 'aa.*.aa' /usr/share/dict/linux.words

3.)
braata
cabaa
cabaan
Erbaa
gifblaar
Jerubbaal
labaara
Rabaal
superbazaar
[phesse001@vplincsci014 111 ~]$ egrep 'b.*aa' /usr/share/dict/linux.words

4.)
bambochade
carbacidometer
Cerambycidae
nonabstractedness
Oxylabracidae
scabicide
unabstractedness
[phesse001@vplincsci014 112 ~]$ egrep 'a.*b.*c.*d.*e' /usr/share/dict/linux.words

5.)
zaqqum
zizz
zizzle
zizzled
zizzles
zizzling
zyzzyva
zyzzyvas
[phesse001@vplincsci014 113 ~]$ egrep '[qz].*[qz].*[qz]' /usr/share/dict/linux.words

6.)
zymologies
zymophosphate
zymosimeter
zymotechnical
zymotically
[phesse001@vplincsci014 122 ~]$ egrep '([aeiouy].*){5}' /usr/share/dict/linux.words

7.)
zymoplastic
zymoscope
zymosterol
zymosthenic
zymotechnic
zymotechnics
zymotechny
zymotize
zymotoxic
zymurgies
Zyrenian
Zyzzogeton
[phesse001@vplincsci014 131 ~]$ egrep '^[^aeiouy]*([aeiouy][^aeiouy]*){4}[^aeiouy]*$' /usr/share/dict/linux.words

8.)
zingiberone
zinober
Zinziberaceae
zinziberaceous
zombis
zoologicobotanical
zoophobes
zoophobous
Zubird
Zurbar
Zurbaran
zygomaticoorbital
[phesse001@vplincsci014 132 ~]$ egrep 'b[a-q][r-z]' /usr/share/dict/linux.words

9.)
xanthochroism
xanthochromia
xanthochromic
xanthochroous
xanthrochroid
X-chromosome
yarn-mercerizing
Y-chromosome
yttrocerite
zinc-roofed
zincuret
zoocurrent
[phesse001@vplincsci014 134 ~]$ egrep 'c[^a]r' /usr/share/dict/linux.words

10.)
zwitter
zwitterion
zwitterionic
zygantra
zygantrum
zymochemistry
zymosthenic
zythem
Zythia
zythum
[phesse001@vplincsci014 135 ~]$ egrep 't[^aeiouy]' /usr/share/dict/linux.words

11.)
zenithwards
zibeths
zillionths
zinjanthropi
Zinjanthropus
zinjanthropus
Zischke
zoanthropy
zooerythrin
zoonerythrin
Zubeneschamali
[phesse001@vplincsci014 137 ~]$ egrep '(th[^aeiouy]|sc[^aeiouy])' /usr/share/dict/linux.words

12.)
zygantrum
zygomaticoorbital
zymochemistry
zymosthenic
zythem
Zythia
zythum
[phesse001@vplincsci014 140 ~]$ egrep '(b[a-q][r-z])|(c[^a]r)|(t[^aeiouy])|(th[^aeiouy]|sc[^aeiouy])' /usr/share/dict/linux.words



