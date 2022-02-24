import zhstructures.*;
import org.junit.*;
import foostructures.*;

/**
 * A JUnit test case class for class <FOO>LinkedBinarySearchTree  
 * 
 * @author Imad M Rahal
 * @version February 26, 2015
 */
public class BSTTest {
  
  private ZHBinarySearchTree<Integer> notEmptyTree, emptyTree;
  private ZHBinarySearchTree<MutableClass> otherTree;
  
  @Before
  public void init(){
    emptyTree = new FOOLinkedBinarySearchTree<Integer>();
    otherTree = new FOOLinkedBinarySearchTree<MutableClass>();      
    notEmptyTree = new FOOLinkedBinarySearchTree<Integer>();
    notEmptyTree.add(15);
    notEmptyTree.add(20);
    notEmptyTree.add(17);
    notEmptyTree.add(25);
    notEmptyTree.add(5);
    notEmptyTree.add(4);
    notEmptyTree.add(9);
    notEmptyTree.add(8);
    notEmptyTree.add(13);
    notEmptyTree.add(11);
    notEmptyTree.add(10);
    notEmptyTree.add(12);
    notEmptyTree.add(3);
  }
  
  @Test
  public void testAddReturnsFalse(){
    Assert.assertFalse("notEmptyTree already contains element 15 ",notEmptyTree.add(15));
    Assert.assertFalse("notEmptyTree already contains element 20 ",notEmptyTree.add(20));
    Assert.assertFalse("notEmptyTree already contains element 17 ",notEmptyTree.add(17));
    Assert.assertFalse("notEmptyTree already contains element 25 ",notEmptyTree.add(25));
    Assert.assertFalse("notEmptyTree already contains element 5 ", notEmptyTree.add(5));
    Assert.assertFalse("notEmptyTree already contains element 4 ", notEmptyTree.add(4));
    Assert.assertFalse("notEmptyTree already contains element 9 ", notEmptyTree.add(9));
    Assert.assertFalse("notEmptyTree already contains element 8 ", notEmptyTree.add(8));
    Assert.assertFalse("notEmptyTree already contains element 13 ",notEmptyTree.add(13));
    Assert.assertFalse("notEmptyTree already contains element 11 ",notEmptyTree.add(11));
    Assert.assertFalse("notEmptyTree already contains element 10 ",notEmptyTree.add(10));
    Assert.assertFalse("notEmptyTree already contains element 12 ",notEmptyTree.add(12));
    Assert.assertFalse("notEmptyTree already contains element 3 ", notEmptyTree.add(3));   
  }
  
  @Test
  public void testAddReturnsTrue(){
    Assert.assertTrue("notEmptyTree does not contain element 40 ",notEmptyTree.add(40));
    Assert.assertTrue("notEmptyTree does not contain element 35 ",notEmptyTree.add(35));
    Assert.assertTrue("notEmptyTree does not contain element 18 ",notEmptyTree.add(18));
    Assert.assertTrue("notEmptyTree does not contain element 16 ",notEmptyTree.add(16));
    Assert.assertTrue("notEmptyTree does not contain element 14 ",notEmptyTree.add(14));   
    Assert.assertTrue("emptyTree does not contain element 14 ",emptyTree.add(14));   
  }
  
