package Moves;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Panels.SelectPanel;
import Panels.StratPanel;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class whileMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	
	
	
	//Constructor
	public whileMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel)
	{
		
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
	}
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Add the selected move to the Strategy Panel
		stratPanel.addMove(toAdd); 

		stratPanel.add(new JLabel("While(true):")); 
		selectPanel.setAddToWhile(true); 
		//Flicker the panel to make the change visible
		stratPanel.setVisible(false); 
		stratPanel.setVisible(true); 
		
		
		
	}

}