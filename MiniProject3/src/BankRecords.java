import java.io.*;						//Needed for IO operations
import java.text.SimpleDateFormat;		//Needed for date/time display format
import java.util.ArrayList;				//Needed for ArrayList class
import java.util.Arrays;				//Needed for Array class
import java.util.Calendar;				//Needed for Calendar
import java.util.List;					//Needed for List class
import java.util.Scanner;				//Needed for Scanner class

/**
 	The BankRecords class holds data of various clients.
 */

public class BankRecords extends Client {
	
	//array of Bankrecords objects
	public static BankRecords robjs[] = new BankRecords[600]; 
	//arraylist to hold spreadsheet rows & columns
	private static ArrayList<List<String>> array = new ArrayList<>();

	//Declaring Variables to get and set columns
	private String id, sex, region, car, married, save_act, current_act, mortgage, pep;
	private int age, children;
	private double income;
	
	public int index=0;
	
	
	//Create a Scanner object to read input.
	Scanner sc = new Scanner(System.in);

	/**
	 * The getId method returns the ID.
	 * @return the ID.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * The setID method sets the id got from csv file
	 * to the variable id.
	 * @param id The id obtained from csv file.
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * The getAge method returns the age. 
	 * @return the age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * The setAge method sets the age obtained from the csv file
	 * to the variable age.
	 * @param age The age obtained from the csv file.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * The getSex method returns the sex.
	 * @return the sex.
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * The setSex method sets the sex obtained from the csv file
	 * to the variable sex.
	 * @param sex The sex obtained from the csv file.
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * The getRegion method returns the sex.
	 * @return the sex.
	 */
	public String getRegion() {
		return region;
	}
	
	/**
	 * The setRegion method sets the region obtained from the csv file
	 * to the variable region.
	 * @param region The region obtained from the csv file.
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * The getIncome method returns the income.
	 * @return the income.
	 */
	public double getIncome() {
		return income;
	}
	
	/**
	 * The setIncome method sets the income obtained from the csv file
	 * to the variable income.
	 * @param income The income obtained from the csv file.
	 */
	public void setIncome(double income) {
		this.income = income;
	}
	
	/**
	 * The getMarried method returns the married.
	 * @return the married.
	 */
	public String getMarried() {
		return married;
	}
	
	/**
	 * The setMarried method sets the married obtained from the csv file
	 * to the variable married.
	 * @param married The married obtained from the csv file.
	 */
	public void setMarried(String married) {
		this.married = married;
	}
	
	/**
	 * The getChildren method returns the children.
	 * @return the children.
	 */
	public int getChildren() {
		return children;
	}
	
	/**
	 * The setChildren method sets the children obtained from the csv file
	 * to the variable children.
	 * @param children The children obtained from the csv file.
	 */
	public void setChildren(int children) {
		this.children = children;
	}

	/**
	 * The getCar method returns the car.
	 * @return the car.
	 */
	public String getCar() {
		return car;
	}
	
	/**
	 * The setCar method sets the car obtained from the csv file
	 * to the variable car.
	 * @param car The car obtained from the csv file.
	 */
	
	public void setCar(String car) {
		this.car = car;
	}
	
	/**
	 * The getSave_act method returns the save_act.
	 * @return the save_act.
	 */
	public String getSave_act() {
		return save_act;
	}
	
