package models;

import java.sql.*;

import records.BankRecords;




public class DaoModel{
	DBConnect conn = null;
	Statement stmt = null;
	

	public DaoModel() { 
		//create db object instance
		 conn = new DBConnect();
	}
	public void createTable() {
		 try {

		 
		 System.out.println("\n\nConnecting to database to create Table...");
		 System.out.println("Connected database successful");
		 System.out.println("\nCreating table in given database...");

		// Open a connection
		 stmt = conn.connect().createStatement();
		 
		 //Create table in database
			 String sql = "CREATE TABLE srini_duli_tab " + 
			              "(pid INTEGER not NULL AUTO_INCREMENT, " + 
			  	        " id VARCHAR(10), " +
					  " income numeric(8,2), " + 
					  " pep VARCHAR(5), " + 
				  " PRIMARY KEY ( pid ))";
		
			// execute the query
		 stmt.executeUpdate(sql); 
		 System.out.println("Created table in given database...");
		//close db connection
		 conn.connect().close();  
		}
		 catch (SQLException se) { // Handle errors for JDBC
			 System.out.println("\nTable 'srini_duli_tab' already exits in the database");
		}
		     }
	
			/** The insertRecords method inserts the
			 * data from BankRecords object into the 
			 * table.
			 * @param robjs the robjs array
			 */
			// INSERT INTO METHOD
			public void insertRecords(BankRecords[] robjs) {
			  try {
			  //connect to the server			  
			  stmt = conn.connect().createStatement();
			  System.out.println("\nConnected to the database.\n");
			  System.out.println("\nInserting records into the table...");
			  String sql = null;
					  
			  // Include all object data to the database table
			  for (int i = 0; i <robjs.length; ++i) {
		        
				//string assignment to insert all object data 
			   // (id, income, pep) into your database table
				 String id = robjs[i].getId();
				 double income = robjs[i].getIncome();
				 String pep = robjs[i].getPep();
				  sql = "INSERT INTO srini_duli_tab" +
						  "(id, income, pep)" +
						  "VALUES('"+id+" ', ' "+income+" ', ' "+pep+" ' )";
				  stmt.executeUpdate(sql); //execute the query
				
			  }
			  System.out.println("\nInserted records to the papdemas server\n"+
					  			"Insertion records successful.");
			  //close the connection 
			  conn.connect().close();
			  } 
			  catch (SQLException se) {
				  se.printStackTrace();  }
			  }// INSERT INTO METHOD
			
			/**
			 * The retrieveRecords method retrieves
			 * the records from the table with pep
			 * in descending order.
			 * @return returns the returned records
			 */
			public ResultSet retrieveRecords() {
				 ResultSet rs = null;
				 
				 try {
				 //open a connection
				 stmt = conn.connect().createStatement();
				 System.out.println("Connected to the database.\n"+
						 			"\nSELECT * from srini_duli_tab order by pep desc"+
						 			"\nRetrieving Records from the table...");
				 String sql = "SELECT * from s_duli_tab order by pep desc";
				// execute the query
				 rs = stmt.executeQuery(sql);
				 System.out.println("\n\nRetrieving Records successful");
				// close the connection
				 conn.connect().close();
				 
				 }
				 catch (SQLException se) {
					 se.printStackTrace(); 
				}
				 return rs;
			}
		

}
