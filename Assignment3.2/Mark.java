public class Mark {
	/**
 * A class to represent a space on a tic tac toe board
 * 
 * @author dkauchak
 *
 */
	private int number;
	
	public Mark(int number){
		this.number = number;
	}
		
	public boolean isEmpty(){
		return true;
	}
	
	public boolean equals(Mark other){
		return toString().equals(other.toString());
	}
	
	public String toString(){
		return Integer.toString(number);
	}	
}