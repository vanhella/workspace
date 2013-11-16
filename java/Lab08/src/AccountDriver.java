import java.util.Scanner;


public class AccountDriver {

	/*
	 * Prompt the user for the information needed to create
	 * a new account, the create the SavingsAccount and
	 * return it.
	 */
	public static SavingsAccount enterAccount(Scanner stdin){
		
		System.out.print("Name on account: ");
		String name = stdin.nextLine();
		System.out.print("Initial balance: ");
		double balance = stdin.nextDouble();
		stdin.nextLine();  //eat end of line char
		
		System.out.println("Do you want Savings/Thrifty: ");
		//String account = stdin.nextLine();
		
		if(stdin.nextLine().startsWith("t"))
			return new ThriftySaver(name, balance);
		else
			return new SavingsAccount(name,balance);
	}

	/*
	 * Cycle through all accounts at the end of the
	 * month, updating them with interest.
	 */
	public static void endMonth(SavingsAccount bank[]){
		for(SavingsAccount s : bank)
			s.update();
	}

	/*
	 * Print all accounts in the bank
	 */
	public static void displayAccounts(SavingsAccount bank[]){
		for(int i = 0; i < bank.length; ++i)
			System.out.println("" + (i+1) + ") " + bank[i]);
	}

	/*
	 * Print all accounts, then let the user select one.
	 * Returns the selected account
	 */
	public static SavingsAccount selectAccount(SavingsAccount bank[], 
			                                     Scanner stdin){
		displayAccounts(bank);
		System.out.print("Which account? ");
		int i = stdin.nextInt();
		return bank[i-1];
	}

	/*
	 * loops to create multiple accounts
	 */
	public static void createAccounts(SavingsAccount bank[],
			                            Scanner stdin){ 
		for(int i = 0; i < bank.length; ++i){
			System.out.println("Enter account #" + (i+1));
			bank[i] = enterAccount(stdin);
		}
	}
	
	public static void main(String[] args) {
		SavingsAccount bank[] = new SavingsAccount[5];
		Scanner stdin = new Scanner(System.in);
		createAccounts(bank,stdin);
		
		System.out.println("Initial accounts:");
		displayAccounts(bank);
		
		int choice;
		SavingsAccount acc;
		do{
			System.out.print(
					"1) make a deposit\n" +
					"2) make a withsrawal\n" +
					"3) end the month\n" +
					"0) quit \n -> ");
			choice = stdin.nextInt();
			switch (choice) {
			case 1:
				acc = selectAccount(bank,stdin);
				System.out.print("Amount to deposit? ");
				acc.deposit(stdin.nextDouble());
				break;
			case 2:
				acc = selectAccount(bank,stdin);
				System.out.print("Amount to withdraw? ");
				if(!acc.withdraw(stdin.nextDouble()))
					System.out.println("ERROR! withdrawal not allowed!");
				break;
			case 3:
				endMonth(bank);
				System.out.println("New balances: ");
				displayAccounts(bank);
				break;
			case 0:
				break;
			default:
				System.out.println("ERROR! not a valid selection!");
			}
		}while(choice != 0);
	}

}
