/* The following code was generated by JFlex 1.7.0 */

// Symbol
import java_cup.runtime.*;

/**
 * This class is the lexer (i.e., scanner) for the Streamer
 * language (that students complete in CSCI 340).
 */

class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\5\1\4\1\16\1\17\1\3\22\0\1\5\1\10\1\61"+
    "\2\0\1\15\1\6\1\0\1\56\1\57\1\13\1\11\1\36\1\12"+
    "\1\0\1\14\12\1\1\52\1\60\1\33\1\35\1\34\1\54\1\0"+
    "\32\2\1\53\1\62\1\55\3\0\1\44\1\41\1\45\1\47\1\27"+
    "\1\43\1\2\1\51\1\22\2\2\1\31\1\26\1\23\1\42\1\20"+
    "\1\2\1\21\1\32\1\24\1\25\1\46\1\50\1\30\2\2\1\37"+
    "\1\7\1\40\7\0\1\16\u1fa2\0\1\16\1\16\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\2\4\2\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\11\3\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\5\3\1\21\1\22\1\1\1\23"+
    "\1\24\1\25\1\26\1\1\1\0\1\27\1\30\3\3"+
    "\1\31\11\3\1\32\1\33\1\34\1\35\1\36\7\3"+
    "\1\37\1\40\1\0\1\41\1\0\1\2\3\3\1\42"+
    "\10\3\1\43\2\3\1\44\4\3\1\41\3\3\1\45"+
    "\1\46\2\3\1\47\1\50\1\51\1\3\1\52\1\53"+
    "\1\3\1\54\1\55\1\3\1\56\1\3\1\57\1\60"+
    "\1\61\1\3\1\62\1\3\1\63\1\64\1\3\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\231\0\314\0\63\0\377\0\u0132"+
    "\0\63\0\63\0\63\0\63\0\63\0\63\0\u0165\0\u0198"+
    "\0\u01cb\0\u01fe\0\u0231\0\u0264\0\u0297\0\u02ca\0\u02fd\0\u0330"+
    "\0\u0363\0\u0396\0\63\0\63\0\63\0\u03c9\0\u03fc\0\u042f"+
    "\0\u0462\0\u0495\0\63\0\u04c8\0\u04fb\0\63\0\63\0\63"+
    "\0\63\0\u052e\0\u0561\0\63\0\63\0\u0594\0\u05c7\0\u05fa"+
    "\0\231\0\u062d\0\u0660\0\u0693\0\u06c6\0\u06f9\0\u072c\0\u075f"+
    "\0\u0792\0\u07c5\0\63\0\63\0\u07f8\0\63\0\63\0\u082b"+
    "\0\u085e\0\u0891\0\u08c4\0\u08f7\0\u092a\0\u095d\0\63\0\63"+
    "\0\u052e\0\63\0\u0990\0\u0561\0\u09c3\0\u09f6\0\u0a29\0\231"+
    "\0\u0a5c\0\u0a8f\0\u0ac2\0\u0af5\0\u0b28\0\u0b5b\0\u0b8e\0\u0bc1"+
    "\0\63\0\u0bf4\0\u0c27\0\231\0\u0c5a\0\u0c8d\0\u0cc0\0\u0cf3"+
    "\0\u052e\0\u0d26\0\u0d59\0\u0d8c\0\231\0\231\0\u0dbf\0\u0df2"+
    "\0\231\0\231\0\231\0\u0e25\0\231\0\231\0\u0e58\0\231"+
    "\0\231\0\u0e8b\0\231\0\u0ebe\0\231\0\231\0\231\0\u0ef1"+
    "\0\231\0\u0f24\0\231\0\231\0\u0f57\0\231";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\2\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\0\1\6\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\4\1\25\1\4"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\4\1\37\1\4\1\40\1\41\1\42\2\4"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\2\63\0\1\53\1\3\1\53\2\0\11\53\2\0"+
    "\43\53\1\0\2\4\15\0\13\4\6\0\11\4\15\0"+
    "\1\6\64\0\1\54\63\0\1\55\54\0\2\4\15\0"+
    "\1\4\1\56\11\4\6\0\11\4\12\0\2\4\15\0"+
    "\7\4\1\57\3\4\6\0\11\4\12\0\2\4\15\0"+
    "\3\4\1\60\7\4\6\0\2\4\1\61\6\4\12\0"+
    "\2\4\15\0\5\4\1\62\5\4\6\0\11\4\12\0"+
    "\2\4\15\0\1\4\1\63\5\4\1\64\3\4\6\0"+
    "\11\4\12\0\2\4\15\0\3\4\1\65\7\4\6\0"+
    "\11\4\12\0\2\4\15\0\1\4\1\66\6\4\1\67"+
    "\1\70\1\4\6\0\11\4\12\0\2\4\15\0\2\4"+
    "\1\71\10\4\6\0\11\4\12\0\2\4\15\0\13\4"+
    "\6\0\7\4\1\72\1\4\44\0\1\73\1\0\1\74"+
    "\61\0\1\75\1\76\62\0\1\77\26\0\2\4\15\0"+
    "\13\4\6\0\1\4\1\100\7\4\12\0\2\4\15\0"+
    "\5\4\1\101\5\4\6\0\1\4\1\102\1\4\1\103"+
    "\5\4\12\0\2\4\15\0\13\4\6\0\3\4\1\104"+
    "\5\4\12\0\2\4\15\0\13\4\6\0\1\4\1\105"+
    "\7\4\12\0\2\4\15\0\7\4\1\106\3\4\6\0"+
    "\11\4\65\0\1\107\63\0\1\110\5\0\61\111\1\112"+
    "\1\113\1\0\1\114\62\0\2\4\15\0\2\4\1\115"+
    "\10\4\6\0\11\4\12\0\2\4\15\0\4\4\1\116"+
    "\6\4\6\0\11\4\12\0\2\4\15\0\1\117\12\4"+
    "\6\0\11\4\12\0\2\4\15\0\6\4\1\120\4\4"+
    "\6\0\11\4\12\0\2\4\15\0\5\4\1\121\5\4"+
    "\6\0\11\4\12\0\2\4\15\0\10\4\1\122\2\4"+
    "\6\0\11\4\12\0\2\4\15\0\4\4\1\123\6\4"+
    "\6\0\11\4\12\0\2\4\15\0\1\4\1\124\11\4"+
    "\6\0\11\4\12\0\2\4\15\0\2\4\1\125\10\4"+
    "\6\0\11\4\12\0\2\4\15\0\12\4\1\126\6\0"+
    "\11\4\12\0\2\4\15\0\12\4\1\127\6\0\11\4"+
    "\12\0\2\4\15\0\2\4\1\130\10\4\6\0\11\4"+
    "\22\0\1\131\52\0\2\4\15\0\13\4\6\0\1\4"+
    "\1\132\7\4\12\0\2\4\15\0\3\4\1\133\7\4"+
    "\6\0\11\4\12\0\2\4\15\0\1\4\1\134\11\4"+
    "\6\0\11\4\12\0\2\4\15\0\11\4\1\135\1\4"+
    "\6\0\11\4\12\0\2\4\15\0\12\4\1\136\6\0"+
    "\11\4\12\0\2\4\15\0\2\4\1\137\10\4\6\0"+
    "\11\4\12\0\2\4\15\0\13\4\6\0\2\4\1\140"+
    "\6\4\11\0\61\111\1\141\1\113\1\0\2\4\15\0"+
    "\3\4\1\142\7\4\6\0\11\4\12\0\2\4\15\0"+
    "\5\4\1\143\5\4\6\0\11\4\12\0\2\4\15\0"+
    "\5\4\1\144\5\4\6\0\11\4\12\0\2\4\15\0"+
    "\7\4\1\145\3\4\6\0\11\4\12\0\2\4\15\0"+
    "\4\4\1\146\6\4\6\0\11\4\12\0\2\4\15\0"+
    "\2\4\1\147\10\4\6\0\11\4\12\0\2\4\15\0"+
    "\13\4\6\0\1\4\1\150\7\4\12\0\2\4\15\0"+
    "\4\4\1\151\6\4\6\0\11\4\12\0\2\4\15\0"+
    "\7\4\1\152\3\4\6\0\11\4\12\0\2\4\15\0"+
    "\4\4\1\153\6\4\6\0\11\4\12\0\2\4\15\0"+
    "\4\4\1\154\6\4\6\0\11\4\12\0\2\4\15\0"+
    "\11\4\1\155\1\4\6\0\11\4\12\0\2\4\15\0"+
    "\13\4\6\0\4\4\1\156\4\4\12\0\2\4\15\0"+
    "\12\4\1\157\6\0\11\4\12\0\2\4\15\0\7\4"+
    "\1\160\3\4\6\0\11\4\12\0\2\4\15\0\13\4"+
    "\6\0\6\4\1\161\2\4\12\0\2\4\15\0\13\4"+
    "\6\0\3\4\1\162\5\4\12\0\2\4\15\0\4\4"+
    "\1\163\6\4\6\0\11\4\12\0\2\4\15\0\1\4"+
    "\1\164\11\4\6\0\11\4\12\0\2\4\15\0\4\4"+
    "\1\165\6\4\6\0\11\4\12\0\2\4\15\0\11\4"+
    "\1\166\1\4\6\0\11\4\12\0\2\4\15\0\1\4"+
    "\1\167\11\4\6\0\11\4\12\0\2\4\15\0\13\4"+
    "\6\0\4\4\1\170\4\4\12\0\2\4\15\0\7\4"+
    "\1\171\3\4\6\0\11\4\12\0\2\4\15\0\5\4"+
    "\1\172\5\4\6\0\11\4\12\0\2\4\15\0\3\4"+
    "\1\173\7\4\6\0\11\4\12\0\2\4\15\0\13\4"+
    "\6\0\10\4\1\174\12\0\2\4\15\0\11\4\1\175"+
    "\1\4\6\0\11\4\12\0\2\4\15\0\4\4\1\176"+
    "\6\4\6\0\11\4\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3978];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\2\1\6\11\14\1\3\11"+
    "\5\1\1\11\2\1\4\11\1\1\1\0\2\11\15\1"+
    "\2\11\1\1\2\11\7\1\2\11\1\0\1\11\1\0"+
    "\15\1\1\11\45\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 168) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Illegal character <" + yytext() + "> at line " + yyline +
                        " column " + yycolumn);
            } 
            // fall through
          case 54: break;
          case 2: 
            { return new Symbol(sym.NUM, yyline + 1, yycolumn + 1, yytext());
            } 
            // fall through
          case 55: break;
          case 3: 
            { return new Symbol(sym.ID, yyline + 1, yycolumn + 1, yytext());
            } 
            // fall through
          case 56: break;
          case 4: 
            { 
            } 
            // fall through
          case 57: break;
          case 5: 
            { return new Symbol(sym.NOT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 58: break;
          case 6: 
            { return new Symbol(sym.PLUS, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 59: break;
          case 7: 
            { return new Symbol(sym.MINUS, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 60: break;
          case 8: 
            { return new Symbol(sym.TIMES, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 61: break;
          case 9: 
            { return new Symbol(sym.DIVIDE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 62: break;
          case 10: 
            { return new Symbol(sym.MODULUS, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 63: break;
          case 11: 
            { return new Symbol(sym.LT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 64: break;
          case 12: 
            { return new Symbol(sym.GT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 65: break;
          case 13: 
            { return new Symbol(sym.ASSIGN, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 66: break;
          case 14: 
            { return new Symbol(sym.COMMA, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 67: break;
          case 15: 
            { return new Symbol(sym.OPCURLY, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 68: break;
          case 16: 
            { return new Symbol(sym.CLCURLY, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 69: break;
          case 17: 
            { return new Symbol(sym.COLON, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 70: break;
          case 18: 
            { return new Symbol(sym.OPSQUARE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 71: break;
          case 19: 
            { return new Symbol(sym.CLSQUARE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 72: break;
          case 20: 
            { return new Symbol(sym.OPPAREN, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 73: break;
          case 21: 
            { return new Symbol(sym.CLPAREN, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 74: break;
          case 22: 
            { return new Symbol(sym.SC, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 75: break;
          case 23: 
            { return new Symbol(sym.AND, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 76: break;
          case 24: 
            { return new Symbol(sym.OR, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 77: break;
          case 25: 
            { return new Symbol(sym.IF, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 78: break;
          case 26: 
            { return new Symbol(sym.READ, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 79: break;
          case 27: 
            { return new Symbol(sym.LTE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 80: break;
          case 28: 
            { return new Symbol(sym.WRITE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 81: break;
          case 29: 
            { return new Symbol(sym.GTE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 82: break;
          case 30: 
            { return new Symbol(sym.EQUALS, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 83: break;
          case 31: 
            { return new Symbol(sym.OPFILTER, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 84: break;
          case 32: 
            { return new Symbol(sym.CLFILTER, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 85: break;
          case 33: 
            { return new Symbol(sym.STRING, yyline + 1, yycolumn + 1, yytext());
            } 
            // fall through
          case 86: break;
          case 34: 
            { return new Symbol(sym.NUMTYPE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 87: break;
          case 35: 
            { return new Symbol(sym.APPEND, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 88: break;
          case 36: 
            { return new Symbol(sym.FOR, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 89: break;
          case 37: 
            { return new Symbol(sym.TRUE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 90: break;
          case 38: 
            { return new Symbol(sym.TEXT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 91: break;
          case 39: 
            { return new Symbol(sym.EXIT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 92: break;
          case 40: 
            { return new Symbol(sym.ELSE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 93: break;
          case 41: 
            { return new Symbol(sym.LIST, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 94: break;
          case 42: 
            { return new Symbol(sym.BOOL, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 95: break;
          case 43: 
            { return new Symbol(sym.FUNC, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 96: break;
          case 44: 
            { return new Symbol(sym.CASE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 97: break;
          case 45: 
            { return new Symbol(sym.VOID, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 98: break;
          case 46: 
            { return new Symbol(sym.PRINT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 99: break;
          case 47: 
            { return new Symbol(sym.INPUT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 100: break;
          case 48: 
            { return new Symbol(sym.UNTIL, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 101: break;
          case 49: 
            { return new Symbol(sym.ERROR, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 102: break;
          case 50: 
            { return new Symbol(sym.FALSE, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 103: break;
          case 51: 
            { return new Symbol(sym.RETURN, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 104: break;
          case 52: 
            { return new Symbol(sym.SWITCH, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 105: break;
          case 53: 
            { return new Symbol(sym.DEFAULT, yyline + 1, yycolumn + 1);
            } 
            // fall through
          case 106: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
