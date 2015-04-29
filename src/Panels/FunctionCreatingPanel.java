package panels;
import interfaces.ResettablePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Board;
import main.Game;
import moves.Move;
import actionListeners.DoneWithFunctionAL;
import buttons.TitlePageButton;

//This Panel is actually an Interface! It is used to help the player create a Panel.
//This Panel sits on top of where the Strategy Panel normally sits, and relies on mouseclicks in both itself, and the SelectPanel.
public class FunctionCreatingPanel extends JPanel implements ResettablePanel{

	
	public ArrayList<Move> moveList; 
	
	StratPanel stratPanel; 
	FunctionCreatingPanel fcp; 
	SelectPanel sp; 
	Board board; 
	Game game; 
	
	public JTextField nameField; 
	
	JLabel numberOfMovesAvailable; 
	
	//Implemented with a StratPanel and SelectPanel, in addition to a Board and Game
	public FunctionCreatingPanel(StratPanel newStratPanel, SelectPanel newSp, Board b, Game g)
	{
		moveList = new ArrayList<Move>(); 
		
		//Setting the size of the Panel
		Dimension stratP = new Dimension((int) Game.APPLET_WIDTH / 5, (int) (Game.APPLET_HEIGHT / 5) * 4);
		setPreferredSize(stratP);
		setSize(stratP);
		setMaximumSize(stratP);
		setMinimumSize(stratP);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
		
		//Creating the UI for the Panel
		JLabel title = new JLabel("Function Builder");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		
		stratPanel = newStratPanel; 
		sp = newSp; 
		board = b; 
		game = g; 
		
		
		

		//Must keep track of the number of moves available for the function
		//We don't want a function to be too large, it would defeat the purpose!
		numberOfMovesAvailable = new JLabel(); 
		numberOfMovesAvailable.setText("Moves left in your function: "+ sp.getCurrentNumberAvailableMovesInFunction()); 
		numberOfMovesAvailable.setFont(new Font("Arial", Font.BOLD, 13));
		
		add(numberOfMovesAvailable); 
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
		//When they are done with their function, they can press the Done Button to bring back the strategy panel.
		TitlePageButton butt = new TitlePageButton("Finish Function", 4); 
		butt.setSize(new Dimension( (Game.APPLET_WIDTH / 5) - 20, 50));
		butt.addActionListener(new DoneWithFunctionAL(stratPanel, this, sp, board, game));
		
		add(butt); 
	}
	
	public void addNameField()
	{
		//Lets the user change the name of their function
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
		add(numberOfMovesAvailable); 
		addNameField(); 
		addDoneButton(); 
		
	}
	
	
	public void setNumMovesAvailable(int set){
		numberOfMovesAvailable.setText("Moves left in your function: " + set);
	}
	
}
