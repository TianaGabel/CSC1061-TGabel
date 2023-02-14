
public class Staff extends Employee{
	String title;

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