  @Test  
  public void testContainsReturnsTrue(){
    Assert.assertTrue("notEmptyTree contains element 15 ", notEmptyTree.contains(15));
    Assert.assertTrue("notEmptyTree contains element 20 ", notEmptyTree.contains(20));
    Assert.assertTrue("notEmptyTree contains element 17 ", notEmptyTree.contains(17));
    Assert.assertTrue("notEmptyTree contains element 25 ", notEmptyTree.contains(25));
    Assert.assertTrue("notEmptyTree contains element 5 ", notEmptyTree.contains(5));    
    Assert.assertTrue("notEmptyTree contains element 4 " , notEmptyTree.contains(4));
    Assert.assertTrue("notEmptyTree contains element 9 " , notEmptyTree.contains(9));
    Assert.assertTrue("notEmptyTree contains element 8 " , notEmptyTree.contains(8));    
    Assert.assertTrue("notEmptyTree contains element 13 ", notEmptyTree.contains(13));
    Assert.assertTrue("notEmptyTree contains element 11 ", notEmptyTree.contains(11));
    Assert.assertTrue("notEmptyTree contains element 10 ", notEmptyTree.contains(10));
    Assert.assertTrue("notEmptyTree contains element 12 ", notEmptyTree.contains(12));
    Assert.assertTrue("notEmptyTree contains element 3 " , notEmptyTree.contains(3));
  }
  
  @Test  
  public void testContainsReturnsFalse(){
    Assert.assertFalse("notEmptyTree does not contain element 50 ", notEmptyTree.contains(50));    
    Assert.assertFalse("emptyTree does not contain element 50 ", emptyTree.contains(50)); 
  }  
  
  @Test  
  public void testGet(){
    Assert.assertTrue("notEmptyTree contains element 10 ",(int) notEmptyTree.get(10)==10);
    Assert.assertTrue("notEmptyTree contains element 20 ",(int) notEmptyTree.get(20)==20);
    Assert.assertTrue("notEmptyTree contains element 30 ",(int) notEmptyTree.get(15)==15);
    Assert.assertTrue("notEmptyTree contains element 40 ",(int) notEmptyTree.get(3)==3);  
  }
  
  @Test  
  public void testGetReturnsNull(){
    Assert.assertNull("notEmptyTree does not contain element 50 ", notEmptyTree.get(50)); 
    Assert.assertNull("emptyTree does not contain element 50 ", emptyTree.get(50)); 
  }
  
  /*
   * Method uses inner class MutableClass to test that method get(Element e) returns 
   * the object in the tree that matches parameter e (not paramater e itself)
   */ 
  @Test  
  public void testGetWithMutableObjects(){
    MutableClass mc1 = new MutableClass(1,"1");
    MutableClass mc1_prime = new MutableClass(1,"1");
    MutableClass mc2 = new MutableClass(2,"2");
    MutableClass mc3 = new MutableClass(3,"3");
    MutableClass mc4 = new MutableClass(4,"4");
    MutableClass mc5 = new MutableClass(5,"5");
    
    otherTree.add(mc3);
    otherTree.add(mc4);
    otherTree.add(mc5);
    otherTree.add(mc2);
    otherTree.add(mc1);
    
    Assert.assertTrue("otherTree contains element mc1 ", otherTree.get(mc1)==mc1);    
    Assert.assertTrue("otherTree contains element mc2 ", otherTree.get(mc2)==mc2);
    Assert.assertTrue("otherTree contains element mc3 ", otherTree.get(mc3)==mc3);
    Assert.assertTrue("otherTree contains element mc4 ", otherTree.get(mc4)==mc4);
    Assert.assertTrue("otherTree contains element mc5 ", otherTree.get(mc5)==mc5);  
    Assert.assertNull("otherTree doesn't contain element MutableClass(2,\"3\");  ", otherTree.get(new MutableClass(2,"3")));  
    Assert.assertTrue("otherTree returns mc1 when searching for mc1_prime ", otherTree.get(mc1_prime)==mc1); 
    Assert.assertFalse("otherTree DOES NOT return mc1_prime when searching for mc1_prime ", otherTree.get(mc1_prime)==mc1_prime); 
  }
  
  @Test  
  public void testIsEmptyReturnsTrue(){
    Assert.assertTrue("emptyTree is empty ",emptyTree.isEmpty());
  }
  
