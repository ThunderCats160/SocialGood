package panels;
import interfaces.ResettablePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Game;
import moves.Move;
import buttons.MoveButton;


//The StratPanel holds an ArrayList of the currentStrategy the player has implemented
public class StratPanel extends JPanel implements ActionListener, ResettablePanel{

	private ArrayList<Move> currentStrat;
	private SelectPanel selectPanel; 
	public int currentNumberMovesAvailable; 
	private int maxAvailableMoves;
	private Game game;
	JLabel numAvailableMovesLabel; 
	
	//Default Constructor for the StratPanel
	public StratPanel(Game g)
	{
		game = g;
		maxAvailableMoves = 10; 
		currentNumberMovesAvailable = maxAvailableMoves; 
		initGUI();

		currentStrat = new ArrayList<Move>();

	}
	public StratPanel(){
		
	}
	public void setSelectPanel(SelectPanel newSelectPanel)
	{
		selectPanel = newSelectPanel; 
	}
	
	public void setMaxAvailableMoves(int num)
	{
		maxAvailableMoves = num; 
		currentNumberMovesAvailable = maxAvailableMoves; 
		numAvailableMovesLabel.setText("Moves Remaining: " + currentNumberMovesAvailable);
	}
	
	public void decrementAvailableMoves()
	{
		currentNumberMovesAvailable --; 
		numAvailableMovesLabel.setText("Moves Remaining: " + currentNumberMovesAvailable);
		revalidate();
	}
	
	//When the clear button is pressed, clear the current strategy and repaint the StratPanel
	public void reset(Boolean all)
	{
		currentStrat.clear(); 
		removeAll(); 
		reinitGUI();
		
		selectPanel.setAddToWhile(false); 
		selectPanel.resetSelectOptions();
		
		currentNumberMovesAvailable = maxAvailableMoves; 
		numAvailableMovesLabel.setText("Moves Remaining: " + currentNumberMovesAvailable);
		
		if(game.getMainGamePanel() != null){
			game.getMainGamePanel().revalidate();
			game.getMainGamePanel().repaint();
		}
		
	}
	
	//Instantiate the location of the Panel, and create the button that can be used to clear the current strategy
	public void initGUI()
	{
		Dimension stratP = new Dimension((int) Game.APPLET_WIDTH / 5, (int) (Game.APPLET_HEIGHT / 5) * 4);
		setPreferredSize(stratP);
		setSize(stratP);
		setMaximumSize(stratP);
		setMinimumSize(stratP);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		

		
		reinitGUI(); 
		
		setBackground(Color.getHSBColor((float).297,(float) .16,(float) .89));
			
	}
	
	private void reinitGUI(){
		JLabel title = new JLabel("Your Strategy");
		title.setFont(new Font("Arial", Font.BOLD, 24));
		add(title);
		
		numAvailableMovesLabel = new JLabel("Moves Remaining: " + currentNumberMovesAvailable);
		numAvailableMovesLabel.setFont( new Font ("Arial", Font.BOLD, 16));
		add(numAvailableMovesLabel); 
		
		
		MoveButton clearButton = new MoveButton("Clear Strategy", 4); 
		clearButton.setSize(new Dimension( (Game.APPLET_WIDTH / 5) - 20, 30));
		clearButton.addActionListener(this);
		add(clearButton);
	}

	//Getter for the current Strategy
	public ArrayList<Move> getCurrentStrat(){
		return  currentStrat;
	}
	
	//When the user selects a move, it is added to the ArrayList
	public void addMove(Move toAdd) {
		
		currentStrat.add(toAdd);
		
		currentNumberMovesAvailable --; 
		
		numAvailableMovesLabel.setText("Moves Remaining: " + currentNumberMovesAvailable);
		numAvailableMovesLabel.revalidate();
		numAvailableMovesLabel.repaint();
		
		if(game.getMainGamePanel()!= null){
			game.getMainGamePanel().revalidate();
			game.getMainGamePanel().repaint();
		}
		
		
	}

	//When the clear button is pressed,  it calls the clearCurrentStrat function
	public void actionPerformed(ActionEvent e) {
		reset(false); 
	}
	public int getMaxAvailableMoves(){
		return maxAvailableMoves; 
	}
	public SelectPanel getSelectPanel(){
		return selectPanel; 
	}

}