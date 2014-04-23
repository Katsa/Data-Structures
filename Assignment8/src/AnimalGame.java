import java.util.Scanner;

public class AnimalGame {
	public static void play(String inputFile, String outputFile){
		Scanner scan = new Scanner(System.in);
		AnimalTree animalTree = AnimalTree.readFile(inputFile);
		System.out.println("Would you like to play a game?(y/n)");
		String answer = scan.nextLine();
		if (answer.equals("y")){
			askQuestion(animalTree,scan,outputFile);
			System.out.println("hey");
			//animalTree.writeFile(outputFile);
			play(outputFile,outputFile);
		}
		else if (answer.equals("n")){
			System.out.println("HAHA sucka, you missing out!");
		}
		else
		{System.out.println("Stop Playin'");
		play(inputFile,outputFile);
		}
	}
	
	
	public static void askQuestion(AnimalTree animalTree, Scanner scan,String outputFile){
		String answer;
		if (animalTree.isLeaf()){
			finalGuess(animalTree,scan,outputFile);
		}
		else{
			System.out.println(animalTree.data());
			answer = scan.next();
			if (answer.equals("y")){
				askQuestion(animalTree.right(),scan,outputFile);
			}
			else if (answer.equals("n")){
				askQuestion(animalTree.left(),scan,outputFile);
			}
			else {
				askQuestion(animalTree,scan,outputFile);
			}
		}
	}
	
	public static void finalGuess(AnimalTree animalTree, Scanner scan,String outputFile ){
		//System.out.println(animalTree.data());
		String answer;
		System.out.println("Were you thinking of a " + animalTree.data() + "?" );
		answer = scan.next();
		if (answer.equals("y")){
			System.out.println("Sweet!");
			
		}
		else if (answer.equals("n")) {
			wrongAnswer(animalTree, outputFile);
		}
		else{
			finalGuess(animalTree,scan,outputFile);
		}	
	}
	public static void firstWrongAnswer (AnimalTree animalTree, String outputfile){
		
	}
	public static void wrongAnswer (AnimalTree animalTree, String outputFile){
		Scanner scan = new Scanner(System.in);
		boolean finished = false;
		System.out.println("Dang! What was the animal?");
		String answer = scan.nextLine();
		AnimalTree newAnimal = new AnimalTree(answer);
		System.out.println("What question separates " + newAnimal.data() +  " from " + animalTree.data()+"?");
		
		if (animalTree.isRoot()){
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
					newNode.writeFile(outputFile);
					
				}else if(correctAnswer.equals("n")){
					AnimalTree newNode = new AnimalTree(seperateQuestion,newAnimal,animalTree);
					newNode.writeFile(outputFile);
					
				}else {
					System.out.println("Just answer the stupid question!");
				}
				finished = true;
			}
		}
		else {
		AnimalTree parentNode = animalTree.parent();
		System.out.println("Dang! What was the animal?");
		String answer = scan.nextLine();
		AnimalTree newAnimal = new AnimalTree(answer);
		System.out.println("What question separates " + newAnimal.data() +  " from " + animalTree.data()+"?");
//		System.out.println("What question separates dog from " + animalTree.data()+"?");
//		AnimalTree newAnimal = new AnimalTree("dog");
		
		String seperateQuestion = scan.nextLine();
//		String seperateQuestion = "this question";
		while (!finished){
			System.out.println("What is the the correct answer for " + newAnimal.data() + "?");
			String correctAnswer = scan.nextLine();
			System.out.println(correctAnswer);
			if (correctAnswer.equals("y")){
				if (animalTree.parent().left() == animalTree){
					AnimalTree newNode = new AnimalTree(seperateQuestion,animalTree,newAnimal);
					parentNode.setLeft(newNode);
					newNode.writeFile(outputFile);

				}
				else {
					AnimalTree newNode = new AnimalTree(seperateQuestion,animalTree,newAnimal);
					parentNode.setRight(newNode);
					System.out.println("hey right");
					newNode.writeFile(outputFile);
				}
				System.out.println("hey3");
				finished = true;
			}else if(correctAnswer.equals("n")){
				if (animalTree.parent().left() == animalTree){
					AnimalTree newNode = new AnimalTree(seperateQuestion,newAnimal,animalTree);
					parentNode.setLeft(newNode);
					newNode.writeFile(outputFile);
				}
				else {
					AnimalTree newNode = new AnimalTree(seperateQuestion,newAnimal,animalTree);
					parentNode.setRight(newNode);
					newNode.writeFile(outputFile);
				}
				finished = true;
			}else {
				System.out.println("Just answer the stupid question!");
			}
		}
		System.out.println("hey2");
		if (animalTree.isRoot()){
		}
			
	}
	}
}