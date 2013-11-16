/*
 * A SavingsAccount keeps the account holder's name
 * and current balance.  It allows unlimited deposits 
 * and withdrawals, although you cannot withdraw more 
 * money than is in the account.
 * Every month the account earns 1.5% interest.
 */
public class SavingsAccount {

	protected double balance;
	private String name;
	
	public SavingsAccount(String name, double initial){
		this.name = name;
		balance = initial;
	}

	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	/*
	 * Add the deposited amount to the balance
	 */
	public void deposit(double amount){
		balance += amount;
	}
	/*
	 * If there is sufficient money to make the withdrawal,
	 * do so and return true. if not, return false
	 */
	public boolean withdraw(double amount){
		if(balance > amount){
			balance -= amount;
			return true;
		}
		return false;	
	}
	/*
	 * Used to earn interest at the end of the month
	 * The fractions of a penny are dropped
	 */
	public void update() {
		balance *= 1.015;
		int bal = (int)(balance * 100);
		balance = bal/100.0;  // floor to a penny
	}
	
	public String toString(){
		return "( " + name + ", $" + balance + " )";
	}
}
