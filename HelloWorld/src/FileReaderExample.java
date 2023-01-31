import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class FileReaderExample {

	
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
		File daFile = null;
		Scanner input = null;
		
		
		//File reading Exception
		
		try {
			daFile = new File("SampleInput");
			input = new Scanner(daFile);
			System.out.println(input.nextLine());
			//This is a file in a different location, you can look up the path from file explorer
			File otherFile =  new File("src\\SampleInput.txt");
			Scanner oScan = new Scanner(otherFile);
			System.out.println(oScan.nextLine());
		} catch (Exception e) {
			System.out.println("ex 1: Something went wrong");
			e.printStackTrace();
			System.exit(-1);
		}
		//Reading from file
		while(input.hasNextLine()){
			//and reading thing
		}
		
		//File ArrayException
		try {
			int[] myNums = {1,2,3};
			//System.out.println(myNums[10]);;
		} catch (Exception e) {
			System.out.println("ex 2: Something went wrong");
			e.printStackTrace();
			System.exit(-1);
		} finally {
			System.out.println("Done!");
		}
		
		
		
	}
}
