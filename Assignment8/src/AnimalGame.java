import java.util.Scanner;

public class AnimalGame {
	public static void play(String inputFile, String outputFile){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to play a game?(y/n)");
		String answer = scan.nextLine();
		//System.out.println(answer);
		if (answer.equals("y")){
			playGame(AnimalTree.readFile(inputFile));
			//System.out.println(answer);
		}
		else if (answer.equals("n")){
			System.out.println("Too Bad, So Sad!");
		}
		else
		{System.out.println("Stop Messing Around");
		System.out.println(answer);
		
		}
	}

	public static void checkWin(AnimalTree animalTree, String answer) {
		if (answer.equals("y")){
			System.out.println("Great");
		}
		else{
			System.out.println("Something went wrong");
			playGame(animalTree);
		}	
	}

	public static void checkLeaves(AnimalTree animalTree, String answer) {
		if (answer.equals("y")){
			System.out.println("Great");
		}
		else if (answer.equals("n")) {
			wrongAnswer(animalTree);
		}
		else{
			playGame(animalTree);
		}	
	}
	
	
	public static void playGame(AnimalTree animalTree){
		Scanner scan = new Scanner(System.in);
		String answer;
		//System.out.println(animalTree.data() + "1");
		if (animalTree.isLeaf()){
			System.out.println("First");
			System.out.println("Were you thinking of a " + animalTree.data());
			answer = scan.next();
			checkLeaves(animalTree, answer);
		}
		else if(!animalTree.left().isLeaf()){
			System.out.println("Second");
			System.out.println(animalTree.data());
			answer = scan.next();
			if (answer.equals("y")){
				System.out.println("Were you thinking of a " + animalTree.visit(animalTree.right()));
				answer = scan.next();
				checkWin(animalTree, answer);
			}
			else if (answer.equals("n")) {
				System.out.println(animalTree.visit(animalTree.left()));
				answer = scan.next();
				if(answer.equals("y")){
					System.out.println("Were you thinking of a " + animalTree.visit(animalTree.left().right()));
					answer = scan.next();
					checkLeaves(animalTree, answer);
				}
				else if(answer.equals("n")){
					System.out.println("Were you thinking of a " + animalTree.visit(animalTree.left().left()));
					answer = scan.next();
					checkWin(animalTree, answer);
				}
				else{
					playGame(animalTree);
				}	
				
			}
		}
		else {
			System.out.println("Third");
			System.out.println(animalTree.data());
			answer = scan.next();
			if (answer.equals("y")){
				System.out.println("Were you thinking of a " + animalTree.visit(animalTree.right()));
				answer = scan.next();
				checkLeaves(animalTree, answer);
			}
			else if (answer.equals("n")) {
				System.out.println("Were you thinking of a " + animalTree.visit(animalTree.left()));
				answer = scan.next();
				checkLeaves(animalTree, answer);;
			}
			else{
				playGame(animalTree);
			}	
		}
	}
	public static void wrongAnswer (AnimalTree animalTree){
		Scanner scan = new Scanner(System.in);

		boolean finished = false;

		if (animalTree.isLeaf()){
			System.out.println("top");
			System.out.println("Doh! What was the animal?");
			AnimalTree newAnimal = new AnimalTree(scan.nextLine());

			System.out.println("What question separates " + newAnimal.data() +  " from " + animalTree.data()+"?");
			String seperateQuestion = scan.nextLine();
			
			while (!finished){
				System.out.println("What is the the correct answer for " + newAnimal.data() + "?");
				String correctAnswer = scan.nextLine();
				if (correctAnswer.equals("y")){
					AnimalTree newNode = new AnimalTree(seperateQuestion,animalTree,newAnimal);
					newNode.writeFile("tree.txt");
					finished = true;
				}else if(correctAnswer.equals("n")){
					AnimalTree newNode = new AnimalTree(seperateQuestion,newAnimal,animalTree);
					newNode.writeFile("tree.txt");
					finished = true;
				}else {
					System.out.println("Just answer the stupid question!");
				}
			}
		}
		else if(!animalTree.left().isLeaf()) {
			System.out.println("middle");
			System.out.println("Doh! What was the animal?");
			AnimalTree newAnimal = new AnimalTree(scan.nextLine());
			System.out.println("What question separates " + newAnimal.data() +  " from " + animalTree.visit(animalTree.left().right())+"?");
			String seperateQuestion = scan.nextLine();
			while (!finished){
				System.out.println("What is the the correct answer for " + newAnimal.data() + "?");
				String correctAnswer = scan.nextLine();
				if (correctAnswer.equals("y")){
					AnimalTree oldAnimal = new AnimalTree(animalTree.visit(animalTree.left().right()));
					AnimalTree newNode = new AnimalTree(seperateQuestion,oldAnimal,newAnimal);
					animalTree.left().setRight(newNode);
					animalTree.writeFile("tree.txt");
					finished = true;
				}else if(correctAnswer.equals("n")){
					AnimalTree oldAnimal = new AnimalTree(animalTree.visit(animalTree.left()));
					AnimalTree newNode = new AnimalTree(seperateQuestion,newAnimal,oldAnimal);
					animalTree.left().setRight(newNode);
			
					animalTree.writeFile("tree.txt");
					finished = true;
				}else {
					System.out.println("Just answer the stupid question!");
				}
			}

		}
		else {
			System.out.println("bottom");
			System.out.println("Doh! What was the animal?");
			AnimalTree newAnimal = new AnimalTree(scan.nextLine());
			System.out.println("What question separates " + newAnimal.data() +  " from " + animalTree.visit(animalTree.left())+"?");
			String seperateQuestion = scan.nextLine();
			while (!finished){
				System.out.println("What is the the correct answer for " + newAnimal.data() + "?");
				String correctAnswer = scan.nextLine();
				if (correctAnswer.equals("y")){
					AnimalTree newNode = new AnimalTree(seperateQuestion,animalTree,newAnimal);
					animalTree.setLeft(newNode);
					animalTree.writeFile("tree.txt");
					finished = true;
				}else if(correctAnswer.equals("n")){
					AnimalTree oldAnimal = new AnimalTree(animalTree.visit(animalTree.left()));
					AnimalTree newNode = new AnimalTree(seperateQuestion,newAnimal,oldAnimal);
					animalTree.setLeft(newNode);
			
					animalTree.writeFile("tree.txt");
					finished = true;
				}else {
					System.out.println("Just answer the stupid question!");
				}
			}
		}

			//AnimalTree newTree = new AnimalTree(newAnimal);
		//}
		
		//System.out.println(animalTree.isRoot()+" 3");
		//System.out.println(animalTree.data()+" 3");
		
		
		
			
	}
}