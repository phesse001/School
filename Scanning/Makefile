##
# This Makefile creates the scanner (Yylex.class)
# and creates the test program (ScannerTest.class)
# for our Calculator example.
#
# Important targets:
#   make             => builds everything
#   make Yylex.class => builds just the Scanner (but not ScannerTest)
#   make clean       => cleans up for a re-build
##

JAVAC = javac
CLASSPATH = ".:/home/patrick/School/software/*"
JFLAGS = -g -Werror -cp $(CLASSPATH)
JFLEXLOC = /home/patrick/School/software

all: ScannerTest.class

ScannerTest.class: ScannerTest.java Yylex.class sym.class
	$(JAVAC) $(JFLAGS) ScannerTest.java

Yylex.class: Yylex.java sym.class
	$(JAVAC) $(JFLAGS) Yylex.java

Yylex.java: Calc.flex sym.class
	java -jar $(JFLEXLOC)/jflex-full-1.7.0.jar Calc.flex

sym.class: sym.java
	$(JAVAC) $(JFLAGS) sym.java

clean:
	rm -f *~ *.class Yylex.java
