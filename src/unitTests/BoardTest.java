package unitTests;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import main.Board;
import main.Game;
import main.Level;
import moves.ConditionalMove;

import org.junit.Before;
import org.junit.Test;

import panels.MainGamePanel;


public class BoardTest {

	MainGamePanel mainPanel;
	Board board;
	Game game;
	
	//Creates the game, mainGamePanel, and board that will be
	//used in the tests
	@Before
	public void setUp()
	{
		game = new Game(); 
		mainPanel = new MainGamePanel(game, false);
		board = new Board(mainPanel);
	}
	
	@Test
	public void setCurrentLevelTest()
	{
		//creates a new level
		Level level = new Level(board.unitDimension, board);
		
		//sets the current level to the newly created level
		board.setCurrentLevel(level);
		
		//checks to make sure the two levels equal each other
		assertEquals(board.getCurrentLevel(), level);
	}
	
	@Test
	public void initGUITest()
	{
		//runs the function being tested
		board.initGUI();
		
		//creates the dimensions that the should be in the size after
		//this function is run
		Dimension boardP = new Dimension((int)((Game.APPLET_WIDTH/5) * 3) - 90, (int)(Game.APPLET_HEIGHT/5) * 4 + 20);
		
		//checks to make sure they are equal
		assertEquals(board.getSize(), boardP);
	}
	

	
	@Test
	public void checkConditionalTest()
	{

		//creates a conditional move, which is going to have components that will be checked
		ConditionalMove move = new ConditionalMove("", null, null);
		
		//sets the condition string which should be red square, so the 
		//function should return false when ran
		move.setConditionalMove("blue square");
		
		//gets the actual and expected booleans
		Boolean actual = board.checkConditional(move);
		Boolean expected = false;
		
		//checks the booleans
		assertEquals(actual, expected);
		
	}
	
	

}
