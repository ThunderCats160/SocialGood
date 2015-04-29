package actionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import moves.Move;
import moves.WhileMove;
import panels.FunctionCreatingPanel;
import panels.SelectPanel;
import panels.StratPanel;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class WhileMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	FunctionCreatingPanel fcp; 
	
	
	
	//Constructor
	public WhileMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, FunctionCreatingPanel newFCP) {
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		fcp = newFCP; 
	}
	
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		
		if(selectPanel.addingToFunction)
		{
			//fcp.addMove(toAdd); 
			fcp.revalidate(); 
			selectPanel.getGame().getMainGamePanel().repaint();
		} else {
			//Only add the move if the user has moves available
			if(stratPanel.currentNumberMovesAvailable > 0) {
				//Add the selected move to the Strategy Panel
				stratPanel.addMove(new WhileMove("While", selectPanel.getBoard(), null)); 

				stratPanel.add(new JLabel("LOOP:")); 
				selectPanel.setAddToWhile(true); 
				
				selectPanel.getGame().getMainGamePanel().repaint();
			}
			
		}
		
		
		
		
		
	}

}