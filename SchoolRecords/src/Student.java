
public class Student extends Person{
	String status; //This can be assigned with freshman, sophmore, junior or senior

	public Student(String name, String address, String phoneNum, String emailAddress, String status) {
		super(name, address, phoneNum, emailAddress);
		status = status;
	}

	@Override
	public String toString() {
		return "Student," + name + "," + address + "," + phoneNum + ","
				+ emailAddress + "," + status;
	}
	
	
	
}
