import zhstructures.*;
import org.junit.*;
import java.util.*;
import <foo>structures.*;;

/**
 * A JUnit test case class for class <FOO>HeapPriorityQueue  
 * 
 * @author Imad M Rahal
 * @version October 18, 2017
 */
public class HeapPriorityQueueTest {
  
  private ZHQueue<Integer> nonEmptyPQ, emptyPQ;
  
  @Before
  public void init(){
    nonEmptyPQ = new <FOO>HeapPriorityQueue<Integer>();
    emptyPQ = new <FOO>HeapPriorityQueue<Integer>(5);
    nonEmptyPQ.enqueue(10);
    nonEmptyPQ.enqueue(50);
    nonEmptyPQ.enqueue(40);
    nonEmptyPQ.enqueue(20);
    nonEmptyPQ.enqueue(30);
    nonEmptyPQ.enqueue(60);
    nonEmptyPQ.enqueue(0);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testConstructorFailsNegativeCapacity(){
    emptyPQ = new <FOO>HeapPriorityQueue<Integer>(-1);
  }
  @Test(expected=IllegalArgumentException.class)
  public void testConstructorFailsZeroCapacity(){
    emptyPQ = new <FOO>HeapPriorityQueue<Integer>(0);
  }
  
  @Test
  public void testPeek(){
    Assert.assertTrue("nonEmptyPQ's peek is 0",nonEmptyPQ.peek()==0);
  }
  
  @Test(expected=NoSuchElementException.class)
  public void testPeekFailsWhenHeapIsEmpty(){
    emptyPQ.peek();
  }  
  
  @Test
  public void testEnqueue(){
    Assert.assertTrue("nonEmptyPQ's peek is 0",nonEmptyPQ.peek()==0);
    nonEmptyPQ.enqueue(5);
    Assert.assertTrue("nonEmptyPQ's peek is 0",nonEmptyPQ.peek()==0);       
    emptyPQ.enqueue(1);
    Assert.assertTrue("emptyPQ's peek is 1",emptyPQ.peek()==1);    
    emptyPQ.enqueue(2);
    Assert.assertTrue("emptyPQ's peek is still 1",emptyPQ.peek()==1);    
  }  
  
  
  @Test
  public void testDequeue(){
    Assert.assertTrue("nonEmptyPQ's dequeue ",(int) nonEmptyPQ.dequeue()==0);  
    Assert.assertTrue("nonEmptyPQ's dequeue ",(int) nonEmptyPQ.dequeue()==10);  
    Assert.assertTrue("nonEmptyPQ's dequeue ",(int) nonEmptyPQ.dequeue()==20);
    Assert.assertTrue("nonEmptyPQ's dequeue ",(int) nonEmptyPQ.dequeue()==30);
    Assert.assertTrue("nonEmptyPQ's dequeue ",(int) nonEmptyPQ.dequeue()==40);
    Assert.assertTrue("nonEmptyPQ's dequeue ",(int) nonEmptyPQ.dequeue()==50);
    Assert.assertTrue("nonEmptyPQ's dequeue ",(int) nonEmptyPQ.dequeue()==60);
  }
  
  
  
  @Test(expected=NoSuchElementException.class)
  public void testDequeueFailsWhenHeapIsEmpty(){
    emptyPQ.dequeue();
  }
  
  @Test
  public void testIsEmpty(){    
    Assert.assertFalse("nonEmptyPQ is NOT empty",nonEmptyPQ.isEmpty());
    Assert.assertTrue("emptyPQ is empty",emptyPQ.isEmpty());
  } 
  
  @Test 
  public void testContainsReturnsTrue(){
    Assert.assertTrue("nonEmptyPQ contains element 0 ",nonEmptyPQ.contains(0));
    Assert.assertTrue("nonEmptyPQ contains element 10 ",nonEmptyPQ.contains(10));
    Assert.assertTrue("nonEmptyPQ contains element 20 ",nonEmptyPQ.contains(20));
    Assert.assertTrue("nonEmptyPQ contains element 30 ",nonEmptyPQ.contains(30));
    Assert.assertTrue("nonEmptyPQ contains element 40 ",nonEmptyPQ.contains(40));
    Assert.assertTrue("nonEmptyPQ contains element 50 ",nonEmptyPQ.contains(50));
    Assert.assertTrue("nonEmptyPQ contains element 60 ",nonEmptyPQ.contains(60));
  }
  
  @Test 
  public void testContainsReturnsFalse(){
    Assert.assertFalse("nonEmptyPQ does not contain element 50 ",nonEmptyPQ.contains(100));
    Assert.assertFalse("emptyPQ does not contain element 10 ",emptyPQ.contains(10));
  }
  
  @Test
  public void testIterator(){
    int i = 0;
    for (Integer element : nonEmptyPQ) {
      Assert.assertTrue("nonEmptyPQ contains element " + element, nonEmptyPQ.contains(element));
      i++;
    }
    Assert.assertTrue("nonEmptyPQ contains the same number of elements in iterator ",nonEmptyPQ.size()==i);
  }
  
  @Test
  public void testSize(){
    Assert.assertTrue("nonEmptyPQ contains 7 elements ",nonEmptyPQ.size()==7);
    Assert.assertTrue("emptyPQ contains 0 elements ",emptyPQ.size()==0);
    nonEmptyPQ.dequeue();
    Assert.assertTrue("nonEmptyPQ contains 6 elements ",nonEmptyPQ.size()==6);
    nonEmptyPQ.dequeue();
    Assert.assertTrue("nonEmptyPQ contains 5 elements ",nonEmptyPQ.size()==5);
    nonEmptyPQ.dequeue();
    Assert.assertTrue("nonEmptyPQ contains 4 elements ",nonEmptyPQ.size()==4);
    nonEmptyPQ.dequeue();
    Assert.assertTrue("nonEmptyPQ contains 3 elements ",nonEmptyPQ.size()==3);
    nonEmptyPQ.dequeue();
    Assert.assertTrue("nonEmptyPQ contains 2 elements ",nonEmptyPQ.size()==2);
    nonEmptyPQ.dequeue();
    Assert.assertTrue("nonEmptyPQ contains 1 elements ",nonEmptyPQ.size()==1);
    nonEmptyPQ.dequeue();
    Assert.assertTrue("nonEmptyPQ contains 0 elements ",nonEmptyPQ.size()==0);    
    nonEmptyPQ.enqueue(10);
    Assert.assertTrue("nonEmptyPQ contains 1 element  ",nonEmptyPQ.size()==1);    
  }
}
