package unitTests;


//Junit Test imports
import static org.junit.Assert.*;

import javax.swing.JPanel;

import main.Game;

import org.junit.Test;

import panels.MainGamePanel;



public class MainGamePanelTest {
	
	
	
	
	@Test
	public void testInitGUI()
	{
		Game g = new Game(); 
		MainGamePanel mp = new MainGamePanel(g, false); 
		
		
		
		
	}


}