  @Test  
  public void testIsEmptyReturnsFalse(){
    Assert.assertFalse("notEmptyTree is NOT empty ",notEmptyTree.isEmpty());
  }
  
  
  @Test  
  public void testIterator(){
    int i = 0;
    for (Integer element : notEmptyTree) {
      Assert.assertTrue("notEmptyTree contains element " + element, notEmptyTree.contains(element));
      emptyTree.add(element);
      i++;
    }
    Assert.assertTrue("notEmptyTree contains the same number of elements in iterator ",notEmptyTree.size()==i);    
    for (Integer element : emptyTree) {
      Assert.assertTrue("emptyTree now contains element " + element, emptyTree.contains(element));
    }  
    Assert.assertTrue("emptyTree now contains the same number of elements in iterator ",emptyTree.size()==i);  
  }
  
  @Test  
  public void testRemoveANodeWithNoChildren(){
    Assert.assertTrue("notEmptyTree contains element 3 " , notEmptyTree.remove(3)); 
    Assert.assertFalse("notEmptyTree does not contain element 3 " , notEmptyTree.contains(3));   
    Assert.assertTrue("notEmptyTree's size is 12 " , notEmptyTree.size()==12);   
    Assert.assertTrue("notEmptyTree contains element 8 " , notEmptyTree.remove(8)); 
    Assert.assertFalse("notEmptyTree does not contain element 8 " , notEmptyTree.contains(8));  
    Assert.assertTrue("notEmptyTree's size is 11 " , notEmptyTree.size()==11);       
    Assert.assertTrue("notEmptyTree contains element 10 ", notEmptyTree.remove(10));
    Assert.assertFalse("notEmptyTree does not contain element 10 " , notEmptyTree.contains(10));          
    Assert.assertTrue("notEmptyTree's size is 10 " , notEmptyTree.size()==10);           
    Assert.assertTrue("notEmptyTree contains element 12 ", notEmptyTree.remove(12));
    Assert.assertFalse("notEmptyTree does not contain element 12 " , notEmptyTree.contains(12));    
    Assert.assertTrue("notEmptyTree's size is 9 " , notEmptyTree.size()==9);           
    Assert.assertTrue("notEmptyTree contains element 11 ", notEmptyTree.remove(11));
    Assert.assertFalse("notEmptyTree does not contain element 11 " , notEmptyTree.contains(11));  
    Assert.assertTrue("notEmptyTree's size is 8 " , notEmptyTree.size()==8);           
    Assert.assertTrue("notEmptyTree contains element 17 ", notEmptyTree.remove(17));    
    Assert.assertFalse("notEmptyTree does not contain element 17 " , notEmptyTree.contains(17));
    Assert.assertTrue("notEmptyTree's size is 7 " , notEmptyTree.size()==7);           
    Assert.assertTrue("notEmptyTree contains element 25 ", notEmptyTree.remove(25));   
    Assert.assertFalse("notEmptyTree does not contain element 25 " , notEmptyTree.contains(25)); 
    Assert.assertTrue("notEmptyTree's size is 6 " , notEmptyTree.size()==6);             
  }
  
  public void testRemoveANodeWithALeftChildOnly(){    
    Assert.assertTrue("notEmptyTree contains element 4 " , notEmptyTree.remove(4)); 
    Assert.assertFalse("notEmptyTree does not contain element 4 " , notEmptyTree.contains(4));   
    Assert.assertTrue("notEmptyTree's size is 12 " , notEmptyTree.size()==12);      
    Assert.assertTrue("notEmptyTree contains element 13 " , notEmptyTree.remove(13)); 
    Assert.assertFalse("notEmptyTree does not contain element 13 " , notEmptyTree.contains(13));   
    Assert.assertTrue("notEmptyTree's size is 11 " , notEmptyTree.size()==11);       
  }
  
