
 /**
 * @author gkatsaounis, dborge
 */

 import java.lang.reflect.Array;
 import java.util.Arrays;

 public class Node {
	
	public static final int order = 4;

	private Entry[] entries;
	private Node[] children;
	private Node parent;
	private int numEntries;

	public Node() {
		entries = new Entry[order -1];
		children = new Node[order];
		numEntries = 0;
		parent = null;
	}

	public Node getChild(int numChild) {
		return children[numChild];
	}

	public Node getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return (children[0] == null) ? true : false ;
	}

	public boolean isFull() {
		return(numEntries == order - 1) ? true :false;
	}

	public getNumEntries() {
		return numEntries;
	}

	public getData(int location) {
		return entries[location];
	}

	public void addChild(int numChild, Node child) {
		children[numChild] = child;
		if (child != null) {
			child.parent = this;
		}
	}

	public Node removeChild(int numChild) {
		Node temp = children[numChild];
		children[numChild] = null;
		return temp;
	}

	public int search(long value) {
		for(int i=0; i<order-1; i++) {
			if(entries[i] == null) {
				break
			}
			else if (entries[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public int insert(Entry newEntry) {
		if (!isFull()) {
			long newKey = newEntry.data;
			numEntries++;

			for (int i = order - 2; i >=0; i--) {
				if (entries[i] == null) {
					continue;
				}

				long current = entries[i].data;
				if (current > newKey) {
					entries[i+1] = entries[i];
				}
				else {
					items[i+1] = newEntry;
					return i+1;
				}
			}
			entries[0] = newEntry;
			return 0;
		}
		return -1;
	}


}
	