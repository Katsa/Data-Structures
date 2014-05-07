/**
 * 234 tree 
 * @author gkatsaounis, dborge
 *
 */
public class Tree {

	private Node root;

	/**
	 * returns the node where the next chid would be
	 * @param current
	 * @return the location of the next child
	 */
	public Node getNextChild(Node current) {
		int numEntries = current.getNumEntries();
		int i;
		for (i =0; i <numEntries -1; i++) {
			if (current.getData(i).data > current.getData(i+1).data) {
				return current.getChild(i);
			}
		}
		return current.getChild(i);
	}
	/**
	 * inserts the value into the tree
	 * Thre are a few issues with insert
	 * @param value
	 */
	public void insert(long value) {
		Node current = root;
		Entries newEntry = new Entries();
		//newEntry.insert(value);

		while(true) {
			if (current.isFull()) {
				split(current);
				Node currentNode = current.getParent();
			} 
			else if(current.isLeaf()) {
				break;
			}
			else {
				current = getNextChild(current);
			}
			current.insert(newEntry);
		}
	}
	
	/**
	 * Splits the nodewhen it is necessary when something is inserted and the enry is full.
	 * @param current
	 */
	public void split(Node current) {
        
        Entries B,C;
        Node parent, child2, child3;
        int itemIndex;
        
        C = current.remove();
        B = current.remove();
        child2= current.removeChild(2);
        child3 = current.removeChild(3);
        
        Node newRight = new Node();
        
        if (current == root) {
            root = new Node();
            parent = root;
            root.addChild(0, current);
        } else {
            parent = current.getParent();    
        }
        
        int numItems = parent.getNumEntries();
        int insertedIndex = parent.insert(B);
        
        for(int i= numItems-1; i > insertedIndex; i--) {
            Node tempChild = parent.removeChild(i);
            parent.addChild(i+1, tempChild);
        }
        
        parent.addChild(insertedIndex+1, newRight);
        
        newRight.insert(C);
        newRight.addChild(0, child2);
        newRight.addChild(1, child3);
    }
    

}