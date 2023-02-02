
public class Staff extends Employee{
	String title;

	public Staff(String name, String address, String phoneNum, String emailAddress, String office, String salary,
			String dateHired, String title) {
		super(name, address, phoneNum, emailAddress, office, salary, dateHired);
		this.title = title;
	}

	@Override
	public String toString() {
		return "Staff\n name: " + name + "\n address:" + address + "\n phoneNum" + phoneNum + "\n email Address:"
				+ emailAddress + "\n office:" + office + "\n salary:" + salary + "\n dateHired:" + dateHired +"\n title:" + title;
	}
	
	
	
	
	
	
}
