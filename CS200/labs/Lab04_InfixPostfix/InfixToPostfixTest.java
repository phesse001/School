import expressions.*;
import org.junit.*;
import java.util.*;

/**
 * A JUnit test case class for class InfixToPostfix
 */
public class InfixToPostfixTest {
  
  @Test
  public void testConvertValid(){
    String input = "344+6*90/3+ (9-3)%5";
    Queue<Token> postfix = InfixToPostfix.convert(Tokenizer.parseString(input));
    Assert.assertTrue("1st token must be 344", postfix.remove().toString().equals("344"));
    Assert.assertTrue("2nd token must be 6  ", postfix.remove().toString().equals("6"));
    Assert.assertTrue("3rd token must be 90 ", postfix.remove().toString().equals("90"));
    Assert.assertTrue("4th token must be *  ", postfix.remove().toString().equals("*"));
    Assert.assertTrue("5th token must be 3  ", postfix.remove().toString().equals("3"));
    Assert.assertTrue("6th token must be /  ", postfix.remove().toString().equals("/"));
    Assert.assertTrue("7th token must be +  ", postfix.remove().toString().equals("+"));
    Assert.assertTrue("8th token must be 9  ", postfix.remove().toString().equals("9"));
    Assert.assertTrue("9th token must be 3  ", postfix.remove().toString().equals("3"));
    Assert.assertTrue("10th token must be - ", postfix.remove().toString().equals("-"));
    Assert.assertTrue("11th token must be 5 ", postfix.remove().toString().equals("5"));
    Assert.assertTrue("12th token must be % ", postfix.remove().toString().equals("%"));
    Assert.assertTrue("13th token must be + ", postfix.remove().toString().equals("+"));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testConvertFailsForExtraLeftParanthesis(){
    InfixToPostfix.convert(Tokenizer.parseString("344+6*90/3+  (9-3)%(5"));
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testConvertFailsForExtraRightParanthesis(){
    InfixToPostfix.convert(Tokenizer.parseString("344+6*90/3)+ (9-3)%5"));
  }  
  
}
