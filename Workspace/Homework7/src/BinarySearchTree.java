import java.util.ArrayList;

/**
 * Binary Search Tree Class
 * 
 * The head class for a binary search tree implementation.
 * 
 * @author jc5pz
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private TreeNode<T> root;

	/**
	 * Default constructor
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinarySearchTree() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinarySearchTree(TreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public TreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Set the root of the tree
	 * 
	 * @param root  The new root of this tree
	 */
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	/**
	 * Find if an element exists
	 * 
	 * Checks to see if the value val appears in the
	 * tree (recursively).  Returns true if it appears
	 * and false otherwise.
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
		if(getRoot() == null) {
			return false;
		}
		return root.find(val);
	}
	/**
	 * 
	 * @return an integer containing the size of the BST (number of total nodes)
	 */
	public int size() {
		if(root == null) {
			return 0;
		}
		return root.size();
	}
	/**
	 * 
	 * @return an integer containing the height of the BST
	 */
	public int height() {
		if(root == null) {
			return 0;
		}
		return root.height();
	}
	
	/**
	 * Insert an element
	 * 
	 * Inserts val into the tree where it should appear, returning
	 * true on success and false otherwise
	 * 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		if(getRoot() == null) {
			setRoot(new TreeNode<T>(val));
			return true;
		}
		return root.insert(val);
	}

	   
    /**
     * Delete an element from the tree
     * 
     * Deletes val from the tree if it appears, returning
     * true on success and false otherwise
     * 
     * @param val The value to delete
     * @return True on success, false otherwise
     */
    public boolean delete(T val) {
    	return false;
    	
    }
    public String inOrder() {
    	return root.inOrder();
    }
    public String postOrder() {
    	return root.postOrder();
    }
	
	/**
	 * Build from a list
	 * 
	 * Build the tree from the given list, overwriting any tree data
	 * previously stored in this tree.  Should read from beginning to
	 * end of the list and repeatedly call insert() to build the tree.
	 * 
	 * @param list The list from which to build the tree
	 * @return True if successfully built, false otherwise
	 */
    public boolean buildFromList(ArrayList<T> list) {
    	if(list.size() == 0) {
    		return false;
    	}
		root = new TreeNode<T>(list.get(0));
	    for(int x = 1; x < list.size(); x++) {
	    	insert(list.get(x));
	    }
	    return true;
	}
	
	   
    /**
     * toString method
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return root.inOrder();
    }
	
	/**
	 * Main method
	 * 
	 * For testing, etc
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		TreeNode<Integer> l = new TreeNode<Integer>(3);
		TreeNode<Integer> r = new TreeNode<Integer>(9); 
		TreeNode<Integer> r1 = new TreeNode<Integer>(5); 
		TreeNode<Integer> ro = new TreeNode<Integer>(7, l, r);
		l.setLeft(new TreeNode<Integer>(2));
		l.setRight(r1);
		r1.setLeft(new TreeNode<Integer>(4));
		r.setLeft(new TreeNode<Integer>(8));
		r.setRight(new TreeNode<Integer>(10));
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(ro);
		System.out.println(bst.insert(1));
	}
}