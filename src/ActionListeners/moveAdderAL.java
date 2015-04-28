package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Main.Board;
import Moves.Move;
import Moves.WhileMove;
import Moves.conditionalMove;
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
		
		System.out.println("HERE"); 
		//Only add moves if the user still has moves to add
		if(stratPanel.currentNumberMovesAvailable > 0)
		{
			
			
			
			//System.out.println("HERE");
			//System.out.println(selectPanel.getAddToWhile()); 
			//System.out.println(selectPanel.getAddToConditional()); 
			
		
			//Add the selected move to the Strategy Panel 
			if(selectPanel.getAddToWhile())
			{
				//System.out.println(stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).getClass().getName());
				
				//If the select panel is adding to a while move, the while move must be the most
				//recent thing added to the current strategy, and thus must be in the last place
				WhileMove whileMove = (WhileMove) stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1); 
				
				//There could be a conditional statement inside of a whileLoop, so we need
				//to make this check. 
				if(selectPanel.getAddToConditional()){
					
					//If its adding to a conditional, the conditional must be the most recent
					//thing added to the current strategy, and thus must be in the last place
					
					conditionalMove conMove = (conditionalMove) whileMove.getMoveList().get(whileMove.getMoveList().size() -1); 
					conMove.moveList.add(toAdd); 
				}
				else
				{
					whileMove.moveList.add(toAdd);
				}
				
				
				
				
				 
				stratPanel.decrementAvailableMoves();
				
				
			
			}
				
			
			else if(selectPanel.addingToFunction)
			{
				
				//No while loops allowed in custom functions
				if(!toAdd.isWhileMove) {
					
					//Check if there are move slots left in the function
					if(selectPanel.getCurrentNumberAvailableMovesInFunction() > 0){
						
						//System.out.println(selectPanel.getCurrentNumberAvailableMovesInFunction()); 
						selectPanel.createFunctionPanel.addMove(toAdd);
						selectPanel.decrementCurrentNumberAvailableMovesInFunction();
						
					}
					
					
				}
			}
			
			else if(selectPanel.getAddToConditional())
			{
				
				if(!toAdd.isWhileMove) {
					stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(toAdd);
					//System.out.println(stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.size());
					stratPanel.decrementAvailableMoves();
					
					//Board.printTest(stratPanel.getCurrentStrat());
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
			
			stratPanel.validate();
			stratPanel.repaint();
			
		}
		
	}

}