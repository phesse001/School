/**
 * A JUnit test case class for <FOO>ArraySet.
 * 
 */

import <foo>structures.*;
import org.junit.*;

public class <FOO>SetTest{
  private <FOO>Set<String> emptySetDefaultLength, emptySetNotDefaultLength,notEmptySet, 
    notEmptySet2, notEmptySet3, notEmptySet4, result;
  
@Before
  public void init(){
    emptySetDefaultLength = new MyArraySet<String>();
    emptySetNotDefaultLength = new MyArraySet<String>(3);
    result = new MyArraySet<String>();
    notEmptySet = new MyArraySet<String>();
    notEmptySet.add("A");
    notEmptySet.add("B");
    
    notEmptySet2 = new MyArraySet<String>();
    notEmptySet2.add("A");
    notEmptySet2.add("C");
    notEmptySet2.add("Y");
    notEmptySet2.add("Z");
    
    notEmptySet3 = new MyArraySet<String>();
    notEmptySet3.add("X");
    notEmptySet3.add("Y");
    notEmptySet3.add("Z");
    
    notEmptySet4 = new MyArraySet<String>();
    notEmptySet4.add("X");
    notEmptySet4.add("Y");
    notEmptySet4.add("A");
    notEmptySet4.add("Z");    
  }
  
  @Test
  public void testDefaultConstructor(){
    Assert.assertTrue("Set is empty", emptySetDefaultLength.isEmpty());
    Assert.assertTrue("Size should be 0", emptySetDefaultLength.size()==0);    
  }
  
  @Test  
  public void testSecondtConstructor(){
    Assert.assertTrue("Set is empty", emptySetNotDefaultLength.isEmpty());
    Assert.assertTrue("Size should be 0", emptySetNotDefaultLength.size()==0);    
  }
  
  @Test (expected=IllegalArgumentException.class)
  public void testSecondtConstructorFailsForNegativeLength(){
    new MyArraySet<String>(-1);
  }
  
  @Test  
  public void testAddToAnEmptySet(){
    //add "A"; set is now {"A"} 
    Assert.assertTrue("add(\"A\") should return true",emptySetDefaultLength.add("A"));
    Assert.assertFalse("Set should NOT be empty", emptySetDefaultLength.isEmpty());
    Assert.assertTrue("Size should be 1", emptySetDefaultLength.size()==1);   
    Assert.assertTrue("String \"A\" should be in set", emptySetDefaultLength.contains("A"));
    Assert.assertFalse("String \"H\" should NOT be in set", emptySetDefaultLength.contains("H"));    
  }
  
  @Test  
  public void testAddToNonEmptySet(){
    //add "H"; set should be {"A" , "B" , "H"} 
    Assert.assertTrue("add(\"H\") should return true",notEmptySet.add("H"));
    Assert.assertTrue("Size should be 3", notEmptySet.size()==3);   
    Assert.assertTrue("String \"H\" should be in set", notEmptySet.contains("H"));
    Assert.assertFalse("String \"Z\" should NOT be in set", notEmptySet.contains("Z"));  
  }
  
  @Test  
  public void testAddBeyondInitialLength(){
    //add "A", "B", "C", "D"; set should be {"A", "B", "C", "D"} 
    Assert.assertTrue("add(\"A\") should return true",emptySetNotDefaultLength.add("A"));
    Assert.assertTrue("add(\"B\") should return true",emptySetNotDefaultLength.add("B"));
    Assert.assertTrue("add(\"C\") should return true",emptySetNotDefaultLength.add("C"));
    Assert.assertTrue("add(\"D\") should return true",emptySetNotDefaultLength.add("D"));
    Assert.assertTrue("Size should be 4", emptySetNotDefaultLength.size()==4);  
    //add "E"; set should be {"A", "B", "C", "D", "E"} 
    Assert.assertTrue("add(\"E\") should return true",emptySetNotDefaultLength.add("E"));
    Assert.assertTrue("Size should be 4", emptySetNotDefaultLength.size()==5);   
    Assert.assertTrue("String \"A\" should be in set", emptySetNotDefaultLength.contains("A"));
    Assert.assertTrue("String \"B\" should be in set", emptySetNotDefaultLength.contains("B"));
    Assert.assertTrue("String \"C\" should be in set", emptySetNotDefaultLength.contains("C"));
    Assert.assertTrue("String \"D\" should be in set", emptySetNotDefaultLength.contains("D"));
    Assert.assertTrue("String \"E\" should be in set", emptySetNotDefaultLength.contains("E"));   
  }  
  
  @Test  
  public void testAddDuplicate(){
    //adding "B" to set again returns false    
    Assert.assertFalse("add(\"B\") should return false since we can't have duplicates",notEmptySet.add("B"));
    Assert.assertTrue("Size should remain at 2", notEmptySet.size()==2);    
    Assert.assertTrue("String \"B\" should be in set", notEmptySet.contains("B"));  
  }
  
