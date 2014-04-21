import java.util.Scanner;

public class AnimalGame {
	public static void play(String inputFile, String outputFile){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to play a game?(y/n)");
		String answer = scan.nextLine();
		if (answer.equals("y")){
			playGame(AnimalTree.readFile(inputFile));
		}
		else if (answer == "n"){
			System.out.println("Too Bad, So Sad!");
		}
		else
		{System.out.println("Stop Messing Around");
		System.out.println(answer);
		
		}
	}
	
	
	public static void playGame(AnimalTree animalTree){
		Scanner scan = new Scanner(System.in);
		String answer;
		System.out.println(animalTree.data());
		if (animalTree.isLeaf()){
			System.out.println("Were you thinking of a " + animalTree.data());
			answer = scan.next();
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
		else{
			System.out.println(animalTree.data());
			answer = scan.next();
			if (answer.equals("y")){
				System.out.println("Were you thinking of a " + animalTree.data());
			}
		}
	}
	public static void wrongAnswer (AnimalTree animalTree){
		Scanner scan = new Scanner(System.in);
		System.out.println("Doh! What was the animal?");
		AnimalTree newAnimal = new AnimalTree(scan.nextLine());
		System.out.println("What question separates " + newAnimal.data() +  " from " + animalTree.data()+" ?");
		String seperateQuestion = scan.nextLine();
		boolean finished = false;
		while (!finished){
			System.out.println("What is the the correct answer for " + newAnimal.data() + "?");
			String correctAnswer = scan.nextLine();
			if (correctAnswer.equals("y")){
				AnimalTree newNode = new AnimalTree(seperateQuestion,animalTree,newAnimal);
				finished = false;
			}else if(correctAnswer.equals("n")){
				AnimalTree newNode = new AnimalTree(seperateQuestion,newAnimal,animalTree);
				finished = false;
			}else {
				System.out.println("Just answer the stupid question!");
			}
		}
		if (animalTree.isRoot()){
		}
			
	}
}