import expressions.*;
import org.junit.*;
import java.util.*;
import <foo>structures.*;
import zhstructures.*;
/**
 * A JUnit test case class for class TokenizerV2 .
 */
public class TokenizerV2Test {
  
  @Test
  public void testMakeTokenForArithmeticOperators(){
    Assert.assertTrue ("testing that plus works",TokenizerV2.makeToken("+").toString().equals("+")); 
    Assert.assertTrue("testing that minus works", TokenizerV2.makeToken("-").toString().equals("-"));
    Assert.assertTrue("testing that times works",TokenizerV2.makeToken("*").toString().equals("*"));
    Assert.assertTrue("testing that divide works", TokenizerV2.makeToken("/").toString().equals("/"));
    Assert.assertTrue("testing that remainder works",TokenizerV2.makeToken("%").toString().equals("%"));
  }    
  
  @Test
  public void testMakeTokenForParantheses(){
    Assert.assertTrue("testing that left paren works",TokenizerV2.makeToken("(").toString().equals("("));
    Assert.assertTrue("testing that right works", TokenizerV2.makeToken(")").toString().equals(")"));
  }
  
  @Test
  public void testMakeTokenForOperands(){
    Assert.assertTrue("testing that multi-digit integer works",TokenizerV2.makeToken("325").toString().equals("325"));
    Assert.assertTrue("testing that single-digit integer works",TokenizerV2.makeToken("4").toString().equals("4"));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testMakeTokenFailsForInvalidTokens(){
    TokenizerV2.makeToken("&");
  }  
  
  @Test
  public void testParseString(){
    ZHQueue<Token> que=TokenizerV2.parseString("344+6*90/3+  (9-3)%5");  
    Assert.assertTrue("testing that parse a 3-DIGIT int works", que.dequeue().toString().equals("344"));
    Assert.assertTrue("testing that parse + works",que.dequeue().toString().equals("+"));
    Assert.assertTrue("testing that parse a 1-DIGIT int works", que.dequeue().toString().equals("6"));
    Assert.assertTrue("testing that parse * works", que.dequeue().toString().equals("*"));
    Assert.assertTrue("testing that parse a 2-DIGIT int works", que.dequeue().toString().equals("90"));
    Assert.assertTrue("testing that parse / works", que.dequeue().toString().equals("/"));
    Assert.assertTrue("testing that parse a second 1-DIGIT int works", que.dequeue().toString().equals("3"));
    Assert.assertTrue("testing that parse + works",que.dequeue().toString().equals("+"));
    Assert.assertTrue("testing that parse ( and skip space works", que.dequeue().toString().equals("("));
    Assert.assertTrue("testing that parse a third 1-DIGIT int works",que.dequeue().toString().equals("9"));
    Assert.assertTrue("testing that parse - works", que.dequeue().toString().equals("-"));
    Assert.assertTrue("testing that parse a fourth 1-DIGIT int works", que.dequeue().toString().equals("3"));
    Assert.assertTrue("testing that parse ) works", que.dequeue().toString().equals(")"));
    Assert.assertTrue("testing that parse % works", que.dequeue().toString().equals("%"));
    Assert.assertTrue("testing that parse a fifth 1-DIGIT int works", que.dequeue().toString().equals("5"));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testStringParseFails(){
    TokenizerV2.parseString("344+6*90/3+ & (9-3)%5");  
  }  
}
