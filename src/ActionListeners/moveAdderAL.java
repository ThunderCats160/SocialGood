package actionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import moves.ConditionalMove;
import moves.Move;
import moves.WhileMove;
import panels.SelectPanel;
import panels.StratPanel;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class MoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	
	//Constructor
	public MoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel)
	{		
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		

	}
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		
		//Only add moves if the user still has moves to add
		if(stratPanel.currentNumberMovesAvailable > 0)
		{
					
			//Add the selected move to the Strategy Panel 
			if(selectPanel.getAddToWhile())
			{
				
				//If the select panel is adding to a while move, the while move must be the most
				//recent thing added to the current strategy, and thus must be in the last place
				WhileMove whileMove = (WhileMove) stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1); 
				
				//There could be a conditional statement inside of a whileLoop, so we need
				//to make this check. 
				if(selectPanel.getAddToConditional()){
					
					//If its adding to a conditional, the conditional must be the most recent
					//thing added to the current strategy, and thus must be in the last place
					
					ConditionalMove conMove = (ConditionalMove) whileMove.getMoveList().get(whileMove.getMoveList().size() -1); 
					conMove.moveList.add(toAdd); 
				}
				else
				{
					whileMove.moveList.add(toAdd);
				}
				
				
				
				
				 //decrements the amount of available moves for the user
				stratPanel.decrementAvailableMoves();
				
				
			
			}
				
			//checks if you are adding to a function
			else if(selectPanel.addingToFunction)
			{
				
				//No while loops allowed in custom functions
				if(!toAdd.isWhileMove) {
					
					//Check if there are move slots left in the function
					if(selectPanel.getCurrentNumberAvailableMovesInFunction() > 0){
						
						//adds the move to the function move list
						//and decrements the moves available in the function
						selectPanel.createFunctionPanel.addMove(toAdd);
						selectPanel.decrementCurrentNumberAvailableMovesInFunction();
						
					}
					
					
				}
			}
			
			//checks if the moves are being added to the conditional
			else if(selectPanel.getAddToConditional())
			{
				//checks to see if the move is not a while move
				if(!toAdd.isWhileMove) {
					stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(toAdd);
					stratPanel.decrementAvailableMoves();
				}
			}
			
			else{
				stratPanel.addMove(toAdd); 
				 
			}
				
			
			//Add the name of the Strategy to display
			if(selectPanel.getAddToWhile() == true){
				stratPanel.add(new JLabel(toAdd.name));
			} else if(!selectPanel.addingToFunction){
				stratPanel.add(new JLabel(toAdd.name));
				
			}
			
			//resets the screen
			
			stratPanel.validate();
			stratPanel.repaint();
			
		}
		
	}

}