import java.util.ArrayList;

public class TestSchoolRecords {

	public static void main(String[] args) {
		// TODO have it create Javac documentation
		// Creating some peeps
		Student student1 = new Student();
		Student student2 = new Student();
		Faculty faculty1 = new Faculty();
		Faculty faculty2 = new Faculty();
		Staff staff1 = new Staff();
		Staff staff2 = new Staff();

		// Adds all the people to test to an ArrayList
		ArrayList<Person> testPersons;
		testPersons.add(student1);
		testPersons.add(student2);
		testPersons.add(faculty1);
		testPersons.add(faculty2);
		testPersons.add(staff1);
		testPersons.add(staff2);

		// Then we will write each person to the person database using the writePerson()
		// method in Database
		Database database = new Database();
		for (Person person : testPersons) {
			database.writePerson();
		}

		ArrayList<Person> filePersons = readDatabase();
		for (Person person : filePersons) {
			System.out.println("" + person);
		}

	}

}
