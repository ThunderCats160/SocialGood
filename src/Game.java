import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//The game class is the underlying class for the entire game. It runs on an Applet, and implements ActionListener which takes in mouse movements.
public class Game extends Applet implements ActionListener {

	//Instantiates a board
	Board board;
	
	//Instantiates the Panel which has buttons for the player to press to select a moving strategy.
	SelectPanel selectPanel;
	
	//Instantiates the Panel which displays the moving strategy the player has selected.
	StratPanel stratPanel;
	
	//Instantiates the button which runs the Player's strategy.
	JButton goButton;
	
	//Instantiates the Panel which displays the description of the level.
	DescriptionPanel descriptionPanel; 
	
	//Instantiates an ArrayList holding the levels implemented in the game.
	ArrayList<Level> levels; 
	
	//Instantiates an integer which holds the current Level being implemented in the game.
	//This index will be used to iterate through the ArrayList<Level> levels
	int currentLevelIndex; 
	
	//Instantiates the main JPanel where the game will be played
	JPanel mainGamePanel; 
	
	//Instantiates the introduction page, which explains the basics of how the game is played.
	//This page will also serve as an instructional page for Teachers to explain the value of this game.
	JPanel introScreenPanel; 

	//Init function to put values into the instantiated objects above.
	public void init()
	{
		
		//When the game is first started, the initial level is level 0.
		currentLevelIndex = 0; 
		
		//sets the layout manager for this container
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
		selectPanel = new SelectPanel(stratPanel);

		
		//Display the moves available to the player based on the currentLevelIndex. 
		selectPanel.setSelectOptions(levels.get(currentLevelIndex).getAvailableMoves());

		//Create the main game panel and set its layout.
		mainGamePanel = new JPanel(); 
		mainGamePanel.setLayout(new BorderLayout());
		
		//Create the layout of the game:
		//Put the Selection panel on the left side, the game board in the center, 
		//the strategy panel on the right, and the description of the level on the bottom.
		mainGamePanel.add(selectPanel, "West");
		mainGamePanel.add(board, "Center");
		mainGamePanel.add(stratPanel, "East");
		mainGamePanel.add(descriptionPanel, "South");
		
		//Show the introduction Screen
		initIntroScreen(); 
		

	}
	//The function to ensure that the Player sees the introduction screen before the mainGamePanel.
	public void initIntroScreen()
	{
		//Implement a new JPanel with a JLabel and JButton.
		//Here, we introduce the point of the game, and how to play.
		//We will also indicate to teachers the value of our game.
		
		//TODO:Put more text in the JLabel about the game & how to play.
		introScreenPanel = new JPanel(); 
		introScreenPanel.add(new JLabel("Welcome to the Game!!!")); 
		JButton b = new JButton("Get Started!");
		
		//Make sure that the button on the JPanel has a listener.
		b.addActionListener(new introPanelButtonAL(this));
		
		introScreenPanel.add(b); 
		
		add(introScreenPanel); 
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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
		}

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
		l1.addGoalAtPosition(7,5); 
		l1.setDescription("Welcome to the game! Add your commands to your strategy using"
						  +" the buttons on the right! Then, hit the GO! button and try and"
						  +" see if you reach the goal!"); 
		levels.add(l1); 
		
		//Level 2: Our second level. This requires them to move the character, and then turn after the correct number of spaces.
		Level l2 = new Level(40, board); 
		l2.setPlayerSpawnPosition(3, 5);
		l2.addGoalAtPosition(7,2); 
		l2.setDescription("OH FUCK! NOW YOU HAVE TO TURN!"); 
		
		levels.add(l2); 
		
		//Level 3: Our third level. This level introduces the first obstacle. The Player gets the choice of going above or below the obstacle, but cannot go through it.
		Level l3 = new Level(40, board); 
		l3.setPlayerSpawnPosition(3, 5);
		l3.addGoalAtPosition(7,5); 
		l3.addObstacleAtPosition(5, 5);
		l3.setDescription("HOLY SHIT AN OBSTACLE! TRY USING COMMANDS TO NAVIGATE AROUND IT"); 
		
		levels.add(l3); 
		
		
		//Load the correct Level.
		board.setCurrentLevel(levels.get(0));
		descriptionPanel.setDescription(levels.get(0).getDescription()); 
	}

}
