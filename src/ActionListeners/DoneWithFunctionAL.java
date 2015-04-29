package actionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.Board;
import main.Game;
import moves.Move;
import panels.FunctionCreatingPanel;
import panels.SelectPanel;
import panels.StratPanel;

public class DoneWithFunctionAL implements ActionListener{

	private StratPanel stratPanel; 
	private SelectPanel selectPanel; 
	private FunctionCreatingPanel fcPanel; 
	Board board;
	Game game; 
	
	//The Action listener for the Button on the create a function menu
	
	public DoneWithFunctionAL(StratPanel newStratPanel, FunctionCreatingPanel newFCP, SelectPanel sp, Board b, Game g)
	{
		stratPanel = newStratPanel; 
		fcPanel = newFCP; 
		selectPanel = sp; 
		board = b; 
		game = g; 
	}
	
	//button listener function
	//no return
	//passes in the actionevent which is the button that was pressed
	public void actionPerformed(ActionEvent arg0) {
		
		 
		//Remove the function panel and re-add the strat Panel
		game.mainGamePanel.topLevel.remove(fcPanel);
		game.mainGamePanel.topLevel.add(stratPanel, "East"); 
 
		//resets the screen
		game.mainGamePanel.revalidate();
		game.mainGamePanel.repaint();
		
		//Copy over all the moves so that they don't get deleted in reset()
		ArrayList<Move> newMoveList = new ArrayList<Move>(); 
		for(int i = 0; i < fcPanel.moveList.size(); i++)
			newMoveList.add(fcPanel.moveList.get(i)); 
		
		//Add the new function to selectPanel
		selectPanel.addNewFunctionButton(newMoveList, fcPanel.nameField.getText());
		selectPanel.addingToFunction = false; 
		
		//reset the number of moves that can be used in making a function
		selectPanel.resetCurrentNumberAvailableMovesInFunctionToMax();
		
		
		fcPanel.reset(false); 
	}

}
