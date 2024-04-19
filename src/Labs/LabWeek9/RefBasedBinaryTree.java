package Labs.LabWeek9;

import java.lang.Math;
import java.util.LinkedList;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
    protected TreeNode root;
    
    public RefBasedBinaryTree() {
        this.root = null;
    }
    
    public void insert(Integer value){
        if (root==null) {
            root = new TreeNode(value);
        } else {
            insert(null, root, value);
		}
        
    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent.getLeft()==null) {
                parent.setLeft(new TreeNode(value));
			} else {
                parent.setRight(new TreeNode(value));
			}            
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight) {
                insert(t, t.getRight(), value);
			} else {
                insert(t, t.getLeft(), value);
			}
        }
    }
    
    private int height(TreeNode t) {
        if (t==null) {
            return -1;
		} else {
            int highest = Math.max(height(t.getLeft()), height(t.getRight()));
            return 1 + highest;
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following an in-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void inOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a pre-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void preOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a post-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void postOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }
    
    
    public int sum() {
        if (root == null) {
            return 0;
        } else {
            return sum(root);
        }
    }

    private int sum(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            // Calculate the sum recursively for left and right subtrees
            int leftSum = sum(t.getLeft());
            int rightSum = sum(t.getRight());
            // Add the value of the current node to the sum of its subtrees
            return t.getValue() + leftSum + rightSum;
        }
    }
    
    
    public Integer getMax() {
        if (root == null) {
            return null; // Return null if the tree is empty
        } else {
            return getMax(root);
        }
    }

    private Integer getMax(TreeNode t) {
        // Initialize max value with the value of the root node
        int max = t.getValue();

        // Recursively traverse the left subtree to find the maximum value
        Integer leftMax = (t.getLeft() != null) ? getMax(t.getLeft()) : null;
        // Recursively traverse the right subtree to find the maximum value
        Integer rightMax = (t.getRight() != null) ? getMax(t.getRight()) : null;

        // Update max value with the maximum of root value, left subtree max, and right subtree max
        if (leftMax != null && leftMax > max) {
            max = leftMax;
        }
        if (rightMax != null && rightMax > max) {
            max = rightMax;
        }

        return max;
    }
    
    public boolean find(Integer value) {
        return find(root, value);
    }

    private boolean find(TreeNode t, Integer value) {
        if (t == null) {
            return false; // If the current node is null, value is not found
        }
        
        if (t.getValue().equals(value)) {
            return true; // If the current node's value matches the target value, return true
        }
        
        // Recursively search in the left subtree and right subtree
        return find(t.getLeft(), value) || find(t.getRight(), value);
    }
    
    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }
    
    private String toString(TreeNode t) {
        if(t==null) {
            return "";
        } else {
            String s = "";
            
            s += toString(t.getLeft());
            s += t.getValue() + " ";
            s += toString(t.getRight());
            
            return s;
        }
    }
    
    
    public static void main(String[] args) {
        // use these trees to test the methods you will implement in Part II
        RefBasedBinaryTree emptyTree = new RefBasedBinaryTree();
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        
        System.out.println(myTree.sum());
        
        System.out.println(myTree.getMax());
        
        System.out.println(myTree.find(7));
        
        System.out.println(myTree.find(8));
    }
    
}
