package unitTests;

//Junit Test imports
import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import javax.swing.JLabel;

import main.Game;
import moves.RightMove;

import org.junit.Before;
import org.junit.Test;

import panels.SelectPanel;
import panels.StratPanel;

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
	
	@Test
	public void testInitGUI(){
		stratPanel.removeAll(); 
		stratPanel.initGUI();
		
		Dimension dim = stratPanel.getPreferredSize();
		assertEquals(new Dimension((int) Game.APPLET_WIDTH / 5, (int) (Game.APPLET_HEIGHT / 5) * 4), dim); 
		
		//3, the "Your strategy" label, the "moves remaining" label, and the "clear strategy" button
		assertEquals(3, stratPanel.getComponents().length);
	}
	
	@Test
	public void testAddMove(){
		RightMove m = new RightMove("", null, null); 
		stratPanel.setMaxAvailableMoves(4);
		stratPanel.addMove(m); 
		
		
		assertEquals(1, stratPanel.getCurrentStrat().size()); 
		assertEquals(3, stratPanel.currentNumberMovesAvailable); 
	}
}
