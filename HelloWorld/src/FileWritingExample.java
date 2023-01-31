import java.io.File;

public class FileWritingExample {

	public static void main(String[] args) {
		File myFile = new File("fileToWrite.txt");
		if(!myFile.exists()) {
			if(myFile.creatNewFile()) {
				//print created
			}
		}
		//print
		PrinterWriter printW = new PrintWriter(newFileOutputStream(myFile))
		
		
	}
	
}
