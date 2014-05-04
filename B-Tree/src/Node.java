import java.lang.reflect.Array;
import java.util.Arrays;
public class Node<E extends Comparable <E>> {
	private Node left;
	private E data;
	private Node right;
	
	public Node (E data){
		left = right = null;
		this.data = data;
	}
	public Node (Node left, E data , Node right){
		this.left = left;
		this.data = data;
		this.right = right;	
	}
	public Node getLeft(){
		return left;}
	
	public E getData(){
		return data;}
	
	public Node getRight(){
		return right;}
	
	public void setLeft(Node a) {
		left = a;}
	
	public void setData(E b) {
		data = b;}
	
	public void setRight(Node c) {
		right = c;}
	public boolean isLeaf(){
		if (left == null & right == null)
			return true;
		else 
			return false;
	}
}
