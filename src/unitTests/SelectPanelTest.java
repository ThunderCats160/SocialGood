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
	
	@Before
	public void setUp()
	{
		Game g = new Game(); 
		stratPanel = new StratPanel(g); 
		mainPanel = new MainGamePanel(g, false);
	}
	
	@Test
	public void testNumberOfFunctions(){
		mainPanel.setCurrentLevelIndex(1);
		
		ArrayList<Level> testlevels = new ArrayList<Level>();
		testlevels = mainPanel.getLevels();
		int expected = testlevels.get(1).getAvailableMoves().size();
		assertEquals(2,expected,0);
		
	}
	

}
