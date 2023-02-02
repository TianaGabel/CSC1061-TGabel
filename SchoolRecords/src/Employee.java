
public class Employee extends Person {
	String office;
	String salary;
	String dateHired;

	public Employee(String name, String address, String phoneNum, String emailAddress, String office, String salary,
			String dateHired) {
		super(name, address, phoneNum, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	@Override
	public String toString() {
		return "Employee\n name: " + name + "\n address:" + address + "\n phoneNum" + phoneNum + "\n email Address:"
				+ emailAddress + "\n office:" + office + "\n salary:" + salary + "\n dateHired:" + dateHired;
	}

}
