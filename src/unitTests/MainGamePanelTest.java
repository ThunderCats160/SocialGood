package unitTests;


//Junit Test imports
import static org.junit.Assert.*;

import javax.swing.JPanel;

import main.Game;

import org.junit.Before;
import org.junit.Test;

import panels.MainGamePanel;



public class MainGamePanelTest {
	
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void testInitGUI()
	{
		Game g = new Game(); 
		MainGamePanel mp = new MainGamePanel(g, false); 
		
		assertEquals(2, mp.getComponents().length); 
		
		
		
	}
	
	@Test
	public void testInitLevels(){
		
	}


}
