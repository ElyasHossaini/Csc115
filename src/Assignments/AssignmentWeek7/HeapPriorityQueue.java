package Assignments.AssignmentWeek7;



/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		// TODO: implement this
		this(DEFAULT_SIZE);
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		// TODO: implement this
		storage = new Comparable[size];
        currentSize = 0;
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}

	public void insert (Comparable element) throws HeapFullException {
		// TODO: implement this
		if(currentSize == storage.length) {
			throw new HeapFullException();
		}
		storage[currentSize] = element;
		currentSize++;
		bubbleUp(currentSize-1);
		
		
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    }
	
	public void bubbleUp(int index) {
		// TODO: implement this
		// Index 0 is root, no need to percolate up further
	    if (index == 0)
	        return;

	    int parentIndex = (index - 1) / 2; // Calculate parent index

	    // Compare the element with its parent and swap if necessary
	    if (storage[index].compareTo(storage[parentIndex]) < 0) {
	        // Swap elements
	        Comparable temp = storage[index];
	        storage[index] = storage[parentIndex];
	        storage[parentIndex] = temp;
	        // Recursively percolate up
	        bubbleUp(parentIndex);
	    }
		
	}
			
	public Comparable removeMin() throws HeapEmptyException {
		// TODO: implement this
		if(currentSize == 0) {
			throw new HeapEmptyException();
		}
		Comparable top = storage[0];
		storage[0] = storage[currentSize-1];
		storage[currentSize-1] = null;
		currentSize--;
		
		bubbleDown(0);
		
		
		
		return top;
		
		
		 // so it compiles
	}
	
	private void bubbleDown(int index) {
		// TODO: implement this
		int leftchild = 2*(index)+1;
		int rightchild = 2*(index)+2;
		int smallest = index;
		
		// Check if the left child is within the bounds and smaller than the current index
	    if (leftchild < currentSize && storage[leftchild].compareTo(storage[smallest]) < 0)
	        smallest = leftchild;

	    // Check if the right child is within the bounds and smaller than the current index
	    if (rightchild < currentSize && storage[rightchild].compareTo(storage[smallest]) < 0)
	        smallest = rightchild;

	    // If the smallest element is not the current index, swap and recursively percolate down
	    if (smallest != index) {
	        // Swap elements
	        Comparable temp = storage[index];
	        storage[index] = storage[smallest];
	        storage[smallest] = temp;
	        // Recursively percolate down
	        bubbleDown(smallest);
	    }
	}

	public boolean isEmpty(){
		// TODO: implement this
		
		return currentSize == 0; // so it compiles
	}
	
	public boolean isFull() {
		// TODO: implement this
		
		return currentSize == storage.length; // so it compiles
	}
	
	public int size () {
		// TODO: implement this
		
		return currentSize; // so it compiles
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=1; i<=currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
