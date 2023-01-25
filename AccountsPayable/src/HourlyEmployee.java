
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

	// TODO how do you call a method from within a class
	//////
	@Override
	public String toString() {
		return "Employee:\n firstName=" + firstName + "\n lastName=" + lastName + "\n socialSecurityNum="
				+ socialSecurityNum + "\n Payment amount=" + (hourlyWage * hours) + " for hourly rate";
	}


}
