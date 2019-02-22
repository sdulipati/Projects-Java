package records;
import java.util.Comparator;

/**
 * The femsComparator method compares the sex per location.
 * @author Sreenidhi Rajesh Dulipati
 *
 */

public class femsComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords f1, BankRecords f2) {
		// TODO Auto-generated method stub
		int result = f1.getSex().compareTo(f2.getSex());
		return result;
	}

}
