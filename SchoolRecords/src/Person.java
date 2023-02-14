
public class Person {
	String name;
	String address;
	String phoneNum;
	String emailAddress;
	
	public Person(String name, String address, String phoneNum, String emailAddress) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Person," + name + "," + address + "," + phoneNum + ","
				+ emailAddress;
	}
	
	
}
