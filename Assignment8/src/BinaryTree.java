
/**
 * Binary tree implementation.
 * 
 * @author dave
 * @data 3/1/2010
 *
 * @param <E>
 */

public class BinaryTree<E> {
	private E data;
	
	private BinaryTree<E> parent;
	
	private BinaryTree<E> left;
	private BinaryTree<E> right;
		
	public BinaryTree(E data){
		this.data = data;
		left = right = null;
	}
	
	public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right){
		this.data = data;
		this.left = left;
		this.right = right;
		
		left.parent = this;
		right.parent = this;
	}
		
	public E data(){
		return data;
	}
	
	public BinaryTree<E> left(){
		return left;
	}
	
	public BinaryTree<E> right(){
		return right;
	}
	
	public void setLeft(BinaryTree<E> left){
		this.left = left;
		left.parent = this;
	}
	
	public void setRight(BinaryTree<E> right){
		this.right = right;
		right.parent = this;
	}
	
	public BinaryTree<E> parent(){
		return parent;
	}
		
	public boolean isLeaf(){
		return left == null && right == null;
	}
	
	public boolean isRoot(){
		return parent == null;
	}
		
	// ---- some more interesting methods
	public int height(){
		if( isLeaf() ){
			return 0;
		}else{
			return Math.max(1+left.height(), 1+right.height());
		}
	}
	
	public int depth(){
		if( isRoot() ){
			return 0;
		}else{
			return 1 + parent.depth();
		}
	}
	
	public int size(){
		if( isLeaf() ){
			return 1;
		}else{
			return 1 + left.size() + right.size();
		}
	}
	
	public boolean search(E item){
		if( data.equals(item) ){
			return true;
		}else if( isLeaf() ){
			return false;
		}else{
			return left.search(item) || right.search(item);
		}
	}
	
	public boolean isCompleteSlow(){
		if( isLeaf() ){
			return true;
		}else if( left.height() != right.height() ){
			return false;
		}else{
			return left.isCompleteSlow()  && right.isCompleteSlow();
		}
	}
	
	public boolean isComplete(){
		return size() == Math.pow(2, height()+1)-1;
	}
}