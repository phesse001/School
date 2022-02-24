/*
 * File: PassengerQueue.java
 */

import java.util.*;
import zhstructures.*;

/** 
 * Class to simulate a queue of passengers.
 * 
 * @author Koffman & Wolfgang, modified by J. A. Holey
 * @version October 21, 2008
 */

public class PassengerQueue {
  // Data Fields
  /**  The queue of passengers. */
  private ZHQueue<Passenger> queue;
  
  /** The number of passengers served. */
  private int numServed = 0;
  
  /** The total units of time passengers were waiting in the queue. */
  private int totalWait = 0;
  
  /** The name of this queue. */
  private String queueName;
  
  /** The average arrival rate per unit of time. */
  private double arrivalRate;
  
  // Constructor
  /** 
   * Construct a PassengerQueue with the given name.
   * 
   * @param queueName the name of this queue
   */
  public PassengerQueue(String queueName) {
    this.queueName = queueName;
    queue = new ZHLinkedQueue<Passenger> ();
  }
  
  /** 
   * Return the number of passengers served
   * 
   * @return the number of passengers served
   */
  public int getNumServed() {
    return numServed;
  }
  
  /** 
   * Return the total wait time
   * 
   * @return the total wait time
   */
  public int getTotalWait() {
    return totalWait;
  }
  
  /**
   * Return the queue name
   * 
   * @return the queue name
   */
  public String getQueueName() {
    return queueName;
  }
  
  /**
   * Set the arrival rate
   * 
   * @param arrivalRate the value to set
   */
  public void setArrivalRate(double arrivalRate) {
    this.arrivalRate = arrivalRate;
  }
  
  /**
   * Determine if the passenger queue is empty
   * 
   * @return true if the passenger queue is empty
   */
  public boolean isEmpty() {
    return queue.isEmpty();
  }
  
  /** Determine the size of the passenger queue
    @return the size of the passenger queue
    */
  public int size() {
    //int size = 0;
    //for(Passenger p : queue) size++;
    return queue.size();
  }
  
  /**
   * Check if a new arrival has occurred.
   * 
   * @param clock the current simulated time
   * @param showAll flag to indicate that detailed
   *                data should be output
   */
  public void checkNewArrival(int clock, boolean showAll) {
    if (Math.random() < arrivalRate) {
      queue.enqueue(new Passenger(clock));
      if (showAll) {
        System.out.println("Time is "
                             + clock + ": "
                             + queueName
                             + " arrival, new queue size is "
                             + this.size());
      }
    }
  }
  
  /**
   * Update statistics.
   * 
   * pre: The queue is not empty.
   * 
   * @param clock the current simulated time
   * @param showAll flag to indicate whether to show detail
   * @return the time passenger is done being served
   */
  public int update(int clock, boolean showAll) {
    Passenger nextPassenger = queue.dequeue();
    int timeStamp = nextPassenger.getArrivalTime();
    int wait = clock - timeStamp;
    totalWait += wait;
    numServed++;
    if (showAll) {
      System.out.println("Time is " + clock
                           + ": Serving "
                           + queueName
                           + " with time stamp "
                           + timeStamp);
    }
    return clock + nextPassenger.getProcessingTime();
  }
  
}
