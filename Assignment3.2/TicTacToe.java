import java.util.Scanner;

public class TicTacToe {
	
	private Board board;

	public TicTacToe() {
		TicTacToe ttt = new TicTacToe;
	

	}

	public void playGame() {
		
		boolean over = false;
		
		
		while(over != true) {
			printLines();
			if(board.hasWin() == true)
				over = true;
			
		}
			
	}
	
	
	private void printLines() {
		
		Scanner scan = new Scanner(System.in);
		
		board.toString();
		
		System.out.println("Pick a move X: ");
		int userChoiceX = scan.nextInt();
		
		board.toString();
		
		System.out.println("Pick a move O: ");
		int userChoiceO = scan.nextInt();
		
		if(userChoiceX == 1) {
			board.addXO(0, true);
		}
		else if(userChoiceX == 2) {
			board.addXO(1, true);
		}
		else if(userChoiceX == 3) {
			board.addXO(2, true);
		}
		else if(userChoiceX == 4) {
			board.addXO(3, true);
		}
		else if(userChoiceX == 5) {
			board.addXO(4, true);
		}
		else if(userChoiceX == 6) {
			board.addXO(5, true);
		}
		else if(userChoiceX == 7) {
			board.addXO(6, true);
		}
		else if(userChoiceX == 8) {
			board.addXO(7, true);
		}
		else if(userChoiceX == 9) {
			board.addXO(8, true);
		}
		else {
			System.out.println(Integer.toString(userChoiceX) + " is not a valid move");
		}
		
		if(userChoiceO == 1) {
			board.addXO(0, false);
		}
		else if(userChoiceO == 2) {
			board.addXO(1, false);
		}
		else if(userChoiceO == 3) {
			board.addXO(2, false);
		}
		else if(userChoiceO == 4) {
			board.addXO(3, false);
		}
		else if(userChoiceO == 5) {
			board.addXO(4, false);
		}
		else if(userChoiceO == 6) {
			board.addXO(5, false);
		}
		else if(userChoiceO == 7) {
			board.addXO(6, false);
		}
		else if(userChoiceO == 8) {
			board.addXO(7, false);
		}
		else if(userChoiceO == 9) {
			board.addXO(8, false);
		}
		else {
			System.out.println(Integer.toString(userChoiceO) + " is not a valid move");
		}
	
	}
}