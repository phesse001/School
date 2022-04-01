/*
 * Directions:
 *
 * 0. Use DrJava :  
 *     - Go to "Edit">"Preferences" and select "Resource Locations" on the left 
 *     - Press the "Add" button under "Extra Classpath" and browse to add the 
 *        following:/usr/people/classes/Java/ojdbc7.jar 
 * 
 * 1. Complete all methods below that start with "COMPLETE ME:" using the provided descriptions.
 * 
 * 2. Please refer to JDBC.java for sample JDBC code (download from Canvas)
 * 
 * 3. Use your Oracle username and password; you'll be using Monty's Company database so let me know if you face 
 * any permissions issues 
 * 
 * 4. For Method 4, you'll need to use Java's ResultSetMetaData class; please google it and take the time to understand it
 * 
 * 5. So far you've practiced how to execute any SQL query as well as stored fucntions from Java. You still need to be 
 * able to do the same stored procedures. Please study the following sample: JDBCCompany_Callable.jdbc (on CANVAS)
 */

import java.util.*;
//Load JDBC API functions
import java.sql.*;
import oracle.jdbc.*;

public class JDBC_lab_Incomplete {
  
  //Variable of type database connection
  private Connection myConnection;
  //Variable of type regular statement
  private Statement stmt;
  //Variable of type prepared statement
  private PreparedStatement preparedStmt;
  //Variable of type ResultSet which will contain query output
  private ResultSet result;
  
  /**
   * (1) COMPLETE ME: ****************************************************************************************************
   * REPLACE XXXXXX WITH YOUR ORACLE USERNAME AND YOUR PASSWORD
   */ 
  public JDBC_lab_Incomplete() throws SQLException, ClassNotFoundException{ 
    //Load driver and link to driver manager
    Class.forName("oracle.jdbc.OracleDriver");
    myConnection = DriverManager.getConnection("jdbc:oracle:thin:@//cscioraclerh7srv.ad.csbsju.edu:1521/csci.cscioraclerh7srv.ad.csbsju.edu", "phesse001", "900234593");
  }
  
  public void Method1(String dname) throws SQLException{
    stmt = myConnection.createStatement();
    String queryString = "Select e.lname as LastName, e.fname as FirstName, d.dname as Department from monty.company_employee e,monty.company_department d ";
    queryString += "where e.dno=d.dnumber and dname like '"+dname+"' order by dname, lname";
    System.out.println(queryString);
    result = stmt.executeQuery(queryString);
    while (result.next()){
      System.out.println(" Department: "+result.getString(3)+" FirstName: "+result.getString(2)+" LastName: "+result.getString(1));
    }
    result.close();
    stmt.close();
    System.out.println("************************************************************************");
  }
  
  
  /**
   * (2) COMPLETE ME: ****************************************************************************************************
   * REDO METHOD 1 using PreparedStatements (use instance variable preparedStmt)
   */ 
  public void Method2(String dename) throws SQLException{
    //???????????????????????????
    String queryString = "Select e.lname as LastName, e.fname as FirstName, d.dname as Department from monty.company_employee e,monty.company_department d ";
    queryString += "where e.dno=d.dnumber and dname like ? order by dname, lname";
           
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setString(1,dename);
    
    //Execute the query and save resulting table/relation in the ResultSet object
    result = preparedStmt.executeQuery();
    //Loop thru the ResultSet object printing each tuple 
    while (result.next()){
      System.out.println(" Department: "+result.getString(3)+" FirstName: "+result.getString(2)+" LastName: "+result.getString(1));
    }
    result.close();
    stmt.close();
    System.out.println("************************************************************************");
  }
  
  /**
   * (3) COMPLETE ME: ****************************************************************************************************
   * COMPLETE METHOD 3 TO INSERT THE SPECIFIED PARAMETERS AS A NEW TUPLE INTO DEPENDENT 
   * using instance variable stmt (of type Statement)
   */  
  public void Method3(String essn, String depenName, char sex, String bDate, String relationship)  throws SQLException{
    //???????????????????????????
    //A string to hold the SQL statement....Notice the use of ? in prepared statements
    String queryString = "INSERT into monty.company_dependent values(?,?,?,?,?)";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setString(1,essn);
    preparedStmt.setString(2,depenName);
    preparedStmt.setString(3,String.valueOf(sex));
    preparedStmt.setString(4,bDate);
    preparedStmt.setString(5,relationship);

    int returns = preparedStmt.executeUpdate();
    System.out.println(queryString);
    System.out.println("Rows affected " + returns);
    System.out.println("***********************************************************************************");
    preparedStmt.close();
    
    System.out.println("Inserting Into dependent values ('"+essn+"', '"+depenName+"', '"+sex+"',to_date('"+bDate+"','DD-MON-RR'),'"+relationship+"')");
    System.out.println("************************************************************************");
  }
  
   public void Method4(String essn, String depenName, char sex, String bDate, String relationship)  throws SQLException{
    stmt = myConnection.createStatement();
    //A string to hold the SQL statement....Notice the use of ? in prepared statements
    String queryString = "INSERT into monty.company_dependent values('"+essn+"', '"+depenName+"', '"+sex+"',to_date('"+bDate+"','DD-MON-RR'),'"+relationship+"')";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    int result = stmt.executeUpdate(queryString);
    System.out.println(queryString);
    System.out.println("Rows affected " + result);
    System.out.println("***********************************************************************************");
    
    System.out.println("Inserting Into dependent values ('"+essn+"', '"+depenName+"', '"+sex+"',to_date('"+bDate+"','DD-MON-RR'),'"+relationship+"')");
    System.out.println("************************************************************************");
    stmt.close();
  }
  
  
  public void closeDatabaseVariables() throws SQLException{
    myConnection.close(); 
  }
  
  
  public static void main(String[] args){
    try{
      
      Random rand = new Random();
      
      //Creates a new class object
      JDBC_lab_Incomplete myJDBC = new JDBC_lab_Incomplete();
      System.out.println();
      
      // Method 1 testing
      System.out.println ("\n--------METHOD 1--------\n");
      myJDBC.Method1("Administration");
      myJDBC.Method1("Potato");
      
      // Method 2 testing
      System.out.println ("\n--------METHOD 2--------\n");
      myJDBC.Method2("Administration");
      myJDBC.Method2("Potato");      
      
      // Method 3 testing
      //PS: random number below ensures dependent name is unique
      System.out.println ("\n--------METHOD 3--------\n");
      myJDBC.Method3("987654321", "Bug"+ rand.nextInt(10000), 'M', "01-JAN-99","SON");
      myJDBC.Method4("987654321", "Bug"+ rand.nextInt(10000), 'M', "01-JAN-99","SON");

      
      myJDBC.closeDatabaseVariables();
    }
    catch(SQLException E){
      System.out.println("SQL problems:" + E);
    }
    catch(ClassNotFoundException E){
      System.out.println("Oracle driver problems:" + E);
    }
    
  }
  
}