	/**
	 * The setSave_act method sets the save_act obtained from the csv file
	 * to the variable save_act.
	 * @param save_act The save_act obtained from the csv file.
	 */
	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}
	
	/**
	 * The getCurrent_act method returns the current_act.
	 * @return the current_act.
	 */
	public String getCurrent_act() {
		return current_act;
	}

	/**
	 * The setCurrent_act method sets the current_act obtained from the csv file
	 * to the variable current_act.
	 * @param current_act The current_act obtained from the csv file.
	 */
	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}

	/**
	 * The getMortgage method returns the mortgage.
	 * @return the mortgage.
	 */
	public String getMortgage() {
		return mortgage;
	}

	/**
	 * The setMortgage method sets the mortgage obtained from the csv file
	 * to the variable mortgage.
	 * @param mortgage The mortgage obtained from the csv file.
	 */
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	/**
	 * The getPep method returns the pep.
	 * @return the pep.
	 */
	public String getPep() {
		return pep;
	}

	/**
	 * The setPep method sets the pep obtained from the csv file
	 * to the variable pep.
	 * @param pep The pep obtained from the csv file.
	 */
	public void setPep(String pep) {
		this.pep = pep;
	}
		
	/** 
	 * The readData method reads the data 
	 * from the bank-Detail csv file using Buffered Reader.
	 * @exception If the file is not found throws an exception error.
	 */
	
	@Override
	public void readData() throws FileNotFoundException, IOException{
		BufferedReader br = null;
	    
	     //initialize reader object and set file path to root of project
	     try { 
	    	 String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	    	 System.out.println("bank-Detail csv file import started"+
	    			 			" at " + timeStamp);
	    	 br = new BufferedReader(new FileReader(new File("bank-Detail.csv")));
				String line;
	            
	              //read each record in csv file
				while ((line = br.readLine()) != null) {
	             //parse each record in csv file by a comma ( , )
	             //into a list stored in the arraylist-> Arrays
			                  array.add(Arrays.asList(line.split(",")));
				}
				//call function for processing record data
				processData();  
	     	  }
	     catch(FileNotFoundException e){
	    	 	
	              System.out.println("File = bank-Detail.csv Not Found");
	              System.exit(0);
	      }
	     catch(IOException ioe) {
	     	    	System.out.println("Unable to read Input/Output");
	      }
	     
	     //Closing the bank-Detail.csv file
	     if(br != null) {
	       br.close();
	   }
	     else{
	    	 System.out.println("File cannot be closed as file is not found");
	     	 }
		
	}
	
	/**
	 * The processData method process the data from 
	 * the csv file using ArrayList.
	 */
	
	@Override
	public void processData() {
	
		//create index for array while iterating thru arrayList
		int idx = 0; 
		idx = index;
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("bank-Detail csv file import completed"+
   			 			" at " + timeStamp);
   	
			    //create for each loop to cycle thru arrayList of values 
			    //and PASS that data into your record objects' setters. 
			    for (List<String> rowData: array) {
			     
			    	//initializing array of objects
			    	robjs[idx] = new BankRecords();
			    	
			    	//calling setters and populating them, item by item
			    	robjs[idx].setId(rowData.get(0)); 						//getting 1st column ID
			    	robjs[idx].setAge(Integer.parseInt(rowData.get(1))); 	//getting 2nd column Age
			    	robjs[idx].setSex(rowData.get(2));						//getting 3rd column Sex
			    	robjs[idx].setRegion(rowData.get(3));					//getting 4th column Region
			    	robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));//getting 5th column Income
			    	robjs[idx].setMarried(rowData.get(5));					//getting 6th column Married
			    	robjs[idx].setChildren(Integer.parseInt(rowData.get(6)));//getting 7th column Children
			    	robjs[idx].setCar(rowData.get(7));						//getting 8th column Car
			    	robjs[idx].setSave_act(rowData.get(8));					//getting 9th column Savings account
			    	robjs[idx].setCurrent_act(rowData.get(9));				//getting 10th column Current Account
			    	robjs[idx].setMortgage(rowData.get(10));				//getting 11th column Mortgage
			    	robjs[idx].setPep(rowData.get(11));						//getting 12th column Pep
			    	
			    	idx++;
			    }
		//printData();  //call function to print objects held in memory
	}

	/**
	 * The printData method prints the data  
	 * received from the processData function.
	 */
	
	/*@Override
	 public void printData() {
		 
		 //Asks the user for the number of records to print 
		 System.out.println("How many records would you like to print?");
		 int size = sc.nextInt();
		 
		 //Checks whether the number is between 1 and 600
		 while(size<1 || size>600) {
			 System.out.println("Please enter number of records between 1 to 600");
			  size = sc.nextInt();
		}
		 System.out.println("ID\t\tAge\t\tSex\t\tRegion\t\tIncome\t\tMarried"+
				 			"\t\tChildren\tCar\t\tSavings Account\t\tCurrent Account\t\tMortgage\tPep");
		 
		 //Prints the data by getting data from getters
		 for (index = 0;index<size;index++) {
			 System.out.print(robjs[index].getId());
			 System.out.print("\t\t");
			 System.out.print(robjs[index].getAge());
			 System.out.print("\t\t");
			 System.out.print(robjs[index].getSex());
			 System.out.print("\t\t");
			 System.out.print(robjs[index].getRegion());
			if(robjs[index].getRegion().equals("INNER_CITY") || robjs[index].getRegion().equals("SUBURBAN")) {
				System.out.print("\t");
			}
			 else {
				 System.out.print("\t\t");
			 }
				 System.out.print(robjs[index].getIncome());
				 if(robjs[index].getIncome()>99999) {
					 System.out.print("\t"); 
				 }
				 else {
				 System.out.print("\t\t");
				 }
			System.out.print(robjs[index].getMarried());
			System.out.print("\t\t");
			System.out.print(robjs[index].getChildren());
			System.out.print("\t\t");
			System.out.print(robjs[index].getCar());
			System.out.print("\t\t");
			System.out.print(robjs[index].getSave_act());
			System.out.print("\t\t\t");
			System.out.print(robjs[index].getCurrent_act());
			System.out.print("\t\t\t");
			System.out.print(robjs[index].getMortgage());
			System.out.print("\t\t");
			System.out.print(robjs[index].getPep());					 
							
			System.out.println("\n");
		 }
	 }*/
}

