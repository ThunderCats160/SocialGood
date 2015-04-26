package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Moves.Move;
import Panels.FunctionCreatingPanel;
import Panels.SelectPanel;
import Panels.StratPanel;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class whileMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	FunctionCreatingPanel fcp; 
	
	
	
	//Constructor
	public whileMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, FunctionCreatingPanel newFCP)
	{
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		fcp = newFCP; 
	}
	
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		
		if(selectPanel.addingToFunction)
		{
			fcp.addMove(toAdd); 
			fcp.revalidate(); 
		}
		else
		{
			if(stratPanel.currentNumberMovesAvailable > 0)
			{
				//Add the selected move to the Strategy Panel
				stratPanel.addMove(toAdd); 

				stratPanel.add(new JLabel("While(true):")); 
				selectPanel.setAddToWhile(true); 
				
				stratPanel.revalidate();
				selectPanel.revalidate();
			}
			
		}
		
		
		
		
		
	}

}