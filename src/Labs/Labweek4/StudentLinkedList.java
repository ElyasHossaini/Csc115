package Labs.Labweek4;



public class StudentLinkedList implements StudentList {

	StudentNode head;
	int count;

	public StudentLinkedList() {
		head = null;
		count = 0;
	}

	public void add(Student s) {
		// TODO: complete
		StudentNode current = head;
  	  	StudentNode newNode = new StudentNode(s);
  	  	if(head == null) {
  	  		head = newNode;
  	  		head.setNext(null);
  	  		count ++;
  	  	} 
  	  	else{ 
  		    //iterate to the last node
  		    while(current.getNext() != null) { 
  		    current = current.getNext(); 
  		    } 
  		    //Append the new node to the end
  		    current.setNext(newNode);  
  		    count++;
  		}
	}

	public int size() {
		// TODO: complete
		return count;
		
		
	}

	public void removeFront() {
		// TODO: complete
		if(head != null) {
			head = head.getNext();
			count--;
		}
		
		
	}

	public boolean contains(Student s) {
		StudentNode current = head;
		boolean istrue = false;
		if(current != null) {
			while(current != null) {
				if(current.getData().equals(s)) {
					istrue = true;
					break;
				}
				else {
					current = current.getNext();
				}
			
			}
		}
		else {
			return istrue;
		}
		// TODO: complete
		return istrue;
		
	}
	
	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		// DO NOT CHANGE THIS METHOD - it is correct
		// Changing it will result in your code getting
		// a score of 0 from the autograder for this lab
		
		String s = "";
		StudentNode tmp = head;

		while(tmp != null) {
			s  += tmp.getData() + "\n";
			tmp = tmp.next;
		}

		return s;
	}
}
