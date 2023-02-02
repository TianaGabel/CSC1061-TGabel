
public class Student extends Person{
	String Status; //This can be assigned with freshman, sophmore, junior or senior

	public Student(String name, String address, String phoneNum, String emailAddress, String status) {
		super(name, address, phoneNum, emailAddress);
		Status = status;
	}

	@Override
	public String toString() {
		return "Student\n name: " + name + "\n address:" + address + "\n phoneNum" + phoneNum + "\n email Address:"
				+ emailAddress + "\n Status:" + Status;
	}
	
	
	
}
