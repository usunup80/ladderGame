package ladderGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class LadderGameTest {

	@Test
	public void test() {
		LadderGame game = new LadderGame(6, 10);
		
		for(int i=1; i<=6; i++){
			System.out.println(i + "번 : " + game.run(i));
		}
	}

	
}
