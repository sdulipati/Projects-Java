import java.util.Scanner;
/**
 * A AccountHolder class simulates a bank account
 * @author 		Sreenidhi Rajesh Dulipati
 * Date 	  - Sept 15 2018
 * File name  - AccountHolderTest.java
 * Lab number - Lab1
 */

public class AccountHolder
{
	private double balance;
	private double totalDeposit,withdrawAmount;
	
	//Initial annual Interest of Bank is set to 4%.
	private static double annualInterestRate = 0.04;     
	
	// Create a Scanner object to read input.
	Scanner amount = new Scanner(System.in);
	
	/**
	 This constructor sets the balance entered by user
	 to the value passed as an argument.
	 @param balance  The Balance entered by user.
	 @exception IllegalArgumentException When
	 Balance entered by user is zero and negative.
	 */
	public AccountHolder(double balance)
	{
		//assign local variable to class member
		this.balance = balance;				 
		
		if(balance<=0) {
			System.out.println("Intial Balance cannot be zero or less than zero\n\n");
		
			throw new IllegalArgumentException("Balance must be non-negative");
			
		}
		
	}
	
	/**
	 * The deposit method makes a deposit into the account.
	 * @param depositAmount The depositAmount to add to 
	 * 	the balance field.
	 */
	public void deposit(double depositAmount){	
		balance+= depositAmount; 
	}
	/**
	 * The getDeposit method returns the balance after
	 * the deposit is added to the balance.
	 * @return The value in the balance field 
	 */
	public double getDeposit() {
		return balance;
	}
	/**
	 * The withdrawal method withdraws an amount 
	 * from the account
	 * @param withdrawEnteredByUser The amount to 
	 * subtract from the balance field
	 */
	public void withdrawal(double withdrawEnteredByUser){
		
		totalDeposit = balance;
		balance = balance - withdrawEnteredByUser;
		withdrawAmount = withdrawEnteredByUser;
		
		/* 
		 As long as necessary, instruct the customer
		  to select different amount for withdrawal 
		  if the balance amount after withdrawal is
		  less than 100. 
		 */ 
		while(balance<100)
		{ 
			System.out.println("Your balance is below 100"+
						" please select different amount for withdrawal\n");
			withdrawEnteredByUser = amount.nextDouble();
			balance = totalDeposit - withdrawEnteredByUser;	
			
		}
		// If the user withdraw amount less than 50 and
		//  account balance is less than 150
		//  as there is transaction fee of 50
		// 	so the transaction is considered  void. 
		if(withdrawEnteredByUser <= 50 && totalDeposit<= 150) {
			System.out.println("As the balance is low and there will be "+
					" transaction fee of $50. This transaction will be cancelled. ");
			balance=totalDeposit;
			withdrawAmount=0;
		}
		
		// If user balance after withdrawal is 500 and 
		//	more than 150 there is transaction fee of 
		//	50 which is deducted from balance.		
		else if(balance<500 && balance>=150) {
			System.out.println("Your account balance is less than 500"+
										" there is transaction fee of 50");
		balance = balance-50;
			getWithdrawal();	
		}
		
		// If the balance after withdrawal is greater than 500.
		else if(balance>500 || withdrawEnteredByUser == 0) {
			withdrawAmount = withdrawEnteredByUser;
			getWithdrawal();
		}
		
		// Deduction of transaction fee from 
		// withdrawal amount if the balance is less 
		// and not greater than 150.
		else{
			System.out.println("Your account balance is less than 500"+
				" there is transaction fee of 50");
			withdrawAmount = withdrawEnteredByUser-50;
			getWithdrawal();
		}
	}
	
	/**
	 * The getWithdrawal method returns the 
	 * withdrawal amount.
	 * @return The amount in the withdrawal.
	 */
	public double getWithdrawal() {
		return withdrawAmount;
	}
	
	/** 
	  The totalBalanceAmount method returns the m
	 * @return The value in the balance field
	 */
	public double totalBalanceAmount() {
		return balance;
	}
	/**
	 * The modifyMonthlyInterest method 
	 * assigns the new the rate of Interest 
	 * entered by user as annulaInterest rate.
	 * @param rateUpdate The rate of Interest
	 * given by the user.
	 */
	public static void modifyMonthlyInterest(double rateUpdate) {
		annualInterestRate = rateUpdate;
	}
	/**
	 * The monthlyInterest method calculates 
	 * the balance balance with interest rate.
	 */
	public void monthlyInterest() {
		balance += balance*(annualInterestRate/12);
	}
	/**
	 * The interestCalculation method
	 *  calculates balance with interest rate
	 *  and toString method is called. 
	 */
	public void interestCalculation() {
		
		balance += balance*(annualInterestRate/12);
		toString();
	}
	/**
	 * toString method
	 * @return A String containing balance. 
	 */
	public String toString() {
		return String.format("$%.2f", balance);
	}
}

