
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Level {
	
	private ArrayList<ArrayList<Unit>> levelLayout; 
	private String description; 
	private ArrayList<Move> availableMoves; 
	
	int dim = 40; 
	
	int horizontalSize = 10; 
	int verticalSize = 10; 
	
	
	public Level(int newDim)
	{
		
		dim = newDim; 
		
		levelLayout = new ArrayList<ArrayList<Unit>>(); 
		description = "Default"; 
		availableMoves = new ArrayList<Move>(); 
		
		availableMoves.add(new RightMove("Go right", null, null)); 
		availableMoves.add(new DownMove("Go Down", null, null)); 
		
		
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
	
	public ArrayList<ArrayList<Unit>> getLayout(){
		return levelLayout; 
	}
	public String getDescripion(){
		return description; 
	}
	public ArrayList<Move> getAvailableMoves(){
		return availableMoves; 
	}
	
	public void draw(Graphics g, int topLeftX)
	{
		for(int i = 0; i< levelLayout.size(); i++)
		{
			for(int j = 0; j < levelLayout.get(0).size(); j ++)
			{
				g.setColor(Color.black); 
				g.drawRect(topLeftX + j*dim,  i*dim, dim,  dim);
				
				Unit current = levelLayout.get(i).get(j); 
				g.setColor(current.getColor()); 
				
				g.fillRect(topLeftX + j*dim + 1, i*dim+1, dim-2, dim-2);
			}
		}
	}

}