  @Test 
  public void testRemoveFromEmptySet(){
    Assert.assertFalse("remove(\"A\") should return false",emptySetNotDefaultLength.remove("A"));    
  }
  
  @Test 
  public void testRemoveFromNonEmptySet(){ 
    Assert.assertTrue("remove(\"A\") should return true",notEmptySet.remove("A")); 
  }
  
  @Test 
  public void testRemoveToEmptyASet(){     
    //remove "A" from set; set is not empty yet 
    Assert.assertTrue("remove(\"A\") should return true",notEmptySet.remove("A"));
    Assert.assertFalse("Set should NOT be empty", notEmptySet.isEmpty());
    Assert.assertTrue("Size should be 1", notEmptySet.size()==1);    
    Assert.assertFalse("String \"A\" should NOT be in set", notEmptySet.contains("A"));    
    Assert.assertTrue("String \"B\" should be in set", notEmptySet.contains("B")); 
    //remove "B" from set; set is now empty
    Assert.assertTrue("remove(\"B\") should return true",notEmptySet.remove("B"));
    Assert.assertTrue("Set should be empty", notEmptySet.isEmpty());
    Assert.assertTrue("Size should be 0", notEmptySet.size()==0);    
    Assert.assertFalse("String \"A\" should NOT be in set", notEmptySet.contains("A"));    
    Assert.assertFalse("String \"B\" should NOT be in set", notEmptySet.contains("B")); 
  }
  
  @Test 
  public void testRemoveNonExistingItem(){
    //remove "C" from set returns false since "C" isn't in set
    Assert.assertFalse("remove(\"C\") should return false",notEmptySet.remove("C"));
    Assert.assertTrue("Size should remain at 2", notEmptySet.size()==2);    
    Assert.assertTrue("String \"A\" should be in set", notEmptySet.contains("A"));    
    Assert.assertTrue("String \"B\" should be in set", notEmptySet.contains("B"));           
  }
  
  @Test  
  public void testIterator(){
    //iterate over notEmptySet to add all elements to set result
    for (String s:notEmptySet){
      result.add(s);
    }
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size should be 2", result.size()==2);    
    Assert.assertTrue("String \"A\" should be in result", result.contains("A"));    
    Assert.assertTrue("String \"B\" should be in result", result.contains("B")); 
    
    //iterate over result to remove all elements from notEmptySet and empty it 
    for (String s:result){
      notEmptySet.remove(s);
    }    
    Assert.assertTrue("Set should be empty now", notEmptySet.isEmpty());
    Assert.assertTrue("Size  should be 0", notEmptySet.size()==0);    
    Assert.assertFalse("String \"A\" should NOT be in set", notEmptySet.contains("A"));    
    Assert.assertFalse("String \"B\" should NOT be in set", notEmptySet.contains("B"));     
  }
  
