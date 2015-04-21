import java.awt.image.BufferedImage;


public class RightMove extends Move{

	public RightMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "RIGHT"; 
	}
	
	public void doMove(Player player)
	{
		player.setX(player.getX()+1);
		
	}
}
