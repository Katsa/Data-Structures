import static org.junit.Assert.*;

import org.junit.Test;


public class AnimalTreeTest {

	@Test
	public void test() {
		AnimalTree test = new AnimalTree("ADog");
		test.readFile("tree.txt");
	}
	
	@Test
	public void AnimalGameTest(){
		AnimalGame test = new AnimalGame();
		test.play("text.txt", "text.txt");
		
	}
}
