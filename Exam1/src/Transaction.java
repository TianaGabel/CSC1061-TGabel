import java.time.LocalDate;

public class Transaction {
	private LocalDate date;
	private char type; //This can be 'W' or 'D'
	private double amount;
	private double balance; //Specifically the balance after this transaction
	
	public Transaction(LocalDate date, char type, double balance, double amount) {
		this.date = date; 
		this.type = type;
		this.balance = balance;
		this.amount = amount;
	}

	@Override
	public String toString() {
		//changes based on wether it was a withdraw or deposit
		String tmpString = "";
		if (type == 'W') {
			tmpString = "" + date + " -- Withdraw for - " + amount + " -----   " + balance + "";
		} else if (type == 'D') {
			tmpString =  "" + date + " -- Deposit  for + " + amount + " -----  " + balance + "";
		}
		return tmpString;
	}
}
