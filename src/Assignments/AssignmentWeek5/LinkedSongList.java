package Assignments.AssignmentWeek5;



public class LinkedSongList {
	// DO NOT ADD ANY MORE FIELDS OR METHODS
	private SongNode head;
	
	public LinkedSongList() {
		head = null;
	}

	public void addFront (Song s) {
		SongNode n = new SongNode(s);
		n.next = head;
		head = n;
	}

	public void addBack (Song s){
		SongNode n = new SongNode(s);
		if (head == null) {
			head = n;
		} else {
			addBackRec(head, n);
		}
	}
	
	private void addBackRec(SongNode cur, SongNode n) {
		if (cur.next == null) {
			cur.next = n;
		} else {
			addBackRec(cur.next, n);
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Song get (int position) {
		return getRec(head, 0, position);
	}
	
	private Song getRec(SongNode cur, int i, int position) {
		if (i == position) {
			return cur.getData();
		} else {
			return getRec(cur.next, i+1, position);
		}
	}

	/* Purpose: create a string representation of list
	 * Parameters: nothing	 
	 * Returns: String - the string representation of the list
	 */
	public String toString() {
		if (head == null) {
			return "{}";
		} else {
			return "{" + toStringRec(head) + "}";
		}
	}
	
	private String toStringRec(SongNode cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString();
		} else {
			return cur.getData().toString() + ", " + toStringRec(cur.next);
		}
	}

	/*
	 * Purpose: Insert all elements from array into this linked list
	 * Parameters: Song[] array - the elements to add to this list
	 * Returns void - nothing
	 */
	public void buildFromArray(Song[] array) {
		buildFromArrayRec(array, array.length-1);
	}
	
	private void buildFromArrayRec(Song[] array, int i) {
		if (i < 0) {
			return;
		} else {
			addFront(array[i]);
			buildFromArrayRec(array, i-1);
		}
	}
	

	/*
	 * Purpose: gets the total number of songs in this list
	 * Parameters: none
	 * Returns: int - the number of songs in this list
	 */
	public int countSongs() {
		return countSongsRecursionHelper(head);
		// TODO: Call a recursive helper method
	}
	
	private int countSongsRecursionHelper(SongNode current) {
		if (current == null) {
			return 0;
		}
		else {
			int first = 1;
			int sumrest = countSongsRecursionHelper(current.next);
			return first + sumrest;
		}

	}
	
		
	/*
	 * Purpose: gets the total duration of all songs in this list
	 * Parameters: none
	 * Returns: int - the total duration of all songs in this list
	 */
	public int totalDuration() {
		// TODO: Call a recursive helper method
		return totalDurationRecursiveHelper(head); // so it compiles
	}
	
	private int totalDurationRecursiveHelper(SongNode current) {
		if(current == null) {
			return 0;
		}
		else {
			int first = current.getData().getDuration();
			int rest = totalDurationRecursiveHelper(current.next);
			return first + rest;
		}
	}
	
	
	/*
	 * Purpose: counts the songs in this list by an artist with artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: int - number of songs by artistName
	 */
	public int countSongsByArtist(String artistName) {
		// TODO: Call a recursive helper method
		return countSongsByArtistRecursiveHelper(head, artistName); // so it compiles
	}
	
	private int countSongsByArtistRecursiveHelper(SongNode current, String artistName) {
		if (current == null) {
			return 0;
		}
		else {
			int count = 0;
			if(current.getData().getArtist().equals(artistName)) {
				count = 1;
			}
			return count + countSongsByArtistRecursiveHelper(current.next, artistName);

		}
	}
	
	
	/*
	 * Purpose: determines whether this list contains a song by artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: boolean - true if a song by artistName is found
	 */
	public boolean containsArtist(String artistName) {
		// TODO: Call a recursive helper method
		return containsArtistRecursiveHelper(head, artistName); // so it compiles
	}
	
	private boolean containsArtistRecursiveHelper(SongNode current, String artistName) {
		if (current == null) {
			return false;
		}
		if (current.getData().getArtist().equals(artistName)) {
			return true;
		}
		return containsArtistRecursiveHelper(current.next, artistName);
	}
	
	
	/*
	 * Purpose: gets the longest song in the list
	 * Parameters: none
	 * Returns Song - the longest song in the list
	 *                or null if the list is empty
	 */
	public Song longestSong() {
		// TODO: Call a recursive helper method
		return longestSongRecursiveHelper(head, null, 0); // so it compiles
	}
	
	private Song longestSongRecursiveHelper(SongNode current, Song longest, int time) {
		if(current == null) {
			return longest;
		}
		else {
			if(current.getData().getDuration() > time) {
				time = current.getData().getDuration();
				longest = current.getData();
			}
			return longestSongRecursiveHelper(current.next, longest, time);
		}
	}
	
		
	/*
	 * Purpose: get the total duration of all songs in the list
	 *          before the first song by artistName
	 * Parameters: String artistName - the artist name to search for
	 * Returns int - the duration of all songs before the first
	 *               song by artistName, or -1 if no song by 
	 *               artistName is found.
	 */
	public int totalTimeUntilArtist(String artistName) {
		// TODO: Call a recursive helper method
		return totalTimeUntilArtistRecursiveHelper(head, artistName, 0); // so it compiles
	}
	
	private int totalTimeUntilArtistRecursiveHelper(SongNode current, String artistName, int time) {
		if(current == null) {
			return -1;
		}
		else {
			if(!current.getData().getArtist().equals(artistName)) {
				time += current.getData().getDuration();
			}
			else {
				return time;
			}
			return totalTimeUntilArtistRecursiveHelper(current.next, artistName, time);
		}
	}
	
}