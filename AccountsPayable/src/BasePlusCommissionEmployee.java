
public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double basePay;

	public BasePlusCommissionEmployee(String firstName, String lastName, int socialSecurityNum, double grossSales,
			double commissionRate, double basePay) {
		super(firstName, lastName, socialSecurityNum, grossSales, commissionRate);
		this.basePay = basePay;
	}

	public double getBasePay() {
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}
	
	@Override
	public double getPaymentAmount() {
		return (basePay + (super.getGrossSales() * super.getCommissionRate()));
	}

	@Override
	public String toString() {
		return "Employee:\n firstName=" + this.getFirstName() + "\n lastName=" + this.getFirstName() + "\n socialSecurityNum="
				+ this.getSocialSecurityNum() + "\n Payment amount=" + this.getPaymentAmount() + " paid on base and commision";
	}

}
