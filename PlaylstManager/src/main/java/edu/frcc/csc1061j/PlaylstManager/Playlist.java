package edu.frcc.csc1061j.PlaylstManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Playlist {

	public static void main(String[] args) {
		// Creates our playlist method
		MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<>();
		Scanner scan = new Scanner(System.in);
		// This will be a local variable
		String name;
		String tmpTitle;
		String tmpArtist;
		int userInput = 1;
		printMenu();
		while (userInput != 0) {
			System.out.println("Enter a command");
			while (!(scan.hasNextInt())) {
				System.out.println("Enter a number between 0 and 8");
				scan.nextLine();
			}
			userInput = Integer.parseInt(scan.nextLine()); 
			if ((userInput > 8) || (userInput < 0)) {
				System.out.println("Enter a number between 0 and 8");
				continue;
			}
			switch (userInput) {
			case 1: // play
				System.out.println("Playing...");
				for (Song song : playlist) {
					System.out.println(song);
				}
				break;
			case 2: // playlist details
				System.out.println("Playlist has " + playlist.size() + " songs");
				break;
			case 3: // add song
				System.out.println(">Add song<");
				System.out.println("Enter song title: ");
				tmpTitle = scan.nextLine();
				System.out.print("Enter song artist: ");
				tmpArtist = scan.nextLine();
				Song newSong = new Song(tmpArtist, tmpTitle);
				playlist.add(newSong);
				System.out.println("\nSong added!");
				break;
			case 4: // remove song
				System.out.println(">Remove Song<");
				System.out.print("Enter song title: ");
				tmpTitle = scan.nextLine();
				System.out.print("Enter song artist: ");
				tmpArtist = scan.nextLine();
				Song tmpSong = new Song(tmpArtist, tmpTitle);
				if (playlist.remove(tmpSong)) {
					System.out.println("Song removed!");
				} else {
					System.out.println("Song not on playlist");
				}
				break;
			case 5: // reverse playlist
				MyDoubleLinkedList<Song> tmp = new MyDoubleLinkedList<>();
				for (int i = playlist.size() - 1; i >= 0; i--) {
					tmp.add(playlist.remove(i));
				}
				playlist = tmp;
				System.out.println("Playlist Reveresed");
				break;
			case 6: // shuffle playlist
				Random rand = new Random();
				for (int i = 0; i < playlist.size(); i++) {
					int currNum = rand.nextInt(playlist.size());
					Song song = playlist.remove(currNum);
					playlist.add(i, song);
				}
				System.out.println("Playlist Shuffled");
				break;
			case 7: // save playlist
				System.out.println(">Save Playlist<\nEnter Playlist Name");
				name = scan.nextLine();
				try {
					save(name, playlist);
				} catch (Exception e) {
					System.out.println("Could not save Playlist...");
					e.printStackTrace();
				}
				break;
			case 8: // load playlist
				System.out.println(">Load Playlist<\nThis will Override the current Playlist");
				System.out.print("Enter Playlist name: ");
				name = scan.nextLine();
				// calls the load method which will override the current playlist
				try {
					playlist = load(name);
				} catch (FileNotFoundException e) {
					// This means that a playlist with that name was not found
					System.out.println("No playlist was found with that name");
				}
				break;
			}
		}
		System.out.println("Thanks for using the playlist");

	}

	// This prints out a menu with the current methods
	public static void printMenu() {
		System.out.println("Playlist Controls");
		System.out.println("[1] - Play");
		System.out.println("[2] - Playlist details\n");
		System.out.println("[3] - Add Song");
		System.out.println("[4] - Remove Song\n");
		System.out.println("[5] - Reverse Playlist");
		System.out.println("[6] - Shuffle\n");
		System.out.println("[7] - Save Playlist");
		System.out.println("[8] - Load Playlist\n");
		System.out.println("[0] - Quit");
		System.out.println("Enter number");
	}

	// takes in a playlist name for saving
	public static void save(String PLName, List<Song> list) throws IOException, Exception {
		PLName = genFileName(PLName);
		File myFile = new File(PLName);
		if (!myFile.exists()) {
			if (myFile.createNewFile()) {
			} else {
				throw new Exception(); // TODO see if there is one that is more appropriate
			}
		}
		// Creates filewriter
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(PLName)));
		// Header if anyone displays information as an excel file
		pw.println("Song,Artist");
		for (Song song : list) {
			pw.println(song.fToString());
		}
		pw.close();
	}

	// takes in a playlist name to load
	public static MyDoubleLinkedList<Song> load(String LName) throws FileNotFoundException {
		Scanner scan = null;
		MyDoubleLinkedList<Song> newList = new MyDoubleLinkedList<>();
		LName = genFileName(LName); // Generates file name
		File lFile = new File(LName);
		scan = new Scanner(lFile);
		// throws away file header
		String tmp = scan.nextLine();
		System.out.println(tmp);
		while (scan.hasNextLine()) {
			// Reads line
			String currLine = scan.nextLine();
			// Creates song from given daa
			String[] info = currLine.split(",");
			Song newSong = new Song(info[1], info[0]);
			// Adds song to the list of songs
			newList.add(newSong);
		}
		return newList;
	}

	// Generates an appropriate file name, Method so this can be updated
	private static String genFileName(String name) {
		// Generates an uppercase csv file with no spaces
		name = name.replaceAll(" ", "_");
		name = name.toUpperCase();
		name += ".csv";
		return name;
	}
}
