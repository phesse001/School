import zhstructures.*;
import <foo>structures.*;
import org.junit.*;
import java.util.*;

/**
 * A JUnit test case class for class <FOO>LinkedStack  
 * 
 * @author Imad M Rahal
 * @version 09/20/2017
 */
public class MYLinkedStackTest {
  
  private ZHStack<Integer> notEmptyStack, emptyStack;
  
  @Before
  public void init(){
    notEmptyStack = new <FOO>LinkedStack<Integer>();
    emptyStack = new <FOO>LinkedStack<Integer>();
    notEmptyStack.push(0);
    notEmptyStack.push(1);
    notEmptyStack.push(2);
    notEmptyStack.push(3);
    notEmptyStack.push(2);    
  }
  
  @Test
  public void testPeek(){
    Assert.assertTrue("notEmptyStack's peek is 2",notEmptyStack.peek()==2);
  }
  
  @Test(expected=NoSuchElementException.class)
  public void testPeekFailsWhenStackIsEmpty(){
    emptyStack.peek();
  }
  
  @Test
  public void testPush(){
    Assert.assertTrue("notEmptyStack's peek is 2",notEmptyStack.peek()==2);
    notEmptyStack.push(5);
    Assert.assertTrue("notEmptyStack's peek is 5",notEmptyStack.peek()==5);
    emptyStack.push(1);
    Assert.assertTrue("emptyStack's peek is 1",emptyStack.peek()==1);    
    emptyStack.push(2);
    Assert.assertTrue("emptyStack's peek is 2",emptyStack.peek()==2);    
  }
  
  @Test
  public void testPop(){
    Assert.assertTrue("notEmptyStack's peek is 2",notEmptyStack.peek()==2);
    Assert.assertTrue("popping notEmptyStack will return 2",notEmptyStack.pop()==2);
    Assert.assertTrue("notEmptyStack's peek is 3",notEmptyStack.peek()==3);    
    Assert.assertTrue("popping notEmptyStack will return 3",notEmptyStack.pop()==3);
    Assert.assertTrue("notEmptyStack's peek is 2",notEmptyStack.peek()==2);    
    Assert.assertTrue("popping notEmptyStack will return 2",notEmptyStack.pop()==2);
    Assert.assertTrue("notEmptyStack's peek is 1",notEmptyStack.peek()==1);    
    Assert.assertTrue("popping notEmptyStack will return 1",notEmptyStack.pop()==1);   
    Assert.assertTrue("notEmptyStack's peek is 0",notEmptyStack.peek()==0);
    Assert.assertTrue("popping notEmptyStack will return 0",notEmptyStack.pop()==0);     
  }
  
  @Test(expected=NoSuchElementException.class)
  public void testPopFailsWhenStackIsEmpty(){
    emptyStack.pop();
  }
  
  @Test
  public void testIsEmpty(){
    Assert.assertFalse("notEmptyStack is not empty ",notEmptyStack.isEmpty());
    Assert.assertTrue("emptyStack is empty ",emptyStack.isEmpty());
  }
  
  @Test
  public void testIterator(){
    int i = 0;
    for (Integer element : notEmptyStack) {
      Assert.assertTrue("notEmptyStack contains element " + element, notEmptyStack.contains(element));
      i++;
    }
    Assert.assertTrue("notEmptyStack contains the same number of elements in iterator ",notEmptyStack.size()==i);
  }
  
  @Test
  public void testSize(){
    Assert.assertTrue("notEmptyStack contains 5 elements ",notEmptyStack.size()==5);
    Assert.assertTrue("emptyStack contains 0 elements ",emptyStack.size()==0);
    notEmptyStack.pop();
    Assert.assertTrue("notEmptyStack contains 4 elements ",notEmptyStack.size()==4);
    notEmptyStack.pop();
    Assert.assertTrue("notEmptyStack contains 3 elements ",notEmptyStack.size()==3);
    notEmptyStack.pop();
    Assert.assertTrue("notEmptyStack contains 2 element  ",notEmptyStack.size()==2);
    notEmptyStack.pop();
    Assert.assertTrue("notEmptyStack contains 1 elements ",notEmptyStack.size()==1);
    notEmptyStack.push(5);
    Assert.assertTrue("notEmptyStack contains 2 element  ",notEmptyStack.size()==2);    
    notEmptyStack.pop();;
    Assert.assertTrue("notEmptyStack contains 1 element  ",notEmptyStack.size()==1);        
    notEmptyStack.pop();
    Assert.assertTrue("notEmptyStack contains 0 element  ",notEmptyStack.size()==0);         
  }
}
