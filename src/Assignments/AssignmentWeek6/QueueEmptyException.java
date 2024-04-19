package Assignments.AssignmentWeek6;



public class QueueEmptyException extends Exception{
	
	String msg;
	public QueueEmptyException (String m)
	{
		this.msg = m;
	}

	public String toString()
	{
		return "QueueEmptyException: " + msg;
	}
}