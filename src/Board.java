import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

//Board Class holds the implementation for the Board.
//Uses JPanel
public class Board extends JPanel{

	//Instantiates:
	//Because our game has multiple levels, it is important for the Board to know which level we are on.
	//Each Level will call for different objects to be painted onto the board in different locations, and the available moves are different.
	private Level currentLevel;
	//Player holds the position of the user's character (currently a block) in XY format.
	private Player player;


	//Default constructor. Calls for the player to be made
	public Board(){
		player = new Player(Color.blue, 5, 10, 40);

	}
	
	//The Level of the game decides the initial location for the player and obstacles.
	public void setCurrentLevel(Level newLevel)
	{
		//TODO: Implement  & Set Obstacle Locations
		
		//Set the player's initial location based on the level's initial settings.
		currentLevel = newLevel;
		player.setX(currentLevel.playerSpawnX);
		player.setY(currentLevel.playerSpawnY);
		
		//??
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
		for(int i = 0; i < moveList.size(); i++){
			
			//Sleep the thread to make the block moves discontinuous.
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Carry out the current move in the iteration
			moveList.get(i).doMove(player);
			//Display the move that was just made.
			paint(g);
			 

			//check if the player is overlapping the goal
			if(currentLevel.getLayout().get(player.getY()).get(player.getX()).isgoal)
			{
				return true; 
			}
			
			//??
			setVisible(false); 
			setVisible(true); 
			
			

		}
		
		//If this point is reached, the player's strategy has failed.
		//We reset their location back to the spawn point
		player.setX(currentLevel.playerSpawnX);
		player.setY(currentLevel.playerSpawnY);
		
		paint(g); 
		//We return false to indicate that their strategy has failed.
		return false;


	}


	//Super for drawing the Level and the Player on the board.
	public void paint(Graphics g)
	{
		currentLevel.draw(g);
		player.draw(g);

	}

}
