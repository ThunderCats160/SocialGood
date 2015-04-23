import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.ArrayList;

//The level class holds the layout for the level, the string description for the level, and the available moves for this level.
//Depending on the currentLevel, these things will change.
public class Level {

	//Holds Units for creating the level's layout.
	private ArrayList<ArrayList<Unit>> levelLayout;
	//Holds the text description of the level. Ex: "This is Level 2. In this level, we are going to implement conditionals"
	private String description;
	//The available moves that can be used for this level.
	private ArrayList<Move> availableMoves;

	//Constants needed for drawing.
	int dim = 40;

	int horizontalSize = 10;
	int verticalSize = 10;
	
	//Holds the XY location where the player will spawn for each level.
	int playerSpawnY; 
	int playerSpawnX; 
	
	

	//TODO: Different levels should have different available moves!
	//Add some way to differentiate the available moves.
	public Level(int newDim, Board b)
	{
		//Initial playerSpawn is 0,0
		playerSpawnY = 0; 
		playerSpawnX = 0; 
		
		
		
		dim = newDim;
		
		
		levelLayout = new ArrayList<ArrayList<Unit>>();
		description = "Default";
		
		//Set the available moves
		availableMoves = new ArrayList<Move>();

		availableMoves.add(new RightMove("Go right", b, null));
		availableMoves.add(new DownMove("Go down", b, null));
		availableMoves.add(new LeftMove("Go left", b, null));
		availableMoves.add(new UpMove("Go up", b, null));
		availableMoves.add(new WhileMove("While", b, null)); 

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
		for(int i = 0; i< levelLayout.size(); i++)
		{
			for(int j = 0; j < levelLayout.get(0).size(); j ++)
			{
				g.setColor(Color.black);
				g.drawRect(j*dim,  i*dim, dim,  dim);

				Unit current = levelLayout.get(i).get(j);
				g.setColor(current.getColor());

				g.fillRect(j*dim + 1, i*dim+1, dim-2, dim-2);
			}
		}
		
		
	}

}