package Moves;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import Panels.SelectPanel;
import Panels.StratPanel;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class moveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	
	//Constructor
	public moveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel)
	{		
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
	}
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		
		//Add the selected move to the Strategy Panel
		if(selectPanel.getAddToWhile()){
			stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(toAdd); 
		}
			
		else
			stratPanel.addMove(toAdd); 
		//Add the name of the Strategy to display
		if(selectPanel.getAddToWhile() == true){
			stratPanel.add(new JLabel(toAdd.name));
		} else {
			stratPanel.add(new JLabel(toAdd.name)); 
		}
		stratPanel.setVisible(false); 
		stratPanel.setVisible(true); 
		stratPanel.revalidate();
		stratPanel.repaint();
		
	}

}