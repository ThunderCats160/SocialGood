package unitTests;
import java.util.ArrayList;

import main.Level; 


//Junit Test imports
import main.Game;

import org.junit.Before;
import org.junit.Test;

import panels.MainGamePanel;



public class MainGamePanelTest {
	
	MainGamePanel mainGamePanel; 
	
	@Before
	public void setup(){
		mainGamePanel = new MainGamePanel(new Game(), false); 
	}
	
	@Test
	public void testInitGUI()
	{
		assertEquals(2, mainGamePanel.getComponents().length); 		
	}
	
	@Test
	public void testInitLevels(){
		mainGamePanel.initLevels(false);
		assertEquals(8, mainGamePanel.getLevels().size());
	}
	
	@Test
	public void testSetLevels(){
		ArrayList<Level> myLevels = new ArrayList<Level>(); 
		myLevels.add(new Level(12, null)); 
		
		mainGamePanel.setLevels(myLevels);
		
		
		assertEquals(myLevels, mainGamePanel.getLevels()); 

	}


}
