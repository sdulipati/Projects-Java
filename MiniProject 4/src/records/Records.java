package records;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * The Bank of IIT program on getting analytics from its
 * clients for loan application process
 * @author 		Sreenidhi Rajesh Dulipati
 * Userid	 :	sdulipati
 * Date 	 :   Oct 21 2018
 * Lab number:   Lab 3
 * CSV File  :   bank-Detail.csv
 * Text File : 	 bankrecords.txt
 */

/**
 * This class displays the console output and writes the records into the
 * bankrecords text file. 
*/
public class Records extends BankRecords {
	//create formatted object to write output directly to the
	//console and to a file
	 
	    static FileWriter fw = null;
	
	    public Records(){
	    	
	    	//Open the file for writing the data
			try {
				fw = new FileWriter("bankrecords.txt");
								
			} 
			//Exception thrown if file couldn't be opened
			catch (IOException e) {
				e.printStackTrace();
			} 
		}
	    
	    /*
		 The main method is the program's starting point.
		*/
		public static void main(String[] args) throws FileNotFoundException, IOException  {
			
			//Creation of records object
		    Records br = new Records();
		    //The function readData is called
	                br.readData();
	            
	                 
	                System.out.println("Hi there...\n");
	        		System.out.println("**************************************************************");
	        		System.out.println("Welcome to Bank of Illinois Institute of Technology");
	        		System.out.println("**************************************************************");
	        		System.out.println("Customer Record Information\n\n");
	        	
	        		//Functions called to perform analytics
		    	    LocationComp(); // analyze average income per loc
		    	    MaxMinComp();  //compare max and min incomes per loc  
		    	    femsComp();    //  analyze females w. mort/savings accounts per loc
		    	    malesComp();  // analyze male count w. car and 1 child per loc 
		    	    ageComp(); // analyze maximum and minimum age 
		    	    
		    	 // *** close out file object ***//
			    	try {
		    	    	fw.close();
		    	    	} catch (IOException e) {
		    	    		e.printStackTrace();
		    	    	}
	    	System.out.println("\n-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
	   		System.out.println("`````````````````````End of Records```````````````````\n");
	   		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
	   		
	   		//To  display the current date, time and programmer name
	   		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	   		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Sreenidhi Rajesh Dulipati\n\n");
	   	
		}
		
		/**
		 * The LocationComp method displays the total,
		 * average income per location. 	
		 */
		public static void LocationComp() {
		
		//Sorts the BankRecords array based on location
		Arrays.sort(robjs,new LocationComparator());
	            
		//set up needed vars for region counts & incomes per loc
		double	townIncSum = 0, innerIncSum=0, suburbanIncSum=0,ruralIncSum=0;
		int innerCt=0, suburbanCt=0,ruralCt=0,townCt = 0;
		
		// For total  count and income per location
		for (int i=0;i<robjs.length;i++) {
			if (robjs[i].getRegion().equals("RURAL")) { 
				ruralIncSum += robjs[i].getIncome();
				++ruralCt;
				}
			else if(robjs[i].getRegion().equals("SUBURBAN")) {
				suburbanIncSum += robjs[i].getIncome();
				++suburbanCt;
				}
			else if(robjs[i].getRegion().equals("INNER_CITY")) {
				innerIncSum += robjs[i].getIncome();
				++innerCt;
				}
			else if (robjs[i].getRegion().equals("TOWN")) { 
				townIncSum += robjs[i].getIncome();
				++townCt;
				}
		
		
		}	 
		//setup resulting averages to print to console and to file
		double ruralAvg = ruralIncSum/(ruralCt);
		double suburbanAvg = suburbanIncSum/(suburbanCt);
		double innerCityAvg = innerIncSum/(innerCt);
		double townAvg = townIncSum/(townCt);
		
		//Displaying total count, income and average income per location  
		System.out.println("AVERAGE INCOME PER LOCATION");
		System.out.printf("INNER_CITY Total %21d\n", innerCt);
		System.out.printf("INNER_CITY Total Income %21.2f\n", innerIncSum);
		System.out.printf("INNER_CITY Average Income %17.2f\n\n", innerCityAvg);
		
		System.out.printf("RURAL Total %25d\n", ruralCt);
		System.out.printf("RURAL Total Income %26.2f\n", ruralIncSum);
		System.out.printf("RURAL Average Income %22.2f\n\n", ruralAvg);
		
		System.out.printf("SUBURBAN Total %22d\n", suburbanCt);
		System.out.printf("SUBURBAN Total Income %23.2f\n", suburbanIncSum);
		System.out.printf("SUBURBAN Average Income %19.2f\n\n", suburbanAvg);
		
		System.out.printf("TOWN Total %27d\n", townCt);
		System.out.printf("TOWN Total Income %27.2f\n", townIncSum);
		System.out.printf("TOWN Average Income %23.2f\n\n", townAvg);
		
		//Writing the data analytics results to the text file
		try {
			fw.write(String.format("Data Analytics Results:"));
			fw.write(System.lineSeparator());
			fw.write(System.lineSeparator());
			fw.write(String.format("AVERAGE INCOME PER LOCATION"));
			fw.write(System.lineSeparator());
			
			//For Inner city Location
			fw.write(System.lineSeparator());
		    fw.write(String.format("INNER_CITY:\n"));
			fw.write(System.lineSeparator());
			fw.write(String.format("INNER_CITY Total %19d", innerCt));
			fw.write(System.lineSeparator());
		    fw.write(String.format("INNER_CITY Total Income %19.2f", innerIncSum));
		    fw.write(System.lineSeparator());
		    fw.write(String.format("INNER_CITY Average Income %15.2f", innerCityAvg));
		    fw.write(System.lineSeparator());
		    
		    //For Rural Location		
		    fw.write(System.lineSeparator());
		    fw.write(String.format("RURAL:"));
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("RURAL Total %23d", ruralCt));
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("RURAL Total Income %24.2f", ruralIncSum));
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("RURAL Average Income %20.2f\n", ruralAvg));
	   		fw.write(System.lineSeparator());
	   		
