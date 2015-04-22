import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class LeftMove extends Move{

	public LeftMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "LEFT"; 
	}
	
	public void doMove(Player player)
	{
		Level l = board.getCurrentLevel(); 
		ArrayList<ArrayList<Unit>> layout = l.getLayout();
		
		if(player.getX() > 0 && !layout.get(player.getY()).get(player.getX() -1).isObstacle)
		{
			player.setX(player.getX()-1);
		}
		
		
		
	}
}
