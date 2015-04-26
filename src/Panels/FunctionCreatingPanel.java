package Panels;
import java.util.ArrayList; 

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Board;
import Main.Game;
import Moves.Move;

public class FunctionCreatingPanel extends JPanel{

	ArrayList<Move> moveList; 
	
	StratPanel stratPanel; 
	FunctionCreatingPanel fcp; 
	SelectPanel sp; 
	Board board; 
	Game game; 
	
	public FunctionCreatingPanel(StratPanel newStratPanel, 
			SelectPanel newSp, Board b, Game g)
	{
		
		moveList = new ArrayList<Move>(); 
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
		
		stratPanel = newStratPanel; 
		sp = newSp; 
		board = b; 
		game = g; 
		
		addDoneButton(); 
	}
	
	public void addDoneButton()
	{
		JButton butt = new JButton("Done!"); 
		
		butt.addActionListener(new DoneWithFunctionAL(stratPanel, this, sp, board, game));
		
		add(butt); 
	}
	
	public void addMove(Move toAdd)
	{
		moveList.add(toAdd); 
		add(new JLabel(toAdd.getName()));
		setVisible(false); 
		setVisible(true); 
	}
	
	public void reset()
	{
		moveList.clear(); 
		removeAll(); 
		addDoneButton(); 
		
	}
	
}
