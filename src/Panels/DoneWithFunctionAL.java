package Panels;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Main.Board;
import Main.Game;
import Moves.FunctionMove;
import Moves.Move;

public class DoneWithFunctionAL implements ActionListener{

	private StratPanel stratPanel; 
	private SelectPanel selectPanel; 
	private FunctionCreatingPanel fcPanel; 
	Board board;
	Game game; 
	
	public DoneWithFunctionAL(StratPanel newStratPanel, FunctionCreatingPanel newFCP, SelectPanel sp, Board b, Game g)
	{
		stratPanel = newStratPanel; 
		fcPanel = newFCP; 
		selectPanel = sp; 
		board = b; 
		game = g; 
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//FunctionMove fm = new FunctionMove("A Function", board, null, fcPanel.moveList); 
		//stratPanel.addMove(fm);
		 
		game.mainGamePanel.remove(fcPanel);
		game.mainGamePanel.add(stratPanel, "East"); 
		game.mainGamePanel.setVisible(false);
		game.mainGamePanel.setVisible(true); 
		
		ArrayList<Move> newMoveList = new ArrayList<Move>(); 
		for(int i = 0; i < fcPanel.moveList.size(); i++)
			newMoveList.add(fcPanel.moveList.get(i)); 
		
		selectPanel.addNewFunctionButton(newMoveList, fcPanel.nameField.getText());
		selectPanel.addingToFunction = false; 
		
		fcPanel.reset(); 
	}

}
