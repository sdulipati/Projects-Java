import java.util.Comparator;

/**
 * The malesComparatoe method for comparing the number of
 * males of the location.
 * @author Sreenidhi Rajesh Dulipati
 */
public class malesComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords mal1, BankRecords mal2) {
		int result = mal2.getSex().compareTo(mal1.getSex());
		return result;
	}

}
