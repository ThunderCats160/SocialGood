package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import Moves.Move;
import Moves.conditionalMove;
import Panels.MainGamePanel;
import Panels.SelectPanel;
import Panels.StratPanel;

public class conditionalMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	MainGamePanel mgp; 
	private String conditional;
	private JButton redSquare = new JButton("Red Square");
	private JButton bracket = new JButton("}");
	
	
	
	
	//Constructor
	public conditionalMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, MainGamePanel mainPanel)
	{
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		mgp = mainPanel; 
		conditional = null;
	
	}
	
	public void displayConditionalOptions()
	{
		selectPanel.removeAll();
		selectPanel.resetSelectOptions();
		
		
		redSquare.addActionListener(this);
		bracket.addActionListener(this);
	
		selectPanel.add(redSquare);
		
		selectPanel.revalidate();
		selectPanel.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource().equals(redSquare))
		{
			conditional = "Red Square";
			((conditionalMove) toAdd).setConditionalMove("red square");
			stratPanel.addMove(toAdd); 
			stratPanel.add(new JLabel("Conditional(" + conditional + ") {")); 
			selectPanel.removeAll();
			selectPanel.reset(false);
			selectPanel.add(bracket);
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
			selectPanel.resetSelectOptions();
			selectPanel.reset(true);
			
			selectPanel.revalidate();
			selectPanel.repaint();
			
			selectPanel.setAddToConditional(false);
			toAdd.moveList = newMoveList; 
			
			
			
		}
		else{
			
		//Only add the move if the user has moves available
			if (stratPanel.currentNumberMovesAvailable > 0) {
				if(selectPanel.getAddToWhile())
				{
					stratPanel.getCurrentStrat().get(stratPanel.getCurrentStrat().size()-1).moveList.add(toAdd); 
					stratPanel.decrementAvailableMoves();
				}
				
				//System.out.println(stratPanel.getCurrentStrat().get(0).moveList.size());
				

				
				selectPanel.setAddToConditional(true); 
				
				//System.out.println(stratPanel.getCurrentStrat().get(0).moveList.size());

				ArrayList<Move> newMoveList = new ArrayList<Move>(); 
				newMoveList = fixWhileLoop();
				
				
				
				selectPanel.resetSelectOptions();
				

				
			
				displayConditionalOptions();

				if(stratPanel.getCurrentStrat().size() > 0)
					stratPanel.getCurrentStrat().get(0).moveList = newMoveList;

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
