package actionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import buttons.MoveButton;
import panels.MainGamePanel;
import panels.SelectPanel;
import panels.StratPanel;
import main.Board;
import moves.Move;
import moves.ConditionalMove;

public class ConditionalMoveAdderAL implements ActionListener {

	//Variables that are needed to implement the conditional move command
	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	MainGamePanel mgp; 
	private String conditional;
	private MoveButton redSquare = new MoveButton("Red Square", 15);
	private MoveButton bracket = new MoveButton("}", 15);
	
	
	
	
	//Constructor
	//No returns
	//the parameters are the move, the strategy panel, the select panel and the main game panel that holds everything
	public ConditionalMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, MainGamePanel mainPanel)
	{
		toAdd = new ConditionalMove("Conditional", m.board, null); 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		mgp = mainPanel; 
		conditional = null;
	
	}
	
	//This function changes what is displayed when the user selects the option for the conditional command
	//there are no returns 
	//there are no parameters
	public void displayConditionalOptions()
	{
		//this removes all the items that were originally on the select panel
		selectPanel.removeAll();
		//selectPanel.resetSelectOptions();
		
		//this adds action listeners to the buttons that are being added to the select panel now
		redSquare.addActionListener(this);
		bracket.addActionListener(this);
	
		//this adds the option to choose red square, the only option given
		selectPanel.add(redSquare);
		
		//this resets the screen
		selectPanel.revalidate();
		selectPanel.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		//checks to see if the button that was pressed was the red square button
		if(e.getSource().equals(redSquare))
		{
			
			//this sets the conditional statement to red square so it can write that
			//on the strat panel
			conditional = "Red Square";
			((ConditionalMove) toAdd).setConditionalMove("red square");
			
			
			//this adds the move to the strategy panel
			stratPanel.add(new JLabel("Conditional(" + conditional + ") {")); 
			
			//this removes the red square button and resets the original buttons
			selectPanel.removeAll();
			selectPanel.reset(false);
			
			//adds a closing bracket button to finish out the conditional
			selectPanel.add(bracket);
			
			//this resets the screen
			selectPanel.revalidate();
			selectPanel.repaint();
			
		}
		
		//checks to see if the bracket button was pressed
		else if(e.getSource().equals(bracket))
		{
			
			
			//creates an array list of moves to add the moves of the conditional to it
			ArrayList<Move> newMoveList = new ArrayList<Move>(); 
			
			//puts the moves that are currently in the conditional move list to this newly created one
			for(int i=  0; i < toAdd.moveList.size(); i ++){
				newMoveList.add(toAdd.moveList.get(i)); 
			}
			
			
			//adds the bracket to the end of the conditional
			stratPanel.add(new JLabel("}"));
			
			//removes then resets the options available to be used
			selectPanel.removeAll();
			selectPanel.reset(true);
			
			//resets the screen
			selectPanel.revalidate();
			selectPanel.repaint();
			
			//makes sure no more moves are added to the conditional move list
			selectPanel.setAddToConditional(false);
			
			//sets the move list of the conditional back to what it was because it was deleted
			toAdd.moveList = newMoveList; 
			
			
			
		}
		
		//this means that the conditional button was pressed
		else{
			
			//Only add the move if the user has moves available
			if (stratPanel.currentNumberMovesAvailable > 0) {
				
				//creates a new conditional move
				toAdd = new ConditionalMove("Conditional", selectPanel.getBoard(), null);
				
				if(selectPanel.getAddToWhile())
				{
					//adds the move to the while move list if it is inside a loop
					stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(
							toAdd); 
					
					//decrements the amount of moves available
					stratPanel.decrementAvailableMoves();
				}
				//if it is not a while loop, it just adds the move the the strategy panel
				else{
					stratPanel.addMove(toAdd);  
				}
				
				//sets the conditional true so all the moves added after this will be in the conditional statement
				selectPanel.setAddToConditional(true); 
				
				//creates a movelist to make sure the move list stays with loop
				ArrayList<Move> newMoveList = new ArrayList<Move>(); 
				
				//gets the move list and saves it here
				newMoveList = fixWhileLoop();
				
				
				
				//selectPanel.resetSelectOptions();	
				
				
				//runs the function for the conditional
				displayConditionalOptions();

				//if(stratPanel.getCurrentStrat().size() > 0)
					//stratPanel.getCurrentStrat().get(0).moveList = newMoveList;

				//resets the screen
				stratPanel.revalidate();
				selectPanel.revalidate();
				
				
				

			}
		}
			
	}
	
	//this function transfers the move list of while loop into a new move list and returns
	//that move list
	//no parameters
	public ArrayList<Move> fixWhileLoop()
	{
		ArrayList<Move> newMoveList = new ArrayList<Move>(); 
		
		if(stratPanel.getCurrentStrat().size() > 0){
			for(int i=  0; i < stratPanel.getCurrentStrat().get(0).moveList.size(); i ++){
				newMoveList.add(stratPanel.getCurrentStrat().get(0).moveList.get(i)); 
			}	
		}
		
		
		return newMoveList;
	
	}

}
