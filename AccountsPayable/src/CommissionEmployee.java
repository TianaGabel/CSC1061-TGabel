
public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(String firstName, String lastName, int socialSecurityNum, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNum);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	@Override
	public double getPaymentAmount() {
		return (grossSales * commissionRate);
	}

	@Override
	public String toString() {
		return "Employee:\n firstName=" + this.getFirstName() + "\n lastName=" + this.getLastName() + "\n socialSecurityNum="
				+ this.getSocialSecurityNum() + "\n Payment amount=" + this.getPaymentAmount() + " paid on commision";
	}

}
