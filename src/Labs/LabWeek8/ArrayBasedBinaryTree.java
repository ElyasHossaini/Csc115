package Labs.LabWeek8;

/*
 * ArrayBasedBinaryTree.java
 *
 * An array-based BinaryTree meant to store values of type Integer
 */
public class ArrayBasedBinaryTree implements BinaryTree {
    private static final int CAPACITY = 5;
    protected Integer[] data;
    protected int root;
    protected int size;
    
    public ArrayBasedBinaryTree() {
        data = new Integer[CAPACITY];
        root = 0;
        size = 0;
    }

    public void insert(Integer value) {
        if (size == data.length) {
            expandAndCopy();
        }
        data[size++] = value;
    }

    protected void expandAndCopy() {
        Integer[] newData = new Integer[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    protected int getLeft(int t) {
        return 2 * t + 1;
    }

    protected int getRight(int t) {
        return 2 * t + 2;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(int t) {
        if (t < size) {
            inOrder(getLeft(t));
            System.out.print(data[t] + " ");
            inOrder(getRight(t));
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(int t) {
        if (t < size) {
            System.out.print(data[t] + " ");
            preOrder(getLeft(t));
            preOrder(getRight(t));
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(int t) {
        if (t < size) {
            postOrder(getLeft(t));
            postOrder(getRight(t));
            System.out.print(data[t] + " ");
        }
    }

    public int height() {
        return height(root);
    }

    protected int height(int t) {
        if (t >= size) {
            return -1;
        } else {
            int leftHeight = height(getLeft(t));
            int rightHeight = height(getRight(t));
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public String toString() {
        return toString(root);
    }

    private String toString(int t) {
        if (t >= size) {
            return "";
        } 
        String s = "";
        s += toString(getLeft(t));
        s += data[t] + " ";
        s += toString(getRight(t));

        return s;
    }

    public static void main(String[] args) {
        ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        System.out.println("in");
        myTree.inOrder();
        System.out.println("\npre");
        myTree.preOrder();
        System.out.println("\npost");
        myTree.postOrder();
        
        System.out.println("\ntoString\n" + myTree);
        
        System.out.println(myTree.height());
    }
}