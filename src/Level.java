
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.ArrayList;

public class Level {

	private ArrayList<ArrayList<Unit>> levelLayout;
	private String description;
	private ArrayList<Move> availableMoves;

	int dim = 40;

	int horizontalSize = 10;
	int verticalSize = 10;
	
	int playerSpawnY; 
	int playerSpawnX; 
	
	


	public Level(int newDim, Board b)
	{
		playerSpawnY = 0; 
		playerSpawnX = 0; 
		
		
		
		dim = newDim;

		levelLayout = new ArrayList<ArrayList<Unit>>();
		description = "Default";
		availableMoves = new ArrayList<Move>();

		availableMoves.add(new RightMove("Go right", b, null));
		availableMoves.add(new DownMove("Go down", b, null));
		availableMoves.add(new LeftMove("Go left", b, null));
		availableMoves.add(new UpMove("Go up", b, null));


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

	
	public void addGoalAtPosition(int X, int Y)
	{
		levelLayout.get(Y).set(X, new Goal(Color.yellow, null)); 
	}
	
	public void addObstacleAtPosition(int X, int Y)
	{
		levelLayout.get(Y).set(X,  new Obstacle(Color.gray, null)); 
	}
	
	public ArrayList<ArrayList<Unit>> getLayout(){
		return levelLayout;
	}
	public String getDescription(){
		return description;
	}
	public ArrayList<Move> getAvailableMoves(){
		return availableMoves;
	}

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
