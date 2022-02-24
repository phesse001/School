/*
 * File AirlineChekinSim.java
 */

import java.util.*;
import javax.swing.*;

/**
 * Simulate the check-in process of an airline.
 * 
 * @author Koffman & Wolfgang, edited by J. A. Holey & I. M. Rahal
 * @version October 20, 2010
 */
public class AirlineCheckinSim {
  
  // Data Fields
  /** Queue of frequent flyers. */
  private PassengerQueue frequentFlyerQueue =
    new PassengerQueue("Frequent Flyer");
  
  /** Queue of regular passengers. */
  private PassengerQueue regularPassengerQueue =
    new PassengerQueue("Regular Passenger");
  
  /** Maximum number of frequent flyers to be served
    before a regular passenger gets served. */
  private int frequentFlyerMax;
  
  /** Maximum time to service a passenger. */
  private int maxProcessingTime;
  
  /** Total simulated time. */
  private int totalTime;
  
  /** If set true, print additional output. */
  private boolean showAll = true;
  
  /** Simulated clock. */
  private int clock = 0;
  
  /** Time that the agent will be done with the current passenger.*/
  private int timeDone;
  
  /** Number of frequent flyers served since the
    last regular passenger was served. */
  private int frequentFlyersSinceRP;
  
  /**
   * Get the data for the simulation.
   */
  private void enterData() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter totalTime (an integer):" +
                       "The total time to run the simulation");
    totalTime = sc.nextInt();
    System.out.println("Enter maxProcessingTime (an integer): " +
                       "The maximum time to serve a passenger");
    maxProcessingTime = sc.nextInt();
    Passenger.setMaxProcessingTime(maxProcessingTime);
    System.out.println("Enter frequentFlyerMax (an integer): " +
                       "The maximum number of frequent flyers " +
                       "to serve between regular passengers");
    frequentFlyerMax = sc.nextInt();
    System.out.println("Enter arrivalRate for regular passengers (a double): " +
                       "The expected number of passenger arrivals per unit of time");
    regularPassengerQueue.setArrivalRate(sc.nextDouble());
    System.out.println("Enter arrivalRate for frequent flyers (a double): " +
                       "The expected number of frequent flyer arrivals per unit of time");
    frequentFlyerQueue.setArrivalRate(sc.nextDouble());
  }
  
  /**
   * Run the simulation.
   */
  private void runSimulation() {
    for (clock = 0; clock < totalTime; clock++) {
      frequentFlyerQueue.checkNewArrival(clock, showAll);
      regularPassengerQueue.checkNewArrival(clock, showAll);
      if (clock >= timeDone) { //means that teller is ready to serve (i.e., not busy)
        startServe();
      }
    }
  }
  
  /**
   * Serve the queues in the simulation.
   */
  private void startServe() {
    if (!frequentFlyerQueue.isEmpty() &&
        ((frequentFlyersSinceRP <= frequentFlyerMax) ||
         regularPassengerQueue.isEmpty())) {
      // Serve the next frequent flyer.
      frequentFlyersSinceRP++;
      timeDone = frequentFlyerQueue.update(clock, showAll);
    }
    else if (!regularPassengerQueue.isEmpty()) {
      // Serve the next regular passenger.
      frequentFlyersSinceRP = 0;
      timeDone = regularPassengerQueue.update(clock, showAll);
    }
    else if (showAll) {
      System.out.println("Time is " + clock + "; server is idle");
    }
  }
  
  /**
   * Show the statistics after the simulation.
   */
  private void showStats() {
    System.out.println("\nThe number of regular passengers served was " +
                       regularPassengerQueue.getNumServed());
    double averageWaitingTime =
      (double) regularPassengerQueue.getTotalWait() /
      (double) regularPassengerQueue.getNumServed();
    System.out.println(" with an average waiting time of " +
                       averageWaitingTime);
    System.out.println("The number of frequent flyers served was " +
                       frequentFlyerQueue.getNumServed());
    averageWaitingTime =
      (double) frequentFlyerQueue.getTotalWait() /
      (double) frequentFlyerQueue.getNumServed();
    System.out.println(" with an average waiting time of " +
                       averageWaitingTime);
    System.out.println("Passengers in frequent flyer queue: " +
                       frequentFlyerQueue.size());
    System.out.println("Passengers in regular passenger queue: " +
                       regularPassengerQueue.size());
  }
  
  /**
   * Main method for the simulation program.
   * 
   * @param args the command line arguments (not used)
   */
  public static void main(String args[] ){
    AirlineCheckinSim sim = new AirlineCheckinSim();
    sim.enterData();
    sim.runSimulation();
    sim.showStats();
  }
  
}
