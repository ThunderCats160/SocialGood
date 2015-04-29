package unitTests;

import static org.junit.Assert.*;
import main.Game;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	Game game; 
	
	@Before
	public void setup(){
		game = new Game(); 
	}
	
	//Tests startNewGame by making sure the game switches to the correct applet view
	// and that the game successfully sets up the mainGamePanel
	@Test
	public void startNewGameTest(){
		game.startNewGame(false);
		assertEquals("Main Game", game.getActiveView());
		assertNotNull(game.mainGamePanel); 
	}

}
