/**
 * 
 * @author Tia
 *
 */
public class Faculty extends Employee {
	String officeHours;
	String rank; // junior or senior
	/**
	 * @param name
	 * @param address
	 * @param phoneNum
	 * @param emailAddress
	 * @param office
	 * @param salary
	 * @param dateHired
	 * @param officeHours
	 * @param rank Junior or Senior
	 */
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
