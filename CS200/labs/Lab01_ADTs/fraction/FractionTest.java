import org.junit.*;

// add another import to give the test class access to the fraction package
//********COMPLETE ME*******************************************************************************


/**
 * A JUnit test case class for the IntFraction class.
 * 
 */
public class FractionTest {
  
  private Fraction frac1, frac2, frac3, frac4;
  
  @Before
  public void init() {
    //frac1 and frac2 are created using constructor 3
    frac1 = new IntFraction(5,7);
    frac2 = new IntFraction(1,2);
    //frac3 is created using constructor 1
    frac3 = new IntFraction();
    //frac4 is created using constructor 2
    frac4 = new IntFraction(5);
  }
  
  /**
   * Complete the test methods below to test the three constructors in class IncFraction. We need to make 
   * sure that the constructors work properly and do not take a 0 parameter for the demonimator.
   * 1. Test each of the frac instance variables has the correct numerator and denominator  
   * 2. Check that contructor 3 fails to create a fraction with a zero denominator
   */
  
  @Test
  public void testDefaultConstructor(){
    //********COMPLETE ME*******************************************************************************
  }
  
  @Test
  public void testSecondConstructor(){
    //********COMPLETE ME*******************************************************************************  
  }
  
  @Test
  public void testThirdConstructor(){
    //********COMPLETE ME*******************************************************************************  
  }  
  
  @Test(expected = IllegalArgumentException.class)
  public void testThirdConstructorFailsForZeroDenominator(){
    //********COMPLETE ME*******************************************************************************  
  }
  
  /**
   * Complete the test method below to test that method addToThis returns a correct fraction result and that the 
   * operand fractions (frac1 and frac2) do not change as a result of this operation
   */  
  @Test
  public void testAddToThis(){
    Fraction test = (IntFraction) frac1.addToThis(frac2);      
    //********COMPLETE ME*******************************************************************************  
  }
  
  /**
   * Add the following test methods (create a separate, clearly-named test method for each case)
   * 
   * 1- test that method subtractFromThis returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   * 
   * 2- test that method multiplyThisBy returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   * 
   * 3- test that method divideThisBy returns a correct fraction result and that 
   * operand fractions do not change as a result of this operation
   * 
   * 4- test that method divideThisBy fails if provided a zero fraction as a parameter 
   *
   * 5- test that two fractions with the same numerators and denominators are equal 
   * 
   * 6- test that two fractions may still be equal even with the different numerators and denominators 
   *     - e.g. 1: 5/7 and 10/14 
   *     - e.g. 2: 1/2 and -5/-10
   * 
   * 7- test that two fractions may be unequal (e.g. 5/7 and -5/-10)
   */

}