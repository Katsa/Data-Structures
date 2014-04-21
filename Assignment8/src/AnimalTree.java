import java.io.*;
import java.util.Scanner;

public class AnimalTree extends BinaryTree<String>{
	
	public AnimalTree(String data){
		super(data);
	}
	public AnimalTree (String data, BinaryTree<String>left, BinaryTree<String>right){
		super(data, left, right);
	}
	public static AnimalTree readFile(String filename){
		Scanner scan;
		try {
			scan = new Scanner(new BufferedReader(new FileReader(filename)));
			AnimalTree tempTree = recBuildTree(scan);
			scan.close();
			return tempTree;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private static AnimalTree recBuildTree(Scanner scan){
		String currentWord = scan.nextLine();
		if (currentWord.startsWith("A")){
			return new AnimalTree(currentWord.substring(1));
		}
		else{
			return new AnimalTree(currentWord.substring(1),recBuildTree(scan),recBuildTree(scan));
		}	
	}
	public void writeFile(String filename){	
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(filename));
			recWriteToFile(writer,this);
			writer.close();
		} catch (IOException e) {
			System.out.println("Problems with file: " + filename);
		}
	}
	
	public  void recWriteToFile (PrintWriter write, AnimalTree node){
		if (node.isLeaf()){
			write.println("A" + node.data());
		}
		else{
			write.println("Q" + node.data());
			recWriteToFile(write,node.left());
			recWriteToFile(write,node.right());
			
		}
	}
	/**
	 * Returns the left AnimalTree.  Note this is just
	 * a cast of the left of the superclass since we know we're
	 * only storing AnimalTrees.
	 */
	public AnimalTree left(){
		return (AnimalTree)super.left();
	}

	/**
	 * Returns the right AnimalTree.  Note this is just
	 * a cast of the right of the superclass since we know we're
	 * only storing AnimalTrees.
	 */

	public AnimalTree right(){
		
		return (AnimalTree)super.right();
	}	
}