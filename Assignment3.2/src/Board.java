public class Board {

private Mark[] board = new Mark[9];
private boolean over = false;

public Board() {

	for (int i = 0; i<board.length;i++) {
		board [i] = new Mark(i);
	}
}

public void addXO(int number, boolean isX) {
	board[number] = new XOMark(number, isX);
}

public Mark getMark(int number) {
	return board[number];
}

public boolean hasWin() {
	boolean over = false;
	//sideways
	if (board[0].toString().equals(board[1].toString()) && board[0].toString().equals(board[2].toString())){
		over = true;
	}
	if (board[3].toString().equals(board[4].toString()) && board[3].toString().equals(board[5].toString())){
		over = true;
	}
	if (board[6].toString().equals(board[7].toString()) && board[6].toString().equals(board[8].toString())){
		over = true;
	}
	//down
	if (board[0].toString().equals(board[3].toString()) && board[0].toString().equals(board[6].toString())){
		over = true;
	}
	if (board[1].toString().equals(board[4].toString()) && board[1].toString().equals(board[7].toString())){
		over = true;
	}
	if (board[2].toString().equals(board[5].toString()) && board[2].toString().equals(board[8].toString())){
		over = true;
	}
	//diagonal
	if (board[0].toString().equals(board[4].toString()) && board[0].toString().equals(board[8].toString())){
		over = true;
	}
	if (board[2].toString().equals(board[4].toString()) && board[2].toString().equals(board[6].toString())){
		over = true;
	}
	return over;
}

public boolean gameOver() {
	for(int i = 0; i < board.length(); i++) {
		int count = 0;
		if(board[i].isEmpty() == false) {
			count += 1;
		}
	}
	if(count == 9) {
		over = true;
	}


	return over;
}

public String toString() {
	String row1 = "";
	String row2 = "";
	String row3 = "";
	String fullBoard = "";

	for(int i = 0; i < 3; i++) {
		if(board[i].isEmpty() == false) {
			row1 += board[i].toString() + " ";
		}
		else {
			String pos = Integer.toString(i+1);
			row1 += pos  + " ";
		}
	}

	for(int i = 0; i < 3; i++) {
		if(board[i].isEmpty() == false) {
			row2 += board[i].toString() + " ";
		}
		else {
			String pos = Integer.toString(i+4);
			row2 += (pos) + " ";
		}
	}

	for(int i = 0; i < 3; i++) {
		if(board[i].isEmpty() == false) {
			row3 += board[i].toString() + " ";
		}
		else {
			String pos = Integer.toString(i+7);
			row3 += (pos) + " ";
		}
	}

	fullBoard = row1 + "/n" + row2 + "/n" + row3;
	return fullBoard;
}


}