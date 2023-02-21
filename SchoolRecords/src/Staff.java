/**
 * 
 * @author Tia
 *Employees that are not faculty
 */
public class Staff extends Employee{
	String title;
	/**
	 * @param name
	 * @param address
	 * @param phoneNum
	 * @param emailAddress
	 * @param office
	 * @param salary
	 * @param dateHired
	 * @param title
	 */
	public Staff(String name, String address, String phoneNum, String emailAddress, String office, String salary,
			String dateHired, String title) {
		super(name, address, phoneNum, emailAddress, office, salary, dateHired);
		this.title = title;
	}

	@Override
	public String toString() {
		return "Staff," + name + "," + address + "," + phoneNum + ","
				+ emailAddress + "," + office + "," + salary + "," + dateHired +"," + title;
	}
	
	
	
	
	
	
}
