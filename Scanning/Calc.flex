// Symbol
import java_cup.runtime.*;

/**
 * This class is the skeleton for the Calculator example
 * (and in-class example from CSCI 340).
 */
%%

%class Yylex
%unicode
%cup
%line
%column

DIGIT  = [0-9]
LETTER = [A-Za-z]
PRINT  = print
WS     = (\r|\n|\r\n) | [ \t\f]

%state STRING

%%
/* patterns */
/* print needs to go first so that it doesn't recognize as an ID*/
{PRINT}
    {
        return new Symbol(sym.PRINT, yytext());
    }

{LETTER} ({LETTER} | {DIGIT})*
    {
        return new Symbol(sym.ID, yytext());
    }
(\+)
    {
        return new Symbol(sym.PLUS, yytext());
    }
{DIGIT}+
    {
        return new Symbol(sym.NUM, yytext());
    }
(=)
    {
        return new Symbol(sym.EQUAL, yytext());
    }
(-)
    {
        return new Symbol(sym.MINUS, yytext());
    }
{WS}
    {
        ;
    } 


/* error fallback */
.
    {
        throw new Error("Illegal character <" + yytext() + "> at line " + yyline +
                        " column " + yycolumn);
    }
