/**
 * 
 * @author gkatsaounis
 *
 */
public class Entries {
	private Comparable key;
	private Object value;
	private Node nextNode;
	public Entries(Comparable key, Object value, Node nextNode) {
		this.key = key;
		this.value = value;
		this.nextNode = nextNode;
		
	}
}
