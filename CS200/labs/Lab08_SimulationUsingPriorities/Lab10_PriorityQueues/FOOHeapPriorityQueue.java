/*
 * File: <FOO>HeapPriorityQueue.java
 */

package <foo>structures;
import zhstructures.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that implements a ZHQueue as heap-based priority queue
 * using an extensible internal array structure.
 * 
 * @author J. Andrew Holey and <your name here>
 * @version <today's date here>
 */
public class <FOO>HeapPriorityQueue<ElementType extends Comparable<ElementType>>
  implements ZHQueue<ElementType> {
  
  private ZHExtensibleArrayStructure<ElementType> elements;
  
  /**
   * Creates a new empty queue with a default capacity.
   */
  public <FOO>HeapPriorityQueue() {
    // your code here
  }
  
  /**
   * Creates a new empty queue with the specified capacity.
   * 
   * @param capacity the initial capacity of the queue
   * @throws IllegalArgumentException if capacity <=0
   */
  public <FOO>HeapPriorityQueue(int capacity) {
    // your code here
  }

  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#contains()
   */
  public boolean contains(ElementType element) {
    // your code here
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#isEmpty()
   */
  public boolean isEmpty() {
    // your code here
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#size()
   */
  public int size() {
    // your code here
  }
    
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#iterator()
   */
  public Iterator<ElementType> iterator() {
    // your code here
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#peek()
   */
  public ElementType peek() {
    // your code here
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#dequeue()
   */
  public ElementType dequeue() {
    // your code here
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHQueue#enqueue(java.lang.Object)
   */
  public void enqueue(ElementType element) {
    // your code here
  }
    
}
