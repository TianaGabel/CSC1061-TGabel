
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
		//TODO tbh idk if this is actually worth the work.
		String s = String.format("Faculty\n Name: " "\n address:" + address + "\n phoneNum" + phoneNum + "\n email Address:"
				+ emailAddress + "\n office:" + office + "\n salary:" + salary + "\n dateHired:" + dateHired + "\n officeHours:" + officeHours + "\n rank:" + rank;

		
		return "Faculty\n name: " + name + "\n address:" + address + "\n phoneNum" + phoneNum + "\n email Address:"
				+ emailAddress + "\n office:" + office + "\n salary:" + salary + "\n dateHired:" + dateHired + "\n officeHours:" + officeHours + "\n rank:" + rank;
	}
	

}
