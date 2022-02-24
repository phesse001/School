import expressions.*;
import org.junit.*;
import java.util.*;

/**
 * A JUnit test case class for class PostfixEvaluator.
 */
public class PostFixEvaluatorTest {
  
  @Test
  public void testEvaluate(){
    int result = PostfixEvaluator.evaluate(InfixToPostfix.convert(Tokenizer.parseString("344+6*90/3+ (9-3)%5")));
    Assert.assertTrue("Expression should evaluate to 525 but instead gave " + result ,result==525);
  }  
  
  @Test(expected=IllegalArgumentException.class)
  public void testEvaluateFailsWhenMissingOneOperand(){
    PostfixEvaluator.evaluate(InfixToPostfix.convert(Tokenizer.parseString("344+6*")));
  }    
  
  @Test(expected=IllegalArgumentException.class)
  public void testEvaluateFailsWhenMissingTwoOperands(){
    PostfixEvaluator.evaluate(InfixToPostfix.convert(Tokenizer.parseString("*")));
  }    
}
