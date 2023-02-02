import java.util.ArrayList;
import java.util.Arrays;

public class TestSchoolRecords {

	public static void main(String[] args) {
		// TODO have it create Javac documentation
		// Creating some peeps
		Student student1 = new Student("John Doe", "123 mulberry ln", "123-333-4444", "JohnDoe@email.com","Freshman");
		Student student2 = new Student("Dude mcDude", "90 main blvd", "44-333-4444", "Dude2x@email.com","Senior");
		Faculty faculty1 = new Faculty("Anne something", "444 the street", "970-666-6666", "A.something@school.email.com", "A100", "$78,000",
				"Feb. 12th 2018", "M-F 8:00 A.M. - 11:30 A.M.", "Dean");
		Faculty faculty2 = new Faculty("Lucy Last-Name", "780 Garibaldi drive", "110-321-89", "L.LastName@school.email.com", "B23", "$52,000",
				"May 30th 2021", "M-T 2:00 P.M. - 5:00 P.M.", "Physics Department");
		Staff staff1 = new Staff("Bob Builder", "333 livingston", "333-66-777", "B.Builder@school.email.com", "H12", "$52,000",
				"December 1st 2022", "Admissions Advisor");
		Staff staff2 = new Staff("Peter Parker", "ll2 drive", "400-66-47", "P.Parker@school.email.com", "H16", "$3",
				"March 20th 2001", "Employee");

		// Adds all the people to test to an ArrayList
		ArrayList<Person> testPersons =  new ArrayList<Person>();
		Person tmpP[] = {student1, student2, faculty1, faculty2, staff1, staff2};
		testPersons.addAll(Arrays.asList(tmpP));

		// Then we will write each person to the person database using the writePerson()
		// method in Database
		//Database database = new Database();
		for (Person person : testPersons) {
			System.out.println(person);
			//database.writePerson();
		}

		//ArrayList<Person> filePersons = readDatabase();
		//for (Person person : filePersons) {
		//	System.out.println("" + person);
		//}

	}

}
