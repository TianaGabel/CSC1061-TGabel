package edu.frcc.csc1061j.PlaylstManager;

import java.util.Scanner;

public class Playlist {

	public static void main(String[] args) {
		//Creates our playlist method
		MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<>();
		Scanner scan = new Scanner(System.in);
		printMenu();
		int userInput = scan.nextInt(); //TODO validate this
		while (userInput != 0) {
			switch (userInput) {
			case 1: // play
				System.out.println("Playing...");
				for(Song song: playlist) {
					System.out.println(song);
				}
				break;
			case 2: // playlist details
				System.out.println("Playlist has " + playlist.count() +  );
			case 3: // add song
				break;	
			case 4: // remove song
				break;
			case 5: // reverse playlist
				break;	
			case 6: // shuffle playlist
				break;
			case 7: // save playlist
				break;	
			case 8: // load playlist
				break;
			}
				
			
			printMenu();
			userInput = scan.nextInt();
		}
		System.out.println("Thanks for using the playlist");

	}

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
	
	//We need to be able to save songs to a file, and get them back
	//It should be comma seperated
}
