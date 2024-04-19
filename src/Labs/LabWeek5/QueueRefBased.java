package Labs.LabWeek5;

public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	private int count;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
		count = 0;
	}

	public int size() {
		return count;			
	}

	public boolean isEmpty() {
		return front == null && back == null;
	}

	public void enqueue (int value) {
		QueueNode newval = new QueueNode(value);
		if(front == null) {
			front = newval;
			back = newval;
			count ++;
		}
		else {
			back.setNext(newval);
			back = newval;
			count ++;
		}
		
		
	}

	public int dequeue() {
		int val = 0;
		if(front != null) {
			val = front.getValue();
			if(front == back) {
				back = null;
			}
			front = front.getNext();
			count--;
		}
		
		if(count == 0) {
			front = null;
			back = null;
		}
		return val;
		
	}

	public int peek()  {
		return front.getValue(); // so it compiles
	}

	public void makeEmpty() {
		front = null;
		count = 0;
	}
}
