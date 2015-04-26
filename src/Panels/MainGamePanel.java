package Panels;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;



import Main.Game;
import Main.Board;
import Main.Level;

public class MainGamePanel extends JPanel implements ActionListener {
	
	Board board;						//Instantiates a board
	SelectPanel selectPanel;			//Instantiates the Panel which has buttons for the player to press to select a moving strategy.
	StratPanel stratPanel;				//Instantiates the Panel which displays the moving strategy the player has selected.
	JButton goButton;					//Instantiates the button which runs the Player's strategy.
	DescriptionPanel descriptionPanel; 	//Instantiates the Panel which displays the description of the level. 
	ArrayList<Level> levels;			//Instantiates an ArrayList holding the levels implemented in the game. 
	int currentLevelIndex; 				//Instantiates an integer which holds the current Level being implemented in the game, used to iterate through the ArrayList<Level> levels
	Game game;							// reference to the game
	
	public MainGamePanel(Game g) {
		game = g;
		initGUI();
	}
	
	private void initGUI(){
		setLayout(new BorderLayout());
		 
		//Instantiate a new Board with a default constructor
		board = new Board();
		//Instantiate a new Button with text "Go". 
		goButton = new JButton("GO!");
		//Indicate that our goButton should have an ActionListener to listen for a press.
		goButton.addActionListener(this);
		
		//The description Panel holds the goButton, as well as an introductory text.
		descriptionPanel = new DescriptionPanel(goButton, "HELLO"); 
		//We set the location and layout of the descriptionPanel to be along the BoxLayout's Page_Axis
		descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.PAGE_AXIS));
		
		//Initializes the Level onto the board
		initLevels(); 
		
		//Instantiate a new StrategyPanel
		stratPanel = new StratPanel();
		
		//Instantiate a new SelectPanel
		selectPanel = new SelectPanel(stratPanel, game, board);

		stratPanel.setSelectPanel(selectPanel);
		
		//Display the moves available to the player based on the currentLevelIndex. 
		selectPanel.setSelectOptions(levels.get(currentLevelIndex).getAvailableMoves(), false);

		//Sets the number of available moves
		stratPanel.setMaxAvailableMoves(levels.get(currentLevelIndex).getNumOfUsableMoves());
		
		
		//Create the layout of the game:
		//Put the Selection panel on the left side, the game board in the center, 
		//the strategy panel on the right, and the description of the level on the bottom.
		add(selectPanel, "West");
		add(board, BorderLayout.CENTER);
		add(stratPanel, "East");
		add(descriptionPanel, "South");
		
		
		setVisible(true);
		validate();
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {

		//Run the Player's Strategy.
		if(board.testStrategy(stratPanel.getCurrentStrat()))
		{
			System.out.println("YOU WIN"); 
			//If they're not at the final level, move them up to the next level.
			if(currentLevelIndex < levels.size() -1)
				currentLevelIndex ++; 
			
			board.setCurrentLevel(levels.get(currentLevelIndex));
			//Clear the Strategy Panel in preparation of the new level.
			stratPanel.clearCurrentStrat(); 	
			descriptionPanel.setDescription(levels.get(currentLevelIndex).getDescription());
			selectPanel.setSelectOptions(levels.get(currentLevelIndex).getAvailableMoves(), levels.get(currentLevelIndex).getCustomFunctionsAvailable());
			
			stratPanel.setMaxAvailableMoves(levels.get(currentLevelIndex).getNumOfUsableMoves()); 
			
			selectPanel.resetNumFunctions();
			
		}

	}
	
	@Override
	public void paint(Graphics theGraphic) {
		super.paint(theGraphic);
		
		selectPanel.validate();
		selectPanel.repaint();
		
		board.revalidate();
		board.repaint();
		
		stratPanel.validate();
		stratPanel.repaint();
		
		descriptionPanel.revalidate();
		descriptionPanel.repaint();
	}
	
	
	//We create the levels here.
	public void initLevels()
	{
		//levels will hold each of our created levels.
		levels = new ArrayList<Level>(); 
		
		//Level 1: Our introduction level.
		//The player simply has to move the character 3 spaces to the right.
		Level l1 = new Level(40, board); 
		l1.setPlayerSpawnPosition(4, 5);
		l1.addGoalAtPosition(7,5, game.getImage(game.getBase(), "u.png")); 
		l1.setDescription("Welcome to the game! Add your commands to your strategy using"
						  +" the buttons on the right! Then, hit the GO! button and try and"
						  +" see if you reach the goal!"); 
		l1.makeRightMoveAvailable();
		l1.setNumOfUsableMoves(400);
		//l1.makeUpMoveAvailable();
		
		levels.add(l1);
		
		//Level 2: Our second level. This requires them to move the character, and then turn after the correct number of spaces.
		Level l2 = new Level(40, board); 
		l2.setPlayerSpawnPosition(3, 5);
		l2.addGoalAtPosition(7,2);
		l2.setDescription("OH WOW! NOW YOU HAVE TO TURN!"); 
		l2.makeRightMoveAvailable();
		l2.makeUpMoveAvailable();
		
		levels.add(l2); 
		
		//Level 3: Our third level. This level introduces the first obstacle. The Player gets the choice of going above or below the obstacle, but cannot go through it.
		Level l3 = new Level(40, board); 
		l3.setPlayerSpawnPosition(3, 5);
		l3.addGoalAtPosition(7,5); 
		l3.addObstacleAtPosition(5, 5, game.getImage(game.getBase(), "u.png"));
		l3.setDescription("WOW! AN OBSTACLE! TRY USING COMMANDS TO NAVIGATE AROUND IT"); 
		
		l3.makeDownMoveAvailable();
		l3.makeLeftMoveAvailable();
		l3.makeRightMoveAvailable();
		l3.makeUpMoveAvailable();
		l3.setCustomFunctionsAvailable(true);
		levels.add(l3);
		
		//Level 4: This introduces while loops
		Level l4 = new Level(40, board); 
		l4.setPlayerSpawnPosition(0, 5); 
		l4.addGoalAtPosition(9, 5);
		l4.setDescription("Wow, that goal sure is far away, Try using a while-loop "
				+ "to get yourself there without just using 'right' over and over again."
				+ "The loop can do that for you!");
		
		l4.makeRightMoveAvailable();
		l4.makeWhileMoveAvailable(); 
		l4.setNumOfUsableMoves(2);
		
		levels.add(l4); 
		
		
		//Load the correct Level.
		board.setCurrentLevel(levels.get(0));
		descriptionPanel.setDescription(levels.get(0).getDescription()); 
	}
	
	public void setPlayerImage(Image image)
	{
		board.setPlayerImage(image);
	}

}
