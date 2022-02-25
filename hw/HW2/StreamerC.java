import java.io.FileReader;
import java_cup.runtime.Symbol;

/**
 * This class is the primary Streamer compiler front-end.  Currently (for HW2)
 * it only runs the Scanner and prints out the data for each token.
 *
 * @author <your name here> based on a template by Peter Ohmann
 */
public class StreamerC {
    /**
     * Given a symbol type (as an int), convert it to its string representation,
     * based on the symbols defined in sym.java.
     *
     * @param symType the symbol type read by the scanner
     * @return the String version
     */
    private static String symTypeToString(int symType) throws IllegalArgumentException {
        switch(symType) {
        case sym.EOF: return "EOF";
        case sym.PLUS: return "PLUS";
        case sym.NUM: return "NUM";
        case sym.QSTRING: return "STRING";
        case sym.ID: return "ID";
        case sym.NUMTYPE: return "NUMTYPE";
        case sym.ASSIGN: return "ASSIGN";
        case sym.SC: return "SEMICOL";
        case sym.PRINT: return "PRINT";
        case sym.STRING: return "STRING";
        case sym.TEXT: return "TEXT";
        case sym.BOOL: return "BOOL";
        case sym.AND: return "AND";
        case sym.OR: return "OR";
        case sym.NOT: return "NOT";
        case sym.TRUE: return "TRUE";
        case sym.FALSE: return "FALSE";
        case sym.LIST: return "LIST";
        case sym.OPCURLY: return "OPCURLY";
        case sym.CLCURLY: return "CLCURLY";
        case sym.LT: return "LT";
        case sym.GT: return "GT";
        case sym.COMMA: return "COMMA";
        case sym.READ: return "READ";
        case sym.ERROR: return "ERROR";
        case sym.EXIT: return "EXIT";
        case sym.FUNC: return "FUNC";
        case sym.VOID: return "VOID";
        case sym.INPUT: return "INPUT";
        case sym.UNTIL: return "UNTIL";
        case sym.OPSQUARE: return "OPSQUARE";
        case sym.CLSQUARE: return "CLSQUARE";
        case sym.DIVIDE: return "DIVIDE";
        case sym.OPPAREN: return "OPPAREN";
        case sym.CLPAREN: return "CLPAREN";
        case sym.OPFILTER: return "OPFILTER";
        case sym.CLFILTER: return "CLFILTER";
        case sym.WRITE: return "WRITE";
        case sym.IF: return "IF";
        case sym.ELSE: return "ELSE";
        case sym.FOR: return "FOR";
        case sym.COLON: return "COLON";
        case sym.RETURN: return "RETURN";
        case sym.SWITCH: return "SWITCH";
        case sym.CASE: return "CASE";
        case sym.DEFAULT: return "DEFAULT";
        case sym.MINUS: return "MINUS";
        case sym.TIMES: return "TIMES";
        case sym.MODULUS: return "MODULUS";
        case sym.LTE: return "LTE";
        case sym.GTE: return "GTE";
        case sym.EQUALS: return "EQUALS";
        case sym.APPEND: return "APPEND";
        default: throw new IllegalArgumentException("Invalid token type in symbol!");
        }
    }

    public static void main(String argv[]) {    
        try {
            Yylex scanner = new Yylex(new FileReader(argv[0]));
            Symbol token = scanner.next_token();
            while (token.sym != sym.EOF) {
                System.out.println("Token: " + symTypeToString(token.sym) +
                                   "\tLine: " + token.left +
                                   "\tColumn: " + token.right +
                                   "\tValue: " + token.value);
                token = scanner.next_token();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
