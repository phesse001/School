/*
 * File: WorkerPolymorphismTest.java
 */

import worker.*;
import org.junit.*;

/**
 * JUnit test class for the CSCI 200 Worker class hierarchy;
 * this particular class tests the polymorphism
 * 
 * @author  Imad Rahal and J. Andrew Whitford Holey
 * @version January 25, 2017
 */
public class WorkerPolymorphismTest {

  // NOTE: In this test class, each test uses a different Worker,
  // so there are no instance variables, and there is no @Before method.
  /**
   * Test that Worker volunteerWorker is an instance of Worker,
   * HourlyWorker, and Volunteer, but not an instance of Employee,
   * HourlyEmployee, or SalariedEmployee.
   */   
  @Test
  public void testPolymorphismForVolunteers() {
    // create a Volunteer worker with name "VolunteerWorker"
    Worker volunteerWorker = new Volunteer("VolunteerWorker");

    Assert.assertTrue( "Volunteers are Workers",
                       volunteerWorker instanceof Worker);
    Assert.assertTrue( "Volunteers are HourlyWorkers",
                       volunteerWorker instanceof HourlyWorker);
    Assert.assertTrue( "Volunteers are Volunteers",
                       volunteerWorker instanceof Volunteer);
    Assert.assertFalse("Volunteers are NOT Employees",
                       volunteerWorker instanceof Employee);
    Assert.assertFalse("Volunteers are NOT HourlyEmployees",
                       volunteerWorker instanceof HourlyEmployee);
    Assert.assertFalse("Volunteers are NOT SalariedEmployees",
                       volunteerWorker instanceof SalariedEmployee);
  }
  
  /**
   * Test that Worker hourlyEmployeeWorker is an instance of Worker,
   * HourlyWorker, Employee, and HourlyEmployee,
   * but not an instance of Volunteer or SalariedEmployee
   */   
  @Test
  public void testPolymorphismForHourlyEmployees(){
    // create an HourlyEmployee worker with name "HourlyEmployeeWorker"
    // and $20.00 hourlyPay 
    Worker hourlyEmployeeWorker =
      new HourlyEmployee("HourlyEmployeeWorker", 20, 10.5);

    Assert.assertTrue ("HourlyEmployees are Workers",
                       hourlyEmployeeWorker instanceof Worker);
    Assert.assertTrue ("HourlyEmployees are HourlyWorkers",
                       hourlyEmployeeWorker instanceof HourlyWorker);
    Assert.assertTrue ("HourlyEmployees are Employees",
                       hourlyEmployeeWorker instanceof Employee);
    Assert.assertTrue ("HourlyEmployees are HourlyEmployees",
                       hourlyEmployeeWorker instanceof HourlyEmployee);
    Assert.assertFalse("HourlyEmployees are NOT Volunteers",
                       hourlyEmployeeWorker instanceof Volunteer);
    Assert.assertFalse("HourlyEmployees are NOT SalariedEmployees",
                       hourlyEmployeeWorker instanceof SalariedEmployee);
  }
  
  /**
   * Test that Worker salariedEmployeeWorker is an instance of Worker,
   * Employee, and SalariedEmployee but not an instance of
   * Volunteer or HourlyWorker.
   */   
  @Test
  public void testPolymorphismForSalariedEmployees(){
    // create an SalariedEmployee worker with name "SalariedEmployeeWorker"
    // and $5000.00 monthlySalary   
    Worker salariedEmployeeWorker =
       new SalariedEmployee("SalariedEmployeeWorker", 5000);

    Assert.assertTrue ("SalariedEmployees are Workers",
                       salariedEmployeeWorker instanceof Worker);
    Assert.assertTrue ("SalariedEmployees are Employees",
                       salariedEmployeeWorker instanceof Employee);
    Assert.assertTrue ("SalariedEmployees are SalariedEmployees",
                       salariedEmployeeWorker instanceof SalariedEmployee);
    Assert.assertFalse("SalariedEmployees are NOT HourlyWorkers",
                       salariedEmployeeWorker instanceof HourlyWorker);    
    Assert.assertFalse("SalariedEmployees are NOT Volunteers",
                       salariedEmployeeWorker instanceof Volunteer);
    Assert.assertFalse("SalariedEmployees are NOT HourlyEmployees",
                       salariedEmployeeWorker instanceof HourlyEmployee);
  } 
}
