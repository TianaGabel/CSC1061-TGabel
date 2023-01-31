import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountsPayable {
	static ArrayList<Employee> payableEmployees = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		// For testing, this is also why the program throws a file not found exception
		//Scanner scan = new Scanner(new File("sampleEmployee"));
		while (payableEmployees.size() < 6) {
			System.out.println("Create 6 employees: \n  [1]Salaried Employee\n  [2]Commission Employee "
					+ "\n  [3]Base + Commission Employee\n  [4]Hourly Employee");
			System.out.println("Enter employee you wish to create:  \r");
			while (!(scan.hasNextInt())) {
				System.out.println("Enter a number between 1 and 4");
				scan.next();
			}
			int userNum = scan.nextInt();
			if ((userNum > 4) || (userNum < 1)) {
				System.out.println("Enter a number between 1 and 4");
				continue;
			}
			// throw away empty character, to allow for inputting names with spaces
			scan.nextLine();
			System.out.println("Enter First Name:");
			String firstName = scan.nextLine();
			System.out.println("Enter Last Name:");
			String lastName = scan.nextLine();
			System.out.println("Enter Social Security Num(enter as a number no dashes):");
			int ssn = scan.nextInt();
			if (userNum == 1) {
				// call method to create Salaried Employee
				System.out.println("Enter weekly Salary in Dollars:");
				double salary = scan.nextDouble();
				SalariedEmployee salariedEmployee = new SalariedEmployee(firstName, lastName, ssn, salary);
				payableEmployees.add(salariedEmployee);
			} else if (userNum == 2) {
				// creates Commission Employee
				System.out.println("Enter commission rate in Dollars:");
				double commissionRate = scan.nextDouble();
				System.out.println("Enter gross sales:");
				double grossSales = scan.nextDouble();
				CommissionEmployee commissionEmployee = new CommissionEmployee(firstName, lastName, ssn, grossSales,
						commissionRate);
				payableEmployees.add(commissionEmployee);
			} else if (userNum == 3) {
				// creates Base + Commmision Employee
				System.out.println("Enter Base pay:");
				double basePay = scan.nextDouble();
				System.out.println("Enter commission rate in Dollars:");
				double commissionRate = scan.nextDouble();
				System.out.println("Enter gross sales:");
				double grossSales = scan.nextDouble();

				BasePlusCommissionEmployee cbEmployee = new BasePlusCommissionEmployee(firstName, lastName, ssn,
						grossSales, commissionRate, basePay);
				payableEmployees.add(cbEmployee);

			} else if (userNum == 4) {
				// creates Hourly Employee
				System.out.println("Enter hourly rate in Dollars:");
				double hourlyRate = scan.nextDouble();
				System.out.println("Enter number of Hours worked:");
				double hours = scan.nextDouble();
				HourlyEmployee hEmployee = new HourlyEmployee(firstName, lastName, ssn, hourlyRate, hours);
				payableEmployees.add(hEmployee);

			}
			System.out.println("Employee created!");
		}

		// Prints out all employees
		System.out.println("\nName                       Payment Amount");
		for (Employee employee : payableEmployees) {
			printEmployeeWOString(employee);
		}

		// Checks if employee is a Base plus Commission Employee
		for (Employee employee : payableEmployees) {
			if (employee instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee currBPC = (BasePlusCommissionEmployee) employee;
				// increases base pay by 10%
				currBPC.setBasePay(currBPC.getBasePay() * 1.10);
				System.out.println("\n Base + Commission Employee Salary increased by 10%");
			}
		}

		// Prints out all employees
		System.out.println("\nName                       Payment Amount");
		for (Employee employee : payableEmployees) {
			printEmployeeWOString(employee);
		}

		scan.close();
	}

	// prints out using the toString method, prints SSN
	public static void printEmployeeString(Employee employee) {
		System.out.println(employee.toString());
	}

	// prints out Name and payment amount, does not print SSN
	public static void printEmployeeWOString(Employee employee) {
		System.out.printf(" %-10s %-10s ", employee.getFirstName(), employee.getLastName());
		System.out.printf(" -- $%8.2f\n", employee.getPaymentAmount());
	}

}
