package records;
import java.util.Comparator;

/**
 * The ageComparator method compares the age per location.
 * @author Sreenidhi Rajesh Dulipati
 *
 */

public class ageComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords a1, BankRecords a2) {
		// TODO Auto-generated method stub
		return Integer.compare(a1.getAge(), a2.getAge());
		//int result = a1.getAge().compareTo(a2.getAge());
		//return result;
	}

}
