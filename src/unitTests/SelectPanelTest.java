package unitTests;

//Junit Test imports
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import main.Game;
import main.Level;

import org.junit.Before;
import org.junit.Test;

import panels.MainGamePanel;
import panels.StratPanel;

public class SelectPanelTest {
	
	StratPanel stratPanel; 
	MainGamePanel mainPanel;
	
	//Sets up the game, stratPanel and mainGamePanel that 
	//will be used in the test
	@Before
	public void setUp()
	{
		Game g = new Game(); 
		stratPanel = new StratPanel(g); 
		mainPanel = new MainGamePanel(g, false);
	}
	
	//Tests to make sure it loads in the correct number
	//of functions from each level
	@Test
	public void testNumberOfFunctions(){
		mainPanel.setCurrentLevelIndex(1);
		
		ArrayList<Level> testlevels = new ArrayList<Level>();
		testlevels = mainPanel.getLevels();
		int expected = testlevels.get(1).getAvailableMoves().size();
		assertEquals(2,expected,0);
		
	}
	

}
