import java.util.*;
import worker.*;
import javax.swing.*;
import java.io.*;

/**
 * This class implements a program that manages a set of workers.
 *
 * @author J. Miller, J. A. Holey and YOUR NAME
 * @version TODAY'S DATE
 */
public class WorkerManager{

  private Set<Worker> workers;
  
  public WorkerManager(){
    System.out.println("Welcome to the Worker Manager");
    workers = new HashSet<Worker>();
  }
  
  public void runManager() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
  private void menu() {
    System.out.println();
    System.out.println("\tA Add a new worker");
    System.out.println("\tR Remove a worker");
    System.out.println("\tM Manage an individual worker");
    System.out.println("\tP rePort on workers");
    System.out.println("\tS Save the current worker set");
    System.out.println("\tL Load a worker set");
    System.out.println("\tQ Quit the program");
    System.out.println();
  }
  
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");
    cmd = s.charAt(0);
    return cmd;
  }
  
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 'a': case 'A':
        add();
        break;
      case 'r': case 'R':
        remove();
        break;
      case 'm': case 'M':
        manage();
        break;
      case 'p': case 'P':
        report();
        break;
      case 's': case 'S':
        save();
        break;
      case 'l': case 'L':
        load();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /** add
    *
    * Prompt the user for the type of worker to add, create the appropriate worker type
    * and add the worker to the set.
    *
    */
  private void add() {
    System.out.println();
    System.out.println("Which type of worker do you want to add?");
    System.out.println();
    System.out.println("\tV add a Volunteer");
    System.out.println("\tH add an Hourly Employee");
    System.out.println("\tS add a Salaried Employee");
    System.out.println("\tC Cancel add worker");
    System.out.println();

    String s = JOptionPane.showInputDialog("Enter worker type: ");;
    char cmd = s.charAt(0);

    Worker newWorker;
    switch (cmd)
    {
      case 'v': case 'V':
        newWorker = newVolunteer();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 'h': case 'H':
        newWorker = newHourlyEmployee();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 's': case 'S':
        newWorker = newSalariedEmployee();
        if (!workers.add(newWorker)) {
          System.out.println("This worker already exists in this set");
        }
        break;
      case 'c': case 'C':
        System.out.println("Add worker cancelled");
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }

  /** newVolunteer
    * Method to get data for and create a new Volunteer
    */
  private Worker newVolunteer() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for a Volunteer (name and hours)
    return new Volunteer(/* fill in the appropriate parameters */);
  } 

  /** newHourlyEmployee
    * Method to get data for and create a new HourlyEmployee
    */
  private Worker newHourlyEmployee() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for an HourlyEmployee (name,  hours and hourly pay rate)
    return new HourlyEmployee(/* fill in the appropriate parameters */);
  } 

  /** newSalariedEmployee
    * Method to get data for and create a new SalariedEmployee
    */
  private Worker newSalariedEmployee() {
    // use the AcceptCommand method as a model to prompt for and get the data
    // you need for a SalariedEmployee (name and salary)
    return new SalariedEmployee(/* fill in the appropriate parameters */);
  } 
  
  /** remove 
    * Prompt the user for a worker name and remove that worker from the set;
    * report if the worker is not found
    */
  private void remove() {
    // Fill in appropriate code
  }
  
  /** manage 
    * Prompt the user for a worker name and find the worker;
    * if the worker is found, create a VolunteerManager, HourlyEmployeeManager or
    * SalariedEmployeeManager on that worker and run it;
    * otherwise report that the worker is not found
    */
  private void manage() {
    // Fill in appropriate code
  }
  
  /** report
    * Prompt the user for the type of report desired: all workers, hourly workers,
    * all employees, volunteers, hourly employees or salaried employees;
    * print a list of all the workers in the selected category.
    */
  private void report() {
    // Fill in appropriate code
  }
  
  /** save
    * Prompt the user for a file name and save the set to the 
    * specified file using an ObjectOutputStream;
    * report an error if an exception occured
    */
  private void save() {
    // Fill in appropriate code
  }
  
  /** load
    * Prompt the user for a file name and load a new set from the specified file
    * using an ObjectInputStream;
    * report an error if an exception occured
    */
  private void load() {
    // Fill in appropriate code
  }
    
  /** quit
    * Method to terminate the WorkerManager program
    */
  private void quit() {        
    System.out.println("Now exiting the Worker Manager\n");
  }
  
  /** Main program--creates and runs WorkerManager
    * @param args the command line arguments (not used)
    */
  public static void main (String args[]) {
    WorkerManager manager = new WorkerManager ();
    manager.runManager();
  }
}
