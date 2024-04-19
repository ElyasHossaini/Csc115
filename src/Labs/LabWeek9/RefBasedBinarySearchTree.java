package Labs.LabWeek9;

import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {
	
	public void insert(Integer n) {
		root = inserthelper(root, n);
	}
	private TreeNode inserthelper(TreeNode root, Integer n) {
		int data = n;
		
		if(root == null) {
			root = new TreeNode(n);
			return root;
		}
		else if(data < root.data) {
			root.left = inserthelper(root.left, n);
		}
		else {
			root.right = inserthelper(root.right, n);
		}

		return root;
	}
	
	public Integer getMax() {
        if (root == null) {
            return null; // Return null if the tree is empty
        } else {
            return getMax(root);
        }
    }

    private Integer getMax(TreeNode t) {
        // Traverse to the rightmost node because the maximum value is located there in a binary search tree
        while (t.getRight() != null) {
            t = t.getRight();
        }
        // Once reached the rightmost node, return its value
        return t.getValue();
    }
    
    public boolean find(Integer value) {
        return find(root, value);
    }

    private boolean find(TreeNode t, Integer value) {
        if (t == null) {
            return false; // If the current node is null, value is not found
        }
        
        if (value.compareTo(t.getValue()) == 0) {
            return true; // If the current node's value matches the target value, return true
        } else if (value.compareTo(t.getValue()) < 0) {
            // If the target value is less than the current node's value, search in the left subtree
            return find(t.getLeft(), value);
        } else {
            // If the target value is greater than the current node's value, search in the right subtree
            return find(t.getRight(), value);
        }
    }


    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);
        
        
        System.out.println(myTree.sum());
        
        System.out.println(myTree.getMax());
        
        System.out.println(myTree.find(7));
        
        System.out.println(myTree.find(8));
        
        
    }
}
