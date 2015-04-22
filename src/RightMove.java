import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class RightMove extends Move{

	public RightMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "RIGHT"; 
	}
	
	public void doMove(Player player)
	{
		Level l = board.getCurrentLevel(); 
		ArrayList<ArrayList<Unit>> layout = l.getLayout();
		
		if(player.getX() < layout.get(0).size() -1 && !layout.get(player.getY()).get(player.getX() +1).isObstacle)
		{
			player.setX(player.getX()+1);
		}
		
		
		
	}
}
