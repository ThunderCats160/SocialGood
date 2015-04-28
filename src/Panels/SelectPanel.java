package Panels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionListeners.conditionalMoveAdderAL;
import ActionListeners.functionMoveAdderAL;
import ActionListeners.moveAdderAL;
import ActionListeners.removeFunctionButtonAL;
import ActionListeners.whileMoveAdderAL;
import Buttons.MoveButton;
import Interfaces.resettablePanel;
import Main.Board;
import Main.Game;
import Moves.FunctionMove;
import Moves.Move;
import Moves.WhileMove;
import Moves.conditionalMove;

//The Select Panel holds an ArrayList of the move options for the level
//It also holds a copy of the strategy panel (which gets inputs from the select Panel)
//It also holds buttons to display the move options
public class SelectPanel extends JPanel implements ActionListener, resettablePanel {

	/* PROPERTIES */
	private ArrayList<Move> selectOptions;
	
	StratPanel stratPanel;
	private Boolean addingToWhile; 
	private Boolean addingToConditional;
	Game game; 
	Board board; 
	
	//Currently useless
	public int currentNumberAvailableMovesInFunction; 
	private int maxAvailableMovesInFunctions;
	
	int numFunctions; 
	
	public Boolean addingToFunction; 
	private Boolean removingFunction; 
	
	public FunctionCreatingPanel createFunctionPanel; 

	//Initiate a SelectPanel with a StratPanel
	public SelectPanel(StratPanel newStratPanel, Game g, Board b)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		stratPanel = newStratPanel;
		
		
		
		addingToWhile = false; 
		removingFunction = false; 
		addingToConditional = false;

		game = g; 
		board = b; 
		
		setupCreateFunctionPanel(); 
		
		addingToFunction = false; 

