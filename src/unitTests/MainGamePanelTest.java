package unitTests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Level; 


//Junit Test imports
import main.Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import panels.MainGamePanel;



public class MainGamePanelTest {
	
	MainGamePanel mainGamePanel; 
	
	@Before
	public void setup(){
		mainGamePanel = new MainGamePanel(new Game(), false); 
	}
	
	//InitGUI should put 2 components onto mainGamePanel, the north and the south 
	//component
	@Test
	public void testInitGUI()
	{
		assertEquals(2, mainGamePanel.getComponents().length); 		
	}
	
	//Makes sure all 8 levels of the game are properly added
	@Test
	public void testInitLevels(){
		mainGamePanel.initLevels(false);
		assertEquals(8, mainGamePanel.getLevels().size());
	}
	
	//Tests that the mainGamePanel's level list can be set properly
	@Test
	public void testSetLevels(){
		ArrayList<Level> myLevels = new ArrayList<Level>(); 
		myLevels.add(new Level(12, null)); 
		
		mainGamePanel.setLevels(myLevels);
		
		
		assertEquals(myLevels, mainGamePanel.getLevels()); 

	}


}
