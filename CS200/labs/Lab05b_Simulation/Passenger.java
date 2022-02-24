/*
 * File: Passenger.java
 */

import java.util.*;

/** 
 * A class to represent a passenger.
 * 
 * @author Koffman & Wolfgang, edited by J. A. Holey
 * @version October 21, 2008
 */

public class Passenger {
  
  // Data Fields
  /** The ID number for this passenger. */
  private int passengerId;
  
  /** The time needed to process this passenger. */
  private int processingTime;
  
  /** The time this passenger arrives. */
  private int arrivalTime;
  
  /** The maximum time to process a passenger. */
  private static int maxProcessingTime=10;
  
  /** The sequence number for passengers. */
  private static int idNum = 0;
  
  /**
   * Create a new passenger.
   * 
   * @param arrivalTime the time this passenger arrives
   */
  public Passenger(int arrivalTime) {
    this.arrivalTime = arrivalTime;
    processingTime = 1 + (new Random()).nextInt(maxProcessingTime);
    passengerId = idNum++;
  }
  
  /**
   * Get the arrival time.
   * 
   * @return the arrival time
   */
  public int getArrivalTime() {
    return arrivalTime;
  }
  
  /**
   * Get the processing time.
   * 
   * @return the processing time
   */
  public int getProcessingTime() {
    return processingTime;
  }
  
  /**
   * Get the passenger ID.
   * 
   * @return the passenger ID
   */
  public int getId() {
    return passengerId;
  }
  
  /**
   * Set the maximum processing time.
   * 
   * @param maxProcessingTime the new value for the maximum processing time
   */
  public static void setMaxProcessingTime(int maxProcessTime) {
    maxProcessingTime = maxProcessTime;
  }
}
