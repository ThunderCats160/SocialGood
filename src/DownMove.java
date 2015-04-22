import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class DownMove extends Move{

	public DownMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "DOWN"; 
	}
	
	public void doMove(Player player)
	{
		Level l = board.getCurrentLevel(); 
		ArrayList<ArrayList<Unit>> layout = l.getLayout();
		
		if(player.getY() < layout.size() -1)
		{
			player.setY(player.getY()+1);
		}
		
		
	}
}
