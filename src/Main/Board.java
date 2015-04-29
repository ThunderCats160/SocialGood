package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import moves.ConditionalMove;
import moves.Move;
import panels.MainGamePanel;
import units.Player;
import units.Unit;

//Board Class holds the implementation for the Board.
//Uses JPanel
public class Board extends JPanel{

	//Instantiates:
	//Because our game has multiple levels, it is important for the Board to know which level we are on.
	//Each Level will call for different objects to be painted onto the board in different locations, and the available moves are different.
	private Level currentLevel;
	//Player holds the position of the user's character (currently a block) in XY format.
	private Player player;
	private MainGamePanel mainPanel;
	//Constants needed for drawing.
	static public int unitDimension = (int) ((int) Game.APPLET_HEIGHT * .08);


	//Default constructor. Calls for the player to be made
	public Board(MainGamePanel mgp) {
		mainPanel = mgp;
		player = new Player(Color.blue, 5, 10, unitDimension);
		initGUI();
	}
	
	//there are no returns or parameters for this function
	//this sets the dimensions of the board
	public void initGUI(){
		Dimension boardP = new Dimension((int)((Game.APPLET_WIDTH/5) * 3) - 90, (int)(Game.APPLET_HEIGHT/5) * 4 + 20);
		setPreferredSize(boardP);
		setSize(boardP);
		setMaximumSize(boardP);
		setMinimumSize(boardP);
	}
	
	//this function sets the player image
	//there are no returns
	//the parameter is the image you would like the player to be
	public void setPlayerImage(BufferedImage image)
	{
		player.setImage(image); 
	}
	
	//this function sets the player visited mark
	//there are no returns
	//the parameter is the image you would like it to be
	public void setPlayerVisitedMark(BufferedImage image){
		player.setVisitedMark(image); 
	}
	
	//this function returns the player
	//there are no parameters
	public Player getPlayer()
	{
		return player;
	}
	
	//The Level of the game decides the initial location for the player and obstacles.
	public void setCurrentLevel(Level newLevel){
		
		//Set the player's initial location based on the level's initial settings.
		currentLevel = newLevel;
		player.setX(currentLevel.playerSpawnX);
		player.setY(currentLevel.playerSpawnY);
		
		mainPanel.revalidate();
		mainPanel.repaint();
		
	}
	//Getter for the currentLevel stored in the Board.
	public Level getCurrentLevel()
	{
		return currentLevel; 		
	}

	//this function was used to error check
	//there is no returns
	//the parameter is an array list of moves that will be printed
	public static void printTest(ArrayList<Move> moveList){
		System.out.println("Here are the items in moveList"); 
		for(int lol = 0; lol < moveList.size(); lol++){
			
			System.out.println(moveList.get(lol).name);
			if(moveList.get(lol).isWhileMove)
			{
				System.out.println("Contents of the whileLoop"); 
				for(int lmao = 0; lmao < moveList.get(lol).moveList.size(); lmao ++){
					System.out.println(moveList.get(lol).moveList.get(lmao).name); 
					//System.out.println(moveList.get(lol).moveList.get(lmao).getClass().getName()); 

					
					if(moveList.get(lol).moveList.get(lmao).isConditionalMove){
						System.out.println("Contents of the Conditional"); 
						for(int x = 0; x < moveList.get(lol).moveList.get(lmao).moveList.size(); x ++){
							System.out.println(moveList.get(lol).moveList.get(lmao).moveList.get(x).name); 
							//System.out.println(moveList.get(lol).moveList.get(lmao).getClass().getName()); 
							
						}
						System.out.println("Ending contents of conditional"); 
					}
					
					
				}
				System.out.println("Ending contents of while loop"); 
			}
			if(moveList.get(lol).isConditionalMove){
				System.out.println("Contents of the Conditional"); 
				for(int lmao = 0; lmao < moveList.get(lol).moveList.size(); lmao ++){
					System.out.println(moveList.get(lol).moveList.get(lmao).name); 
					//System.out.println(moveList.get(lol).moveList.get(lmao).getClass().getName()); 
					
				}
				System.out.println("Ending contents of conditional"); 
			}
		}
		System.out.println("End of contents of moveList"); 
	}
	
