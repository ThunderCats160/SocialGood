package Main;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionListeners.InstructionPanelGoBackAL;
import ActionListeners.TeacherPanelGoBackAL;
import ActionListeners.instructionsPanelButtonAL;
import ActionListeners.introPanelButtonAL;
import ActionListeners.teacherPanelButtonAL;
import Panels.DescriptionPanel;
import Panels.SelectPanel;
import Panels.StratPanel;

//The game class is the underlying class for the entire game. It runs on an Applet, and implements ActionListener which takes in mouse movements.
public class Game extends Applet implements ActionListener {

	
	// PROPERTIES
	Board board;						//Instantiates a board
	SelectPanel selectPanel;			//Instantiates the Panel which has buttons for the player to press to select a moving strategy.
	StratPanel stratPanel;				//Instantiates the Panel which displays the moving strategy the player has selected.
	JButton goButton;					//Instantiates the button which runs the Player's strategy.
	DescriptionPanel descriptionPanel; 	//Instantiates the Panel which displays the description of the level. 
	ArrayList<Level> levels;			//Instantiates an ArrayList holding the levels implemented in the game. 
	int currentLevelIndex; 				//Instantiates an integer which holds the current Level being implemented in the game, used to iterate through the ArrayList<Level> levels
	public JPanel mainGamePanel;				//Instantiates the main JPanel where the game will be played 
	JPanel introScreenPanel;			//Instantiates the introduction page, which explains the basics of how the game is played and serves as an instructional page for Teachers to explain the value of this game.
	JPanel instructionalPanel;
	JPanel teacherPanel; 				//The Teacher's panel, explains to teachers how to use the game to educate kids
	
	public final int FRAME_WIDTH = 700;	// width of our frame
	public final int FRAME_HEIGHT = 503;// height of our frame
	
	/* PUBLIC SETTINGS */
	public final String FONT_NAME = "Helvetica";
	
	
	public Game(){
		initGUI();
	}

	//Init function to put values into the instantiated objects above.
	public void initGUI() {
		Dimension dim = new Dimension(50000, 50000);
		
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setSize(dim);
		
		//sets the layout manager for this container
		setLayout(new BorderLayout());
		
		//creates the instructions page
		createInstructionPanel();
		
		//creates the teacher's page
		createTeacherPanel(); 
		
		//Show the introduction Screen
		initIntroScreen(); 
		
	}
	
