package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Main.Board;
import Main.Game;
import Moves.FunctionMove;
import Moves.Move;
import Panels.FunctionCreatingPanel;
import Panels.SelectPanel;
import Panels.StratPanel;

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
	
	public void actionPerformed(ActionEvent arg0) {
		//FunctionMove fm = new FunctionMove("A Function", board, null, fcPanel.moveList); 
		//stratPanel.addMove(fm);
		 
		//Remove the function panel and re-add the strat Panel
		game.mainGamePanel.remove(fcPanel);
		game.mainGamePanel.add(stratPanel, "East"); 
//		game.mainGamePanel.setVisible(false);
//		game.mainGamePanel.setVisible(true); 
		game.mainGamePanel.revalidate();
		game.mainGamePanel.repaint();
		
		//Copy over all the moves so that they don't get deleted in reset()
		ArrayList<Move> newMoveList = new ArrayList<Move>(); 
		for(int i = 0; i < fcPanel.moveList.size(); i++)
			newMoveList.add(fcPanel.moveList.get(i)); 
		
		//Add the new function to selectPanel
		selectPanel.addNewFunctionButton(newMoveList, fcPanel.nameField.getText());
		selectPanel.addingToFunction = false; 
		
		fcPanel.reset(); 
	}

}
