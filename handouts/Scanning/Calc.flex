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
WS     = (\r|\n|\r\n) | [ \t\f]

%state STRING

%%

/* patterns */
(\+)
    {
        return new Symbol(sym.PLUS);
    }
{DIGIT}+
    {
        return new Symbol(sym.NUM);
    }

/* error fallback */
.
    {
        throw new Error("Illegal character <" + yytext() + "> at line " + yyline +
                        " column " + yycolumn);
    }
