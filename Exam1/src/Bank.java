import java.util.ArrayList;

public class Bank {

	public static void main(String[] args) {
		//Test for part one
		System.out.println("Test of part one\n");
		//sets id and initial balance
		Account account = new Account(1122,20000);
		account.setAnnualInterestRate(4.5);
		//We withdraw 2,500$
		account.withdraw(2500);
		//We deposit 3,000$
		account.deposit(3000);
		
		System.out.println("" + account);
		
		//Test of Checking and Saving
		System.out.println("\nTesting of Checking and Savings");
		CheckingAccount cAcc1 = new CheckingAccount();
		CheckingAccount cAcc2 = new CheckingAccount(3344,200,30);
		CheckingAccount cAcc3 = new CheckingAccount(500);
		SavingsAccount sAcc1 = new SavingsAccount();
		SavingsAccount sAcc2 = new SavingsAccount(5590,17800);
		
		ArrayList<Account> accs = new ArrayList<>();
		accs.add(cAcc1);
		accs.add(cAcc2);
		accs.add(cAcc3);
		accs.add(sAcc1);
		accs.add(sAcc2);
		
		for (Account currAccount: accs) {
			System.out.println("\n" + currAccount);
		}
		
		//Testing of Part 2
		System.out.println("\nTesting of Part 2");
		CheckingAccount george = new CheckingAccount("George",1122,1000);
		george.setAnnualInterestRate(1.5);
		george.deposit(30.0);
		george.deposit(40.0);
		george.deposit(50.0);
		george.withdraw(5.0);
		george.withdraw(4.0);
		george.withdraw(2.0);
		
		george.printAccountSummary();
		
		

	}

}
