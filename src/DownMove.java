import java.awt.image.BufferedImage;


public class DownMove extends Move{

	public DownMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "DOWN"; 
	}
	
	public void doMove(Player player)
	{
		player.setY(player.getY()+1);
		
	}
}
