import java.util.Calendar;					//Needed for Calendar
import java.io.IOException;					//Needed for IO Exception
import java.text.SimpleDateFormat;			//Needed for date/time display format

/**
 * The Bank of IIT program on getting data for loans
 * to various clients 
 * @author 		Sreenidhi Rajesh Dulipati
 * Userid	 :	sdulipati
 * Date 	 :   Oct 3 2018
 * Lab number:   Lab 2
 * CSV File  :   bank-Detail.csv
 */
public class BankRecordsTest {

	/*
	 The main method is the program's starting point.
	*/
	public static void main(String[] args) throws IOException{
		
		System.out.println("Hi there...\n");
		System.out.println("**************************************************************");
		System.out.println("Welcome to Bank of Illinois Institute of Technology");
		System.out.println("**************************************************************");
		System.out.println("Customer Record Information");
		
		// Object accObj1 of BankRecords is declared		
		BankRecords accObj1 = new BankRecords();
		accObj1.readData();
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
		System.out.println("`````````````````````End of Records```````````````````\n");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
		
		//To  display the current date, time and programmer name
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Sreenidhi Rajesh Dulipati\n\n");
	}
}
