import org.junit.*;

/**
 * A JUnit test case class for the Customer Class
 * 
 */
public class PriorityCustomerTest {
  private Customer cust1;
  private Customer cust2;
  private Customer cust3;
  private Customer cust4;
  private Customer cust5;
  
  @Before
  public void init(){
    cust1 = new Customer(13, 1);
    cust2 = new Customer(15, 1);
    cust3 = new Customer(11, 2);
    cust4 = new Customer(13, 2);
    cust5 = new Customer(11, 3);
  }
  
  @Test
  public void testInitialState(){
    Assert.assertTrue("priority for cust1 should be 1", cust1.getPriority()==1);
    Assert.assertTrue("priority for cust2 should be 1", cust2.getPriority()==1);
    Assert.assertTrue("priority for cust3 should be 2", cust3.getPriority()==2);
    Assert.assertTrue("priority for cust4 should be 2", cust4.getPriority()==2);
    Assert.assertTrue("priority for cust5 should be 3", cust5.getPriority()==3);    
    Assert.assertTrue("arrival time for cust1 should be 13", cust1.getArrivalTime()==13);
    Assert.assertTrue("arrival time for cust2 should be 15", cust2.getArrivalTime()==15);
    Assert.assertTrue("arrival time for cust3 should be 11", cust3.getArrivalTime()==11);
    Assert.assertTrue("arrival time for cust4 should be 13", cust4.getArrivalTime()==13);
    Assert.assertTrue("arrival time for cust5 should be 11", cust5.getArrivalTime()==11);    
  }
  
  @Test  
  public void testCompareToReturnsNegative(){
    Assert.assertTrue("cust1 should be less than cust2", cust1.compareTo(cust2)<0);
    Assert.assertTrue("cust1 should be less than cust3", cust1.compareTo(cust3)<0);
    Assert.assertTrue("cust1 should be less than cust4", cust1.compareTo(cust4)<0);
    Assert.assertTrue("cust1 should be less than cust5", cust1.compareTo(cust5)<0);
    
    Assert.assertTrue("cust2 should be less than cust3", cust2.compareTo(cust3)<0);
    Assert.assertTrue("cust2 should be less than cust4", cust2.compareTo(cust4)<0);
    Assert.assertTrue("cust2 should be less than cust5", cust2.compareTo(cust5)<0);
    
    Assert.assertTrue("cust3 should be less than cust4", cust1.compareTo(cust4)<0);
    Assert.assertTrue("cust3 should be less than cust5", cust1.compareTo(cust5)<0);
    
    Assert.assertTrue("cust4 should be less than cust5", cust4.compareTo(cust5)<0);    
  }
  
  @Test  
  public void testCompareToReturnsPositive(){
    Assert.assertTrue("cust2 should be more than cust1", cust2.compareTo(cust1)>0);  
    
    Assert.assertTrue("cust3 should be more than cust1", cust3.compareTo(cust1)>0);
    Assert.assertTrue("cust3 should be more than cust2", cust3.compareTo(cust2)>0);   
    
    Assert.assertTrue("cust4 should be more than cust1", cust4.compareTo(cust1)>0);
    Assert.assertTrue("cust4 should be more than cust2", cust4.compareTo(cust2)>0);
    Assert.assertTrue("cust4 should be more than cust3", cust4.compareTo(cust3)>0);
    
    Assert.assertTrue("cust5 should be more than cust1", cust5.compareTo(cust2)>0);
    Assert.assertTrue("cust5 should be more than cust2", cust5.compareTo(cust3)>0);
    Assert.assertTrue("cust5 should be more than cust3", cust5.compareTo(cust3)>0);
    Assert.assertTrue("cust5 should be more than cust4", cust5.compareTo(cust3)>0);      
  }
  
  @Test  
  public void testCompareToReturnsZero(){
    Assert.assertTrue("cust1 should equal itself", cust1.compareTo(cust1)==0);
    Assert.assertTrue("cust2 should equal itself", cust2.compareTo(cust2)==0);   
    Assert.assertTrue("cust3 should equal itself", cust3.compareTo(cust3)==0);
    Assert.assertTrue("cust4 should equal itself", cust4.compareTo(cust4)==0);   
    Assert.assertTrue("cust5 should equal itself", cust5.compareTo(cust5)==0);    
    cust5 = new Customer(13, 1);
    Assert.assertTrue("cust5 should now equal cust1", cust1.compareTo(cust5)==0);
    Assert.assertTrue("cust1 should now equal cust5", cust5.compareTo(cust1)==0);      
  }
}
