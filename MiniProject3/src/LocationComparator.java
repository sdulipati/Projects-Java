import java.util.Comparator;

/**
 * The LocationComparaor method compares the region per location.
 * @author Sreenidhi Rajesh Dulipati
 *
 */
public class LocationComparator implements Comparator<BankRecords>{
	 
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
	// use compareTo to compare strings
	int result = o1.getRegion().compareTo(o2.getRegion());
	//System.out.println(result);
	return result;
	}
 }
