package Main;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Moves.DownMove;
import Moves.LeftMove;
import Moves.Move;
import Moves.RightMove;
import Moves.UpMove;
import Moves.WhileMove;
import Moves.conditionalMove;
import Units.Goal;
import Units.Obstacle;
import Units.Unit;

//The level class holds the layout for the level, the string description for the level, and the available moves for this level.
//Depending on the currentLevel, these things will change.
public class Level {

	//Holds Units for creating the level's layout.
	private ArrayList<ArrayList<Unit>> levelLayout;
	//Holds the text description of the level. Ex: "This is Level 2. In this level, we are going to implement conditionals"
	private String description;
	//The available moves that can be used for this level.
	private ArrayList<Move> availableMoves;

	

	int horizontalSize = 10;
	int verticalSize = 10;
	
	//Holds the XY location where the player will spawn for each level.
	int playerSpawnY; 
	int playerSpawnX; 
	
	Board board; 
	
	Boolean customFunctionsAvailable; 
	
	//The number of moves that can be used for this
	private int numOfUsableMoves; 
	
	

	//TODO: Different levels should have different available moves!
	//Add some way to differentiate the available moves.
	public Level(int newDim, Board b)
	{
		//Initial playerSpawn is 0,0
		playerSpawnY = 0; 
		playerSpawnX = 0; 
		
		board = b; 
		
		//board.setUnitDimension(newDim);
		
		
		levelLayout = new ArrayList<ArrayList<Unit>>();
		description = "Default";
		
		//Set the available moves
		availableMoves = new ArrayList<Move>();

		numOfUsableMoves = 10; 
		

		//TODO: I have no idea what this does.
		for(int i =0; i < horizontalSize; i ++)
		{
			ArrayList<Unit> toAdd = new ArrayList<Unit>();
			for(int j = 0; j < verticalSize; j ++)
			{
				toAdd.add(new Unit(Color.white, null));
			}

			levelLayout.add(toAdd);
		}
		
		customFunctionsAvailable = false; 
		 

	}
	
	public void setNumOfUsableMoves(int set){
		numOfUsableMoves = set; 
	}
	
	public int getNumOfUsableMoves(){
		return numOfUsableMoves;
	}
	
	public void setCustomFunctionsAvailable(Boolean set)
	{
		customFunctionsAvailable = set; 
	}
	public Boolean getCustomFunctionsAvailable()
	{
		return customFunctionsAvailable; 
	}
	
	public void makeRightMoveAvailable()
	{
		availableMoves.add(new RightMove("Go right", board, null));
		
	}
	public void makeDownMoveAvailable()
	{
		availableMoves.add(new DownMove("Go down", board, null));
	}
	public void makeLeftMoveAvailable()
	{
		availableMoves.add(new LeftMove("Go left", board, null));
	}
	public void makeUpMoveAvailable()
	{
		availableMoves.add(new UpMove("Go up", board, null));
	}
	public void makeWhileMoveAvailable()
	{	
		availableMoves.add(new WhileMove("While", board, null)); 
	}
	public void makeConditionalMoveAvailable()
	{
		availableMoves.add(new conditionalMove("Conditional", board, null));
	}

	//Setter for the Description for the level.
	public void setDescription(String newDesc)
	{
		description = newDesc; 
	}
	
	//Sets the Goal for the level at the position indicated
	public void addGoalAtPosition(int X, int Y)
	{
		levelLayout.get(Y).set(X, new Goal(Color.yellow, null)); 
	}
	//Sets the Goal for the level at the position indicated
	public void addGoalAtPosition(int X, int Y, BufferedImage image)
	{
		levelLayout.get(Y).set(X, new Goal(Color.yellow, image)); 
	}
		
	
	
	//Sets the Player's Spawn for the level.
	public void setPlayerSpawnPosition(int X, int Y)
	{
		playerSpawnX = X; 
		playerSpawnY = Y; 
	}
	
	//Sets the obstacle in the level
	public void addObstacleAtPosition(int X, int Y)
	{
		levelLayout.get(Y).set(X,  new Obstacle(Color.gray, null)); 
	}
	
	//Sets the obstacle in the level
	public void addObstacleAtPosition(int X, int Y, BufferedImage image)
	{
		levelLayout.get(Y).set(X,  new Obstacle(Color.gray, image)); 
	}
	
	//Getter for the Level's layout
	public ArrayList<ArrayList<Unit>> getLayout(){
		return levelLayout;
	}
	//Getter for the Description for the level
	public String getDescription(){
		return description;
	}
	//Getter for the available moves for each level
	public ArrayList<Move> getAvailableMoves(){
		return availableMoves;
	}
	
	//Draw the layout grid.
	public void draw(Graphics g)
	{
		
		
		
	}
	
	public void addRedSquareAtPosition(int X, int Y){
		levelLayout.get(Y).get(X).isRedSquare = true; 
		levelLayout.get(Y).get(X).setColor(Color.red); 
		levelLayout.get(Y).get(X).setImage(null);
	}
	
	public Unit getUnitAtPosition(int X, int Y){
		return levelLayout.get(Y).get(X); 
	}

}