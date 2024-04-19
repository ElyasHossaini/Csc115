package Labs.LabWeek7;



public class QueueRefBased<T> implements Queue<T> {

    private QueueNode<T> front;
    private QueueNode<T> back;

    public QueueRefBased() {
        front = null;
        back = null;
    }

    public int size() {
        int count = 0;
        QueueNode<T> tmp = front;

        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }


    public boolean isEmpty() {
        return front == null;
    }


    public void enqueue (T element) {
        QueueNode<T> nn = new QueueNode<T>(element);
        if (front == null) {
            front = nn;
            back = nn;
        } else {
            back.next = nn;
            back = nn;
        }
    }

    public T dequeue() throws QueueEmptyException {
    	try {
			T val = front.getValue();
			front = front.getNext();
			if (front == null) {
				back = null;
			}
			return val;
		}
		catch (NullPointerException e) {
			throw new QueueEmptyException("Empty queue in dequeue");
		}
    }

    public T peek() throws QueueEmptyException  {

    	try {
			return front.getValue();
		}
		catch (NullPointerException e) {
			throw new QueueEmptyException("Empty queue while peeking");
		}
    }

    public void makeEmpty() {
        front = null;
        back = null;
    }
}
