
public class Faculty extends Employee {
	String officeHours;
	String rank; // junior or senior

	public Faculty(String name, String address, String phoneNum, String emailAddress, String office, String salary,
			String dateHired, String officeHours, String rank) {
		super(name, address, phoneNum, emailAddress, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Faculty," + name + "," + address + "," + phoneNum + ","
				+ emailAddress + "," + office + "," + salary + "," + dateHired + "," + officeHours + "," + rank;
	}
	

}
