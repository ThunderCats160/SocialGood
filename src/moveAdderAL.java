import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

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
		// TODO Auto-generated method stub
		
		//Add the selected move to the Strategy Panel
		if(selectPanel.addingToWhile){
			stratPanel.currentStrat.get(stratPanel.currentStrat.size()-1).moveList.add(toAdd); 
		}
			
		else
			stratPanel.addMove(toAdd); 
		//Add the name of the Strategy to display
		if(selectPanel.addingToWhile)
			stratPanel.add(new JLabel(toAdd.name)); 
		else
			stratPanel.add(new JLabel(toAdd.name)); 
		stratPanel.setVisible(false); 
		stratPanel.setVisible(true); 
		
		
		
	}

}