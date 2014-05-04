/**
 * 
 * @author gkatsaounis, dborge
 *
 *
 */
public class BTree<Key extends Comparable<Key>, Value> {
	private static final int maxChildren = 4;
	
	private Node root;
	private int height;
	private int pairs;
	
	//private Values[] children = new Values[maxChildren];
	
	public Btree() {
		root = new Node(0);
		
	}
	
	public int size() {
		return pairs;
	}
	
	public int height() {
		return height;
	}
	
}
