package edu.frcc.csc1061j.SentimentAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class SentimentAnalyzer {
	private static Map<String, Integer> sentimentsToInts = null;
	static int totalSentiment = 0;
	static int numWords = 0;
	static double avgSentiment = 0;
	public static void main(String[] args) {	
		try {
			loadSentiments();
		} catch (FileNotFoundException e) {
			System.out.println("Could not load sentiments");
			e.printStackTrace();
		}
		analyzeSentiment(intakeReview());
		
		System.out.println("There were " + numWords + " words");
		System.out.println("Total sentiment is" + totalSentiment);
		System.out.println("The average sentiment of the text was:" + avgSentiment);
		
	}
	
	//This takes in input from the user
	public static String[] intakeReview() {
		Scanner scan = new Scanner(System.in);
		String inString = "";
		
		//loop will stop if it reachs end of File or the word "END"
		while(scan.hasNextLine()) {
			//reads in the line
			String currLine = scan.nextLine();
			if (currLine.contains("END")) {
				//if the word end is found, we only take the part before END
				currLine = currLine.substring(0, currLine.indexOf("END"));
				inString += " " + currLine.trim();
				break;
			}
			//leading and trailing white space is trimmed, and a space is added between lines
			inString += " " + currLine.trim();
		}
		String[] words = inString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		return words;
	}
	//This loads list of sentiments
	public static void loadSentiments() throws FileNotFoundException {
		sentimentsToInts = new MyHashmap<String,Integer>();
		Scanner scan = null;
		//opens file of sentiments
		File sFile = new File("sentiments.txt");
		scan = new Scanner(sFile);
		while (scan.hasNextLine()) {
			// Reads line
			String currLine = scan.nextLine();
			// Puts info into the hashmap
			String[] info = currLine.split(",");
			sentimentsToInts.put(info[0], Integer.parseInt(info[1]));
		}
	}
	//This anaylyzes the Sentiments
	public static void analyzeSentiment(String[] words) {
		//an empty string is added to the end of the array
		//So that the loop functions as expected
		words = Arrays.copyOf(words, words.length+1);
		words[words.length - 1] = "";
		//this will anaylyze Sentiments
		for(int i=0; i < words.length; i++) {
			//looks for 2 word pair first
			Integer value = sentimentsToInts.get(words[i]+words[i+1]);
			//if it is found then we add the value, and skip the second word
			if (value != null) {
				i++;
			} else {
				//otherwise we look for 
				value = sentimentsToInts.get(words[i]);
				if (value == null) {
					continue;
				}
			}
			totalSentiment += value;
		}
		
	}

}
