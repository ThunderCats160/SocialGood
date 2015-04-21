import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	public Player player; 
	private ArrayList<ArrayList<Unit>> layout; 
	private Level currentLevel; 
	
	public Boolean runningStrat; 
	private ArrayList<Move> currentStrat; 
	
	
	 
	
	public Board(Level l){
		currentLevel = l; 
		
		player = new Player(Color.blue, 5, 10, 40);
		
		int b = this.getX(); 
		
		runningStrat = false; 
		
		
		
	}
	
	public void incrementStrat()
	{
		if(currentStrat.size() != 0)
		{
			currentStrat.get(0).doMove(player); 
			currentStrat.remove(0); 
		}
		else
		{
			runningStrat = false; 
		}
	}
	
	
	public Boolean testStrategy(ArrayList<Move> moveList){
		
		//currentStrat = moveList; 
		runningStrat = true; 
		
		
		Graphics g = getGraphics(); 
		 
		
		for(int i = 0; i < moveList.size(); i++){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			moveList.get(i).doMove(player);
			
			draw(g); 
			
			
		}
		runningStrat = false; 
		
		moveList.clear(); 

		return false; 
		
		 
	}
	
	public void paint(Graphics g)
	{
		draw(g);  
	}
	
	public void draw(Graphics g)
	{
		if(runningStrat){
			currentLevel.draw(g, 0); 
			player.draw(g, 0); 
		}
		else
		{
			currentLevel.draw(g, this.getX()); 
			player.draw(g, this.getX()); 
		}
		
	}
}
