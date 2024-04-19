package Labs.LabWeek8;

import java.lang.Math;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
    protected TreeNode root;

    public RefBasedBinaryTree() {
        // Initialize an empty tree with no root
        root = null;
    }

    public void insert(Integer value) {
        insert(null, root, value);
    }

    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t == null) {
            // If the current node is null, create a new TreeNode with the given value
            TreeNode newNode = new TreeNode(value);
            if (parent == null) {
                // If there is no parent, this is the root node
                root = newNode;
            } else if (parent.getLeft() == null) {
                // If the parent's left child is null, set the new node as its left child
                parent.setLeft(newNode);
            } else {
                // Otherwise, set the new node as the right child of the parent
                parent.setRight(newNode);
            }
        } else {
            // Recursively insert into the subtree with shorter height
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft <= htRight) {
                insert(t, t.getLeft(), value);
            } else {
                insert(t, t.getRight(), value);
            }
        }
    }

    public int height() {
        return height(root);
    }

    protected int height(TreeNode t) {
        if (t == null) {
            return -1;
        } else {
            // Calculate the height recursively
            int leftHeight = height(t.getLeft());
            int rightHeight = height(t.getRight());
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode t) {
        if (t != null) {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }

    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode t) {
        if (t == null) {
            return "";
        }
        String s = "";
        s += toString(t.getLeft());
        s += t.getValue() + " ";
        s += toString(t.getRight());
        return s;
    }

    public static void main(String[] args) {
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i = 2; i <= 8; i++) {
            myTree.insert(i);
        }
        System.out.println("in:");
        myTree.inOrder();
        System.out.println();
        System.out.println("pre:");
        myTree.preOrder();
        System.out.println();
        System.out.println("post:");
        myTree.postOrder();
        System.out.println();
        System.out.println("toString\n" + myTree);
        

        System.out.println(myTree.height());
    }
}