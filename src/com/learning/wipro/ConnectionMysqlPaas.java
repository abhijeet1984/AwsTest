/**
 * 
 */
package com.learning.wipro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author AB277176
 *
 */
public class ConnectionMysqlPaas {
	
	  private static Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	//	new ConnectionMysqlPaas().readDataBase();
		new ConnectionMysqlPaas().writeUser("AwsUser", "Rock", "aws@amazon.com", "M", 8);
		
	  }
//	static{
//
//		System.out.println("Get Loaded");
//		  try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	      // Setup the connection with the DB
////	      connect = DriverManager
////	          .getConnection("jdbc:127.3.214.130:3306/sqlpaas","adminZx9QJbw", "DpixVYmYsd7W");
//
//	      try {
//			connect = DriverManager
//			          .getConnection("jdbc:mysql://awsmysql.curcvja00dt8.us-east-1.rds.amazonaws.com:3306/iaassql","awsuser", "awspassword");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	      
//
//	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		System.out.println("Get Loaded");
		  Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
//	      connect = DriverManager
//	          .getConnection("jdbc:127.3.214.130:3306/sqlpaas","adminZx9QJbw", "DpixVYmYsd7W");

	      connect = DriverManager
		          .getConnection("jdbc:mysql://awsmysql.curcvja00dt8.us-east-1.rds.amazonaws.com:3306/iaassql","awsuser", "awspassword");
	      return connect ;
	}

	 public String readDataBase() throws Exception {
		    try {
		      // This will load the MySQL driver, each DB has its own driver
		//      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
//		      connect = DriverManager
//		          .getConnection("jdbc:127.3.214.130:3306/sqlpaas","adminZx9QJbw", "DpixVYmYsd7W");
//
//		      connect = DriverManager
//			          .getConnection("jdbc:mysql://awsmysql.curcvja00dt8.us-east-1.rds.amazonaws.com:3306/iaassql","awsuser", "awspassword");
		      // Statements allow to issue SQL queries to the database
		    	connect = getConnection();
		      statement = connect.createStatement();
		      System.out.println("Statement obj :"+statement.toString());
		      // Result set get the result of the SQL query
		      resultSet = statement
		          .executeQuery("select * from iaassql.userData");
		     String result =  writeResultSet(resultSet);
		     System.out.println("Result is "+result);
		      // PreparedStatements can use variables and are more efficient
//		      preparedStatement = connect
//		          .prepareStatement("insert into  FEEDBACK.COMMENTS values (default, ?, ?, ?, ? , ?, ?)");
//		      // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
//		      // Parameters start with 1
//		      preparedStatement.setString(1, "Test");
//		      preparedStatement.setString(2, "TestEmail");
//		      preparedStatement.setString(3, "TestWebpage");
//		      preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//		      preparedStatement.setString(5, "TestSummary");
//		      preparedStatement.setString(6, "TestComment");
//		      preparedStatement.executeUpdate();
//
//		      preparedStatement = connect
//		          .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
//		      resultSet = preparedStatement.executeQuery();
//		      writeResultSet(resultSet);
//
//		      // Remove again the insert comment
//		      preparedStatement = connect
//		      .prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
//		      preparedStatement.setString(1, "Test");
//		      preparedStatement.executeUpdate();
//		      
//		      resultSet = statement
//		      .executeQuery("select * from FEEDBACK.COMMENTS");
//		      writeMetaData(resultSet);
		      return result;
		    } catch (Exception e) {
		      throw e;
		    } finally {
		      close();
		    }

		  }

		  private void writeMetaData(ResultSet resultSet) throws SQLException {
		    //   Now get some metadata from the database
		    // Result set get the result of the SQL query
		    
		    System.out.println("The columns in the table are: ");
		    
		    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
		      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		    }
		  }

		  private String writeResultSet(ResultSet resultSet) throws SQLException {
		    // ResultSet is initially before the first data set
			  StringBuffer sb = new StringBuffer();
		    while (resultSet.next()) {
		      // It is possible to get the columns via name
		      // also possible to get the columns via the column number
		      // which starts at 1
		      // e.g. resultSet.getSTring(2);
		      String fName = resultSet.getString("firstname");
		      String lName = resultSet.getString("lastname");
		      String gender = resultSet.getString("gender");
		      int age = resultSet.getInt("age");
		      String email = resultSet.getString("email");
		      System.out.println("User: " + fName);
		      System.out.println("Website: " + lName);
		      System.out.println("Summary: " + gender);
		      System.out.println("Date: " + age);
		      System.out.println("Comment: " + email);
		      StringBuffer row = new StringBuffer("<TR>"+"<TD>"+fName+"</TD>"+"<TD>"+lName+"</TD>"+"<TD>"+gender+"</TD>"+"<TD>"+age+"</TD>"+"<TD>"+email+"</TD>"+"</TR>");
		      sb= sb.append(row);
		    }
		    return sb.toString();
		  }

		  // You need to close the resultSet
		  private void close() {
		    try {
		      if (resultSet != null) {
		        resultSet.close();
		      }

		      if (statement != null) {
		        statement.close();
		      }

		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {

		    }
		  }
		  
		  public void writeUser(String fName,String lName, String email,String gender,int age){
			 System.out.println("Inside the writeuser :"+fName+" "+lName);
			  try {
				connect = getConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  try {
				preparedStatement = connect
				          .prepareStatement("insert into  iaassql.userData values ( ?, ?, ?, ? , ?)");
				
				preparedStatement.setString(1, fName);
			      preparedStatement.setString(2, lName);
			      preparedStatement.setString(5, email);
			      
			      preparedStatement.setString(4, gender);
			      preparedStatement.setInt(3, age);
			      preparedStatement.executeUpdate();
			      System.out.println("Executed succesfully");
			  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			      // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
		      // Parameters start with 1
			      finally{
			    	  close();
			      }
		  }
}
