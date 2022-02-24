/**
 * VolunteerTest.java
 */

import worker.*;
import org.junit.*;

public class VolunteerTest {
  private Volunteer noHoursVolunteer, withHoursVolunteer;
  
  @Before
  public void init(){
    // creates Volunteer workers with name
    noHoursVolunteer=new Volunteer("noHoursVolunteer");
    withHoursVolunteer=new Volunteer("withHoursVolunteer",10);
  }
  
  /**
   * test that the constructor in class Volunteer sets the name and hours fields to the expected 
   * initial values and that the toString method returns the String "Volunteer" 
   */
  @Test
  public void testVolunteerConstructor(){
    Assert.assertTrue("noHoursVolunteer should have given name",noHoursVolunteer.getName().equals("noHoursVolunteer"));
    Assert.assertTrue("Hours in noHoursVolunteer should be 0 initially", noHoursVolunteer.getHours()==0);
    Assert.assertTrue("toString should return 'Volunteer'",noHoursVolunteer.toString().equals("Volunteer"));
    
    Assert.assertTrue("withHoursVolunteer should have given name",withHoursVolunteer.getName().equals("withHoursVolunteer"));
    Assert.assertTrue("Hours in withHoursVolunteer should be 10 initially", withHoursVolunteer.getHours()==10);
    Assert.assertTrue("toString should return 'Volunteer'",withHoursVolunteer.toString().equals("Volunteer"));    
  }  
  
  
  /**
   * test that method addHours in Volunteer adds non-negative hours properly
   */ 
  @Test
  public void testAddHoursValidParameter(){
    noHoursVolunteer.addHours(5);
    Assert.assertTrue("Hours should add positive numbers correctly",noHoursVolunteer.getHours()==5);
    withHoursVolunteer.addHours(6);
    Assert.assertTrue("Hours should add positive numbers correctly",withHoursVolunteer.getHours()==16);   
  }
  
  
  /**
   * test that method addHours in Volunteer fails as expected for negative hours
   */
  @Test(expected=IllegalArgumentException.class)
  public void testAddHoursFailsForNegativeParameter(){
    noHoursVolunteer.addHours(-5);
  }
  
  
  /**
   * test that method resetHours in Volunteer works properly 
   */   
  @Test
  public void testResetHours(){
    noHoursVolunteer.resetHours();
    Assert.assertTrue("Hours should be reset to 0",noHoursVolunteer.getHours()==0);

    withHoursVolunteer.resetHours();
    Assert.assertTrue("Hours should be reset to 0",withHoursVolunteer.getHours()==0);     
  }
  
  /**
   * test that method equals returns true for different Workers with the same names  
   */  
  @Test
  public void testEqualsDifferentWorkersSameNames(){
    noHoursVolunteer=new Volunteer("test");
    withHoursVolunteer=new Volunteer("test",10);
    Assert.assertTrue("Volunteers should be equal",noHoursVolunteer.equals(withHoursVolunteer));
    
    Assert.assertTrue("Volunteer and HourlyEmployee should be equal",noHoursVolunteer.equals(new HourlyEmployee("test",0,0)));
    
    Assert.assertTrue("Volunteer and SalariedEmployee should be equal",noHoursVolunteer.equals(new SalariedEmployee("test",0)));
  }
  
  /**
   * test that method equals returns false for Workers with different names  
   */  
  @Test
  public void testEqualsDifferentWorkersDifferentNames(){
    Assert.assertFalse("Volunteers should not be equal",noHoursVolunteer.equals(withHoursVolunteer));
    
    Assert.assertFalse("Volunteer and HourlyEmployee should not be equal",noHoursVolunteer.equals(new HourlyEmployee("test",0,0)));
    
    Assert.assertFalse("Volunteer and SalariedEmployee should not be equal",noHoursVolunteer.equals(new SalariedEmployee("test",0)));
  }
}
