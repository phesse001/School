/*
 * File: <FOO>LinkedStack.java
 */
package <foo>structures;

import java.util.*;
import zhstructures.*;

/**
 * Class implementing a ZHStack using an internal
 * one-way linked structure/node.
 * 
 * @author I. Rahal, J. A. Whitford Holey, and <YOUR NAME>
 * @version <today's date>
 */
public class <FOO>LinkedStack<ElementType> implements ZHStack<ElementType> {
  
  /**
   * The number of elements in this stack.
   */
  protected int size = 0;
  /**
   * A reference to the top node in this stack.
   */
  protected StackNode top;
  
  /**
   * Creates a new empty stack.
   */
  public <FOO>LinkedStack() {
    this.top = new StackNode();
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHStack#peek()
   */
  public ElementType peek() {
    //COMPLETE ME *************************************************************
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHStack#pop()
   */
  public ElementType pop() {
    //COMPLETE ME **************************************************************
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHStack#push(java.lang.Object)
   */
  public void push(ElementType element) {
    //COMPLETE ME **************************************************************
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#contains(java.lang.Object)
   */
  public boolean contains(ElementType element) {
    //COMPLETE ME *************************************************************
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#isEmpty()
   */
  public boolean isEmpty() {
    //COMPLETE ME *************************************************************
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#size()
   */
  public int size() {
    //COMPLETE ME *************************************************************
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHCollection#iterator()
   */
  public Iterator<ElementType> iterator() {
    return this.top.iterator();
  }
  
  /**
   * Class implementing nodes for this stack.
   * 
   * Inherited methods:
   *   boolean contains()
   *   boolean isEmpty()
   *   int size()
   *   Iterator<ElementType> iterator()
   *   ElementType getElement()
   *   void setElement(ElementType element)
   *   StackNode getNext()
   *   void setNext(StackNode next)
   */
  protected class StackNode
    extends ZHOneWayListNode<ElementType, StackNode> {
    
    /**
     * Creates a new empty node.
     */
    protected StackNode() {
      super();
    }
    
    /**
     * Creates a new node with the specified data element and next node.
     * 
     * @param element the data element for the new node
     * @param next the next node for the new node
     */
    protected StackNode(ElementType element, StackNode next) {
      super(element, next);
    }
  }
}
