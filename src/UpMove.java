import java.awt.image.BufferedImage;



public class UpMove extends Move{

	public UpMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "UP"; 
	}
	
	public void doMove(Player player)
	{
		
		if(player.getY() > 0)
		{
			player.setY(player.getY()-1);
		}
	
	}
}
