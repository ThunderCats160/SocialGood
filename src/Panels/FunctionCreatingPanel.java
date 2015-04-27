package Panels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList; 

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ActionListeners.DoneWithFunctionAL;
import Buttons.TitlePageButton;
import Interfaces.resettablePanel;
import Main.Board;
import Main.Game;
import Moves.Move;

public class FunctionCreatingPanel extends JPanel implements resettablePanel{

	public ArrayList<Move> moveList; 
	
	StratPanel stratPanel; 
	FunctionCreatingPanel fcp; 
	SelectPanel sp; 
	Board board; 
	Game game; 
	
	public JTextField nameField; 
	
	public FunctionCreatingPanel(StratPanel newStratPanel, SelectPanel newSp, Board b, Game g)
	{
		moveList = new ArrayList<Move>(); 
		
		Dimension stratP = new Dimension((int) Game.APPLET_WIDTH / 5, (int) (Game.APPLET_HEIGHT / 5) * 4);
		setPreferredSize(stratP);
		setSize(stratP);
		setMaximumSize(stratP);
		setMinimumSize(stratP);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
		
		JLabel title = new JLabel("Function Builder");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		stratPanel = newStratPanel; 
		sp = newSp; 
		board = b; 
		game = g; 
		
		addNameField(); 
		addDoneButton(); 
		setBackground(Color.getHSBColor((float).297,(float) .16,(float) .89));
		
		setVisible(true);
		validate();
		repaint();
		
		game.refreshApplet();
	}
	
	public void addDoneButton()
	{
		TitlePageButton butt = new TitlePageButton("Finish Function", 4); 
		butt.setSize(new Dimension( (Game.APPLET_WIDTH / 5) - 20, 50));
		butt.addActionListener(new DoneWithFunctionAL(stratPanel, this, sp, board, game));
		
		add(butt); 
	}
	
	public void addNameField()
	{
		nameField = new JTextField("FunctionName", 20); 
		nameField.setMaximumSize(new Dimension(300, 40));
		add(nameField);
	}
	
	//Adds a move and puts the move's name on the panel
	public void addMove(Move toAdd)
	{
		moveList.add(toAdd); 
		add(new JLabel(toAdd.getName()));

		revalidate();
		repaint();
		game.refreshApplet();
	}
	
	//Clears the panel to be used next time
	public void reset(Boolean all)
	{
		moveList.clear(); 
		removeAll(); 
		addNameField(); 
		addDoneButton(); 
		
	}
	
}
