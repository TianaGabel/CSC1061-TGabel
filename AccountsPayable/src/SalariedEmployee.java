
public class SalariedEmployee extends Employee {
	private double weeklySalary;

	// This needs!! to have the fields from the super class
	public SalariedEmployee(String firstName, String lastName, int socialSecurityNum, double weeklySalary) {
		super(firstName, lastName, socialSecurityNum);
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		return "Employee:\n firstName=" + firstName + "\n lastName=" + lastName + "\n socialSecurityNum="
				+ socialSecurityNum + "\n Payment amount=" + weeklySalary + " paid weekly";
	}

}
