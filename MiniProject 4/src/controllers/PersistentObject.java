package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PersistentObject extends LoanProcessing {

	double startTime;
	
	/**
	 * The serialize method serializes bank records
	 * objects.
	 */
	public void serialize() {
		System.out.println("\n\n**************Serialization and Deseialization of BankRecords object"+
							"**************");
		System.out.println("\nStarting Serialization");
		
		//Creating an empty HashMap
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		int k=1;
		
		//mapping string values to int keys
		for(int j=0;j<robjs.length;j++) {
			hmap.put(k,robjs[j].getId());
			++k;
		}
	    //Adding elements to HashMap
	    try
	    {
	           FileOutputStream fos =
	              new FileOutputStream("bankrecords.ser");
	           ObjectOutputStream oos = new ObjectOutputStream(fos);
	           oos.writeObject(hmap);
	           oos.close();
	           fos.close();// close the file
	           
	           startTime = System.currentTimeMillis();
	           System.out.println("Serialization is completed.");
	           System.out.println("Serialized data is saved in bankrecords.ser");
	    }
	    catch(IOException ioe){
	           ioe.printStackTrace();
	     }
	}
	
	/**
	 * The deserialize method reads the 
	 * serailized bytes in bakrecords.ser constructs
	 * bank records object. 
	 * @throws InterruptedException when thread is sleeping.
	 */
	@SuppressWarnings("unchecked")
	public void deserialize() throws InterruptedException {  
		 
	    System.out.println("\nApplication sleeps  for  5 seconds...");
	    System.out.println("\nThread running");
	    
	    //Application sleeps for 5 seconds
	    Thread.sleep(5000);	    
	    
	    System.out.println("Thread run completed");
		
		Map<Integer, String> map = null;
		try
		{
		  FileInputStream fis = new FileInputStream("bankrecords.ser");
		  ObjectInputStream ois = new ObjectInputStream(fis);
		  //Reads the bytes from the file
		  map = (Map<Integer, String>) ois.readObject();
		  ois.close();
		  fis.close();// close the file
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			return;
		}
		catch(ClassNotFoundException c){
			System.out.println("Class not found.");
			c.printStackTrace();
			return;
		}
		
		double stopTime = System.currentTimeMillis();
		//for time difference between the serialization and deserialization
		double elapsedTime = (stopTime - startTime)/1000;
		System.out.printf( "\nThe time difference between"+
			   				" Serialization and Deserialization process"+
			   				" is  %.3f seconds", (elapsedTime-5));
		System.out.println("\n\nDeserialized Map is been given below:");
		
		//To  display the current date and time
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		String timeStamp1 = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		
		//To display day of the week
		Calendar calendar = Calendar.getInstance();
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		DateFormatSymbols dfs = new DateFormatSymbols();
		System.out.println(dfs.getWeekdays()[weekday] +" Date = " + timeStamp+ " Time:"+ timeStamp1 + " CST");
		
		
		// Display content using Iterator
		Set<?> set = map.entrySet();
		Iterator<?> iterator = set.iterator();
		while(iterator.hasNext()) {
		  @SuppressWarnings("rawtypes")
		  Map.Entry mentry = (Map.Entry)iterator.next();
		  System.out.print("Data==> Key Value: "+ mentry.getKey() + " & ID: ");
		  System.out.println(mentry.getValue());
		}
	}
}
