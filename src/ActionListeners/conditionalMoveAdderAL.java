package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import Main.Board;
import Moves.Move;
import Moves.conditionalMove;
import Panels.MainGamePanel;
import Panels.SelectPanel;
import Panels.StratPanel;

public class conditionalMoveAdderAL implements ActionListener {

	//Variables that are needed to implement the conditional move command
	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	MainGamePanel mgp; 
	private String conditional;
	private JButton redSquare = new JButton("Red Square");
	private JButton bracket = new JButton("}");
	
	
	
	
	//Constructor
	//No returns
	//the parameters are the move, the strategy panel, the select panel and the main game panel that holds everything
	public conditionalMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, MainGamePanel mainPanel)
	{
		toAdd = new conditionalMove("Conditional", m.board, null); 
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
			((conditionalMove) toAdd).setConditionalMove("red square");
			
			
			//System.out.println("TOP"); 
			//System.out.println(""); 
			//Board.printTest(stratPanel.getCurrentStrat());
			
			
			//stratPanel.addMove(toAdd); 
			
			
			
			//System.out.println("");
			//System.out.println("Bottom"); 
			//System.out.println(""); 
			//Board.printTest(stratPanel.getCurrentStrat());
			
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
		
		else if(e.getSource().equals(bracket))
		{
			
			
			
			ArrayList<Move> newMoveList = new ArrayList<Move>(); 
			
			for(int i=  0; i < toAdd.moveList.size(); i ++){
				newMoveList.add(toAdd.moveList.get(i)); 
			}
			
			
			
			stratPanel.add(new JLabel("}"));
			
			selectPanel.removeAll();
			//selectPanel.resetSelectOptions();
			selectPanel.reset(true);
			
			selectPanel.revalidate();
			selectPanel.repaint();
			
			selectPanel.setAddToConditional(false);
			toAdd.moveList = newMoveList; 
			
			
			
		}
		else{
			
		//Only add the move if the user has moves available
			if (stratPanel.currentNumberMovesAvailable > 0) {
				toAdd = new conditionalMove("Conditional", selectPanel.getBoard(), null);
				if(selectPanel.getAddToWhile())
				{
					
					//stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(toAdd); 
					stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(
							toAdd); 
					stratPanel.decrementAvailableMoves();
				}
				else{
					stratPanel.addMove(toAdd);  
				}
				
				//System.out.println(stratPanel.getCurrentStrat().get(0).moveList.size());	
				selectPanel.setAddToConditional(true); 
				
				//System.out.println(stratPanel.getCurrentStrat().get(0).moveList.size());

				ArrayList<Move> newMoveList = new ArrayList<Move>(); 
				newMoveList = fixWhileLoop();
				
				
				
				//selectPanel.resetSelectOptions();	
				displayConditionalOptions();

				//if(stratPanel.getCurrentStrat().size() > 0)
					//stratPanel.getCurrentStrat().get(0).moveList = newMoveList;

				stratPanel.revalidate();
				selectPanel.revalidate();
				
				
				

			}
		}
			
	}
	
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
