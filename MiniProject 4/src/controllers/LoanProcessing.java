package controllers;
import records.Records;
import java.io.*;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import models.DaoModel;
import records.BankRecords;
import views.LoanView;

/**
 * The Bank of IIT program which uses MVC simulated 
 * approach that performs Loan analysis reports from class objects
 * @author 		Sreenidhi Rajesh Dulipati
 * Userid	 		:	sdulipati
 * Date 	 		:   Nov 11 2018
 * Lab number		:   Lab 4
 * CSV File  		:   bank-Detail.csv
 * Text File 		: 	bankrecords.txt
 * Serialized File 	: 	bankrecords.ser
 */

public class LoanProcessing extends BankRecords{
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Hi there...\n");
		System.out.println("**************************************************************");
		System.out.println("Welcome to Bank of Illinois Institute of Technology");
		System.out.println("**************************************************************");
		System.out.println("Customer Record Information\n\n");
	
		//Functions called to perform analytics
		
	 // *** close out file object ***//
    	
		try{
			BankRecords br = new BankRecords();
			br.readData();
			Records r = new Records();
		    r.LocationComp(); // analyze average income per loc
		    r.MaxMinComp();  //compare max and min incomes per loc  
		    r.femsComp();    //  analyze females w. mort/savings accounts per loc
		    r.malesComp();  // analyze male count w. car and 1 child per loc 
		    r.ageComp(); // analyze maximum and minimum age 
		    
			DaoModel dao = new DaoModel();
			
			//perform create table
			dao.createTable();
			
			// perform insert records into the table
			dao.insertRecords(robjs); 
			ResultSet rs;
			//perform retrieve records from the table
			rs = dao.retrieveRecords();
			new LoanView().runView(rs);
		}
		catch(FileNotFoundException e){
    	 	System.out.println("File = bank-Detail.csv Not Found");
  		}
		catch(IOException ioe) {
   	    	System.out.println("Unable to read Input/Output");
		}
		
		//creation of Persistent object
		 PersistentObject obj1 = new PersistentObject();
		 //serialize method is called 
		 obj1.serialize();
		 //deserialize method is called
		 obj1.deserialize();	
		 
		System.out.println("\n-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
		System.out.println("`````````````````````End of Records```````````````````\n");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
		
		//To  display the current date, time and programmer name
		String timeStamp2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp2 + "\nProgrammed by Sreenidhi Rajesh Dulipati\n\n");

   }

	
	}


