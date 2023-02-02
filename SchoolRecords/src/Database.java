import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
public class Database {
	final String PDFile= "PersonDatabase";
	File myFile;
	
	public Database() throws IOException {
		//create database file if it does not exist already
		myFile =  new File(PDFile);
		if(!myFile.exists()) {
			if(myFile.createNewFile()) {
				System.out.println("Database created");
			}
		}
	}

	public void writePerson(Person p){
		// TODO you should totally make sure this make sense
		BufferedWriter pr = new BufferedWriter(Writer(myFile));
	}
	//Writes the class of the object
	//all the information for the object to PersonDatabase
	
	public ArrayList<Person> readDatabase(){
		//This will read all person from the file and return arraylist of persons
		return null;
	}
	
}
