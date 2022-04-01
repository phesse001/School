package productdeals;

import java.io.*;
import java.sql.*;
import oracle.jdbc.*;

/**
 * Use the SQL script file provided in this folder to create a NEW (slightly different) 
 * version of the ProductDeals database on Oracle and insert data into all tables. The 
 * script also creates an SQL function.
 */
public class Customer implements Serializable {
  /**
   * The following fields correspond to the fields in Table ProductDeals_CUSTOMER in your
   * PRODUCTDEALS Oracle database
   */
  private String customerNumber;
  private String last;
  private String first;
  private String street;
  private String city;
  private String state;
  private String zipCode;
  private double balance;
  private double creditLimit;
  private String slsRepNumber;
  /**
   * The following stores whether or not the customer has successfully logged
   * to the System
   */    
  private boolean loggedIn = false;
  
  /**
   * A getter for instance field customerNumber
   * @return the customerNumber
   */
  public String getCustomerNumber() {
    return customerNumber;
  }
  
  /**
   * A setter for instance field customerNumber
   * @param customerNumber the customerNumber to set
   */
  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }
  
  /**
   * A getter for instance field last
   * @return the last
   */
  public String getLast() {
    return last;
  }
  
  /**
   * A setter for instance field last
   * @param last the last to set
   */
  public void setLast(String last) {
    this.last = last;
  }
  
  /**
   * A getter for instance field first
   * @return the first
   */
  public String getFirst() {
    return first;
  }
  
  /**
   * A setter for instance field first
   * @param first the first to set
   */
  public void setFirst(String first) {
    this.first = first;
  }
  
  /**
   * A getter for instance field street
   * @return the street
   */
  public String getStreet() {
    return street;
  }
  
  /**
   * A setter for instance field street
   * @param street the street to set
   */
  public void setStreet(String street) {
    this.street = street;
  }
  
  /**
   * A getter for instance field city
   * @return the city
   */
  public String getCity() {
    return city;
  }
  
  /**
   * A setter for instance field city
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }
  
  /**
   * A getter for instance field state
   * @return the state
   */
  public String getState() {
    return state;
  }
  
  /**
   * A setter for instance field state
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }
  
  /**
   * A getter for instance field zipCode
   * @return the zipCode
   */
  public String getZipCode() {
    return zipCode;
  }
  
  /**
   * A setter for instance field zipCode
   * @param zipCode the zipCode to set
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  
  /**
   * A getter for instance field balance
   * @return the balance
   */
  public double getBalance() {
    return balance;
  }
  
  /**
   * A setter for instance field balance
   * @param balance the balance to set
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  /**
   * A getter for instance field creditLimit
   * @return the creditLimit
   */
  public double getCreditLimit() {
    return creditLimit;
  }
  
  /**
   * A setter for instance field creditLimit
   * @param creditLimit the creditLimit to set
   */
  public void setCreditLimit(double creditLimit) {
    this.creditLimit = creditLimit;
  }
  
  /**
   * A getter for instance field slsRepNumber
   * @return the slsRepNumber
   */
  public String getSlsRepNumber() {
    return slsRepNumber;
  }
  
  /**
   * A setter for instance field slsRepNumber 
   * @param slsRepNumber the slsRepNumber to set
   */
  public void setSlsRepNumber(String slsRepNumber) {
    this.slsRepNumber = slsRepNumber;
  }
  
  /**
   * A default constructor ... no need for other constructors
   */
  public Customer() {
  }
  
  /**
   ***************************************COMPLETE ME***************************************
   *********************USE YOUR ORACLE USERNAME AND PASSWORD instead of XXXX***************
   * This method and creates and returns a Connection object to the database. 
   * All other methods that need database access should call this method.
   * @return a Connection object to Oracle
   */
  public Connection openDBConnection() {
    try {
      // Load driver and link to driver manager
      Class.forName("oracle.jdbc.OracleDriver");
      // Create a connection to the specified database
      Connection myConnection = DriverManager.getConnection("jdbc:oracle:thin:@//cscioraclerh7srv.ad.csbsju.edu:1521/" +
                                                            "csci.cscioraclerh7srv.ad.csbsju.edu","phesse001", "900234593");
      return myConnection;
    } catch (Exception E) {
      E.printStackTrace();
    }
    return null;
  }
  
  /**
   * A getter for instance field loggedIn
   * @return whether the Customer is logged in or not
   */
  public Boolean isLoggedIn() {
    return this.loggedIn;
  }
  
  /**
   ***************************************COMPLETE ME***************************************
   * When called, this method uses a Statement object to query table ProductDeals_CUSTOMER 
   * for the customer whose last name and customer number are stored in class instance
   * fields last and customerNumber, respectively.
   * 
   * For example, to login a Customer with number 124 and last name Adams, first we set 
   * the following (assume object is called cus)
   * 
   *     cus.setCustomerNumber("124");
   *     cus.setLast("Adams");
   * 
   * then we call login method with NO parameters; instead method will use name and customer 
   * number values stored in class instance fields last and customerNumber
   * 
   *     cus.login()
   * 
   * If a match is found, the method sets loggedIn instance field to true and 
   * returns true; otherwise, loggedIn instance field is set to false and false is returned 
   * 
   * @return true or false based on whether the login information of the customer
   * stored in instance fields last and customerNumber exist in Table ProductDeals_CUSTOMER
   */
  public boolean login() throws SQLException{
    Connection con = openDBConnection();
    Statement stmt = con.createStatement();
    String last = this.last;
    String cNum = this.customerNumber;
    
    String queryString = "Select COUNT(*) from phesse001.ProductDeals_CUSTOMER " + 
      "where CUSTOMER_NUMBER="+cNum+" and LAST="+ "'" + last + "'";
    System.out.println(queryString);
    ResultSet result = stmt.executeQuery(queryString);
    
    if (result.next()) {
      this.loggedIn = true;
    }
    else {
      this.loggedIn = false; 
    }
    return this.loggedIn;
  }
  
  /**
   * sets loggedIn instance field to false
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public void logout(){
    if(! isLoggedIn())
      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
    
    this.loggedIn = false;
  }
  
  /**
   ***************************************COMPLETE ME***************************************
   * This method uses a Statement object to query the ProductDeals_CUSTOMER table
   * for the customer whose customer number is stored in instance field 
   * customerNumber.
   * 
   * @return a ResultSet object containing the record for the matching customer from 
   * the ProductDeals_CUSTOMER table
   * 
   * @throws IllegalStateException if the method is called when loggedIn = false
   */
  public ResultSet getCustomerInfo() throws SQLException{
    if(! isLoggedIn()){
      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
    }
    Connection con = openDBConnection();
    Statement stmt = con.createStatement();
    String cNum = this.customerNumber;
    System.out.println(last);
    
    //A string to hold the SQL statement
    String queryString = "Select * from phesse001.ProductDeals_CUSTOMER " + 
      "where CUSTOMER_NUMBER="+cNum;
    
    System.out.println(queryString);
    //Execute the query and save resulting table/relation in the ResultSet object
    ResultSet result = stmt.executeQuery(queryString);
    return result;
  }
  
  /**
   ***************************************COMPLETE ME***************************************
   * This method uses a PreparedStatement object to update the LAST, FIRST,
   * STREET, CITY, STATE, and ZIP_CODE table fields in the ProductDeals_CUSTOMER table to 
   * the values in the corresponding instance fields (i.e. set table field LAST to the value 
   * of instance field last, etc.) for the customer whose customer number is 
   * stored in instance field customerNumber.
   * 
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public void editCustomerInfo() throws SQLException {
    if(! isLoggedIn()){
      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
    }
    Connection con = openDBConnection();
    String queryString = "UPDATE phesse001.ProductDeals_CUSTOMER SET last=?, first=?, street=?, city=?, state=?, zip_code=?" + " WHERE CUSTOMER_NUMBER=" + this.customerNumber;
    System.out.println(queryString);
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    PreparedStatement preparedStmt = con.prepareStatement(queryString);
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setString(1,this.last);
    preparedStmt.setString(2,this.first);
    preparedStmt.setString(3,this.street);
    preparedStmt.setString(4,this.city);
    preparedStmt.setString(5,this.state);
    preparedStmt.setString(6,this.zipCode);
    System.out.println(queryString);
 
    int ret = preparedStmt.executeUpdate();
    preparedStmt.close();

  }
  
  /**
   ***************************************COMPLETE ME***************************************
   * This method uses a Statement object to query the ProductDeals_TRANS table
   * for all transactions made by the customer whose customer number is 
   * stored in instance field customerNumber.
   * 
   * @return a ResultSet containing all transactions made by the customer 
   * whose customer number is stored in instance field customerNumber.
   * 
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public ResultSet getAllTransactions()throws SQLException{
     if(! isLoggedIn()){
      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
    }
    Connection con = openDBConnection();
    Statement stmt = con.createStatement();
    String cNum = this.customerNumber;
    
    String queryString = "Select * from phesse001.ProductDeals_TRANS " + 
      "where CUSTOMER_NUMBER="+cNum;
    System.out.println(queryString);
    ResultSet result = stmt.executeQuery(queryString);
    return result;

  }
  
  /**
   ***************************************COMPLETE ME***************************************
   * This method uses a Statement object to query the ProductDeals_TRANSPART and
   * ProductDeals_PART tables for all transaction parts that belong to the transaction 
   * whose number is specified as a parameter; order output by PART_NUMBER in ascending order.
   * 
   * MUST use "Select *" to get all columns and "Order By" PART_NUMBER
   * 
   * @param transNumber the transaction number for which we need all the 
   * transaction parts from table ProductDeals_TRANSPART
   * 
   * @return a ResultSet containing all transaction parts that belong to the 
   * transaction whose number is specified as a parameter.
   * 
   * @throws IllegalStateException if then method is called when loggedIn = false
   */   
  public ResultSet getTransactionParts(String transNumber) throws SQLException {
      if(! isLoggedIn()){
      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
    }
    Connection con = openDBConnection();
    Statement stmt = con.createStatement();
    
    String queryString = "Select * from phesse001.ProductDeals_PART pdp, phesse001.ProductDeals_TRANSPART pdtp " + 
      "where pdp.PART_NUMBER=pdtp.PART_NUMBER AND pdtp.TRANS_NUMBER= " + transNumber;
    System.out.println(queryString);
    ResultSet result = stmt.executeQuery(queryString);
    return result;
  }
  
  /**
   ***************************************COMPLETE ME***************************************
   * This method uses a PreparedStatement object to call an SQL stored function 
   * Function ProductDeals_getTransVal(transNum varchar) to get the total $ value for
   * a given transaction whose number is specified as a parameter.
   * 
   * @param transNumber the transaction number for which we need the total $ value
   * 
   * @return the total $ value for the transaction whose number is specified 
   * as a parameter.
   * 
   * @throws IllegalStateException if then method is called when loggedIn = false
   */
  public double getTransactionTotalValue(String transNumber) throws SQLException{
    double ret;
    if(! isLoggedIn()){
      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
    }
    Connection con = openDBConnection();
    String queryString = "select phesse001.ProductDeals_getTransVal(?) as totalValue from dual";
    PreparedStatement preparedStmt = con.prepareStatement(queryString);
    preparedStmt.clearParameters();
    preparedStmt.setString(1,transNumber);
    
    ResultSet result = preparedStmt.executeQuery();
    System.out.println(queryString);
    if(result.next()) {
      return result.getDouble(1);
    }
    return 0;
  }
}
