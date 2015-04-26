package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import Moves.Move;
import Panels.SelectPanel;
import Panels.StratPanel;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class functionMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	JButton functionButton; 
	
	//Constructor
	public functionMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, JButton newFB)
	{		
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		functionButton = newFB; 
	}
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		
		
		if(selectPanel.getRemovingFunction())
		{
			selectPanel.remove(functionButton);
			selectPanel.setRemovingFunction(false); 
			
			selectPanel.setVisible(false);
			selectPanel.setVisible(true); 
			
			return; 
		}
			
		
		
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
		
		stratPanel.revalidate();
		stratPanel.repaint();
		
	}

}