	   		//For Suburban Location
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("SUBURBAN:"));
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("SUBURBAN Total %20d", suburbanCt));
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("SUBURBAN Total Income %21.2f", suburbanIncSum));
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("SUBURBAN Average Income %17.2f", suburbanAvg));
	   		fw.write(System.lineSeparator());
	   		
	   		//For Town Location
	   		fw.write(System.lineSeparator());
	   		fw.write(String.format("TOWN:\n"));
			fw.write(System.lineSeparator());
			fw.write(String.format("TOWN Total %25d", townCt));
			fw.write(System.lineSeparator());
		    fw.write(String.format("TOWN Total Income %25.2f", townIncSum));
		    fw.write(System.lineSeparator());
		    fw.write(String.format("TOWN Average Income %21.2f", townAvg));
		    fw.write(System.lineSeparator());
		    
		    
			                  
		} 
		//Exception if unable to write data to text file
		catch (IOException e) {
				      e.printStackTrace();
				   }  
		}
		
		/**
		 * The MaxMinComp method for getting maximum 
		 * and minimum income per location.
		 */
		public static void MaxMinComp() {
			//Sorts the BankRecords array based on maximum and minimum income
			Arrays.sort(robjs,new MaxMinComparator());
			
			//set up needed vars for max and min income per location
			double maxRuralIncome = 0,maxSuburbanIncome =0,maxCityIncome =0,maxTownIncome =0,minRuralIncome,minSuburbanIncome,minCityIncome,minTownIncome;
			minCityIncome=minSuburbanIncome=minRuralIncome=minTownIncome=0;
			
			// For minimum income per location
			for (int i=0;i<robjs.length;i++) {
				if (robjs[i].getRegion().equals("RURAL")) {
					minRuralIncome = robjs[i].getIncome();
					break;
				}
					
			}
			for (int j=0;j<robjs.length;j++) {
				 if (robjs[j].getRegion().equals("SUBURBAN")) {
					minSuburbanIncome = robjs[j].getIncome();
					break;
				 }
			}
			for (int i=0;i<robjs.length;i++) {
				if (robjs[i].getRegion().equals("INNER_CITY")) { 
						minCityIncome = robjs[i].getIncome();
						break;
				}
			}
			for (int i=0;i<robjs.length;i++) {
				 if (robjs[i].getRegion().equals("TOWN")) {
						minTownIncome = robjs[i].getIncome();
						break;
				 }
			}
			
			// For maximum and minimum income per location
			for (int i = robjs.length-1;i<robjs.length;i--) {
				if (robjs[i].getRegion().equals("RURAL")) {
						maxRuralIncome = robjs[i].getIncome();
						break;
					}
			}
			for (int j=robjs.length-1;j<robjs.length;j--) {
				if (robjs[j].getRegion().equals("SUBURBAN")) {
						maxSuburbanIncome = robjs[j].getIncome();
						break;
				}
			}
			for (int i=robjs.length-1;i<robjs.length;i--) {
				if (robjs[i].getRegion().equals("INNER_CITY")) { 
						maxCityIncome = robjs[i].getIncome();
							break;
				}
			}
			for (int i=robjs.length-1;i<robjs.length;i--) {
				if (robjs[i].getRegion().equals("TOWN")) {
					maxTownIncome = robjs[i].getIncome();
					 break;
				 }
			}
			
			//Displaying maximum and minimum income per location
			System.out.println("MINIMUM INCOME PER LOCATION:");
			System.out.printf("INNER_CITY %30.1f\n", minCityIncome);
			System.out.printf("RURAL %35.1f\n", minRuralIncome);
			System.out.printf("SUBURBAN %32.1f\n", minSuburbanIncome);
			System.out.printf("TOWN %36.1f\n\n", minTownIncome);
			
			System.out.println("MAXIMUM INCOME PER LOCATION:");
			System.out.printf("INNER_CITY %31.1f\n", maxCityIncome);
			System.out.printf("RURAL %35.1f\n", maxRuralIncome);
			System.out.printf("SUBURBAN %32.1f\n", maxSuburbanIncome);
			System.out.printf("TOWN %36.1f\n\n", maxTownIncome);
		 
			//Writing the data analytics results to the text file
			try {
				fw.write(System.lineSeparator());
				fw.write(System.lineSeparator());
				fw.write(String.format("MINIMUM INCOME PER LOCATION:"));
				fw.write(System.lineSeparator());
				fw.write(String.format("INNER_CITY Min Income %18.2f", minCityIncome));
			    fw.write(System.lineSeparator());
			    fw.write(String.format("RURAL Min Income %23.2f", minRuralIncome));
			    fw.write(System.lineSeparator());
			    fw.write(String.format("SUBURBAN Min Income %20.2f", minSuburbanIncome));
			    fw.write(System.lineSeparator());
			    fw.write(String.format("TOWN Min Income %24.2f", minTownIncome));
			    fw.write(System.lineSeparator());
			    fw.write(System.lineSeparator());
			    fw.write(String.format("MAXIMUM INCOME PER LOCATION:"));
			    fw.write(System.lineSeparator());
			    fw.write(String.format("INNER_CITY Max Income %20.2f", maxCityIncome));
		   		fw.write(System.lineSeparator());
		   		fw.write(String.format("RURAL Max Income %24.2f", maxRuralIncome));
		   		fw.write(System.lineSeparator());
		   		fw.write(String.format("SUBURBAN Max Income %21.2f", maxSuburbanIncome));
		   		fw.write(System.lineSeparator());
		   		fw.write(String.format("TOWN Max Income %25.2f", maxTownIncome));
		   		fw.write(System.lineSeparator());
		   		
			}
			// Exception if unable to write data to a file
			catch (IOException e) {
			      e.printStackTrace();
			}  
		}
	
		/**
		 * The femsComp method displays the number of 
		 * females per location.  
		 */
		public static void femsComp() {
			//Sorts the BankRecords array based on number of females per location
			Arrays.sort(robjs,new femsComparator());
			
			//set up needed vars for number of females per location
			int numFemaleRural=0,numFemaleSuburban =0,numFemaleCity =0,numFemaleTown =0;
			
			//for number of females per location
			for (int i=0;i<robjs.length;i++) {
				if (robjs[i].getRegion().equals("RURAL")) {
			
					if(robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES")) 
					++numFemaleRural;
				
					
				
				}
				else if(robjs[i].getRegion().equals("SUBURBAN")) {
					if(robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES")) 
					++numFemaleSuburban;
				
				}
				else if(robjs[i].getRegion().equals("INNER_CITY")) {
					if(robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES")) 
						++numFemaleCity;
					
					}
				else if (robjs[i].getRegion().equals("TOWN")) {
					if(robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES")) 
						++numFemaleTown;
					
					}
			}
			
			//Displaying number of females with both mortgage and savings account per location
			System.out.println("NUMBER OF FEMALES WITH BOTH A MORTGAGE AND SAVINGS ACCOUNT PER LOCATION");
			System.out.printf("INNER_CITY %25d\n", numFemaleCity);
			System.out.printf("RURAL %29d\n", numFemaleRural);
			System.out.printf("SUBURBAN %26d\n", numFemaleSuburban);
			System.out.printf("TOWN %31d\n\n", numFemaleTown);
			
			//Writing the data to the text file
			try {
				fw.write(System.lineSeparator());
				fw.write(System.lineSeparator());
				fw.write(String.format("NUMBER OF FEMALES WITH BOTH A MORTGAGE AND SAVINGS ACCOUNT PER LOCATION"));
				fw.write(System.lineSeparator());
				fw.write(String.format("INNER_CITY: %23d",numFemaleCity ));
			    fw.write(System.lineSeparator());
				fw.write(String.format("RURAL: %27d",numFemaleRural));
				fw.write(System.lineSeparator());
				fw.write(String.format("SUBURBAN: %24d",numFemaleSuburban));
				fw.write(System.lineSeparator());
				fw.write(String.format("TOWN: %29d",numFemaleTown));
				fw.write(System.lineSeparator());
			
			}
			catch (IOException e) {
			      e.printStackTrace();
			   }
		}
		
		/**
		 * The malesComp method for calculating 
		 * number of males per location.
		 */
		public static void malesComp() {
			
			//for number of females per location
			Arrays.sort(robjs, new malesComparator());
			
			//set up needed vars for number of males per location
			int numMaleRural =0, numMaleSuburban =0, numMaleCity =0,numMaleTown =0;
			
			//For number of males per location 
			for (int i=0;i<robjs.length;i++) {
				if (robjs[i].getRegion().equals("RURAL")) {
					if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1) 
						++numMaleRural;
				}
				else if(robjs[i].getRegion().equals("SUBURBAN")) {
					if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1) 
					++numMaleSuburban;
				}
				else if(robjs[i].getRegion().equals("INNER_CITY")) {
					if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1) 
					++numMaleCity;
				}
				else if (robjs[i].getRegion().equals("TOWN")) {
					if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1) 
					++numMaleTown;
				}
			}
			//Displaying the number of males with both a car and 1 child per location
			System.out.println("NUMBER OF MALES WITH BOTH A CAR AND 1 CHILD PER LOCATION");
			System.out.printf("INNER_CITY %25d\n", numMaleCity);
			System.out.printf("RURAL %29d\n", numMaleRural);
			System.out.printf("SUBURBAN %26d\n", numMaleSuburban);
			System.out.printf("TOWN %30d\n", numMaleTown);
			
			//Writing the data to the file
			try {
				fw.write(System.lineSeparator());
				fw.write(System.lineSeparator());
				fw.write(String.format("NUMBER OF MALES WITH BOTH A CAR AND 1 CHILD PER LOCATION"));
				fw.write(System.lineSeparator());
				fw.write(String.format("INNER_CITY: %23d",numMaleCity ));
				fw.write(System.lineSeparator());
				fw.write(String.format("RURAL: %27d",numMaleRural));
				fw.write(System.lineSeparator());
				fw.write(String.format("SUBURBAN: %24d",numMaleSuburban));
				fw.write(System.lineSeparator());
				fw.write(String.format("TOWN: %28d",numMaleTown));
				fw.write(System.lineSeparator());
			
			}
			//Exception if unable to write data to the file
			catch (IOException e) {
			      e.printStackTrace();
			   }
		
		}
		/**
		 * The ageComp method for calculating 
		 * maximum and minimum age per location.
		 */
		public static void  ageComp() {
			//Sorts the BankRecords array based on number of females per location
			Arrays.sort(robjs, new ageComparator());
			
			//Minimum and maximum age 
			int minAge = robjs[0].getAge();
			int maxAge = robjs[robjs.length-1].getAge();
			
			//For displaying the maximum and minimum age 
			System.out.println("\nMINIMUM AND MAXIMUM AGE");
			System.out.printf("Minimum age %24d\n", minAge);
			System.out.printf("Maximum age %24d\n", maxAge);
			
			//Writing the data to the text file
			try {
				fw.write(System.lineSeparator());
				fw.write(System.lineSeparator());
				fw.write(String.format("MINIMUM AND MAXIMUM AGE"));
				fw.write(System.lineSeparator());
				fw.write(String.format("Minimum age: %22d",minAge));
				fw.write(System.lineSeparator());
				fw.write(String.format("Maximum age: %22d",maxAge));
			}
			//Exception if unable to write data to file
			catch (IOException e) {
			      e.printStackTrace();
			   }
		}
	}