		numFunctions = 1; 
		initGUI();

	}
	
	
	public void setMaxAvailableMovesInFunctions(int set){
		maxAvailableMovesInFunctions = set; 
		currentNumberAvailableMovesInFunction = maxAvailableMovesInFunctions; 
	}
	public void resetCurrentNumberAvailableMovesInFunctionToMax(){
		currentNumberAvailableMovesInFunction = maxAvailableMovesInFunctions; 
	}
	public void decrementCurrentNumberAvailableMovesInFunction(){
		currentNumberAvailableMovesInFunction --; 
	}
	public int getCurrentNumberAvailableMovesInFunction(){
		return currentNumberAvailableMovesInFunction; 
	}
	
	public void setupCreateFunctionPanel(){
		createFunctionPanel = new FunctionCreatingPanel(stratPanel, this, board, game); 
	}
	
	//InitGUI must be called as a default
	public void initGUI() {
		setLayout(new BoxLayout( this, BoxLayout.PAGE_AXIS));
		
		Dimension selectP = new Dimension((int) Game.APPLET_WIDTH / 5, (int) (Game.APPLET_HEIGHT / 5) * 4);
		setPreferredSize(selectP);
		setSize(selectP);
		setMaximumSize(selectP);
		setMinimumSize(selectP);
		
		JLabel title = new JLabel("Available Moves");
		title.setFont(new Font("Arial", Font.BOLD, 24));
		add(title);
		
		setBackground(Color.getHSBColor((float).297,(float) .16,(float) .89));
		
		setVisible(true);
	}
	
	public void setAddToWhile(boolean value){
		addingToWhile = value;
		game.getMainGamePanel().repaint();
	}

	public boolean getAddToWhile(){
		return addingToWhile;
	}
	
	public void setAddToConditional(boolean value){
		addingToConditional = value;
	}

	public boolean getAddToConditional(){
		return addingToConditional;
	}
	
	
	
	//Iterate through the ArrayList of Moves to create the buttons in the SelectPanel
	public void setSelectOptions(ArrayList<Move> newOptions, Boolean customFunctions){

		removeAll();
		// re-add our title
		JLabel title = new JLabel("Available Moves");
		title.setFont(new Font("Arial", Font.BOLD, 24));
		add(title);
		
		selectOptions = newOptions;
		//Iterates through
		for(int i = 0; i < selectOptions.size(); i ++)
		{
			//Create a new button for each option in the ArrayList
			MoveButton b = new MoveButton(selectOptions.get(i).getName(), 15);
			
			if(!selectOptions.get(i).isWhileMove && !selectOptions.get(i).isConditionalMove)
				b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel, this));
			else if(selectOptions.get(i).isWhileMove)
				b.addActionListener(new whileMoveAdderAL(new WhileMove("While", board, null), stratPanel, this, createFunctionPanel));
			else if(selectOptions.get(i).isConditionalMove)
				b.addActionListener(new conditionalMoveAdderAL(new conditionalMove("Conditional", board, null), stratPanel, this, game.mainGamePanel));
				 
			
			add(b);
			add(Box.createRigidArea(new Dimension(5,5)));
		}
		
		
		
		if(customFunctions)
			
			addDefineFunctionButton(); 
		
	}
	
	public void reset(Boolean displayAllMoves)
	{
		
		
		if(displayAllMoves)
		{
			for(int i = 0; i < selectOptions.size(); i ++)
			{
				//Create a new button for each option in the ArrayList
				MoveButton b = new MoveButton(selectOptions.get(i).getName(), 15);
				
				if(!selectOptions.get(i).isWhileMove && !selectOptions.get(i).isConditionalMove)
					b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel, this));
				else if(selectOptions.get(i).isWhileMove)
					b.addActionListener(new whileMoveAdderAL(selectOptions.get(i), stratPanel, this, createFunctionPanel));
				else if(selectOptions.get(i).isConditionalMove)
					b.addActionListener(new conditionalMoveAdderAL(selectOptions.get(i), stratPanel, this, game.mainGamePanel));
					 
				
				add(b);
			}
		}
		
		else{
			
			for(int i = 0; i < selectOptions.size(); i ++)
			{
			
				if(!selectOptions.get(i).isWhileMove && !selectOptions.get(i).isConditionalMove){
					MoveButton b = new MoveButton(selectOptions.get(i).getName(), 15);
					b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel, this));
					add(b);
				}
		
			}
		}
	}
	
 
	public void resetSelectOptions()
	{
//		for(int i = 0; i< getSelectOptions().size(); i++)
//		{
//		
//			getSelectOptions().get(i).clearMoveList(); 
//			//System.out.println(selectOptions.get(i).getMoveList().size()); 
//		}
	}


	//Runs when the user clicks the "Create a function" button
	public void actionPerformed(ActionEvent arg0) {
		
		game.mainGamePanel.topLevel.remove(stratPanel);
		game.mainGamePanel.repaint();
		game.mainGamePanel.topLevel.add(createFunctionPanel); 
		
		addingToFunction = true; 

	}

	public void addDefineFunctionButton()
	{	
		add(Box.createVerticalGlue());
		MoveButton dfb = new MoveButton("Create a function", 15); 
		dfb.setButtonColor(new Color(36, 125, 13));
		dfb.addActionListener(this); 
		
		MoveButton removeFunctionButton = new MoveButton("Remove a function", 15); 
		removeFunctionButton.setButtonColor(Color.RED);
		removeFunctionButton.addActionListener(new removeFunctionButtonAL(this)); 

		add(dfb); 
		add(Box.createRigidArea(new Dimension(5,5)));
		add(removeFunctionButton); 
	}
	
	//Takes the moves that the function will run and the name of the function
	//Adds a button that will add the related function
	public void addNewFunctionButton(ArrayList<Move> functionMoves, String name)
	{
		MoveButton b = new MoveButton(name, 15);
		
		String SMovesInFunction = "<html>";
		 
		//iterate through functionMoves
		
		for(int i = 0; i < functionMoves.size();i++)
		{
			SMovesInFunction = SMovesInFunction + functionMoves.get(i).getName() + " <br/> " ;
		}
		SMovesInFunction += "</html>";
		
		b.setToolTipText(SMovesInFunction);
		add(Box.createRigidArea(new Dimension(5,5)));
		add(b); 
		
		//System.out.println(functionMoves.size()); 
		
		FunctionMove f = new FunctionMove("NOPE", board, null, functionMoves, name); 
		
		functionMoveAdderAL m = new functionMoveAdderAL(f, stratPanel, this, b);
		
		b.addActionListener(m);
		
		numFunctions ++; 
		
		
	}
	
	//Currently useless, just ignore
	public void resetNumFunctions()
	{
		numFunctions = 1; 
	}
	
	public Game getGame(){
		return game;
	}

	public ArrayList<Move> getSelectOptions() {
		return selectOptions;
	}

	public void setSelectOptions(ArrayList<Move> selectOptions) {
		this.selectOptions = selectOptions;
	}
	public void setRemovingFunction(Boolean bool)
	{
		removingFunction = bool; 
	}
	public Boolean getRemovingFunction()
	{
		return removingFunction; 
	}

	public Board getBoard(){
		return board; 
	}


}