  @Test  
  public void testIntersectionEmpty(){
    result = notEmptySet.intersection(notEmptySet3);
    
    //result should be empty
    Assert.assertTrue("Set result should be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 0", result.size()==0);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertFalse("String \"X\" should NOT be in result", result.contains("X"));
    Assert.assertFalse("String \"Y\" should NOT be in result", result.contains("Y"));
    Assert.assertFalse("String \"Z\" should NOT be in result", result.contains("Z")) ;     
    
    //notEmptySet should NOT be affected by operation
    Assert.assertTrue("Size of notEmptySet should be 2", notEmptySet.size()==2);    
    Assert.assertTrue("String \"A\" should be in notEmptySet", notEmptySet.contains("A"));    
    Assert.assertTrue("String \"B\" should be in notEmptySet", notEmptySet.contains("B")); 
    
    //notEmptySet3 should NOT be affected by operation  
    Assert.assertTrue("Size of notEmptySet3 should be 3", notEmptySet3.size()==3);    
    Assert.assertTrue("String \"X\" should be in notEmptySet3", notEmptySet3.contains("X"));   
    Assert.assertTrue("String \"Y\" should be in notEmptySet3", notEmptySet3.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in notEmptySet3", notEmptySet3.contains("Z")); 
  }
  
  @Test  
  public void testIntersectionNotEmpty(){
    result = notEmptySet.intersection(notEmptySet2);
    
    //result should be {"A"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 1", result.size()==1);    
    Assert.assertTrue("String \"A\" should be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertFalse("String \"X\" should NOT be in result", result.contains("X"));
    Assert.assertFalse("String \"Y\" should NOT be in result", result.contains("Y"));
    Assert.assertFalse("String \"Z\" should NOT be in result", result.contains("Z")) ;   
    
    result = notEmptySet2.intersection(notEmptySet3);
    
    //result should be {"A", "C"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 2", result.size()==2);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertFalse("String \"X\" should NOT be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z"));     
    
    //notEmptySet should NOT be affected by operation
    Assert.assertTrue("Size of notEmptySet should be 2", notEmptySet.size()==2);    
    Assert.assertTrue("String \"A\" should be in notEmptySet", notEmptySet.contains("A"));    
    Assert.assertTrue("String \"B\" should be in notEmptySet", notEmptySet.contains("B")); 
    
    //notEmptySet2 should NOT be affected by operation  
    Assert.assertTrue("Size of notEmptySet2 should be 3", notEmptySet2.size()==4);    
    Assert.assertTrue("String \"A\" should be in notEmptySet2", notEmptySet2.contains("A"));   
    Assert.assertTrue("String \"C\" should be in notEmptySet2", notEmptySet2.contains("C"));
    Assert.assertTrue("String \"Y\" should be in notEmptySet2", notEmptySet2.contains("Y"));    
    Assert.assertTrue("String \"Z\" should be in notEmptySet2", notEmptySet2.contains("Z"));  
    
    //notEmptySet3 should NOT be affected by operation  
    Assert.assertTrue("Size of notEmptySet3 should be 3", notEmptySet3.size()==3);    
    Assert.assertTrue("String \"X\" should be in notEmptySet3", notEmptySet3.contains("X"));   
    Assert.assertTrue("String \"Y\" should be in notEmptySet3", notEmptySet3.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in notEmptySet3", notEmptySet3.contains("Z"));     
  }
  
  @Test  
  public void testIntersectionIsCommutative(){
    result = notEmptySet3.intersection(notEmptySet2); 
    
    //result should be {"Y", "Z"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 2", result.size()==2);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertFalse("String \"X\" should NOT be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z"));  
    
    result = notEmptySet2.intersection(notEmptySet3);
    
    //result should be {"Y", "Z"}   
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 2", result.size()==2);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertFalse("String \"X\" should NOT be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z"));    
  }
  
  @Test  
  public void testUnion(){
    result = notEmptySet.union(notEmptySet3);
    
    //result should be {"A" , "B", "X", "Y", "Z"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 5", result.size()==5);    
    Assert.assertTrue("String \"A\" should be in result", result.contains("A")); 
    Assert.assertTrue("String \"B\" should be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertTrue("String \"X\" should be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z")) ;   
    
    result = notEmptySet3.union(notEmptySet4);    
    
