/* File: CityNamesStreamDriver.java */

import java.util.*;
import java.io.*;

/**
 * This class uses methods in class CityNamesStream  to copy text from
 * standard input to standard output. It contains a "main" method to create an 
 * instance of this class and call another method called "run" 
 * 
 * @author  I. Rahal AND YOUR NAME
 * @version September 01, 2017
 */

public class CityNamesStreamDriver {
  
  /**
   * When complete, method "run" should accomplish the following 
   * (and in the shown order): 
   * 
   * 1. (Using a Scanner object) 
   *    Get the name of a text file from the user, 
   *    create an instance of class CityNameStreams, and 
   *    call method input2TextFile on the CityNameStreams instance passing 
   *    the text file name as a parameter. 
   * THIS PART IS COMPLETE
   * 
   * 2. Get the name of an object file from the user, and call
   *    method textFile2ObjectFile on the same CityNameStreams instance 
   *    passing the existing text file name (from 1.) and object file name as 
   *    parameters.
   *
   * 3. Call method objectFile2Output on the same CityNameStreams instance 
   *    passing the existing object file name (from 2.) as a parameter.
   */
  public void run() {
    // Create a Scanner for standard input
    Scanner systemInScan = new Scanner(System.in);
    
    // Part 1:
    System.out.print("Enter the name of the text file: ");
    String textFileName = systemInScan.next();
    CityNamesStream cns = new CityNamesStream();
    cns.input2TextFile(textFileName);
  }
  
  /**
   * Creates an object of this class and call its run method.
   * 
   * @param args the command line arguments--unused
   */
  public static void main(String [] args) {
    (new CityNamesStreamDriver()).run();
  }  
}
