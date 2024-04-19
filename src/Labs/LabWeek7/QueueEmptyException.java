package Labs.LabWeek7;

class QueueEmptyException extends Exception {
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
