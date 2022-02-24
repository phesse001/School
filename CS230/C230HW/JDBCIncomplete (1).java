package csci230.jdbc;

import java.util.*;
//Load JDBC API functions
import java.sql.*;

/**
 * A class that demos how JDBC allows a Java program to interact with a remote
 * MySQL database called college.
 * The database contains the following two tables:
 *  
 *  1- Department table is made up of 2 columns:  
 *        Name  (a unique String up to to 20 characters long) and 
 *        Location (String 3-characters long (either CSB or SJU))
 *   
 * Originally, table Department contains following:
 *   Name Location
 *   ----- --------
 *   ARTS CSB
 *   BIOL SJU
 *   CHEM CSB
 *   CSCI SJU
 *   ENVL SJU
 *   MGMT CSB
 *   
 *  2- Student table is made up of 3 columns:    
 *        ID   (a unique String up to 10 characters long),
 *        Name  (a String up to 20 characters long), and 
 *        Major  (a String up to 20 characters long; value must appear under column Name in table Department)
 * 
 *   Originally, table Student contains following:
 *   ID     Name    Major
 *   -----  -----   -----
 *   11111  Jessica CSCI
 *   22222  Brian   CSCI
 *   33333  Vickie  MGMT
 *   44444  Paula   BIOL
 *   55555  Brandon CHEM
 *   66666  Dusty   ENVL
 *   77777  Erica   ARTS
 *   88888  Ryan    CSCI
 * 
 * @author irahal
 */
public class JDBCIncomplete {

	// Variable of type database connection
	private Connection myConnection;
	// Variables of type statement
	private Statement stmt;
	

