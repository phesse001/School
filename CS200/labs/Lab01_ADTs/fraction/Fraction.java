/*
 * Fraction.java
 */

package fraction;

/** 
 * Fraction is an interface for objects that represent rational numbers
 * as fractions
 * 
 * @author J. Andrew Holey
 * @version January 13, 2009
 */
public  interface  Fraction {
  
  /**
   * Add the specified addend to this Fraction and return the result
   * 
   * pre: result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param addend the Fraction to add to this Fraction
   * @return the sum of this Fraction and addend
   */
  public Fraction addToThis(Fraction addend);
  
  /**
   * Subtract the specified subtrahend from this Fraction and return the result
   * 
   * pre: result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param subtrahend the Fraction to subtract from this Fraction
   * @return the difference between this Fraction (the minuend) and subtrahend
   */
  public Fraction subtractFromThis(Fraction subtrahend);
  
  /**
   * Multiply this Fraction by the specified multiplier and return the result
   * 
   * pre: result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param multiplier the Fraction to multiply this Fraction by
   * @return the product of this Fraction (the multiplicand) and multiplier
   */
  public Fraction multiplyThisBy(Fraction multiplier);
  
  /**
   * Divide this Fraction by the specified divisor and return the result
   * 
   * pre: divisor is not a zero Fraction
   *      and result should be computable within the types used for the
   *      representation
   * post: this Fraction is unchanged
   * 
   * @param divisor the Fraction to divide this Fraction by
   * @return the quotient of this Fraction and divisor
   * @throws ArithmeticException if divisor is a zero Fraction
   */
  public Fraction divideThisBy(Fraction divisor);
  
  /**
   * Compare this Fraction to another object to determine if they are equal
   *
   * post: this Fraction is unchanged
   * 
   * @param other the object to which to compare this Fraction
   * @return true if other is a Fraction equal to this Fraction; false otherwise
   */
  public boolean equals(Object other);
  
  /**
   * Get the value of the numerator of this Fraction
   * 
   * post: this Fraction is unchanged
   * 
   * @return the Integer value of the numerator
   */
  public int getNumerator();
  
  
  /**
   * Get the value of the denominator of this Fraction
   * 
   * post: this Fraction is unchanged
   * 
   * @return the Integer value of the denominator
   */
  public int getDenominator();
  
}
