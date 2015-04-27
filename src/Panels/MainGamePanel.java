package Panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
	private ArrayList<Level> levels;			//Instantiates an ArrayList holding the levels implemented in the game. 
	private int currentLevelIndex; 				//Instantiates an integer which holds the current Level being implemented in the game, used to iterate through the ArrayList<Level> levels
	Game game;							// reference to the game
	
	public MainGamePanel(Game g) {
		game = g;
		initGUI();
	}
	
	private void initGUI(){
		
		 
		//Instantiate a new Board with a default constructor
		board = new Board();
		//Instantiate a new Button with text "Go". 
		goButton = new JButton("GO!");
		//Indicate that our goButton should have an ActionListener to listen for a press.
		goButton.addActionListener(this);
		
		//The description Panel holds the goButton, as well as an introductory text.
		descriptionPanel = new DescriptionPanel(goButton, "HELLO"); 
		//We set the location and layout of the descriptionPanel to be along the BoxLayout's Page_Axis
		//descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.PAGE_AXIS));
		
		//Initializes the Level onto the board
		initLevels(); 
		
		//Instantiate a new StrategyPanel
		stratPanel = new StratPanel();
		
		//Instantiate a new SelectPanel
		selectPanel = new SelectPanel(stratPanel, game, board);

		stratPanel.setSelectPanel(selectPanel);
		
		//Display the moves available to the player based on the currentLevelIndex. 
		selectPanel.setSelectOptions(getLevels().get(getCurrentLevelIndex()).getAvailableMoves(), getLevels().get(getCurrentLevelIndex()).getCustomFunctionsAvailable());

		//Sets the number of available moves
		stratPanel.setMaxAvailableMoves(getLevels().get(getCurrentLevelIndex()).getNumOfUsableMoves());
		
		
		//Create the layout of the game:
		//Put the Selection panel on the left side, the game board in the center, 
		//the strategy panel on the right, and the description of the level on the bottom.
		
		
		//Game.APPLET_WIDTH //600
		//Game.APPLET_HEIGHT //960
		//Dimension: Width, Height
		BorderLayout b = new BorderLayout();
		setLayout(b);
		Dimension selectP = new Dimension(Game.APPLET_WIDTH/5,(int) (Game.APPLET_HEIGHT/2.4));
		Dimension boardP = new Dimension((int)(Game.APPLET_WIDTH/2), (int)(Game.APPLET_HEIGHT/2.133333));
		Dimension stratP = new Dimension((int)(Game.APPLET_WIDTH/6), (int)(Game.APPLET_HEIGHT/2.133333));
		Dimension descP = new Dimension((int)(Game.APPLET_WIDTH/1), (int)(Game.APPLET_HEIGHT/9.6));
		selectPanel.setPreferredSize(selectP);
		add(selectPanel, BorderLayout.LINE_START);
		board.setPreferredSize(boardP);
		add(board, BorderLayout.CENTER);	
		stratPanel.setPreferredSize(stratP);
		add(stratPanel, "East");
		descriptionPanel.setPreferredSize(descP);
		add(descriptionPanel, "South");
		
		
		setVisible(true);
		game.refreshApplet();
	}
	
	public void actionPerformed(ActionEvent e) {

		//Run the Player's Strategy.
		if(board.testStrategy(stratPanel.getCurrentStrat()))
		{
			System.out.println("YOU WIN"); 
			//If they're not at the final level, move them up to the next level.
			if(getCurrentLevelIndex() < getLevels().size() -1)
				setCurrentLevelIndex(getCurrentLevelIndex() + 1); 
			
			board.setCurrentLevel(getLevels().get(getCurrentLevelIndex()));
			//Clear the Strategy Panel in preparation of the new level.
			stratPanel.reset(false); 	
			descriptionPanel.setDescription(getLevels().get(getCurrentLevelIndex()).getDescription());
			selectPanel.setSelectOptions(getLevels().get(getCurrentLevelIndex()).getAvailableMoves(), getLevels().get(getCurrentLevelIndex()).getCustomFunctionsAvailable());
			
			stratPanel.setMaxAvailableMoves(getLevels().get(getCurrentLevelIndex()).getNumOfUsableMoves()); 
			
			selectPanel.resetNumFunctions();
			
		}

	}
	
	@Override
	public void paint(Graphics theGraphic) {
		super.paint(theGraphic);
		
		game.validate();
		
		selectPanel.revalidate();
		selectPanel.repaint();
		
		board.revalidate();
		board.repaint();
		
		stratPanel.revalidate();
		stratPanel.repaint();
		
		descriptionPanel.revalidate();
		descriptionPanel.repaint();
	}
	
	
	//We create the levels here.
	public void initLevels()
	{
		//levels will hold each of our created levels.
		setLevels(new ArrayList<Level>()); 
		
		//Level 1: Our introduction level.
		//The player simply has to move the character 3 spaces to the right.
		Level l1 = new Level(Board.unitDimension, board); 
		l1.setPlayerSpawnPosition(4, 5);
		l1.addGoalAtPosition(7,5, game.getBufferedImage("doghouseGrass.png")); 
		l1.setDescription("Welcome to the game! Add your commands to your strategy using"
						  +" the buttons on the right! Then, hit the GO! button and try and"
						  +" see if you reach the goal!"); 
		l1.makeRightMoveAvailable();
		l1.setNumOfUsableMoves(400);
		//l1.makeUpMoveAvailable();
		
		//levels.add(l1);
		
		//Level 2: Our second level. This requires them to move the character, and then turn after the correct number of spaces.
		Level l2 = new Level(Board.unitDimension, board); 
		l2.setPlayerSpawnPosition(3, 5);
		l2.addGoalAtPosition(7,2, game.getBufferedImage(Game.goalImage));
		l2.setDescription("OH WOW! NOW YOU HAVE TO TURN!"); 
		l2.makeRightMoveAvailable();
		l2.makeUpMoveAvailable();
		
		//levels.add(l2); 
		
		//Level 3: Our third level. This level introduces the first obstacle. The Player gets the choice of going above or below the obstacle, but cannot go through it.
		Level l3 = new Level(Board.unitDimension, board); 
		l3.setPlayerSpawnPosition(3, 5);
		l3.addGoalAtPosition(7,5, game.getBufferedImage(Game.goalImage)); 
		l3.addObstacleAtPosition(5, 5, game.getBufferedImage("dragon_new.png"));
		l3.setDescription("WOW! AN OBSTACLE! TRY USING COMMANDS TO NAVIGATE AROUND IT"); 
		
		l3.makeDownMoveAvailable();
		l3.makeLeftMoveAvailable();
		l3.makeRightMoveAvailable();
		l3.makeUpMoveAvailable();
		l3.setCustomFunctionsAvailable(true);
		//levels.add(l3);
		
		//Level 4: This introduces while loops
		Level l4 = new Level(Board.unitDimension, board); 
		l4.setPlayerSpawnPosition(0, 5); 
		l4.addGoalAtPosition(9, 5, game.getBufferedImage(Game.goalImage));
		l4.setDescription("Wow, that goal sure is far away, Try using a while-loop "
				+ "to get yourself there without just using 'right' over and over again."
				+ "The loop can do that for you!");
		
		l4.makeRightMoveAvailable();
		l4.makeWhileMoveAvailable(); 
		l4.makeConditionalMoveAvailable();
		l4.setNumOfUsableMoves(10);
		
		//getLevels().add(l4); 
		
		//Level 5: this introduces conditional Statements
		Level l5 = new Level(Board.unitDimension, board);
		l5.setPlayerSpawnPosition(0, 5);
		l5.addRedSquareAtPosition(2,5);
		l5.addGoalAtPosition(9, 4, game.getBufferedImage("doghouse.png"));
		l5.addObstacleAtPosition(2, 0, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(2, 1, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(2, 2, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(2, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(3, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(4, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(5, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(6, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(7, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(8, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(9, 3, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(3, 5, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(4, 5, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(5, 5, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(6, 5, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(7, 5, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(8, 5, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(2, 6, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(2, 7, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(2, 8, game.getBufferedImage("dragon_new.png"));
		l5.addObstacleAtPosition(2, 9, game.getBufferedImage("dragon_new.png"));
		l5.setDescription("good luck on this extremely difficult level bwhahahaha");
		l5.makeRightMoveAvailable();
		l5.makeUpMoveAvailable();
		l5.makeDownMoveAvailable();
		l5.makeWhileMoveAvailable();
		l5.makeConditionalMoveAvailable();
		l5.setNumOfUsableMoves(15);
		
		getLevels().add(l5);
		
		
		
		
		//Load the correct Level.
		board.setCurrentLevel(getLevels().get(0));
		descriptionPanel.setDescription(getLevels().get(0).getDescription()); 
	}

	public void setPlayerImage(BufferedImage image)
	{
		board.setPlayerImage(image);
	}
	
	public void setPlayerVisitedMark(BufferedImage image){
		board.setPlayerVisitedMark(image); 
	}

	public ArrayList<Level> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}

	public int getCurrentLevelIndex() {
		return currentLevelIndex;
	}

	
	public void setCurrentLevelIndex(int currentLevelIndex) {
		this.currentLevelIndex = currentLevelIndex;
	}
	
	
}
