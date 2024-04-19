package Assignments.AssignmentWeek9;


import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

    private List<List<Entry<K,V>>> 	table;
    private int	count;
    private int  tableSize;

    // For Part III
    private long getLoops;
    private long putLoops;

    public HashMap() {
        tableSize = 1000003; // prime number
        table = new ArrayList<List<Entry<K,V>>>(tableSize);

        // initializes table as a list of empty lists
        for (int i = 0; i < tableSize; i++) {
            table.add(new LinkedList<Entry<K,V>>());
        }

        count = 0;

        // For Part III:
        resetGetLoops();
        resetPutLoops();
    }

    // For Part III
    public long getGetLoopCount() {
        return getLoops;
    }

    // For Part III
    public long getPutLoopCount() {
        return putLoops;
    }

    // For Part III
    public void resetGetLoops() {
        getLoops = 0;
    }
    
    // For Part III
    public void resetPutLoops() {
        putLoops = 0;
    }

    public boolean containsKey(K key) {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        List<Entry<K,V>> list = table.get(index);
        boolean found = false;
        Iterator<Entry<K,V>> iter = list.iterator();
        while(iter.hasNext() && found == false) {
        	Entry<K,V> cur = iter.next();
        	if(cur.key.compareTo(key) == 0) {
        		found = true;
        	}
        }
        
        return found;
    }

    public V get (K key) throws KeyNotFoundException {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;

        List<Entry<K,V>> list = table.get(index);
        boolean found = false;
        Iterator<Entry<K,V>> iter = list.iterator();
        V value = null;
        while(iter.hasNext() && found == false) {
        	Entry<K,V> cur = iter.next();
        	if(cur.key.compareTo(key) == 0) {
        		found = true;
        		value = cur.value;
        	}
        }
        if(found == false) {
        	throw new KeyNotFoundException();
        }
        else {
        	return value;
        }
    }


    public List<Entry<K,V>> entryList() {
        List<Entry<K,V>> resultList = new LinkedList<Entry<K,V>>();
        for (List<Entry<K,V>> list : table) {
            resultList.addAll(list);
        }
        return resultList;
    }
    
    public void put (K key, V value){
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        List<Entry<K,V>> list = table.get(index);
        Iterator<Entry<K,V>> iter = list.iterator();
        boolean found = false;
        while(iter.hasNext() && found == false) {
        	Entry<K,V> cur = iter.next();
        	if(cur.key.compareTo(key) == 0) {
        		cur.value = value;
        		found = true;
        	}
        }
        
        if(found == false) {
        	list.add(new Entry<K,V> (key, value));
        	count ++;
        }
    }

    public int size() {
        return count;
    }

    public void clear() {
        for(int i = 0; i < tableSize; i++) {
            table.get(i).clear();
        }
        count = 0;
    }
}