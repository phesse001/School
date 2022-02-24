/*
 * File: TankTest.java
 */

import tank.*;

import org.junit.*;

/**
 * A JUnit test case class for the DoubleTank class.
 * 
 * Every method preceded with an @Test annotation will be called when running
 * the test with JUnit. Methods preceded with an @Before annotation are re-executed 
 * before each test method is run
 */
public class TankTest {
  
  private Tank emptyTank, // a tank initalized to be EMPTY
               fullTank, // a tank initalized to be FULL
               notFullTank;  // a tank initalized to be neither EMPTY nor  FULL
  
  @Before
  public void init() {
    emptyTank = new DoubleTank();       // uses default constructor
    notFullTank = new DoubleTank(250.0);
    notFullTank.add(50.0);
    fullTank = new DoubleTank();
    fullTank.add(DoubleTank.DEFAULT_CAPACITY);
  }
  
  @Test
  public void testDefaultConstructor() {
    Assert.assertTrue("emptyTank initially empty", emptyTank.isEmpty());
    Assert.assertTrue("emptyTank capacity is appropriate default", emptyTank.getCapacity()== 
                                                                   DoubleTank.DEFAULT_CAPACITY);
  }
  
  @Test
  public void testSecondConstructor(){
    Assert.assertTrue("notFullTank initially NOT empty", !notFullTank.isEmpty());
    Assert.assertTrue("notFullTank should have 50.0",notFullTank.getLevel()==50.0);
    Assert.assertTrue("notFullTank capacity is 250", notFullTank.getCapacity()== 250.0);  
  }
  
  // Put additional test methods here. Each method name must be preceded with an @Test annotation
  @Test
  public void testAddToEmptyTank() {
    //COMPLETE
  }
  
  
 
  
}
