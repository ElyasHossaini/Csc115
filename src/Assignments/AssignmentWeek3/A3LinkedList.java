package Assignments.AssignmentWeek3;





// Name:Elyas hossaini
// Student number: v01046248

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node newNode = new A3Node(s);
		if (head == null) {
	        head = newNode;
	        tail = newNode; // Set tail to newNode when list is empty
	    } else {
	    	newNode.setNext(head);
			head = newNode;
			head.getNext().setPrev(newNode);// Update tail to be the new node
	    }
		length++;
	}

	public void addBack(String s) {
		A3Node newNode = new A3Node(s);
		if (head == null || tail == null) {
	        head = newNode;
	        tail = newNode; // Set tail to newNode when list is empty
	    } else {
	        tail.setNext(newNode); // Set the next node of the current last node to the new node
	        newNode.setPrev(tail); // Set the prev node of the new node to the current last node
	        tail = newNode; // Update tail to be the new node
	    }
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		// TODO: implement this
		if(head != null) {
			if(head.next != null) {
				A3Node afterhead = head.getNext();
				afterhead.setPrev(null);
				head = afterhead;
				length--;
			}
			else {
				head = null;
				tail = null;
				length--;
			}
			
		}
	}
	
	public void removeBack() {
		// TODO: implement this
  
        // Find the second last node 
		if(tail != null ) {
			if(tail.getPrev() == null) {
				tail = null;// List becomes empty, so set tail to null
				head = null;
				length--;
	        } else {
	            // Find the second last node
	            A3Node prelast = tail.getPrev();
	            prelast.setNext(null); // Remove the last node
	            tail = prelast;
	            length--;
			}
		}
  
	}
	
	
	
	//////////////////
	/* PART 2 BELOW */
	//////////////////
	
	public void removeMiddle() {
		// TODO: implement this
		if(head == tail) {
			head = null;
			tail = null;
		}
		else if(length == 2) {
			head = null;
			tail = head;
			length--;
			length--;
		}
		else if(head != null) {
			if(length % 2 == 0) {
				A3Node current = head;
				int middle = length/2; 
				int count = 0;
				while(count<middle-1) {
					current = current.getNext();
					count += 1;
				}
				A3Node aftermiddle = current.getNext().getNext();
				aftermiddle.setPrev(current.getPrev());
				current.getPrev().setNext(aftermiddle);
				current.setNext(aftermiddle);
				length--;
				length--;
			}
			else {
				A3Node current = head;
				int middle = length/2; 
				int count = 0;
				while(count<middle-1) {
					current = current.getNext();
					count += 1;
				}
				A3Node aftermiddle = current.getNext().getNext();
				aftermiddle.setPrev(current);
				current.setNext(aftermiddle);
				length--;
			}
		}
	}
	
	
	public void interleave(A3LinkedList other) {
		// TODO: implement this
		A3Node current = head;
		A3Node othercurrent = other.head;


		while(current.getNext() != null){

				if(current.getPrev() == null) {
					A3Node nextcur = current.getNext(); 
					current.setNext(othercurrent.getNext());
					othercurrent.setNext(nextcur);
				}
				else {
					A3Node nextcur = current.getNext();
					A3Node curprev = current.getPrev();
					A3Node nextothcur = othercurrent.getNext();
					A3Node othcurprev = othercurrent.getPrev();
					current.setNext(nextothcur);
					othercurrent.setNext(nextcur);
					current.setPrev(othcurprev);
					othercurrent.setPrev(curprev);
				}
				

				current = current.getNext();
				othercurrent = othercurrent.getNext();

			
			
		}
		A3Node last = tail;
		A3Node otherlast = other.tail;
		
		A3Node prevlast = last.getPrev();
		last.setPrev(otherlast.getPrev());
		otherlast.setPrev(prevlast);
		
	}
	
	
	
	////////////////////////////////////////
	/* METHODS BELOW TO HELP WITH TESTING */
	////////////////////////////////////////
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	