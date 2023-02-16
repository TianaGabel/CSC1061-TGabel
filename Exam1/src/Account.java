import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0; // This is stored as a percentage
	private LocalDate dateCreated;
	private String customerName;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	// no-arg constructor
	public Account() {
		dateCreated = java.time.LocalDate.now();
	}

	// id and initial balance specified constructor
	public Account(int id, double balance) {
		dateCreated = java.time.LocalDate.now();
		this.id = id;
		this.balance = balance;
	}

	// Name, id and initial balance constructor
	public Account(String name, int id, double balance) {
		dateCreated = java.time.LocalDate.now();
		this.customerName = name;
		this.id = id;
		this.balance = balance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Note the annual interest Rate is stored as a percentage
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public LocalDate getDateCreated() {
		return this.dateCreated;
	}

	// Note returns rate as a percentage not a decimal
	public Double getMonthlyInterestRate() {
		return (annualInterestRate / 12.0);
	}

	public Double getMonthlyInterest() {
		return (balance * (getMonthlyInterestRate() / 100.0));
	}

	public void withdraw(double amount) {
		// subtracts that amount from account balance
		balance -= amount;
		// Creates a transaction object to document the transaction
		LocalDate tmpDate = java.time.LocalDate.now();
		Transaction tmpTrasaction = new Transaction(tmpDate, 'W', getBalance(), amount);
		transactions.add(tmpTrasaction);
	}

	public void deposit(double amount) {
		// adds that amount to account balance
		balance += amount;
		// Creates a transaction object to document the transaction
		LocalDate tmpDate = java.time.LocalDate.now();
		Transaction tmpTrasaction = new Transaction(tmpDate, 'D', getBalance(), amount);
		transactions.add(tmpTrasaction);
	}

	@Override
	// TODO format decimal output for balance
	public String toString() {
		return "Account holder:" + customerName + "\nId: " + getId() + "\nThis account was created: " + getDateCreated()
				+ "\nBalance: $" + getBalance() + "\nMonthly Interest: %" + getMonthlyInterest();
	}

	public void printAccountSummary() {
		// Print basic account details
		System.out.println(this.toString());
		System.out.println("   date    -- Type -    amount  -----   balance ");
		for (Transaction t:transactions) {
			System.out.println("" + t);
		}

	}

}
