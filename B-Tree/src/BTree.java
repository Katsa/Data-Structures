/**
 * 
 * @author gkatsaounis, dborge
 *
 *
 */
public class BTree<E extends Comparable> {
	
	private int maxChildren;
	private Node root;
	private int height;
	private int numNodes;
	
	public BTree(int maxChildren){
		root = new Node(new E[maxChildren], maxChildren);
	}
	
	/**
	 * inserts the element you passed at the correct location. Also will split up the array of elements if it surpasses maxChildren
	 */
	public void insert() {
		
	}
	/**
	 * helper method called in insert. Splits the node if the size is larger then maxChildren
	 */
	private void split() {
		
	}
	
	/**
	 * Steps through the tree until it finds the object you are looking for, or not.
	 * @return
	 */
	public boolean contains(E value) {
		
	}
	
	/**
	 * removes the element you pass, and returns it
	 * @return
	 */
	public E remove(E value) {
		
	}
	
	/**
	 * helper method that joins two nodes if one of them is going to be smaller then maxChildren/2
	 */
	private void join() {
		
	}
	/**
	 * Helper method that checks weather or not the specific node is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		return false;
		
	}
	/**
	 * Helper method that returns the size of the BTree
	 * @return
	 */
	public int getNumNodes() {
		return numNodes;
	}
	
	/**
	 * Helper method that returns the height of the BTree
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	
}