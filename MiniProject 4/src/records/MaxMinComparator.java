package records;
import java.util.Comparator;

/**
 * The MaxMinComparator comparator method compares
 *  income of the location.
 * @author Sreenidhi Rajesh Dulipati
 */
public class MaxMinComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords m1, BankRecords m2) {
		
		return Double.compare(m1.getIncome(), m2.getIncome());
	}
}
