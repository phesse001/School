//Load JDBC API functions
import java.sql.*;
import oracle.jdbc.*;


public class JDBC {
  
  //Variable of type database connection
  private Connection myConnection;
  //Variable of type regular statement
  private Statement stmt;
  //Variable of type prepared statement
  private PreparedStatement preparedStmt;
  //Variable of type ResultSet which will contain query output
  private ResultSet result;
  
  public JDBC() throws SQLException, ClassNotFoundException{   
    //Load driver and link to driver manager
    Class.forName("oracle.jdbc.OracleDriver");
    //Create a connection to the specified database ("jdbc:oracle:thin:@//HOST:PORT/SERVICE_NAME","USERNAME","PASSWORD")

    //REPLACE XXXXXX WITH YOUR ORACLE USERNAME AND YOUR PASSWORD
    myConnection = DriverManager.getConnection("jdbc:oracle:thin:@//cscioraclerh7srv.ad.csbsju.edu:1521/" + 
                                               "csci.cscioraclerh7srv.ad.csbsju.edu","jdbc", "jdbc");
  }
  
  public void RegQuery(int dno) throws SQLException{
    //Create a regular statement using the connection object ... default constructor creates a resultset that can only 
    //be read forward ... can't rewind or go back
    stmt = myConnection.createStatement();
    //the following allows for resultsets that can be rewound
    //stmt = myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    
    //A string to hold the SQL statement
    String queryString = "Select pno,pname, Sum(hours) as hours from monty.company_works_on, monty.company_project " + 
                         "where pno=pnumber and dnum="+dno+" Group By pno,pname";
    System.out.println(queryString);
    //Execute the query and save resulting table/relation in the ResultSet object
    result = stmt.executeQuery(queryString);
    
    //Loop thru the ResultSet object printing each tuple twice using the two different ways of accessing tuple 
    //attributes from a ResultSet
    System.out.println("REGULAR STATEMENT USING ATTRIBUTE NAMES");
    while (result.next())
      System.out.println("Project Name:"+result.getString("pname")+ " Total Hours: " + result.getDouble("hours"));
    
    /*result.beforeFirst();
    System.out.println("REGULAR STATEMENT USING ATTRIBUTE POSITIONS");
    while (result.next())
      System.out.println("Project Name:"+result.getString(2)+ " Total Hours: " + result.getDouble(3)); */ 
   
    System.out.println("***********************************************************************************");
    
    result.close();
    stmt.close();
  }
   
  public void RegUpdate(String oldLocation,String newLocation) throws SQLException{
    //A string to hold the SQL statement
    String queryString = "Update monty.company_dept_locations set dlocation = '" +newLocation + "' where " + 
                         "dlocation ='" + oldLocation+ "'";
    System.out.println(queryString);
    //Create a statement using the connection object...must specify an SQL string as an arguement
    stmt = myConnection.createStatement();
    int returns = stmt.executeUpdate(queryString);
    
    System.out.println("Rows affected " + returns);
    System.out.println("***********************************************************************************");
    stmt.close();
  }
  
  public void PreQuery(int dno) throws SQLException{
    //A string to hold the SQL statement....Notice the use of ? in prepared statements
    String queryString  = " Select pno,pname, Sum(hours) as hours from monty.company_works_on, monty.company_project ";
           queryString += " where pno=pnumber and dnum=? Group By  pno,pname";
           
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setInt(1,dno);
    
    //Execute the query and save resulting table/relation in the ResultSet object
    result = preparedStmt.executeQuery();
    //Loop thru the ResultSet object printing each tuple 
    System.out.println(queryString);
    while (result.next())
      System.out.println("Project Name:"+result.getString(2)+ " Total Hours: " + result.getDouble(3));
    
    System.out.println("***********************************************************************************");
    result.close();
    preparedStmt.close();
  } 
  
  public void PreInsert(int dnumber, String location) throws SQLException{
    //A string to hold the SQL statement....Notice the use of ? in prepared statements
    String queryString = "INSERT into monty.company_dept_locations values(?,?)";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setInt(1,dnumber);
    preparedStmt.setString(2,location);
    
    int returns = preparedStmt.executeUpdate();
    System.out.println(queryString);
    System.out.println("Rows affected " + returns);
    System.out.println("***********************************************************************************");
    preparedStmt.close();
  }
  
  public void FunctionCall(int dnumber) throws SQLException{
    //A string to hold the SQL statement....
    String queryString = "select monty.COMPANY_numEmps_Func(?) as Employee_Count from dual";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setInt(1,dnumber);
    
    result = preparedStmt.executeQuery();
    System.out.println(queryString);
    if (result.next()){    
      System.out.println("Number of employees in dept " + dnumber + " is " + result.getString(1));
    }
    System.out.println("***********************************************************************************");
    result.close();
    preparedStmt.close();
  }  
  
  
  public void closeDatabaseVariables () throws SQLException{
    //Close all database variables (Connection)
    myConnection.close();
  }
  
  public static void main(String[] args){
    try
    {
      //Creates a new class object
      JDBC myJDBC = new JDBC();
      myJDBC.RegQuery(5);
      myJDBC.RegUpdate("Stafford","Staffford");
      myJDBC.RegUpdate("Staffford","Stafford");
      myJDBC.PreQuery(5);
      myJDBC.FunctionCall(7);
      myJDBC.PreInsert(8,"Saint Joseph5");
      
      myJDBC.closeDatabaseVariables();
    }
    catch(SQLException E)
    {
      System.out.println("SQL problems:" + E);
    }
    catch(ClassNotFoundException E)
    {
      System.out.println("Oracle driver problems:" + E);
    }
    
    
  }
  
}

/*
grant ALL on COMPANY_DEPARTMENT to JDBC with GRANT option;
grant ALL on COMPANY_DEPENDENT to JDBC with GRANT option;
grant ALL on COMPANY_DEPTEMPSPROJS_PROC to JDBC with GRANT option;
grant ALL on COMPANY_DEPTEMPS_PROC to JDBC with GRANT option;
grant ALL on COMPANY_DEPT_8_EMP_VIEW to JDBC with GRANT option;
grant ALL on COMPANY_DEPT_INFO to JDBC with GRANT option;
grant ALL on COMPANY_DEPT_LOCATIONS to JDBC with GRANT option;
grant ALL on COMPANY_EMPLOYEE to JDBC with GRANT option;
grant ALL on COMPANY_ISSMALLDEPT_FUNC to JDBC with GRANT option;
grant ALL on COMPANY_ISSMALLDEPT_PROC to JDBC with GRANT option;
grant ALL on COMPANY_NUMEMPS_FUNC to JDBC with GRANT option;
grant ALL on COMPANY_NUMEMPS_PROC to JDBC with GRANT option;
grant ALL on COMPANY_PROJECT to JDBC with GRANT option;
grant ALL on COMPANY_UPDATEDEPTNAME_PROC to JDBC with GRANT option;
grant ALL on COMPANY_WORKS_ON to JDBC with GRANT option;
grant ALL on COMPANY_WORKS_ON_TOTALS_VIEW to JDBC with GRANT option;
*/
