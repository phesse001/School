import zhstructures.*;
import <foo>structures.*;
import org.junit.*;
import java.util.*;

/**
 * A JUnit test case class for class <<FOO>>IndexedListQueue
 * 
 * @author Imad M Rahal
 * @version October 04, 2017
 */
public class IndexedListQueueTest{
  
  private ZHQueue<Integer> notEmptyQueue, emptyQueue;
  
  @Before
  public void init(){
    notEmptyQueue = new <FOO>IndexedListQueue<Integer>();
    emptyQueue = new <FOO>IndexedListQueue();
    notEmptyQueue.enqueue(0);
    notEmptyQueue.enqueue(1);
    notEmptyQueue.enqueue(2);
    notEmptyQueue.enqueue(3);
    notEmptyQueue.enqueue(2);    
  }
  
  @Test
  public void testPeek(){
    Assert.assertTrue("notEmptyQueue's peek is 0",notEmptyQueue.peek()==0);
  }
  
  @Test(expected=NoSuchElementException.class)
  public void testPeekFailsWhenQueueIsEmpty(){
    emptyQueue.peek();
  }
  
  @Test
  public void testEnqueue(){
    Assert.assertTrue("notEmptyQueue's peek is 0",notEmptyQueue.peek()==0);
    notEmptyQueue.enqueue(5);
    Assert.assertTrue("notEmptyQueue's peek is 0",notEmptyQueue.peek()==0);       
    emptyQueue.enqueue(1);
    Assert.assertTrue("emptyQueue's peek is 1",emptyQueue.peek()==1);    
    emptyQueue.enqueue(2);
    Assert.assertTrue("emptyQueue's peek is still 1",emptyQueue.peek()==1);    
  }
  
  @Test
  public void testDequeue(){
    Assert.assertTrue("notEmptyQueue's peek is 2",notEmptyQueue.peek()==0);
    Assert.assertTrue("dequeuing from notEmptyQueue will return 0",notEmptyQueue.dequeue()==0);
    Assert.assertTrue("notEmptyQueue's peek is 1",notEmptyQueue.peek()==1);    
    Assert.assertTrue("dequeuing from  notEmptyQueue will return 1",notEmptyQueue.dequeue()==1);
    Assert.assertTrue("notEmptyQueue's peek is 2",notEmptyQueue.peek()==2);    
    Assert.assertTrue("dequeuing from  notEmptyQueue will return 2",notEmptyQueue.dequeue()==2);
    Assert.assertTrue("notEmptyQueue's peek is 3",notEmptyQueue.peek()==3);    
    Assert.assertTrue("dequeuing from  notEmptyQueue will return 3",notEmptyQueue.dequeue()==3);   
    Assert.assertTrue("notEmptyQueue's peek is 2",notEmptyQueue.peek()==2);    
    Assert.assertTrue("dequeuing from  notEmptyQueue will return 2",notEmptyQueue.dequeue()==2);  
  }
  
  @Test(expected=NoSuchElementException.class)
  public void testDequeueFailsWhenQueueIsEmpty(){
    emptyQueue.dequeue();
  }
  
  public void testIsEmpty(){
    Assert.assertFalse("notEmptyQueue is not empty ",notEmptyQueue.isEmpty());
    Assert.assertTrue("emptyQueue is empty ",emptyQueue.isEmpty());
  }
  
  public void testIterator(){
    int i = 0;
    for (Integer element : notEmptyQueue) {
      Assert.assertTrue("notEmptyQueue contains element " + element, notEmptyQueue.contains(element));
      i++;
    }
    Assert.assertTrue("notEmptyQueue contains the same number of elements in iterator ",notEmptyQueue.size()==i);
  }
  
  public void testSize(){
    Assert.assertTrue("notEmptyQueue contains 5 elements ",notEmptyQueue.size()==5);
    Assert.assertTrue("emptyQueue contains 0 elements ",emptyQueue.size()==0);
    notEmptyQueue.dequeue();
    Assert.assertTrue("notEmptyQueue contains 4 elements ",notEmptyQueue.size()==4);
    notEmptyQueue.dequeue();
    Assert.assertTrue("notEmptyQueue contains 3 elements ",notEmptyQueue.size()==3);
    notEmptyQueue.dequeue();
    Assert.assertTrue("notEmptyQueue contains 2 element  ",notEmptyQueue.size()==2);
    notEmptyQueue.dequeue();
    Assert.assertTrue("notEmptyQueue contains 1 elements ",notEmptyQueue.size()==1);
    notEmptyQueue.enqueue(5);
    Assert.assertTrue("notEmptyQueue contains 2 element  ",notEmptyQueue.size()==2);    
    notEmptyQueue.dequeue();;
    Assert.assertTrue("notEmptyQueue contains 1 element  ",notEmptyQueue.size()==1);        
    notEmptyQueue.dequeue();
    Assert.assertTrue("notEmptyQueue contains 0 element  ",notEmptyQueue.size()==0);        
  }
  
}

