
public class CheckingAccount extends Account {
	// Has an // overdraft limit
	private double overDraftLimit = 200; // Should be in postive dollars

	public CheckingAccount() {
	}

	public CheckingAccount(double limit) {
		this.overDraftLimit = limit;
	}

	public CheckingAccount(int id, int balance, double limit) {
		super(id, balance);
		this.overDraftLimit = limit;
	}

	public CheckingAccount(String name, int id, double balance) {
		super(name, id, balance);
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public void withdraw(double amount) {
		double tmpBalance = getBalance() - amount;
		if ((tmpBalance) < -(overDraftLimit)) {
			// if the user tries to withdraw more than the allowed overdraft amount it is
			// not allowed
			System.out.println("Insufficent Balance");
		} else if ((tmpBalance) < 0) {
			// warns user that the account balance is below zero
			System.out.println("Overdrafting account");
		} else {
			super.withdraw(amount);
		}
	}

	@Override
	public String toString() {
		return "Checking Account\nAccount holder:" + getCustomerName() + "\nId: " + getId() + "\nThis account was created: " + getDateCreated() + "\nBalance: $"
				+ getBalance() + "\nMonthly Interest: " + getMonthlyInterest();
	}
}
