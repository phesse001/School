import expressions.*;
import org.junit.*;
import java.util.*;
import zhstructures.*;
/**
 * A JUnit test case class for class PostfixEvaluatorV2.
 */
public class PostFixEvaluatorV2Test {
  
  @Test
  public void testPostfixEvaluator(){
    int result = PostfixEvaluatorV2.evaluate(InfixToPostfixV2.convert(TokenizerV2.parseString("344+6*90/3+ (9-3)%5")));
    Assert.assertTrue("Expression should evaluate to 525 but instead gave " + result ,result==525);
  }  
  
  @Test(expected=IllegalArgumentException.class)
  public void testInfixToPostfixFailMissingOneOperand(){
    PostfixEvaluatorV2.evaluate(InfixToPostfixV2.convert(TokenizerV2.parseString("344+6*")));
  }    
  
  @Test(expected=IllegalArgumentException.class)
  public void testInfixToPostfixFailMissingTwoOperands(){
    PostfixEvaluatorV2.evaluate(InfixToPostfixV2.convert(TokenizerV2.parseString("*")));
  }    
}
