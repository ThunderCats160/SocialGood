package UnitTest;

//Junit Test imports
import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import Main.Game;
import Panels.SelectPanel;
import Panels.StratPanel;

public class StratPanelTest extends StratPanel {
	
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	
	@Before
	public void setUp()
	{
		Game g = new Game(); 
		stratPanel = new StratPanel(g); 
		
		selectPanel = new SelectPanel(stratPanel, g, null); 
	}
	
	@Test
	public void testSetMaxAvailableMoves(){

		stratPanel.setMaxAvailableMoves(13);
		
		assertEquals(13, stratPanel.currentNumberMovesAvailable); 
		assertEquals(13, stratPanel.getMaxAvailableMoves()); 
	}
	
	
	@Test 
	public void testSetSelectPanel(){
		
		stratPanel.setSelectPanel(selectPanel);  
		assertEquals(selectPanel, stratPanel.getSelectPanel()); 
		
	}
	
	@Test
	public void testDecrementAvailableMoves(){
		stratPanel.setMaxAvailableMoves(13);
		stratPanel.decrementAvailableMoves();
		assertEquals(12, stratPanel.currentNumberMovesAvailable); 
	}
	
	@Test
	public void testReset(){
		
		stratPanel.setSelectPanel(selectPanel); 
		
		stratPanel.add(new JLabel("DSJFKHSKJ")); 
		stratPanel.add(new JLabel("HDKJFDH")); 
		stratPanel.getSelectPanel().setAddToWhile(true);
		stratPanel.setMaxAvailableMoves(10);
		stratPanel.decrementAvailableMoves(); 
		
		stratPanel.reset(false); 
		
		//3, the "Your strategy" label, the "moves remaining" label, and the "clear strategy" button
		assertEquals(3, stratPanel.getComponents().length);
		assertEquals(false, stratPanel.getSelectPanel().getAddToWhile());
		assertEquals(10, stratPanel.currentNumberMovesAvailable); 
		
	}
}
