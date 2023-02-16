
public class SavingsAccount extends Account{
	//Cannot be OverDrawn
	
	public SavingsAccount() {}
	
	public SavingsAccount(int id, double balance) {
		super(id,balance);
	}

	@Override
	public void withdraw(double amount) {
		//subtracts that amount from account balance if there is sufficient money
		double tmpBalance = getBalance() - amount; 
		if (tmpBalance < 0) {
			System.out.println("Insufficient funds");
		} else {
			setBalance(tmpBalance);
		}
		
	}
	
	@Override
	public String toString() {
		return "Savings Account\nAccount holder:" + getCustomerName() + "\nId: " + getId() + "\nThis account was created: " + getDateCreated() + "\nBalance: $" + getBalance() +
				"\nMonthly Interest: " + getMonthlyInterest();
	}
}
