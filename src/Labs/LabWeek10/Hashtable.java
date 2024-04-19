package Labs.LabWeek10;

import java.util.Arrays;

public class Hashtable {
    
    private static final int TABLE_SZ = 7; // a prime number

    Student[] table;
    int count;  // number of Students in the table

    public Hashtable() {
        table = new Student[TABLE_SZ];
        count = 0;
    }

    /* MethodName: insertCollisions
     * Purpose: insert (or update entry) s in this Hashtable with no collision handling strategy
     * Parameters: Student - s
     * Throws:  TableFullException - if inserting a new key into a full table
     *          CollisionException - if inserting a new key into table at index that is full
     * Returns: nothing
     */
    public void insertCollisions(Student s) throws TableFullException, CollisionException {
        int index = s.hashCode() % TABLE_SZ;
        if (table[index] == null) {
            table[index] = s;
            count++;
        } else {
            throw new CollisionException();
        }
    }

    /* MethodName: getCollisions
     * Purpose: find Student with sid in this Hashtable with no collision handling and returns their grade
     * Parameters: String - sid
     * Throws:  KeyNotFoundException  - if Student with sid is not found in table
     * Returns: int - the grade of Student with sid
     */
    public int getCollisions(String sid) throws KeyNotFoundException {
        for (Student student : table) {
            if (student != null && student.getSID().equals(sid)) {
                return student.getGrade();
            }
        }
        throw new KeyNotFoundException();
    }

    /* MethodName: insertLinearProbing
     * Purpose: insert (or update entry) s in this Hashtable with Linear Probing to handle collisions
     * Parameters: Student - s
     * Throws: TableFullException  - if inserting a new key into a full table
     * Returns: nothing
     */
    public void insertLinearProbing(Student s) throws TableFullException {
        int index = s.hashCode() % TABLE_SZ;
        int startIndex = index;
        while (table[index] != null) {
            index = (index + 1) % TABLE_SZ;
            if (index == startIndex) {
                throw new TableFullException();
            }
        }
        table[index] = s;
        count++;
    }

    /* getLinearProbing
     * Purpose: find Student with sid in this Hashtable that uses Linear Probing and returns their grade
     * Parameters: String - sid
     * Throws:  KeyNotFoundException  - if Student with sid is not found in table
     * Returns: int - the grade of Student with sid
     */
    public int getLinearProbing(String sid) throws KeyNotFoundException {
        int index = Math.abs(sid.hashCode() % TABLE_SZ);
        int startIndex = index;
        while (table[index] != null) {
            if (table[index].getSID().equals(sid)) {
                return table[index].getGrade();
            }
            index = (index + 1) % TABLE_SZ;
            if (index == startIndex) {
                break;
            }
        }
        throw new KeyNotFoundException();
    }

    /*
     * Purpose: returns the number of elements in this Hashtable
     * Parameters: none
     * Returns: int - the number of elements
     */
    public int size() {
        return count;
    }

    /*
     * Purpose: returns a String representation of elements
     *      in this Hashtable separated by newlines
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return Arrays.toString(table);
    }
}
