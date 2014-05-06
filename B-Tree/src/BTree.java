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
	 * Steps through the tree until it finds the object you are looking for, or not.
	 * @return
	 */
	public boolean contains(E value) {
		if(height == 0) {
			for(int i = 0; i < maxChildren; i++) { //could go out of bounds. the bound of i is meh
				if(root.getData(i).compareTo(value) == 0) {
					return true;
				}
			}
			return false;
		}
		else {
			for(int i = 0; i < maxChildren; i++) {
				if(root.getData(i).compareTo(value) < 0) {
					return contains();
				}
			}
		}
	}
	
	/**
	 * removes the element you pass, and returns it
	 * @return
	 */
	public E remove(E value) {
		
	}
	
	/**
	 * helper method called in insert. Splits the node if the size is larger then maxChildren
	 */
	private void split(Node current) {
		Node newNode = new Node(new E[maxChildren], maxChildren/2);
		//current. = maxChildren/2;
		for(int i = 0; i < maxChildren/2; i++) {
			newNode.children[i] = current.children[maxChildren/2 + i];
		}
	}

	/**
	 * helper method that joins two nodes if one of them is going to be smaller then maxChildren/2
	 */
	private void join(Node one, Node two) {
		Node newNode = new Node(new E[maxChildren], maxChildren/2);
		int first = 0;
		for(int i = 0; i < maxChildren; i++) {
			newNode.children[i] = one.children[i];
			first ++;
		}

		for(int i = 0; i < maxChildren/2; i++) {
			newNode.children[i+first] = two.children[i];
		}
		
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