    //result should be {"A", "X", "Y", "Z"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 4", result.size()==4);    
    Assert.assertTrue("String \"A\" should be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertTrue("String \"X\" should be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z")) ;    
    
    //notEmptySet should NOT be affected by operation
    Assert.assertTrue("Size of notEmptySet should be 2", notEmptySet.size()==2);    
    Assert.assertTrue("String \"A\" should be in notEmptySet", notEmptySet.contains("A"));    
    Assert.assertTrue("String \"B\" should be in notEmptySet", notEmptySet.contains("B")); 
    
    
    //notEmptySet3 should NOT be affected by operation  
    Assert.assertTrue("Size of notEmptySet3 should be 3", notEmptySet3.size()==3);    
    Assert.assertTrue("String \"X\" should be in notEmptySet3", notEmptySet3.contains("X"));   
    Assert.assertTrue("String \"Y\" should be in notEmptySet3", notEmptySet3.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in notEmptySet3", notEmptySet3.contains("Z"));     
    
    //notEmptySet4 should NOT be affected by operation  
    Assert.assertTrue("Size of notEmptySet4 should be 4", notEmptySet4.size()==4);    
    Assert.assertTrue("String \"A\" should be in notEmptySet4", notEmptySet4.contains("A"));   
    Assert.assertTrue("String \"X\" should be in notEmptySet4", notEmptySet4.contains("X"));
    Assert.assertTrue("String \"Y\" should be in notEmptySet4", notEmptySet4.contains("Y"));    
    Assert.assertTrue("String \"Z\" should be in notEmptySet4", notEmptySet4.contains("Z"));  
  }
  
  @Test  
  public void testUnionIsCommutative(){
    result = notEmptySet.union(notEmptySet3);
        
    //result should be {"A" , "B", "X", "Y", "Z"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 5", result.size()==5);    
    Assert.assertTrue("String \"A\" should be in result", result.contains("A")); 
    Assert.assertTrue("String \"B\" should be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertTrue("String \"X\" should be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z"));  
    
    result = notEmptySet3.union(notEmptySet);
    //result should be {"A" , "B", "X", "Y", "Z"}  
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 5", result.size()==5);    
    Assert.assertTrue("String \"A\" should be in result", result.contains("A")); 
    Assert.assertTrue("String \"B\" should be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertTrue("String \"X\" should be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z"));
  }  
  
  @Test  
  public void testDifferenceEmpty(){
    result = notEmptySet3.difference(notEmptySet4);
    
    //result should be empty
    Assert.assertTrue("Set result should be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 0", result.size()==0);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertFalse("String \"X\" should NOT be in result", result.contains("X"));
    Assert.assertFalse("String \"Y\" should NOT be in result", result.contains("Y"));
    Assert.assertFalse("String \"Z\" should NOT be in result", result.contains("Z")) ;     
    
    //notEmptySet3 should NOT be affected by operation  
    Assert.assertTrue("Size of notEmptySet3 should be 3", notEmptySet3.size()==3);    
    Assert.assertTrue("String \"X\" should be in notEmptySet3", notEmptySet3.contains("X"));   
    Assert.assertTrue("String \"Y\" should be in notEmptySet3", notEmptySet3.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in notEmptySet3", notEmptySet3.contains("Z")); 
    
    //notEmptySet4 should NOT be affected by operation
    Assert.assertTrue("Size of notEmptySet4 should be 2", notEmptySet4.size()==4);    
    Assert.assertTrue("String \"A\" should be in notEmptySet4", notEmptySet4.contains("A"));    
    Assert.assertTrue("String \"X\" should be in notEmptySet4", notEmptySet4.contains("X")); 
    Assert.assertTrue("String \"Y\" should be in notEmptySet4", notEmptySet4.contains("Y")); 
    Assert.assertTrue("String \"Z\" should be in notEmptySet4", notEmptySet4.contains("Z"));
  }
  
  @Test  
  public void testDifferenceNotEmpty(){
    result = notEmptySet4.difference(notEmptySet);
    
    //result should be {"X", "Y", "Z"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 3", result.size()==3);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertTrue("String \"X\" should be in result", result.contains("X"));
    Assert.assertTrue("String \"Y\" should be in result", result.contains("Y"));
    Assert.assertTrue("String \"Z\" should be in result", result.contains("Z")) ;     
    
    //notEmptySet should NOT be affected by operation
    Assert.assertTrue("Size of notEmptySet should be 2", notEmptySet.size()==2);    
    Assert.assertTrue("String \"A\" should be in notEmptySet", notEmptySet.contains("A"));    
    Assert.assertTrue("String \"B\" should be in notEmptySet", notEmptySet.contains("B")); 
    
    //notEmptySet4 should NOT be affected by operation
    Assert.assertTrue("Size of notEmptySet4 should be 2", notEmptySet4.size()==4);    
    Assert.assertTrue("String \"A\" should be in notEmptySet4", notEmptySet4.contains("A"));    
    Assert.assertTrue("String \"X\" should be in notEmptySet4", notEmptySet4.contains("X")); 
    Assert.assertTrue("String \"Y\" should be in notEmptySet4", notEmptySet4.contains("Y")); 
    Assert.assertTrue("String \"Z\" should be in notEmptySet4", notEmptySet4.contains("Z"));  
  }
  
  @Test  
  public void testDifferenceIsNotCommutative(){
    result = notEmptySet4.difference(notEmptySet2); 
    
    //result should be {"X"}
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 1", result.size()==1);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertFalse("String \"C\" should NOT be in result", result.contains("C")); 
    Assert.assertTrue("String \"X\" should be in result", result.contains("X"));
    Assert.assertFalse("String \"Y\" should NOT be in result", result.contains("Y"));
    Assert.assertFalse("String \"Z\" should NOT be in result", result.contains("Z"));  
    
    result = notEmptySet2.difference(notEmptySet4);
    
    //result should be {"C"}   
    Assert.assertFalse("Set result should NOT be empty", result.isEmpty());
    Assert.assertTrue("Size of result should be 1", result.size()==1);    
    Assert.assertFalse("String \"A\" should NOT be in result", result.contains("A")); 
    Assert.assertFalse("String \"B\" should NOT be in result", result.contains("B"));    
    Assert.assertTrue("String \"C\" should be in result", result.contains("C")); 
    Assert.assertFalse("String \"X\" should NOT be in result", result.contains("X"));
    Assert.assertFalse("String \"Y\" should NOT be in result", result.contains("Y"));
    Assert.assertFalse("String \"Z\" should NOT be in result", result.contains("Z"));    
  }  
  
  @Test  
  public void testSubset(){
    //notEmptySet3 is a subset of notEmptySet4
    Assert.assertTrue("notEmptySet3 is a subset of notEmptySet4", notEmptySet4.subset(notEmptySet3));    
    //notEmptySet4 is NOT a subset of notEmptySet3
    Assert.assertFalse("notEmptySet4 is NOT a subset of notEmptySet3", notEmptySet3.subset(notEmptySet4));        
  }  
}