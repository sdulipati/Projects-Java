import java.util.Scanner; 				//Needed for Scanner class 
import java.text.SimpleDateFormat;		//Needed for date/time display format
import java.util.Calendar;				//Needed for Calendar

/**
 * This class will prompt users for options such as creating an initial balance, 
 * entering deposits or withdrawals. This will allow for the printing of account 
 * information including interest at various interest rates.
 * AccountHolderTest class demonstrates the AccountHolder class.  
 * @author 		Sreenidhi Rajesh Dulipati
 * Date 	  - Sept 15 2018
 * File name  - AccountHolderTest.java
 * /

public class AccountHolderTest {

	/*
	 The main method is the program's starting point.
	*/
	public static void main(String[] args) {
		
		double bankinterest = 0.04;
		double intialBal,deposit,withdraw,userInput;
		int m,option;
		
		// Create a Scanner object to read input.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hi there...\n");
		System.out.println("Welcome to Bank of Illinois Institute of Technology\n\n");
		System.out.println("We are happy to welcome you and look forward to serving your banking needs.\n");
		System.out.println("What to Expect With Your Account\n");
		
		//List of Bank of IIT policies
		System.out.println("Before opening an account. Let's have a look at Bank of IIT policies\n");
		System.out.println("1. Initial Balance must be more than $100\n");
		System.out.println("2. There is a transaction fee of $50 if your account balance is than $500.\n");
		System.out.println("3. There will no withdrawal if the account balance is $100.\n");
		System.out.println("4. The customer is given the freedom of modifying the interest rate.\n");
		System.out.println("5. There is no monthly transaction fee and there are no charges for updating the rate of interest\n");
		System.out.println("Let's get started by opening an account\n");
		
		//To get initial balance from customer.
		System.out.println("Can you tell the intial balance");
		intialBal = sc.nextDouble();							
		AccountHolder accObj1 = new AccountHolder(intialBal);
		
		do {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Main Menu - Bank of IIT\n");
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Enter the option from the below Menu");
		System.out.println("Menu:\n" +
							"Press 1 if you want to about your balance\n" +
							"Press 2 if you want to deposit the amount to the Bank of IIT\n" +
							"Press 3 if you want to withdraw money from the bank\n" +
							"Press 4 if you want the display with new balances for a 12 month period with bank interest rate\n" +
							"Press 5 if you want to update the annual Interest rate and display with new balances for a 12 month period\n"+
							"Press 6 if you want to know about our Contact Information\n");
		option = sc.nextInt();
		
		//Get the desired option from customer and switch on it.
		switch(option)
		{
		//To display customer account balance.
		case 1:{
			System.out.printf("Your balance is $%,.2f\n", accObj1.totalBalanceAmount());
			break;
		}
		
		//If the customer wants to deposit amount to his account.
		case 2:{
			System.out.println("Please enter the deposit amount");
			deposit = sc.nextDouble();
			while(deposit<0) {
				System.out.println("Please enter number greater than zero for deposit");
				deposit = sc.nextDouble();
			}
			accObj1.deposit(deposit);
			System.out.printf("Your pay has been deposited"+
							" and your balance is $%,.2f\n",accObj1.getDeposit());
			break;	
		}
		
		//If the customer wants withdraw money from the bank.
		case 3:{
		System.out.println("Please enter the withdrawal amount");
		withdraw = sc.nextDouble();
				
		//Checks whether the withdrawal amount is less than zero
		while(withdraw<0) {
			System.out.println("Please enter number greater than zero for withdrawal");
			withdraw = sc.nextDouble();
		}
		accObj1.withdrawal(withdraw);
		
		// Checks whether the withdrawal amount is equal to zero.
		if(accObj1.getWithdrawal() == 0) {
			System.out.printf("Your balance amount is $%,.2f and your"+
							" withdrawal amount is $%,.2f\n",accObj1.totalBalanceAmount(),accObj1.getWithdrawal());			
		}
		else {	
		System.out.printf("Transaction fee has been deducted from your account"+
						" and your balance is $%,.2f and your withdrawal "+
						" amount is $%,.2f\n",accObj1.totalBalanceAmount(),accObj1.getWithdrawal());
		
		}
		break;
		}
		
		//If the customer wants the balance for 12 months with initial bank rate of interest. 
		case 4:{
			System.out.printf("Monthly balances for one year at %.2f\n", bankinterest);
			System.out.println("Balances:\n" +
								"Annual Balance w. Interest\n");
			System.out.printf("Base\t\t$%.2f\n", accObj1.totalBalanceAmount());
			accObj1.monthlyInterest();
			m =1;
			
			//Prints the balance with initial rate of interest for a period of 12 months.
			while(m<=12) {
				System.out.printf("Month %d:\t%s\n", m, accObj1.toString());
				accObj1.interestCalculation();
				m++;
			}
			break;
		}
		
		//If the customer wants the balance for 12 months with his modified rate of interest.
		case 5:{
		System.out.println("Please enter the annual Interest rate between" +
												" 1-100");
		bankinterest = sc.nextDouble();	
		bankinterest = bankinterest/100;
		AccountHolder.modifyMonthlyInterest(bankinterest);
		System.out.printf("Monthly balances for one year at %.2f\n", bankinterest);
		System.out.println("Balances:\n" +
							"Annual Balance w. Interest\n");
		System.out.printf("Base\t\t$%.2f\n", accObj1.totalBalanceAmount());
		accObj1.monthlyInterest();
		m =1;
		
		//Prints the balance with customer's rate of interest for a period of 12 months.
		while(m<=12) {
			System.out.printf("Month %d:\t%s\n", m, accObj1.toString());
			accObj1.interestCalculation();
			m++;
		}
		break;
		}
		
		//If the customer wants the contact information of Bank of IIT
		case 6:{
			System.out.println("Please find the contact information:" );
			System.out.println("Bank of Illinois Institute of Technology");
			System.out.println("10 W 35th Street\n"+
								"Chicago, IL 60616");
			System.out.println("Phone no: 555-333-1234\n");		
			break;
		}
		default:
			System.out.println("Oops!!\n" + 
								"The option you entered is not in the prescribed menu.\n");
		}
		
		System.out.println("\nThank you for using Bank of IIT\n");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
		System.out.println("`````````````````````End of transaction```````````````````\n");
		System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
		
		//To  display the current date, time and programmer name
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Sreenidhi Rajesh Dulipati\n\n");

		
		System.out.println("Do you want to go back to the Menu. Enter from the below options\n");
		do{
		System.out.println("Enter 1: If you want to go back to the previous menu\n"+
						   "Enter 2: If you want to exit ");
		userInput = sc.nextDouble();
		if(userInput == 2) {
			System.out.println("\nThank you for using Bank of IIT\n");
			System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
			System.out.println("`````````````````````End of transaction```````````````````\n");
			System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/\n");
			String timeStamp1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			System.out.println("Cur dt=" + timeStamp1 + "\nProgrammed by Sreenidhi Rajesh Dulipati\n");

			System.exit(0);
		}
		}while(userInput<1 || userInput>2); 
		
		}while(option<1 || option>5 || userInput== 1);
	}
}

