package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import Moves.Move;
import Panels.FunctionCreatingPanel;
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
		
		//System.out.println("OKAY"); 
		//System.out.println(toAdd.getName()); 
		//System.out.println(toAdd.moveList.size()) ;
	}
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		
		//Only add moves if the user still has moves to add
		if(stratPanel.currentNumberMovesAvailable > 0)
		{
			
		
			//Add the selected move to the Strategy Panel 
			if(selectPanel.getAddToWhile())
			{
				stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(toAdd); 
				stratPanel.decrementAvailableMoves();
			
			}
				
			
			else if(selectPanel.addingToFunction)
			{
				
				//No while loops allowed in custom functions
				if(!toAdd.isWhileMove) {
					selectPanel.createFunctionPanel.addMove(toAdd);
				}
			}
			
			else if(selectPanel.getAddToConditional())
			{
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
			
			stratPanel.validate();
			stratPanel.repaint();
			
		}
		
	}

}