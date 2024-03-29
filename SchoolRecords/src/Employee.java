/**
 * @author Tia
 *
 */
public class Employee extends Person {
	String office;
	String salary;
	String dateHired;
	/**
	 * @param name
	 * @param address
	 * @param phoneNum
	 * @param emailAddress
	 * @param office
	 * @param salary 
	 * @param dateHired
	 */
	public Employee(String name, String address, String phoneNum, String emailAddress, String office, String salary,
			String dateHired) {
		super(name, address, phoneNum, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	@Override
	public String toString() {
		return "Employee," + name + "," + address + "," + phoneNum + ","
				+ emailAddress + "," + office + "," + salary + "," + dateHired;
	}

}
