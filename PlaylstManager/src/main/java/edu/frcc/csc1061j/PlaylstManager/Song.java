package edu.frcc.csc1061j.PlaylstManager;

public class Song {
	private String artist;
	private String title;
	
	public Song(String artist,String title) {
		this.artist = artist;
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Song) {
			Song s = (Song) o;
			if((this.artist.equals(s.getArtist())) &&(this.title.equals(s.getTitle()))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "[" + title + " by " + artist + "]";
	}
	
	//This will print out a formatted print for saving songs
	public String fToString() {
		return title + "," + artist;
	}
	
	
	
}