	/* Function to start a new game */
	public void startNewGame(){
		//When the game is first started, the initial level is level 0.
		currentLevelIndex = 0; 
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
		selectPanel = new SelectPanel(stratPanel, this, board);

		stratPanel.setSelectPanel(selectPanel);
		
		//Display the moves available to the player based on the currentLevelIndex. 
		selectPanel.setSelectOptions(levels.get(currentLevelIndex).getAvailableMoves(), false);

		//Sets the number of available moves
		stratPanel.setMaxAvailableMoves(levels.get(currentLevelIndex).numberOfUseableMoves);
		
		//Create the main game panel and set its layout.
		mainGamePanel = new JPanel(); 
		mainGamePanel.setLayout(new BorderLayout());
		
		//Create the layout of the game:
		//Put the Selection panel on the left side, the game board in the center, 
		//the strategy panel on the right, and the description of the level on the bottom.
		mainGamePanel.add(selectPanel, "West");
		mainGamePanel.add(board, BorderLayout.CENTER);
		mainGamePanel.add(stratPanel, "East");
		mainGamePanel.add(descriptionPanel, "South");
		
		mainGamePanel.setVisible(true);
		mainGamePanel.revalidate();
		
		
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
		JButton getStartedButton = new JButton("Get Started!");
		JButton instructionsPageButton = new JButton("Instructions");
		JButton teacherPageButton = new JButton("Instructions For Teachers"); 
		
		//Make sure that the button on the JPanel has a listener.
		getStartedButton.addActionListener(new introPanelButtonAL(this));
		instructionsPageButton.addActionListener(new instructionsPanelButtonAL(this));
		teacherPageButton.addActionListener(new teacherPanelButtonAL(this)); 
		
		//adds these two buttons to the Intro Screen Panel
		introScreenPanel.add(getStartedButton); 
		introScreenPanel.add(instructionsPageButton);
		introScreenPanel.add(teacherPageButton); 
		
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
			selectPanel.setSelectOptions(levels.get(currentLevelIndex).getAvailableMoves(), levels.get(currentLevelIndex).getCustomFunctionsAvailable());
			
			stratPanel.setMaxAvailableMoves(levels.get(currentLevelIndex).numberOfUseableMoves); 
			
			selectPanel.resetNumFunctions();
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
		l1.makeRightMoveAvailable();
		l1.setNumberOfUseableMoves(400);
		//l1.makeUpMoveAvailable();
		
		//levels.add(l1); 
		
		//Level 2: Our second level. This requires them to move the character, and then turn after the correct number of spaces.
		Level l2 = new Level(40, board); 
		l2.setPlayerSpawnPosition(3, 5);
		l2.addGoalAtPosition(7,2); 
		l2.setDescription("OH WOW! NOW YOU HAVE TO TURN!"); 
		l2.makeRightMoveAvailable();
		l2.makeUpMoveAvailable();
		
		//levels.add(l2); 
		
		//Level 3: Our third level. This level introduces the first obstacle. The Player gets the choice of going above or below the obstacle, but cannot go through it.
		Level l3 = new Level(40, board); 
		l3.setPlayerSpawnPosition(3, 5);
		l3.addGoalAtPosition(7,5); 
		l3.addObstacleAtPosition(5, 5);
		l3.setDescription("WOW! AN OBSTACLE! TRY USING COMMANDS TO NAVIGATE AROUND IT"); 
		
		l3.makeDownMoveAvailable();
		l3.makeLeftMoveAvailable();
		l3.makeRightMoveAvailable();
		l3.makeUpMoveAvailable();
		l3.setCustomFunctionsAvailable(true);
		//levels.add(l3);
		
		//Level 4: This introduces while loops
		Level l4 = new Level(40, board); 
		l4.setPlayerSpawnPosition(0, 5); 
		l4.addGoalAtPosition(9, 5);
		l4.setDescription("Wow, that goal sure is far away, Try using a while-loop "
				+ "to get yourself there without just using 'right' over and over again."
				+ "The loop can do that for you!");
		
		l4.makeRightMoveAvailable();
		l4.makeWhileMoveAvailable(); 
		l4.setNumberOfUseableMoves(2);
		
		levels.add(l4); 
		
		
		//Load the correct Level.
		board.setCurrentLevel(levels.get(0));
		descriptionPanel.setDescription(levels.get(0).getDescription()); 
	}
	
	public void createInstructionPanel() {
		instructionalPanel = new JPanel();
		instructionalPanel.add(new JLabel("Instructions:"));
		
		JButton b = new JButton("Go back"); 
		b.addActionListener(new InstructionPanelGoBackAL(this));
		instructionalPanel.add(b); 
	}
	
	public void createTeacherPanel(){
		teacherPanel = new JPanel(); 
		teacherPanel.add(new JLabel("Here is where the instructions for teachers goes")); 
		
		JButton b = new JButton("Go back"); 
		b.addActionListener(new TeacherPanelGoBackAL(this)); 
		teacherPanel.add(b); 
	}
	
	// GETTERS FOR OUR PRIMARY PANELS	
	public JPanel getInstructionPanel() {
		return instructionalPanel;
	}
	
	public JPanel getTeacherPanel(){
		return teacherPanel; 
	}
	
	public JPanel getIntroScreenPanel(){
		return introScreenPanel;
	}
	
	public JPanel getMainGamePanel(){
		return mainGamePanel;
	}

}
