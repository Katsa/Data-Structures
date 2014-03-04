import static org.junit.Assert.*;
import org.junit.*;

/**
 * Some test cases for the tic tac toe game
 * 
 * @author dkauchak
 *
 */
public class Tests {
	// ---------------------------------------------
	// tests for the Mark class
	@Test
	public void testMarkToString(){
		for( int i = 0; i < 8; i++ ){
			Mark temp = new Mark(i);
			assertEquals(temp.toString(), Integer.toString(i));
		}
	}
	
	@Test
	public void testMarkIsEmpty(){
		Mark temp = new Mark(3);
		assertTrue(temp.isEmpty());
	}
	
	@Test
	public void testMarkEquals(){
		Mark temp = new Mark(3);
		Mark temp2 = new Mark(4);
		Mark temp3 = new Mark(3);
		
		assertTrue(temp.equals(temp));
		assertTrue(temp.equals(temp3));
		assertFalse(temp.equals(temp2));
	}
	
	// ---------------------------------------------
	// tests for the XOMark class
	@Test
	public void testXOMarkToString(){
		XOMark temp = new XOMark(0, true);
		assertEquals(temp.toString(), "X");
		
		temp = new XOMark(1, false);
		assertEquals(temp.toString(), "O");
	}
	
	@Test
	public void testXOMarkIsEmpty(){
		XOMark temp = new XOMark(3, true);
		assertFalse(temp.isEmpty());
		
		temp = new XOMark(7, false);
		assertFalse(temp.isEmpty());
	}
	
	// ---------------------------------------------
	// tests for the Board class
	@Test
	public void testBoardConstructor(){
		Board board = new Board();
		
		for( int i = 0; i < 9; i++ ){
			assertTrue(board.getMark(i) != null);
			assertTrue(board.getMark(i).isEmpty());
		}
	}
	
	@Test
	public void testBoardAddX(){
		Board board = new Board();
		int position = 8;
		board.addXO(position, true);
		
		for( int i = 0; i < 9; i++ ){
			assertTrue(board.getMark(i) != null);
			
			if( i == position ){
				assertEquals(board.getMark(i).toString(), "X");
			}
		}
	}
	
	@Test
	public void testBoardAddO(){
		Board board = new Board();
		int position = 3;
		board.addXO(position, false);
		
		for( int i = 0; i < 9; i++ ){
			assertTrue(board.getMark(i) != null);
			
			if( i == position ){
				assertEquals(board.getMark(i).toString(), "O");
			}
		}
	}
	
	@Test
	public void testBoardGameOver1(){
		// check to see that once the board gets filled in  with X's
		// and Os, the game is over (i.e. a tie)
		
		// board is
		// X X O
		// O O X
		// X O X
		Board board = new Board();
		board.addXO(0, true);
		board.addXO(1, true);
		board.addXO(2, false);
		board.addXO(3, false);
		board.addXO(4, false);
		board.addXO(5, true);
		board.addXO(6, true);
		board.addXO(7, false);
		board.addXO(8, true);
		
		assertTrue(board.gameOver());
	}
	
	@Test
	public void testBoardGameOver2(){
		// check a horizontal row
		Board board = new Board();
		board.addXO(0, true);
		board.addXO(1, true);
		board.addXO(2, true);
	
		// HINT: If you're failing this, remember to use
		// .equals on objects, NOT ==
		assertTrue(board.gameOver());
	}
	
	@Test
	public void testBoardGameOver3(){
		// check a vertical column
		Board board = new Board();
		board.addXO(0, false);
		board.addXO(3, false);
		board.addXO(6, false);
		
		assertTrue(board.gameOver());
	}
	
	@Test
	public void testBoardGameOver4(){
		// check a horizontal row that doesn't have a win
		Board board = new Board();
		board.addXO(0, true);
		board.addXO(1, false);
		board.addXO(2, true);
		
		assertFalse(board.gameOver());
	}
	
	@Test
	public void testBoardGameOver5(){
		// check a vertical column that doesn't have a win
		Board board = new Board();
		board.addXO(0, false);
		board.addXO(3, true);
		board.addXO(6, false);
		
		assertFalse(board.gameOver());
	}
}