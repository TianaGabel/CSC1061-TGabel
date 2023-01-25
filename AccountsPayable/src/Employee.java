
public class Employee {
	protected String firstName;
	protected String lastName;
	protected int socialSecurityNum;

	public Employee() {
	}

	public Employee(String firstName, String lastName, int socialSecurityNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNum = socialSecurityNum;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSocialSecurityNum() {
		return socialSecurityNum;
	}

	public void setSocialSecurityNum(int socialSecurityNum) {
		this.socialSecurityNum = socialSecurityNum;
	}

	//default class returns -1.0
	public double getPaymentAmount() {
		return -1.0;
	}

	@Override
	public String toString() {
		return "Employee:\n firstName=" + firstName + "\n lastName=" + lastName + "\n socialSecurityNum="
				+ socialSecurityNum + "";
	}
	
	
}
