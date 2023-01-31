
public class HourlyEmployee extends Employee{
	private double hourlyWage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, int socialSecurityNum, double hourlyWage,
			double hours) {
		super(firstName, lastName, socialSecurityNum);
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
	@Override
	public double getPaymentAmount() {
		return (hourlyWage * hours);
	}

	@Override
	public String toString() {
		return "Employee:\n firstName=" + this.getFirstName() + "\n lastName=" + this.getLastName() + "\n socialSecurityNum="
				+ this.getSocialSecurityNum() + "\n Payment amount=" + this.getPaymentAmount() + " for hourly rate";
	}


}
