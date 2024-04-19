package Labs.LabWeek9;

public class TreeEmptyException extends Exception {
private String message;
	
	public TreeEmptyException (String m) {
		this.message = m;
	}

	public String toString(){
		return "StackEmptyException: " + message;
	}
}
