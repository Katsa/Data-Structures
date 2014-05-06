
 /**
 * @author gkatsaounis, dborge
 */

 import java.lang.reflect.Array;
 import java.util.Arrays;
 public class Node<E extends Comparable <E>> {
	
	public E[] data;
 	public Node[] children;
 	
 	public Node (E[] data, Node[] children) {

 		this.data = data;
 		children = new Node[maxChildren];
 	}
 	
 	public E getData(int location) {
 	
 		return data[location];
 	}
 	
 	public void setData(E b) {
 		data = b;
 	}
 	

}
	