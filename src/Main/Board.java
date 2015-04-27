package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Moves.Move;
import Moves.conditionalMove;
import Units.Player;
import Units.Unit;

//Board Class holds the implementation for the Board.
//Uses JPanel
public class Board extends JPanel{

	//Instantiates:
	//Because our game has multiple levels, it is important for the Board to know which level we are on.
	//Each Level will call for different objects to be painted onto the board in different locations, and the available moves are different.
	private Level currentLevel;
	//Player holds the position of the user's character (currently a block) in XY format.
	private Player player;
	//Constants needed for drawing.
	static public int unitDimension = 55;


	//Default constructor. Calls for the player to be made
	public Board() {
		player = new Player(Color.blue, 5, 10, unitDimension);
		initGUI();
	}
	
	public void initGUI(){
		
	}
	
	public void setPlayerImage(BufferedImage image)
	{
		player.setImage(image); 
	}
	public void setPlayerVisitedMark(BufferedImage image){
		player.setVisitedMark(image); 
	}
	
	//The Level of the game decides the initial location for the player and obstacles.
	public void setCurrentLevel(Level newLevel){
		
		//Set the player's initial location based on the level's initial settings.
		currentLevel = newLevel;
		player.setX(currentLevel.playerSpawnX);
		player.setY(currentLevel.playerSpawnY);
		
		setVisible(false); 
		setVisible(true); 
		
	}
	//Getter for the currentLevel stored in the Board.
	public Level getCurrentLevel()
	{
		return currentLevel; 		
	}

	//If the user clicks "Run", we want to see if their strategy works. We move pieces around on the board to test their strategy.
	public Boolean testStrategy(ArrayList<Move> moveList){

		Graphics g = getGraphics();

		//Iterate through the list of moves in order to move the Player around the board.
		for(int i = 0; i < moveList.size(); i++) {
			
			//Carry out the current move in the iteration
			//The graphics item and board are passed so the whileMove can 
			//create a loop similar to this one
			if (moveList.get(i).isWhileMove) {		
				//Get the list of moves that the whileMove is to perform over and over
				ArrayList<Move> whileList = moveList.get(i).getMoveList(); 
				//System.out.println("inside the while loop");
				//Only perform the loop 10 times in case of an infinite
				for(int j = 0; j < 10; j++)
				{
					//System.out.println(whileList.size()); 
					for(int p = 0; p < whileList.size(); p++)
					{		
						
						if(whileList.get(p).name == "Conditional")
						{
							if(checkConditional(moveList.get(p)))
							{
								//get the list of moves that the conditionalMove is to perform over and over
								ArrayList<Move> conditionalList = moveList.get(p).getMoveList();
								
								
								for(int index = 0; index < conditionalList.size(); index++)
								{
									if(doMove(conditionalList.get(index), g))
									{
//										//System.out.println("in the conditional statement");
										return true;
									}
								}
							}
						}
						else if(doMove(whileList.get(p), g))
							return true; 
						
					}
				}
				
			}
			else if(moveList.get(i).isFunctionMove)
			{
				ArrayList<Move> functionList = moveList.get(i).getMoveList(); 
				
				for(int j = 0; j< functionList.size(); j++){
					if(doMove(functionList.get(j), g))
						return true; 
				}
			}
			else if(moveList.get(i).isConditionalMove)
			{
				
				
				if(checkConditional(moveList.get(i)))
				{
					//get the list of moves that the conditionalMove is to perform over and over
					ArrayList<Move> conditionalList = moveList.get(i).getMoveList();
					//System.out.println(conditionalList.size());
					
					
					for(int index = 0; index < conditionalList.size(); index++)
					{
						//System.out.println("in the conditional statement");
						if(doMove(conditionalList.get(index), g))
						{
							//System.out.println("in the conditional statement");
							return true;
						}
					}
				}
				
			}
			else
			{
				
				if(doMove(moveList.get(i), g)){
					return true; 
				}
			}
			
			
			

		}
		
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
		
		repaint(); 
		
		//We return false to indicate that their strategy has failed.
		return false;
	}
	
	private Boolean checkConditional(Move move)
	{
		//System.out.println("inside of check conditional");
		Boolean checker = false;
		String condition = ((conditionalMove) move).getConditionalMove();
		//System.out.println(condition);
		

		if(condition == "red square" && currentLevel.getUnitAtPosition(player.getX(), player.getY()).isRedSquare)
		{
			//System.out.println("in the red square condition");
			checker = true;
		}
	
		
		//red square 2,5
			
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
	
	//public void setUnitDimension(int dim){
		//unitDimension = dim;
	//}
	
	//Super for drawing the Level and the Player on the board.
	@Override
	public void paint(Graphics g)
	{
		// draw the grid
		BufferedImage grass = Game.getBufferedImage("Grass.png");
		super.paint(g);
		
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
					//System.out.println("NOT NULL"); 
					g.drawImage(current.getImage(), j*unitDimension + 1, i*unitDimension + 1, unitDimension - 2, unitDimension - 2, player); 
				}
				else
				{
					//g.setColor(current.getColor());
					g.drawImage(grass, j*unitDimension + 1, i*unitDimension + 1, unitDimension - 2, unitDimension - 2,null); 
					//g.fillRect(j*unitDimension + 1, i*unitDimension + 1, unitDimension - 2, unitDimension - 2);
				}
			}
		}
		
		//doesn't do anything
		//currentLevel.draw(g);
		player.draw(g);
	}

}