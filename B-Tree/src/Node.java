
 /**
 * @author gkatsaounis, dborge
 */

 import java.lang.reflect.Array;
 import java.util.Arrays;

 public class Node {
	
	public static final int order = 4;

	private Entries[] entries;
	private Node[] children;
	private Node parent;
	private int numEntries;
	
	/**
	 * constructor
	 */
	public Node() {
		entries = new Entries[order -1];
		children = new Node[order];
		numEntries = 0;
		parent = null;
	}
	/**
	 * Returns the child at the location indicated by the user
	 * @param numChild
	 * @return child
	 */
	public Node getChild(int numChild) {
		return children[numChild];
	}
	/**
	 * returns the parent of the current node
	 * @return parent
	 */
	public Node getParent() {
		return parent;
	}
	/**
	 * Boolean that indicates whether it is a leaf or not
	 * @return boolean
	 */
	public boolean isLeaf() {
		if(children[0] == null) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Boolean that indicates whether the entry is full or not
	 * @return boolean
	 */
	public boolean isFull() {
		if(numEntries == order - 1) {
			return true;
		}
		else {
			return false;
		}
	}
		
	/**
	 * Helper function that indicates the number of entries that are stored under the current node
	 * @return numEntries
	 */
	public int getNumEntries() {
		return numEntries;
	}
	/**
	 * returns the data at a curtain location in the entry
	 * @param location
	 * @return entries[location]
	 */
	public Entries getData(int location) {
		return entries[location];
	}

	/**
	 * adds a child to the entry
	 * @param numChild
	 * @param child
	 */
	public void addChild(int numChild, Node child) {
		children[numChild] = child;
		if (child != null) {
			child.parent = this;
		}
	}

	/**
	 * removes the child at the location designated by the user and returns it
	 * @param numChild
	 * @return temp. it is the child that is removed
	 */
	public Node removeChild(int numChild) {
		Node temp = children[numChild];
		children[numChild] = null;
		return temp;
	}
	
	/**
	 * Searches through the tree and returns the location of the value that is being searched
	 * @param value
	 * @return i if it exists or -1 if it is not there
	 */
	public int search(long value) {
		for(int i=0; i<order-1; i++) {
			if(entries[i] == null) {
				break;
			}
			else if (entries[i].data == value) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * inserts the entry into the correct location in the tree
	 * @param newEntry
	 * @return location where it will be inserted
	 */
	public int insert(Entries newEntry) {
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
					entries[i+1] = newEntry;
					return i+1;
				}
			}
			entries[0] = newEntry;
			return 0;
		}
		return -1;
	}
	
	/**
	 * removes the entry that it is called on
	 * @return
	 */
	public Entries remove() {
        // get biggest item from ordered array
        Entries deletedItem = entries[numEntries-1];
        entries[numEntries-1] = null;
        numEntries--;
        return deletedItem;
    }


}
	