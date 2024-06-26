package Assignments.AssignmentWeek4;


public class A4Stack<T> implements Stack<T> {
	
	private A4Node<T> head;
	// Do NOT add any other fields to this class.
	// You should be able to implement the Stack 
	// interface with just a head field.

	public A4Stack() {
		// TODO: implement this
		
	}
	
	public void push(T value) {
		if(head == null) {
			A4Node<T> item = new A4Node<T>(value);
			head = item;
		}
		else {
			A4Node<T> currenthead = head;
			A4Node<T> item = new A4Node<T>(value);
			head = item;
			head.setNext(currenthead);
		}
		
		// TODO: implement this
	}
	
	public T pop() {
		// TODO: implement this
		if(head == null) {
			return null;
		}
		else if(head != null && head.next == null) {
			T data = head.getData();
			head = null;
			return data;
		}
		else if(head.next != null) {
			T data = head.getData();
			head = head.next;
			return data;
			
		}
		
		return null; // so it compiles
	}
	
	public void popAll() {
		// TODO: implement this
		head = null;
	}
	
	public boolean isEmpty() {
		// TODO: implement this
		if(head != null) {
			return false;
		}
		else {
			return true;// so it compiles
		}
	}
	
	public T peek() {
		// TODO: implement this
		if(head == null) {
			return null;
		}
		else {
			return head.getData();
		}
		 // so it compiles
	}
	
	// Implemented for you for debugging purposes
	public String toString() {
		String result = "{";
		String separator = "";
		
		A4Node<T> cur = head;
		while (cur != null) {
			result += separator + cur.getData().toString();
			separator = ", ";
			cur = cur.next;
		}
	
		result += "}";
		return result;
	}
}