	/**
	 * EXERCISE 0: COMPLETE ME
	 * *****************************************************************************************
	 * Sets up the MySQL drivers and creates a connection object. REPLACE ??? WITH
	 * CMC DATABASE USERNAME AND PASSWORD
	 */
	public JDBCIncomplete() {
		try {
			// Load driver and link to driver manager
			Class.forName("com.mysql.jdbc.Driver");

			// Create a connection to the specified database
			// ("jdbc:mysql://HOSTNAME:PORT/DATABASE","USERNAME","PASSWORD")
			myConnection = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu:3306/college", "???", "???");
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * A method to insert a record into the Student table
	 * 
	 * @param ID
	 *            the ID of the inserted student; must be unique
	 * @param name
	 *            the name of the inserted student
	 * @param dept
	 *            the name of the student's major department; department name must
	 *            exist in table Department
	 */
	public void insertStudentTable(String ID, String name, String dept) {
		try {
			// Create a statement using the connection object
			stmt = myConnection.createStatement();

			// A string to hold the SQL statement
			String queryString = "Insert Into Student Values('" + ID + "', '" + name + "' , '" + dept + "')";
			System.out.println(queryString);

			// Execute the SQL statement
			int result = stmt.executeUpdate(queryString);
			
			// Report what happened
			System.out.println("Affected " + result + " rows");
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * A method to query the Student table for ALL students
	 */
	public void queryStudentTable() {
		try {
			// Create a statement using the connection object
			stmt = myConnection.createStatement();

			// A string to hold the SQL statement
			String queryString = "Select * from Student";

			// Execute the query and save resulting table/relation in the ResultSet object
			// (Variables of type ResultSet will contain query output)
			ResultSet rs = stmt.executeQuery(queryString);

			// Loop thru the ResultSet object printing each tuple
			System.out.println(queryString);
			while (rs.next()) {
				System.out.println(" Name = " + rs.getString("Name") + ", ID  = " + rs.getString("ID") + ", Dept = "
						+ rs.getString("Major"));
			}
			rs.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * A method to query the Department table for ALL students
	 */
	public void queryDepartmentTable() {
		try {
			// Create a statement using the connection object
			stmt = myConnection.createStatement();

			// A string to hold the SQL statement
			String queryString = "Select * from Department";

			// Execute the query and save resulting table/relation in the ResultSet object
			// (Variables of type ResultSet will contain query output)
			ResultSet rs = stmt.executeQuery(queryString);

			// Loop thru the ResultSet object printing each tuple
			System.out.println(queryString);
			while (rs.next()) {
				System.out.println("  Name = " + rs.getString("Name") + ", Location = " + rs.getString("Location"));
			}
			rs.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * A method to query the Student table for students by name and print out all
	 * matches
	 * 
	 * @param student
	 *            the name of the student we're searching for
	 */
	public void queryStudentTableByStudentName(String student) {
		try {
			// Create a statement using the connection object
			stmt = myConnection.createStatement();

			// A string to hold the SQL statement
			String queryString = "Select * from Student where Name like '" + student + "'";

			// Execute the query and save resulting table/relation in the ResultSet object
			// (Variables of type ResultSet will contain query output)
			ResultSet rs = stmt.executeQuery(queryString);

			// Loop thru the ResultSet object printing each tuple
			System.out.println(queryString);
			while (rs.next()) {
				System.out.println(" Name = " + rs.getString("Name") + ", ID  = " + rs.getString("ID") + ", Dept = "
						+ rs.getString("Major"));
			}
			rs.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * A method to delete a student from the Student table
	 * 
	 * @param ID
	 *            the ID of the student we're deleting
	 */
	public void deleteStudentByID(String ID) {
		try {
			// Create a statement using the connection object
			stmt = myConnection.createStatement();

			// A string to hold the SQL statement
			String queryString = "Delete from Student Where ID='" + ID + "'";
			System.out.println(queryString);

			// Execute the SQL statement
			int result = stmt.executeUpdate(queryString);
			
			// Report what happened
			System.out.println("Affected " + result + " rows");
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * A method to delete a department from the Department table
	 * 
	 * @param dept
	 *            the name of the department we're deleting
	 */
	public void deleteDepartmentByName(String dept) {
		try {
			// Create a statement using the connection object
			stmt = myConnection.createStatement();

			// A string to hold the SQL statement
			String queryString = "Delete from Department Where Name='" + dept + "'";
			System.out.println(queryString);

			// Execute the SQL statement
			int result = stmt.executeUpdate(queryString);
			
			// Report what happened
			System.out.println("Affected " + result + " rows");
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	/**
	 * EXERCISE 1: COMPLETE ME
	 * *****************************************************************************************
	 * A method to insert a record into the Department table
	 * 
	 * @param deptName
	 *            the name of the inserted department; must be unique
	 * @param deptLocation
	 *            a 3 character long string (either CSB or SJU)
	 */
	public void insertDepartmentTable(String deptName, String deptLocation) {
		String queryString = " Insert Into Department .... ";
		System.out.println(queryString);
	}

	/**
	 * EXERCISE 2: COMPLETE ME
	 * *****************************************************************************************
	 * A method to find students by the name of their major department and print out
	 * all matches
	 * 
	 * @param dept
	 *            the name of the department we're searching for
	 */
	public void queryStudentTableByMajor(String dept) {
		String queryString = "Select * from Student .... ";
		System.out.println(queryString);
	}

	/**
	 * EXERCISE 3: COMPLETE ME
	 * *****************************************************************************************
	 * A method to find students by the location of their major department and print
	 * out all matches
	 * 
	 * @param location
	 *            for departments we're searching for
	 */
	public void queryBothTablesForStudentsByLocation(String location) {
		String queryString = " .... ";
		System.out.println(queryString);
	}

	/**
	 * EXERCISE 4: COMPLETE ME
	 * *****************************************************************************************
	 * A method to update name and major for a student given a matching ID number
	 * 
	 * @param ID
	 *            the ID of the edited edited
	 * @param name
	 *            the updated name for the student
	 * @param dept
	 *            the updated major for the student; department name must exist in
	 *            table Department
	 */
	public void updateStudentTableByID(String ID, String name, String dept) {
		String queryString = "Update Student set name='" + name + "', Major = .... where ID =...";
		System.out.println(queryString);
	}

	/**
	 * Method to close all statement and connection objects
	 */
	public void closeDatabaseVariables() {
		try {
			// Close database variables (Statement and Connection)
			stmt.close();
			myConnection.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			// Creates a new class object
			JDBCIncomplete myJDBC = new JDBCIncomplete();
			// generates random ID to avoid conflicts
			Random rand = new Random();
			int id1 = rand.nextInt(100000);
			System.out.println(
					"*****************************************************************************************");
			myJDBC.insertStudentTable("" + id1, "The Boss" + id1, "CSCI");
			System.out.println(
					"*****************************************************************************************");
			myJDBC.queryStudentTable();
			System.out.println(
					"*****************************************************************************************");
			myJDBC.queryDepartmentTable();
			System.out.println(
					"*****************************************************************************************");
			myJDBC.queryStudentTableByStudentName("Paula");
			System.out.println(
					"*****************************************************************************************");
			int id2 = rand.nextInt(40);
			String loc = "";
			if (id2 >= 20) {
				loc = "CSB";
			} else {
				loc = "SJU";
			}
			myJDBC.insertDepartmentTable("CS" + id2, loc);
			System.out.println(
					"*****************************************************************************************");
			myJDBC.queryStudentTableByMajor("CSCI");
			System.out.println(
					"*****************************************************************************************");
			myJDBC.queryBothTablesForStudentsByLocation(loc);
			System.out.println(
					"*****************************************************************************************");
			myJDBC.updateStudentTableByID("" + id1, "What Boss" + id1, "MATH");
			System.out.println(
					"*****************************************************************************************");
			myJDBC.queryStudentTable();
			System.out.println(
					"*****************************************************************************************");
			myJDBC.queryDepartmentTable();
			System.out.println(
					"*****************************************************************************************");
			myJDBC.deleteStudentByID("" + id1);
			myJDBC.deleteDepartmentByName("CS" + id2);
			myJDBC.closeDatabaseVariables();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
}
