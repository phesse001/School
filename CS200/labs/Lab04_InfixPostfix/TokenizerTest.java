import expressions.*;
import org.junit.*;
import java.util.*;

/**
 * A JUnit test case class for class Tokenizer .
 */
public class TokenizerTest {
  
  @Test
  public void testMakeTokenForArithmeticOperators(){
    Assert.assertTrue ("testing that plus works",Tokenizer.makeToken("+").toString().equals("+")); 
    Assert.assertTrue("testing that minus works", Tokenizer.makeToken("-").toString().equals("-"));
    Assert.assertTrue("testing that times works",Tokenizer.makeToken("*").toString().equals("*"));
    Assert.assertTrue("testing that divide works", Tokenizer.makeToken("/").toString().equals("/"));
    Assert.assertTrue("testing that remainder works",Tokenizer.makeToken("%").toString().equals("%"));
  }    
  
  @Test
  public void testMakeTokenForParantheses(){
    Assert.assertTrue("testing that left paren works",Tokenizer.makeToken("(").toString().equals("("));
    Assert.assertTrue("testing that right works", Tokenizer.makeToken(")").toString().equals(")"));
  }
  
  @Test
  public void testMakeTokenForOperands(){
    Assert.assertTrue("testing that multi-digit integer works",Tokenizer.makeToken("325").toString().equals("325"));
    Assert.assertTrue("testing that single-digit integer works",Tokenizer.makeToken("4").toString().equals("4"));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testMakeTokenFailsForInvalidTokens(){
    Tokenizer.makeToken("&");
  }  
  
  @Test
  public void testParseString(){
    Queue<Token> que=Tokenizer.parseString("344+6*90/3+  (9-3)%5");  
    Assert.assertTrue("testing that parse a 3-DIGIT int works", que.remove().toString().equals("344"));
    Assert.assertTrue("testing that parse + works",que.remove().toString().equals("+"));
    Assert.assertTrue("testing that parse a 1-DIGIT int works", que.remove().toString().equals("6"));
    Assert.assertTrue("testing that parse * works", que.remove().toString().equals("*"));
    Assert.assertTrue("testing that parse a 2-DIGIT int works", que.remove().toString().equals("90"));
    Assert.assertTrue("testing that parse / works", que.remove().toString().equals("/"));
    Assert.assertTrue("testing that parse a second 1-DIGIT int works", que.remove().toString().equals("3"));
    Assert.assertTrue("testing that parse + works",que.remove().toString().equals("+"));
    Assert.assertTrue("testing that parse ( and skip space works", que.remove().toString().equals("("));
    Assert.assertTrue("testing that parse a third 1-DIGIT int works",que.remove().toString().equals("9"));
    Assert.assertTrue("testing that parse - works", que.remove().toString().equals("-"));
    Assert.assertTrue("testing that parse a fourth 1-DIGIT int works", que.remove().toString().equals("3"));
    Assert.assertTrue("testing that parse ) works", que.remove().toString().equals(")"));
    Assert.assertTrue("testing that parse % works", que.remove().toString().equals("%"));
    Assert.assertTrue("testing that parse a fifth 1-DIGIT int works", que.remove().toString().equals("5"));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testStringParseFails(){
    Tokenizer.parseString("344+6*90/3+ & (9-3)%5");  
  }  
}
