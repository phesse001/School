// Symbol
import java_cup.runtime.*;

/**
 * This class is the lexer (i.e., scanner) for the Streamer
 * language (that students complete in CSCI 340).
 */
%%

%class Yylex
%unicode
%cup
%line 
%column

DIGIT  = [0-9]
LETTER = [A-Za-z]
WS     = (\r|\n|\r\n) | [ \t\f]
AND    = &&
OR     = \|\|
NOT    = \!
%state STRING
%%

/* patterns */
(\+)
    {
        return new Symbol(sym.PLUS, yyline + 1, yycolumn + 1);
    }
-
    {
        return new Symbol(sym.MINUS, yyline + 1, yycolumn + 1);
    }
(\*)
    {
        return new Symbol(sym.TIMES, yyline + 1, yycolumn + 1);
    }
\/
    {
        return new Symbol(sym.DIVIDE, yyline + 1, yycolumn + 1);
    }
\%
    {
        return new Symbol(sym.MODULUS, yyline + 1, yycolumn + 1);
    }
{AND}
    {
        return new Symbol(sym.AND, yyline + 1, yycolumn + 1);
    }
{OR}
    {
        return new Symbol(sym.OR, yyline + 1, yycolumn + 1);
    }
{NOT}
    {
        return new Symbol(sym.NOT, yyline + 1, yycolumn + 1);
    }

{DIGIT}+ | {DIGIT}+ . {DIGIT}+
    {
        return new Symbol(sym.NUM, yyline + 1, yycolumn + 1, yytext());
    }
print
    {
        return new Symbol(sym.PRINT, yyline + 1, yycolumn + 1);
    }
num
    {
        return new Symbol(sym.NUMTYPE, yyline + 1, yycolumn + 1);
    }   
text
    {
        return new Symbol(sym.TEXT, yyline + 1, yycolumn + 1);
    }
list    
    {
        return new Symbol(sym.LIST, yyline + 1, yycolumn + 1);
    }
\<
    {
        return new Symbol(sym.LT, yyline + 1, yycolumn + 1);
    }
\>
    {
        return new Symbol(sym.GT, yyline + 1, yycolumn + 1);
    }
\<=
    {
        return new Symbol(sym.LTE, yyline + 1, yycolumn + 1);
    }
\>=
    {
        return new Symbol(sym.GTE, yyline + 1, yycolumn + 1);
    }
,
    {
        return new Symbol(sym.COMMA, yyline + 1, yycolumn + 1);
    }
\{
    {
        return new Symbol(sym.OPCURLY, yyline + 1, yycolumn + 1);
    }
\}
    {
        return new Symbol(sym.CLCURLY, yyline + 1, yycolumn + 1);
    }
bool
    {
        return new Symbol(sym.BOOL, yyline + 1, yycolumn + 1);
    }
true
    {
        return new Symbol(sym.TRUE, yyline + 1, yycolumn + 1);
    }
false
    {
        return new Symbol(sym.FALSE, yyline + 1, yycolumn + 1);
    }
error
    {
        return new Symbol(sym.ERROR, yyline + 1, yycolumn + 1);
    }
exit
    {
        return new Symbol(sym.EXIT, yyline + 1, yycolumn + 1);
    }
func
    {
        return new Symbol(sym.FUNC, yyline + 1, yycolumn + 1);
    }
void
    {
        return new Symbol(sym.VOID, yyline + 1, yycolumn + 1);
    }
input
    {
        return new Symbol(sym.INPUT, yyline + 1, yycolumn + 1);
    }
until
    {
        return new Symbol(sym.UNTIL, yyline + 1, yycolumn + 1);
    }
if
    {
        return new Symbol(sym.IF, yyline + 1, yycolumn + 1);
    }
else
    {
        return new Symbol(sym.ELSE, yyline + 1, yycolumn + 1);
    }
for
    {
        return new Symbol(sym.FOR, yyline + 1, yycolumn + 1);
    }
return
    {
        return new Symbol(sym.RETURN, yyline + 1, yycolumn + 1);
    }
switch
    {
        return new Symbol(sym.SWITCH, yyline + 1, yycolumn + 1);
    }
case
    {
        return new Symbol(sym.CASE, yyline + 1, yycolumn + 1);
    }
default
    {
        return new Symbol(sym.DEFAULT, yyline + 1, yycolumn + 1);
    }
:
    {
        return new Symbol(sym.COLON, yyline + 1, yycolumn + 1);
    }
\[\?
    {
        return new Symbol(sym.OPFILTER, yyline + 1, yycolumn + 1);
    }
\?\]
    {
        return new Symbol(sym.CLFILTER, yyline + 1, yycolumn + 1);
    }

\[
    {
        return new Symbol(sym.OPSQUARE, yyline + 1, yycolumn + 1);
    }
\]
    {
        return new Symbol(sym.CLSQUARE, yyline + 1, yycolumn + 1);
    }
\(
    {
        return new Symbol(sym.OPPAREN, yyline + 1, yycolumn + 1);
    }
\)
    {
        return new Symbol(sym.CLPAREN, yyline + 1, yycolumn + 1);
    }
=
    {
        return new Symbol(sym.ASSIGN, yyline + 1, yycolumn + 1);
    }
==
    {
        return new Symbol(sym.EQUALS, yyline + 1, yycolumn + 1);
    }

\<\<
    {
        return new Symbol(sym.READ, yyline + 1, yycolumn + 1);
    }
>>
    {
        return new Symbol(sym.WRITE, yyline + 1, yycolumn + 1);
    }
>>\+
    {
        return new Symbol(sym.APPEND, yyline + 1, yycolumn + 1);
    }
;
    {
        return new Symbol(sym.SC, yyline + 1, yycolumn + 1);
    }

{LETTER}+ ({LETTER}|{DIGIT})*
    {
        return new Symbol(sym.ID, yyline + 1, yycolumn + 1, yytext());
    }
\"([^\"] | \\.)*\"
    {
        return new Symbol(sym.STRING, yyline + 1, yycolumn + 1, yytext());
    }
{WS}
    {

    }

/* error fallback */
.
    {
        throw new Error("Illegal character <" + yytext() + "> at line " + yyline +
                        " column " + yycolumn);
    }
