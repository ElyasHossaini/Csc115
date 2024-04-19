package Labs.LabWeek9;

public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{


	public void insert(int val) {
		if(size == 0) {
			data[size]	= val;
		}
		else {
			insert(val, 0);
		}
		size++;
	}
	protected void insert(int val, int node) {
		if(data[node] == null) {
			data[node] = val;
		}
		else {
			if(val < data[node]) {
				insert(val, 2*node + 1);
			}
			else {
				insert(val, 2*node + 2);
			}
		}
	
	}
    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
    }

}
