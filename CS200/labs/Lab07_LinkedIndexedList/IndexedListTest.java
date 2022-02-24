import <foo>structures.*;
import org.junit.*;
import java.util.*;
/**
 * A JUnit test case class for class <Foo>LinkedIndexedList  
 * 
 * @author Imad M Rahal
 * @version October 05, 2017
 */
public class IndexedListTest {
  
  private <FOO>IndexedList<Integer> notEmptyList, emptyList, withDuplicatesList;
  
  @Before
  public void init(){
    emptyList = new <FOO>LinkedIndexedList<Integer>();
    
    notEmptyList = new <FOO>LinkedIndexedList<Integer>();    
    notEmptyList.addElementAt(0,10);
    notEmptyList.addElementAt(1,20);
    notEmptyList.addElementAt(2,30);
    notEmptyList.addElementAt(3,40);
    notEmptyList.addElementAt(2,25);   
    
    withDuplicatesList  = new <FOO>LinkedIndexedList<Integer>();
    withDuplicatesList.addElementAt(0,10);
    withDuplicatesList.addElementAt(1,10);
    withDuplicatesList.addElementAt(2,30);
    withDuplicatesList.addElementAt(3,30);
    withDuplicatesList.addElementAt(4,50);       
    withDuplicatesList.addElementAt(5,50);       
  }
  
  //method isEmpty
  @Test 
  public void testIsEmptyReturnsFalse(){
    Assert.assertFalse("notEmptyList is not empty ",notEmptyList.isEmpty());
    Assert.assertFalse("withDuplicatesList is not empty ",withDuplicatesList.isEmpty());
  }
  
  @Test 
  public void testIsEmptyReturnsTrue(){
    Assert.assertTrue("emptyList is empty ",emptyList.isEmpty());
  } 
  
  //method contains  
  @Test 
  public void testContainsReturnsFalse(){
    Assert.assertFalse("notEmptyList does not contain element 50 ",notEmptyList.contains(50));
    Assert.assertFalse("withDuplicatesList does not contain element 60 ",withDuplicatesList.contains(60));
    Assert.assertFalse("emptyList does not contain element 10 ",emptyList.contains(10));
  } 
  
  @Test 
  public void testContainsAtStart(){
    Assert.assertTrue("notEmptyList contains element 10 ",notEmptyList.contains(10));
    Assert.assertTrue("withDuplicatesList contains element 10 ",withDuplicatesList.contains(10));    
  }
  
  @Test 
  public void testContainsAtEnd(){
    Assert.assertTrue("notEmptyList contains element 40 ",notEmptyList.contains(40));
    Assert.assertTrue("withDuplicatesList contains element 50 ",withDuplicatesList.contains(50));  
  }  
  
  @Test 
  public void testContainsInTheMiddle(){
    Assert.assertTrue("notEmptyList contains element 20 ",notEmptyList.contains(20));
    Assert.assertTrue("notEmptyList contains element 25 ",notEmptyList.contains(25));
    Assert.assertTrue("notEmptyList contains element 30 ",notEmptyList.contains(30));;
    Assert.assertTrue("withDuplicatesList contains element 30 ",withDuplicatesList.contains(30));
  }
  
  //method iterator  
  @Test
  public void testIteratorForEmptyLists(){
    int i = 0;
    for (Integer element : emptyList) {
      Assert.assertTrue("emptyList contains element " + element, emptyList.contains(element));
      i++;
    }
    Assert.assertTrue("emptyList contains the same number of elements in iterator ",emptyList.size()==i);    
  }  
  
  @Test
  public void testIteratorForNonEmptyLists(){
    int i = 0;
    for (Integer element : notEmptyList) {
      Assert.assertTrue("notEmptyList contains element " + element, notEmptyList.contains(element));
      i++;
    }
    Assert.assertTrue("notEmptyList contains the same number of elements in iterator ",notEmptyList.size()==i);
    i = 0;
    for (Integer element : withDuplicatesList) {
      Assert.assertTrue("withDuplicatesList contains element " + element, withDuplicatesList.contains(element));
      i++;
    }
    Assert.assertTrue("withDuplicatesList contains the same number of elements in iterator ",withDuplicatesList.size()==i);    
  }
  
  //method size  
  @Test 
  public void testSize(){
    Assert.assertTrue("notEmptyList contains 5 elements ",notEmptyList.size()==5);
    Assert.assertTrue("withDuplicatesList contains 6 elements ",withDuplicatesList.size()==6);
    Assert.assertTrue("emptyList contains 0 elements ",emptyList.size()==0);     
  }
 
