package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import moves.Move;
import panels.SelectPanel;
import panels.StratPanel;

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
		
		//checks to see if you are removing a funciton
		if(selectPanel.getRemovingFunction())
		{
			//if you are you remove the function button
			selectPanel.remove(functionButton);
			selectPanel.setRemovingFunction(false); 
			
			//reset the screen
			selectPanel.setVisible(false);
			selectPanel.setVisible(true); 
			
			return; 
		}
			
		//checks to make sure moves can be made
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
		
		//repaints the screen
		selectPanel.getGame().getMainGamePanel().repaint();	
	}

}