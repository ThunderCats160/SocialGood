import java.awt.image.BufferedImage;


public class LeftMove extends Move{

	public LeftMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "LEFT"; 
	}
	
	public void doMove(Player player)
	{
		
		if(player.getX() > 0)
		{
			player.setX(player.getX()-1);
		}
		
		
		
	}
}
