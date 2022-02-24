#!/bin/sh
echo 'name: solution
version: 0.1.0
id: solution-0.1.0-0080863e5960895b2a12127aabadd708

license: AllRightsReserved
copyright:
maintainer:
stability:
homepage:
package-url:
synopsis:
description:
category:
author: Jeremy Iverson
exposed: True
exposed-modules: Solutions
hidden-modules:
trusted: False
import-dirs: /usr/people/classes/CS239/labs/Lab09_Functions2/solution/lib/solution-0.1.0/ghc-7.6.3
library-dirs: /usr/people/classes/CS239/labs/Lab09_Functions2/solution/lib/solution-0.1.0/ghc-7.6.3
hs-libraries: HSsolution-0.1.0
extra-libraries:
extra-ghci-libraries:
include-dirs:
includes:
depends: base-4.6.0.1-8aa5d403c45ea59dcd2c39f123e27d57
hugs-options:
cc-options:
ld-options:
framework-dirs:
frameworks:
haddock-interfaces: /usr/people/classes/CS239/labs/Lab09_Functions2/solution/share/doc/solution-0.1.0/html/solution.haddock
haddock-html: /usr/people/classes/CS239/labs/Lab09_Functions2/solution/share/doc/solution-0.1.0/html
' | '/usr/bin/ghc-pkg' 'update' '-' '--global' '--user' "$@"
