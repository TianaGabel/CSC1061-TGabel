
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

}
