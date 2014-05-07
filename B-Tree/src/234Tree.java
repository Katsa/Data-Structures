public class Tree {

	private Node root;

	public int find(long key) {
		Node currentNode = rootl
		int numChildren;

		while (true) {
			if((()))
		}	
	}

	public Node getNextChild(Node current) {
		int numEntries = current.getNumEntries();

		for (int i =0; i <numEntries; i++) {
			if (current.getData(i).data > value) {
				return current.getChild(i);
			}
		}
		return current.getChild(i);
	}

	public void insert(long value) {
		Node current = root;
		Entries newEntry = new Entries(value);

		while(true) {
			if (current.isFull()) {
				split(current);
				Node current = current.getParent();
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

}