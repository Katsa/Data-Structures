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
	
	public BTree() {
		root = new Node(0);
		
	}
	
	public int size() {
		return pairs;
	}
	
	public int height() {
		return height;
	}
	
	public Value get(Key key) {
		
		return search(root,key, height);
	}
	public Value search(Node n, Key key, int ht) {
		Entries[] children = n.children;
		
		//external node
		if (ht == 0) {
			for(int i == 0; i< n.data; i++) {
				if(equal(key, children[i].key)) {
					return (Value) children[i].value;
				}
			}
		}
		//internal node
		else {
			for(int i == 0; i < n.data ; i++) {
				if(i+1 == n.data || smaller(key, children[i+1].key)) {
					return search(children[i].nextNode, key, ht-1);
				}
			}
		}
	}
	
	public Node split(Node n) {
		int halfChildren = maxChildren/2;
		Node current = new Node(halfChildren);
		n.data = halfChildren;
		for(int i = 0; i < halfChildren; i++) {
			
		}
	}
	
	public boolean equal(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) == 0;
	}
	
	public boolean smaller(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) < 0;
	}
}
