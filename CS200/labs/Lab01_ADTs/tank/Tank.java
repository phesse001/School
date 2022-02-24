/*
 * File: Tank.java
 */

package tank;

/** 
 * Tank is an interface for objects that hold a quantity of some substance
 * up to a maximum capacity.
 * 
 * @author John Miller and J. Andrew Holey
 * @version January 9, 2009
 */
public interface Tank
{
  
  /**
   * Put general description of the method here
   *
   * pre: fill in these lines with appropriate precondition(s) 
   *      or delete them if not needed
   * post: fill in these lines with appropriate postcondition(s) 
   *       or delete it if not needed
   *
   * @param parameter-name description of parameter    // delete if not needed
   * @return description of the return value           // delete if not needed
   * @throws exception-name description of when thrown // delete if not needed
   */
  public boolean isEmpty();
  
  /**
   * Put general description of the method here
   *
   * pre: fill in these lines with appropriate precondition(s) 
   *      or delete them if not needed
   * post: fill in these lines with appropriate postcondition(s) 
   *       or delete it if not needed
   *
   * @param parameter-name description of parameter    // delete if not needed
   * @return description of the return value           // delete if not needed
   * @throws exception-name description of when thrown // delete if not needed
   */
  public boolean isFull();
  
  /**
   * Put general description of the method here
   *
   * pre: fill in these lines with appropriate precondition(s) 
   *      or delete them if not needed
   * post: fill in these lines with appropriate postcondition(s) 
   *       or delete it if not needed
   *
   * @param parameter-name description of parameter    // delete if not needed
   * @return description of the return value           // delete if not needed
   * @throws exception-name description of when thrown // delete if not needed
   */
  public double getCapacity();
  
  /**
   * Put general description of the method here
   *
   * pre: fill in these lines with appropriate precondition(s) 
   *      or delete them if not needed
   * post: fill in these lines with appropriate postcondition(s) 
   *       or delete it if not needed
   *
   * @param parameter-name description of parameter    // delete if not needed
   * @return description of the return value           // delete if not needed
   * @throws exception-name description of when thrown // delete if not needed
   */
  public double getLevel();
 
  /**
   * Put general description of the method here
   *
   * pre: fill in these lines with appropriate precondition(s) 
   *      or delete them if not needed
   * post: fill in these lines with appropriate postcondition(s) 
   *       or delete it if not needed
   *
   * @param parameter-name description of parameter    // delete if not needed
   * @return description of the return value           // delete if not needed
   * @throws exception-name description of when thrown // delete if not needed
   */
  public void add(double amount);
  
  /**
   * Put general description of the method here
   *
   * pre: fill in these lines with appropriate precondition(s) 
   *      or delete them if not needed
   * post: fill in these lines with appropriate postcondition(s) 
   *       or delete it if not needed
   *
   * @param parameter-name description of parameter    // delete if not needed
   * @return description of the return value           // delete if not needed
   * @throws exception-name description of when thrown // delete if not needed
   */
  public void remove(double amount);

}
