package Panels;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionListeners.conditionalMoveAdderAL;
import ActionListeners.moveAdderAL;
import ActionListeners.whileMoveAdderAL;
import Main.Board;
import Main.Game;
import Moves.FunctionMove;
import Moves.Move;

//The Select Panel holds an ArrayList of the move options for the level
//It also holds a copy of the strategy panel (which gets inputs from the select Panel)
//It also holds buttons to display the move options
public class SelectPanel extends JPanel implements ActionListener {

	/* PROPERTIES */
	private ArrayList<Move> selectOptions;
	
	StratPanel stratPanel;
	private Boolean addingToWhile; 
	private Boolean addingToConditional;
	Game game; 
	Board board; 
	
	//Currently useless
	private int numFunctions; 
	
	public Boolean addingToFunction; 
	
	public FunctionCreatingPanel createFunctionPanel; 

	//Initiate a SelectPanel with a StratPanel
	public SelectPanel(StratPanel newStratPanel, Game g, Board b)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		stratPanel = newStratPanel;
		
		addingToWhile = false; 
		addingToConditional = false;

		game = g; 
		board = b; 
		
		setupCreateFunctionPanel(); 
		
		addingToFunction = false; 
		numFunctions = 1; 
		
		initGUI();

	}
	
	public void setupCreateFunctionPanel(){
		createFunctionPanel = new FunctionCreatingPanel(stratPanel, this, board, game); 

	}
	
	//InitGUI must be called as a default
	public void initGUI() {
		
	}
	
	public void setAddToWhile(boolean value){
		addingToWhile = value;
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
		selectOptions = newOptions;
		//Iterates through
		for(int i = 0; i < selectOptions.size(); i ++)
		{
			//Create a new button for each option in the ArrayList
			JButton b = new JButton();
			b.setText(selectOptions.get(i).getName());
			
			if(!selectOptions.get(i).isWhileMove && !selectOptions.get(i).isConditionalMove)
				b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel, this));
			else if(selectOptions.get(i).isWhileMove)
				b.addActionListener(new whileMoveAdderAL(selectOptions.get(i), stratPanel, this, createFunctionPanel));
			else if(selectOptions.get(i).isConditionalMove)
				b.addActionListener(new conditionalMoveAdderAL(selectOptions.get(i), stratPanel, this, game.mainGamePanel));
				 
			
			add(b);
			add(Box.createRigidArea(new Dimension(5,5)));
		}
		
		
		
		if(customFunctions)
			addDefineFunctionButton(); 
		
	}
	
	public void resetButtonsOnSelectPanel(Boolean allMoves)
	{
		Boolean displayAllMoves = allMoves;
		
		if(displayAllMoves)
		{
			for(int i = 0; i < selectOptions.size(); i ++)
			{
				//Create a new button for each option in the ArrayList
				JButton b = new JButton();
				b.setText(selectOptions.get(i).getName());
				
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
					JButton b = new JButton();
					b.setText(selectOptions.get(i).getName());
					b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel, this));
					add(b);
				}
		
			}
		}
	}
	
	//To reset what the whileMove holds. 
	public void resetSelectOptions()
	{
		for(int i = 0; i< getSelectOptions().size(); i++)
		{
		
			getSelectOptions().get(i).clearMoveList(); 
			//System.out.println(selectOptions.get(i).getMoveList().size()); 
		}
	}


	//Runs when the user clicks the "Create a function" button
	public void actionPerformed(ActionEvent arg0) {
		
		game.mainGamePanel.remove(stratPanel);
		game.mainGamePanel.setVisible(false);
		game.mainGamePanel.setVisible(true); 
		game.mainGamePanel.add(createFunctionPanel, "East"); 
		
		addingToFunction = true; 

	}

	public void addDefineFunctionButton()
	{
		JButton dfb = new JButton("Create a function!"); 
		dfb.addActionListener(this); 

		add(dfb); 
	}
	
	//Takes the moves that the function will run and the name of the function
	//Adds a button that will add the related function
	public void addNewFunctionButton(ArrayList<Move> functionMoves, String name)
	{
		JButton b = new JButton(name); 
		
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
		
		moveAdderAL m = new moveAdderAL(f, stratPanel, this);
		
		b.addActionListener(m);
		
		numFunctions ++; 
		
		
	}
	
	//Currently useless, just ignore
	public void resetNumFunctions()
	{
		numFunctions = 1; 
	}

	public ArrayList<Move> getSelectOptions() {
		return selectOptions;
	}

	public void setSelectOptions(ArrayList<Move> selectOptions) {
		this.selectOptions = selectOptions;
	}



}