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

public class conditionalMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	FunctionCreatingPanel fcp; 
	private String conditional;
	
	
	
	//Constructor
	public conditionalMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, FunctionCreatingPanel newFCP)
	{
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		fcp = newFCP; 
		conditional = null;
	}
	
public void actionPerformed(ActionEvent e) {
		
		
		
		//Only add the move if the user has moves available
		if(stratPanel.currentNumberMovesAvailable > 0)
		{
			//Add the selected move to the Strategy Panel
			stratPanel.addMove(toAdd); 

			stratPanel.add(new JLabel("Conditional(" + conditional + ")")); 
			selectPanel.setAddToConditional(true); 
			
			stratPanel.revalidate();
			selectPanel.revalidate();
		}
		
		
		
		
		
	}
	
}