  public void testRemoveANodeWithARightChildOnly(){  
    Assert.assertTrue("notEmptyTree contains element 17 " , notEmptyTree.remove(17));      
    Assert.assertTrue("notEmptyTree contains element 20 " , notEmptyTree.remove(20)); 
    Assert.assertFalse("notEmptyTree does not contain element 20 " , notEmptyTree.contains(20));   
    Assert.assertTrue("notEmptyTree's size is 11 " , notEmptyTree.size()==11);      
    Assert.assertTrue("notEmptyTree contains element 8 " , notEmptyTree.remove(8));      
    Assert.assertTrue("notEmptyTree contains element 9 " , notEmptyTree.remove(9)); 
    Assert.assertFalse("notEmptyTree does not contain element 9 " , notEmptyTree.contains(9));   
    Assert.assertTrue("notEmptyTree's size is 9 " , notEmptyTree.size()==9);        
  }
  
  public void testRemoveANodeWithTwoChildren(){        
    Assert.assertTrue("notEmptyTree contains element 20 " , notEmptyTree.remove(20)); 
    Assert.assertFalse("notEmptyTree does not contain element 20 " , notEmptyTree.contains(20));   
    Assert.assertTrue("notEmptyTree's size is 12 " , notEmptyTree.size()==12);      
    Assert.assertTrue("notEmptyTree contains element 9 " , notEmptyTree.remove(9)); 
    Assert.assertFalse("notEmptyTree does not contain element 9 " , notEmptyTree.contains(9));   
    Assert.assertTrue("notEmptyTree's size is 11 " , notEmptyTree.size()==11);         
    Assert.assertTrue("notEmptyTree contains element 15 " , notEmptyTree.remove(15)); 
    Assert.assertFalse("notEmptyTree does not contain element 15 " , notEmptyTree.contains(15));   
    Assert.assertTrue("notEmptyTree's size is 10 " , notEmptyTree.size()==10);         
  }
  
  public void testRemoveAllNodes(){        
    notEmptyTree.remove(3);
    notEmptyTree.remove(4);
    notEmptyTree.remove(5);       
    notEmptyTree.remove(8);        
    notEmptyTree.remove(9);            
    notEmptyTree.remove(10);  
    notEmptyTree.remove(11);  
    notEmptyTree.remove(12);  
    notEmptyTree.remove(13);        
    notEmptyTree.remove(15);        
    notEmptyTree.remove(17);    
    notEmptyTree.remove(20);     
    notEmptyTree.remove(25);    
    Assert.assertTrue("notEmptyTree's size is 0 " , notEmptyTree.size()==0);    
  }
  
  @Test  
  public void testRemoveReturnsFalse(){
    Assert.assertFalse("notEmptyTree does not contain element 40 ",notEmptyTree.remove(40));    
    Assert.assertFalse("emptyTree does not contain element 40 ",emptyTree.remove(40));       
  }
 
  @Test  
  public void testSize(){
    Assert.assertTrue("notEmptyTree contains 13 elements ",notEmptyTree.size()==13);
    Assert.assertTrue("emptyTree contains 0 elements ",emptyTree.size()==0);    
  }
  
  
  /*
   * The following class is used to test that method get(Element e) returns the object in the notEmptyTree
   * that matches parameter e not paramater e itself
   * Any mutable class would work instead
   * */
  private class MutableClass implements Comparable<MutableClass>{
    private int someInteger;
    private String someString;
    
    private MutableClass(){}
    
    private MutableClass(int someInteger,String someString){
      this.someInteger = someInteger;
      this.someString = someString;}
    
    private void setSomeInteger(int someInteger){
      this.someInteger = someInteger;}
    
    private int getSomeInteger(){
      return this.someInteger;}
    
    private void setSomeString(String someString){
      this.someString = someString;}
    
    private String getSomeString(){
      return this.someString;}
    
    public int compareTo(MutableClass mc){
      if(this.getSomeInteger()==mc.getSomeInteger())
        return this.getSomeString().compareTo(mc.getSomeString());
      else
        return this.getSomeInteger()-(mc.getSomeInteger());}
  }
}
