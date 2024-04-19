package Assignments.AssignmentWeek8;



import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
    
	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		// TODO: implement this
		try {
	        get(key); // If get() doesn't throw KeyNotFoundException, then key exists
	        return true;
	    } catch (KeyNotFoundException e) {
	        return false;
	    }
	}

	public V get (K key) throws KeyNotFoundException {
		// TODO: implement this
		return bst.find(key); // so it compiles
	}

	public List<Entry<K,V> >	entryList() {
		// TODO: implement this
		return bst.entryList(); // so it compiles
	}

	public void put (K key, V value) {
		// TODO: implement this
		bst.insert(key, value);
	}

	public int size() {
		// TODO: implement this
		return bst.size(); // so it compiles
	}

	public void clear() {
		// TODO: implement this
		bst.clear();
	}

}