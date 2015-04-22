import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class UpMove extends Move{

	public UpMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "UP"; 
	}
	
	public void doMove(Player player)
	{
		Level l = board.getCurrentLevel(); 
		ArrayList<ArrayList<Unit>> layout = l.getLayout();
		
		if(player.getY() > 0 && !layout.get(player.getY() - 1).get(player.getX()).isObstacle)
		{
			player.setY(player.getY()-1);
		}
	
	}
}