	//If the user clicks "Run", we want to see if their strategy works. We move pieces around on the board to test their strategy.
	//the returns says if there strategy was successful or not
	//the parameter are the list of moves being tested
	public Boolean testStrategy(ArrayList<Move> moveList){

		Graphics g = getGraphics();
		//printTest(moveList); 
		
		
		///*
		//Iterate through the list of moves in order to move the Player around the board.
		for(int i = 0; i < moveList.size(); i++) {
			
			 
			//Carry out the current move in the iteration
			//The graphics item and board are passed so the whileMove can 
			//create a loop similar to this one
			if (moveList.get(i).isWhileMove) {		
				
				//Get the list of moves that the whileMove is to perform over and over
				ArrayList<Move> whileList = moveList.get(i).getMoveList(); 
				
				//Only perform the loop 10 times in case of an infinite
				for(int whileLoopCounter = 0; whileLoopCounter < 10; whileLoopCounter++)
				{
					 
					for(int whileListCounter = 0; whileListCounter < whileList.size(); whileListCounter++)
					{		
						//checks to see if it is a conditional move
						if(whileList.get(whileListCounter).isConditionalMove)
						{
							//checks the condition if it is a conditional move
							if(checkConditional(whileList.get(whileListCounter)))
							{
								
								//get the list of moves that the conditionalMove is to perform over and over
								ArrayList<Move> conditionalList = whileList.get(whileListCounter).getMoveList();
								
								
								for(int index = 0; index < conditionalList.size(); index++)
								{
									//does the conditional moves if there are any
									if(doMove(conditionalList.get(index), g))
									{
										return true;
									}
								}
							}
						}
						//checks if it is a function
						else if(whileList.get(whileListCounter).isFunctionMove){
							ArrayList<Move> functionList = whileList.get(whileListCounter).getMoveList();
							
							
							for(int functionListCounter = 0; functionListCounter< functionList.size(); functionListCounter++){
								//does the function moves
								if(doMove(functionList.get(functionListCounter), g))
									return true; 
							}
						}
						else if(doMove(whileList.get(whileListCounter), g))
							return true; 
						
					}
				}
				
			}//end of a while moveList
			
			//checks if the move is a function move
			else if(moveList.get(i).isFunctionMove)
			{
				ArrayList<Move> functionList = moveList.get(i).getMoveList(); 
				//runs all the moves that are in the function
				for(int j = 0; j< functionList.size(); j++){
					if(doMove(functionList.get(j), g))
						return true; 
				}
			}
			
			//checks if the move is a conditional move
			else if(moveList.get(i).isConditionalMove)
			{
				
				//checks the condition of the move
				if(checkConditional(moveList.get(i)))
				{
					ArrayList<Move> conditionalList = moveList.get(i).getMoveList();
					//performs the moves if the condition is true
					
					for(int index = 0; index < conditionalList.size(); index++)
					{
						if(doMove(conditionalList.get(index), g))
						{
							return true;
						}
					}
				}
				
			}
			//does all the rest of the moves
			else
			{
				
				if(doMove(moveList.get(i), g)){
					return true; 
				}
			}
			
			
			

		}
		//*/
		//Sleep again so the User can see their final position
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//If this point is reached, the player's strategy has failed.
		//We reset their location back to the spawn point
		player.setX(currentLevel.playerSpawnX);
		player.setY(currentLevel.playerSpawnY);
		
		//We return false to indicate that their strategy has failed.
		return false;
	}
	
	//this function checks the condition of the conditional moves
	//there are no returns
	//the parameter is the move that is passed in
	public Boolean checkConditional(Move move)
	{

		Boolean checker = false;
		//gets the condition
		String condition = ((ConditionalMove) move).getConditionalMove();
			
		//the only condition that is possible is this one
		if(condition == "red square" && currentLevel.getUnitAtPosition(player.getX(), player.getY()).isRedSquare)
		{
			checker = true;
		}
				
		return checker;
	}

	
	//Sleeps to make things more visible, moves the player, then repaints and revalidates to display the new state
	private Boolean doMove(Move m, Graphics g)
	{
		//Sleep the thread to make the block moves discontinuous.
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		player.drawVisitedMark(g);
		
		m.doMove(player, g);
		
		//Display the move that was just made.
		player.draw(g);

		//check if the player is overlapping the goal
		if (currentLevel.getLayout().get(player.getY()).get(player.getX()).isgoal) {

			JOptionPane.showMessageDialog(this,
				    "You guided Buster home safely! Click OK to proceed to next level",
				    "Congratulations!",
				    JOptionPane.PLAIN_MESSAGE);
			return true; 
		}
		
		validate();
		repaint();
		return false;
	}

	// returns the dimension of a unit on the board
	public int getUnitDimension(){
		return unitDimension;
	}
	
	
	//Super for drawing the Level and the Player on the board.
	@Override
	public void paintComponent(Graphics g)
	{
		// draws the grid
		BufferedImage grass = Game.getBufferedImage(Game.tileImage);
		super.paintComponent(g);
		
		for(int i = 0; i< currentLevel.getLayout().size(); i++)
		{
			for(int j = 0; j < currentLevel.getLayout().get(0).size(); j ++)
			{
				
				g.setColor(Color.lightGray);
				g.drawRect(j*unitDimension,  i*unitDimension, unitDimension,  unitDimension);

				Unit current = currentLevel.getLayout().get(i).get(j);
				
			
					
				if(current.isRedSquare)
				{
					g.setColor(current.getColor());
					g.fillRect(j*unitDimension + 1, i*unitDimension + 1, unitDimension - 2, unitDimension - 2); 
				}
				else if(current.getImage() != null)
				{
					g.drawImage(current.getImage(), j*unitDimension + 1, i*unitDimension + 1, unitDimension - 2, unitDimension - 2, player); 
				}
				else
				{
					g.drawImage(grass, j*unitDimension + 1, i*unitDimension + 1, unitDimension - 2, unitDimension - 2,null); 
				}
			}
		}
		

		player.draw(g);
	}

}