  //method get    
  @Test 
  public void testGetFromStart(){
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0",(int) withDuplicatesList.get(0)==10);
  }
  
  @Test 
  public void testGetFromEnd(){
    Assert.assertTrue("notEmptyList contains element 40 at location 4",(int) notEmptyList.get(4)==40);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 5",(int) withDuplicatesList.get(5)==50);    
  }
  
  @Test 
  public void testGetFromTheMiddle(){
    Assert.assertTrue("notEmptyList contains element 20 at location 1",(int) notEmptyList.get(1)==20);
    Assert.assertTrue("notEmptyList contains element 25 at location 2",(int) notEmptyList.get(2)==25);    
    Assert.assertTrue("notEmptyList contains element 30 at location 3",(int) notEmptyList.get(3)==30);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 1",(int) withDuplicatesList.get(1)==10);    
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2",(int) withDuplicatesList.get(2)==30);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 3",(int) withDuplicatesList.get(3)==30);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4",(int) withDuplicatesList.get(4)==50);
  }  
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testGetFailsForIndexEqualToSize(){
    emptyList.get(0);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testGetFailsForIndexLargerThanSize(){
    notEmptyList.get(6);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testGetFailsForNegativeIndex(){
    notEmptyList.get(-1);
  }
  
  //method set  
  @Test
  public void testSetAtStart(){
    Assert.assertTrue("notEmptyList contains old element 10 at location 0",(int) notEmptyList.set(0,100)==10);
    Assert.assertTrue("notEmptyList contains new element 100 at location 0",(int) notEmptyList.get(0)==100);
    
    Assert.assertTrue("withDuplicatesList contains old element 10 at location 0",(int) withDuplicatesList.set(0,100)==10);
    Assert.assertTrue("withDuplicatesList contains new element 100 at location 0",(int) withDuplicatesList.get(0)==100);    
  }
  
  @Test
  public void testSetAtEnd(){
    Assert.assertTrue("notEmptyList contains old element 40 at location 4",(int) notEmptyList.set(4,400)==40);
    Assert.assertTrue("notEmptyList contains new element 400 at location 4",(int) notEmptyList.get(4)==400);
    
    Assert.assertTrue("withDuplicatesList contains old element 50 at location 5",(int) withDuplicatesList.set(5,500)==50);
    Assert.assertTrue("withDuplicatesList contains new element 500 at location 5",(int) withDuplicatesList.get(5)==500);     
  }
  
  @Test
  public void testSetInTheMiddel(){
    Assert.assertTrue("withDuplicatesList contains old element 10 at location 1",(int) withDuplicatesList.set(1,100)==10);
    Assert.assertTrue("withDuplicatesList contains new element 100 at location 1",(int) withDuplicatesList.get(1)==100);
    Assert.assertTrue("withDuplicatesList contains old element 30 at location 3",(int) withDuplicatesList.set(3,300)==30);
    Assert.assertTrue("withDuplicatesList contains new element 300 at location 3",(int) withDuplicatesList.get(3)==300);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForIndexEqualToSize(){    
    emptyList.set(0,400);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForIndexLargerThanSize(){
    notEmptyList.set(6,400);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testSetFailsForNegativeIndex(){
    notEmptyList.set(-1,400);    
  }  
  
  //test addElementAt    
  @Test
  public void testAddElementAtStart(){
    notEmptyList.addElementAt(0,10);
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("notEmptyList contains element 10 at location 1",(int) notEmptyList.get(1)==10);
    Assert.assertTrue("notEmptyList contains element 20 at location 2",(int) notEmptyList.get(2)==20);    
    Assert.assertTrue("notEmptyList contains element 25 at location 3",(int) notEmptyList.get(3)==25);
    Assert.assertTrue("notEmptyList contains element 30 at location 4",(int) notEmptyList.get(4)==30);
    Assert.assertTrue("notEmptyList contains element 40 at location 5",(int) notEmptyList.get(5)==40);
    Assert.assertTrue("Size of notEmptyList is now 6",withDuplicatesList.size()==6);   
  }
    
  @Test
  public void testAddElementAtEnd(){
    notEmptyList.addElementAt(5,10);
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("notEmptyList contains element 20 at location 1",(int) notEmptyList.get(1)==20);    
    Assert.assertTrue("notEmptyList contains element 25 at location 2",(int) notEmptyList.get(2)==25);
    Assert.assertTrue("notEmptyList contains element 30 at location 3",(int) notEmptyList.get(3)==30);
    Assert.assertTrue("notEmptyList contains element 40 at location 4",(int) notEmptyList.get(4)==40);
    Assert.assertTrue("notEmptyList contains element 10 at location 5",(int) notEmptyList.get(5)==10);
    Assert.assertTrue("Size of notEmptyList is now 6",notEmptyList.size()==6);     
  }

  @Test
  public void testAddElementAtInTheMiddle(){
    notEmptyList.addElementAt(3,10);
    Assert.assertTrue("notEmptyList contains element 10 at location 0",(int) notEmptyList.get(0)==10);
    Assert.assertTrue("notEmptyList contains element 20 at location 1",(int) notEmptyList.get(1)==20);    
    Assert.assertTrue("notEmptyList contains element 25 at location 2",(int) notEmptyList.get(2)==25);
    Assert.assertTrue("notEmptyList contains element 10 at location 3",(int) notEmptyList.get(3)==10);
    Assert.assertTrue("notEmptyList contains element 30 at location 4",(int) notEmptyList.get(4)==30);
    Assert.assertTrue("notEmptyList contains element 40 at location 5",(int) notEmptyList.get(5)==40);
    Assert.assertTrue("Size of notEmptyList is now 6",notEmptyList.size()==6);     
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testAddElementAtFailsForIndexLargerThanSize(){
    emptyList.addElementAt(1,50);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testAddElementAtFailsForNegativeIndex(){
    notEmptyList.addElementAt(-1,50);
  }
  
  //test removeElementAt 
  @Test
  public void  testRemoveElementAtStart(){
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4 ", withDuplicatesList.indexOf(50)==4);
    Assert.assertTrue("Size of withDuplicatesList is originally 6",withDuplicatesList.size()==6);
    
    Assert.assertTrue("Removing element at location 0",(int) withDuplicatesList.removeElementAt(0)==10);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 1 ", withDuplicatesList.indexOf(30)==1);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 3 ", withDuplicatesList.indexOf(50)==3);
    Assert.assertTrue("Size of withDuplicatesList is now 5",withDuplicatesList.size()==5);
    
    Assert.assertTrue("Removing element at location 0",(int) withDuplicatesList.removeElementAt(0)==10);
    Assert.assertTrue("withDuplicatesList does not contain element 10  ", withDuplicatesList.indexOf(10)==-1);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 0 ", withDuplicatesList.indexOf(30)==0);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 2 ", withDuplicatesList.indexOf(50)==2);
    Assert.assertTrue("Size of withDuplicatesList is now 4",withDuplicatesList.size()==4);    
  }
  
  @Test
  public void  testRemoveElementAtEnd(){
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4 ", withDuplicatesList.indexOf(50)==4);
    Assert.assertTrue("Size of withDuplicatesList is originally 6",withDuplicatesList.size()==6);
    
    Assert.assertTrue("Removing element at location 5",(int) withDuplicatesList.removeElementAt(5)==50);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList contains element 50 at location 4 ", withDuplicatesList.indexOf(50)==4);
    Assert.assertTrue("Size of withDuplicatesList is now 5",withDuplicatesList.size()==5);
    
    Assert.assertTrue("Removing element at location 4",(int) withDuplicatesList.removeElementAt(4)==50);
    Assert.assertTrue("withDuplicatesList contains element 10 at location 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("withDuplicatesList contains element 30 at location 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("withDuplicatesList does not contain element 50 ", withDuplicatesList.indexOf(50)==-1);
    Assert.assertTrue("Size of withDuplicatesList is now 4",withDuplicatesList.size()==4);   
  }
  
  @Test
  public void  testRemoveElementAtInTheMiddle(){
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList contains element 20 at location 1 ", notEmptyList.indexOf(20)==1);
    Assert.assertTrue("notEmptyList contains element 25 at location 2 ", notEmptyList.indexOf(25)==2);
    Assert.assertTrue("notEmptyList contains element 30 at location 3 ", notEmptyList.indexOf(30)==3);
    Assert.assertTrue("notEmptyList contains element 40 at location 4 ", notEmptyList.indexOf(40)==4);
    Assert.assertTrue("Size of notEmptyList is originally 5",notEmptyList.size()==5);
    
    Assert.assertTrue("Removing element at location 2",(int) notEmptyList.removeElementAt(2)==25);
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList contains element 20 at location 1 ", notEmptyList.indexOf(20)==1);
    Assert.assertTrue("notEmptyList does not contain element 25 ... returns -1 ", notEmptyList.indexOf(25)==-1);
    Assert.assertTrue("notEmptyList contains element 30 at location 2 ", notEmptyList.indexOf(30)==2);
    Assert.assertTrue("notEmptyList contains element 40 at location 3 ", notEmptyList.indexOf(40)==3);
    Assert.assertTrue("Size of notEmptyList is now 4",notEmptyList.size()==4);
    
    Assert.assertTrue("Removing element at location 1",(int) notEmptyList.removeElementAt(1)==20);
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList does not contain element 20 ... returns -1 ", notEmptyList.indexOf(20)==-1);
    Assert.assertTrue("notEmptyList does not contain element 25 ... returns -1 ", notEmptyList.indexOf(25)==-1);
    Assert.assertTrue("notEmptyList contains element 30 at location 1 ", notEmptyList.indexOf(30)==1);
    Assert.assertTrue("notEmptyList contains element 40 at location 2 ", notEmptyList.indexOf(40)==2);
    Assert.assertTrue("Size of notEmptyList is now 1",notEmptyList.size()==3);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void  testRemoveElementAtFailsForIndexLargerThanSize(){
    emptyList.removeElementAt(6);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void  testRemoveElementAtFailsForIndexEqualToSize(){
    emptyList.removeElementAt(0);
  }                                                    
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void  testRemoveElementAtFailsForNegativeIndex(){
    notEmptyList.removeElementAt(-1);
  }                                                    
  
  //method indexOf   
  @Test
  public void testIndexOfReturnsNegativeOne(){
    Assert.assertTrue("notEmptyList does not contain element 50 ", notEmptyList.indexOf(50)==-1); 
    Assert.assertTrue("withDuplicatesList does not contain element 60 ", withDuplicatesList.indexOf(60)==-1);  
    Assert.assertTrue("emptyList does not contain element 50 ", emptyList.indexOf(50)==-1); 
  }
 
  
  @Test
  public void testIndexOfForListsWithNoDuplicates(){
    Assert.assertTrue("first location for value 10 in notEmptyList is 0 ", notEmptyList.indexOf(10)==0);
    Assert.assertTrue("first location for value 20 in notEmptyList is 1 ", notEmptyList.indexOf(20)==1);
    Assert.assertTrue("first location for value 25 in notEmptyList is 2 ", notEmptyList.indexOf(25)==2);
    Assert.assertTrue("first location for value 30 in notEmptyList is 3 ", notEmptyList.indexOf(30)==3);
    Assert.assertTrue("first location for value 40 in notEmptyList is 4 ", notEmptyList.indexOf(40)==4);
      
  }
  
  @Test
  public void testIndexOfForListsWithWithDuplicatese(){
    Assert.assertTrue("first location for value 10 in withDuplicatesList is 0 ", withDuplicatesList.indexOf(10)==0);
    Assert.assertTrue("first location for value 30 in withDuplicatesList is 2 ", withDuplicatesList.indexOf(30)==2);
    Assert.assertTrue("first location for value 50 in withDuplicatesList is 4", withDuplicatesList.indexOf(50)==4); 
  }
  
  //method lastIndexOf
  @Test 
  public void testLastIndexOfReturnsNegativeOne(){;
    Assert.assertTrue("Last location for value 50 in notEmptyList is -1", notEmptyList.lastIndexOf(50)==-1);
    Assert.assertTrue("Last location for value 60 in withDuplicatesList is -1", withDuplicatesList.lastIndexOf(60)==-1);
    Assert.assertTrue("Last location for value 50 in emptyList is -1", emptyList.lastIndexOf(50)==-1);
  }
  
  @Test 
  public void testLastIndexOfForListsWithNoDuplicates(){
    Assert.assertTrue("Last location for value 10 in notEmptyList is 0 ", notEmptyList.lastIndexOf(10)==0);
    Assert.assertTrue("Last location for value 20 in notEmptyList is 1 ", notEmptyList.lastIndexOf(20)==1);
    Assert.assertTrue("Last location for value 25 in notEmptyList is 2 ", notEmptyList.lastIndexOf(25)==2);
    Assert.assertTrue("Last location for value 30 in notEmptyList is 3 ", notEmptyList.lastIndexOf(30)==3);
    Assert.assertTrue("Last location for value 40 in notEmptyList is 4 ", notEmptyList.lastIndexOf(40)==4);     
  }  
  
  @Test 
  public void testLastIndexOfForListsWithDuplicates(){
    Assert.assertTrue("Last location for value 10 in withDuplicatesList is 1 ", withDuplicatesList.lastIndexOf(10)==1);
    Assert.assertTrue("Last location for value 30 in withDuplicatesList is 3 ", withDuplicatesList.lastIndexOf(30)==3);
    Assert.assertTrue("Last location for value 50 in withDuplicatesList is 5", withDuplicatesList.lastIndexOf(50)==5);   
  }  
  
  //method subList
  @Test 
  public void testSubListFromStart(){
    emptyList = notEmptyList.subList(0,3);
    Assert.assertTrue("emptyList contains element 10 at location 0 ", emptyList.indexOf(10)==0);
    Assert.assertTrue("emptyList contains element 20 at location 1 ", emptyList.indexOf(20)==1);
    Assert.assertTrue("emptyList contains element 25 at location 2 ", emptyList.indexOf(25)==2);
    Assert.assertTrue("emptyList contains element 30 at location 3 ", emptyList.indexOf(30)==3);
    Assert.assertTrue("emptyList does not contain element 40 ", emptyList.indexOf(40)==-1);  
  }
  @Test 
  public void testSubListToEnd(){    
    emptyList = notEmptyList.subList(1,4);
    Assert.assertTrue("emptyList contains element 20 at location 0 ", emptyList.indexOf(20)==0);
    Assert.assertTrue("emptyList contains element 25 at location 1 ", emptyList.indexOf(25)==1);
    Assert.assertTrue("emptyList contains element 30 at location 2 ", emptyList.indexOf(30)==2);
    Assert.assertTrue("emptyList contains element 40 at location 3 ", emptyList.indexOf(40)==3);    
    Assert.assertTrue("emptyList does not contain element 10 ", emptyList.indexOf(10)==-1);  
  }
  
  @Test 
  public void testSubListInTheMiddle(){    
    emptyList = notEmptyList.subList(1,2);    
    Assert.assertTrue("emptyList contains element 20 at location 0 ", emptyList.indexOf(20)==0);
    Assert.assertTrue("emptyList contains element 25 at location 1 ", emptyList.indexOf(25)==1);
    Assert.assertTrue("emptyList does not contain element 30 ", emptyList.indexOf(30)==-1);
    Assert.assertTrue("emptyList does not contain element 40 ", emptyList.indexOf(40)==-1);    
    Assert.assertTrue("emptyList does not contain element 10 ", emptyList.indexOf(10)==-1); 
  }
  
  @Test 
  public void testSubListToForAllElements(){   
    emptyList = notEmptyList.subList(0,4);
    Assert.assertTrue("notEmptyList contains element 10 at location 0 ", emptyList.indexOf(10)==0);
    Assert.assertTrue("notEmptyList contains element 20 at location 1 ", emptyList.indexOf(20)==1);
    Assert.assertTrue("notEmptyList contains element 25 at location 2 ", emptyList.indexOf(25)==2);
    Assert.assertTrue("notEmptyList contains element 30 at location 3 ", emptyList.indexOf(30)==3);
    Assert.assertTrue("notEmptyList contains element 40 at location 4 ", emptyList.indexOf(40)==4);
    Assert.assertTrue("notEmptyList does not contain element 50 ", notEmptyList.indexOf(50)==-1); 
  }
  
  @Test(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForNegativeIndex(){       
    notEmptyList.subList(-1,3); 
  }
  
  @Test(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForIndexLargerThanSize(){       
    notEmptyList.subList(1,6);     
  }  
  
  @Test(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForIndexEqualToSize(){       
    notEmptyList.subList(1,5);     
  }    
  
  @Test(expected=IndexOutOfBoundsException.class) 
  public void testSubListFailsForFromIndexLargerThanToIndex(){ 
    notEmptyList.subList(3,2); 
  }    
  
  //test containsDuplicates
  @Test 
  public void testContainsDuplicatesReturnsTrue(){     
    Assert.assertTrue("withDuplicatesList contains duplicates",withDuplicatesList.containsDuplicates()); 
  }  
  
  @Test 
  public void testContainsDuplicatesReturnsFalse(){
    Assert.assertFalse("notEmptyList contains no duplicates",notEmptyList.containsDuplicates()); 
    Assert.assertFalse("emptyList contains no duplicates",notEmptyList.containsDuplicates());         
  } 
}
