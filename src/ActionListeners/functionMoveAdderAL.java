package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import panels.SelectPanel;
import panels.StratPanel;
import moves.Move;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class FunctionMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	JButton functionButton; 
	
	//Constructor
	public FunctionMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, JButton newFB)
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
			
		
		if(stratPanel.currentNumberMovesAvailable > 0){
			//Add the selected move to the Strategy Panel
			if(selectPanel.getAddToWhile()){
				stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(toAdd);
				stratPanel.decrementAvailableMoves();
			}
				
			else{
				stratPanel.addMove(toAdd); 
			}
			//Add the name of the Strategy to display
			stratPanel.add(new JLabel(toAdd.name));
		}
		
		
		selectPanel.getGame().getMainGamePanel().repaint();	
	}

}