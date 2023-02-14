import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
public class Database {
	final String PDFile= "PersonDatabase";
	File myFile;
	PrintWriter pw;
	Scanner scan;
	
	public Database() throws IOException {
		// Creates database file if it does not exist already
		myFile =  new File(PDFile);
		if(!myFile.exists()) {
			if(myFile.createNewFile()) {
				System.out.println("Database created");
			}
		}
		// Creates filewriter 
		pw = new PrintWriter(myFile.getName());
		// Header if anyone displays information as an excel file
		pw.println("Type,Name,Address,Phone Number,Email");
	}

	public void writePerson(Person person){
		// Writes a single person on a single line
		pw.println("" + person);
	}
	
	public ArrayList<Person> readDatabase(){
		//This will read all person from the file and return arraylist of persons
		ArrayList<Person> persons = new ArrayList<>();
		try {
			scan = new Scanner(myFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		//throws away file header
		String tmp = scan.nextLine();
		while(scan.hasNextLine()) {
			// Reads line
			String currLine = scan.nextLine();
			// Creates person from data given
			Person tmpPerson = readPerson(currLine);
			// Adds person to arrayList
			persons.add(tmpPerson);
		}
		return persons;
	}
	
	private Person readPerson(String currLine) {
		String[] info = currLine.split(",");
		//Figure out what type it is then input all the data accordingly
		Person rPerson = null;
		if (info[0].equals("Employee")) {
			Employee tmpE = new Employee(info[1], info[2], info[3], info[4], info[5], info[6], info[7]);
			rPerson = tmpE;
		}
		if (info[0].equals("Faculty")) {
			Faculty tmpF = new Faculty(info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9]);
			rPerson = tmpF;
		}
		if (info[0].equals("Staff")) {
			Staff tmpS = new Staff(info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]);
			rPerson = tmpS;
		}
		if (info[0].equals("Student")) {
			Student tmpS = new Student(info[1], info[2], info[3], info[4], info[5]);
			rPerson = tmpS;
		}
		
		return rPerson;
	}
	
}
