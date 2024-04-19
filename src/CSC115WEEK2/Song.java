package CSC115WEEK2;

public class Song {
	private String  title;
	private String  artist;
	private int duration; // in seconds

	public Song() {
		title = "";
		artist = "";
		duration = 0;
	}
	
	public Song (String t, String a) {
		title = t;
		artist = a;
		duration = 0;
	}
	
	public Song (String title, String artist, int duration) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}
	
	/*
	* Purpose: get the title of the song
	* Parameters: nothing
	* Returns: String - title
	*/
	public String getTitle() {
		return title;
	}
	
	/*
	* Purpose: set the title of the song
	* Parameters: String - title
	* Returns: void - nothing
	*/
	public void setTitle(String title) {
		title = title;
	}
	
	/*
	* Purpose: get the artist of the song
	* Parameters: none
	* Returns: String - artist
	*/
	public String getArtist() {
		return artist;
	}
	
	// No setArtist -- for this implementation
	// the artist cannot be changed
	
	/*
	* Purpose: get the duration of the song (in seconds)
	* Parameters: none
	* Returns: int - duration
	*/
	public int getDuration() {
		return duration;
	}
	
	/*
	* Purpose: set the song's duration (in seconds)
	* Parameters: int - duration
	* Returns: void - nothing
	*/
	public void setDuration(int duration) {
		duration = duration;
	}
	
	/*
	* Purpose: generates a string representation of a song
	* Parameters: none
	* Returns: String - representation of the song
	*/
	public String toString() {
		return title + " - " + artist + " (" + duration + ")";
	}
	
	/*
	* Purpose: adds 'amount' to the duration for this song
	* Parameters: int - amount of time in seconds to add
	* Returns: void - nothing
	*/
	public void addTime(int amount) {
		
	}

	/*
	* Purpose: determines whether this Song is the same as other
	* Parameters: Song - the song to compare to
	* Returns: boolean - true if they are equal, false otherwise
	*/
	public boolean equals(Song other) {
		return false; // so it compiles
	}
}
