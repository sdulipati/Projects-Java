import java.io.FileNotFoundException;	//Needed for File not found Exception
import java.io.IOException;				//Needed for IO Exception

/**
 * The Client class is an abstract class that contains 
 * public abstract methods of readData, processData
 * and printData. 
 */
public abstract class Client {

	public abstract void readData() throws FileNotFoundException, IOException;
	public abstract void processData();
	//public abstract void printData();

}
