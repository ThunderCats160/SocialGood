import java.awt.image.BufferedImage;


public class Move {

	private BufferedImage sprite; 
	protected String name; 
	private Board board; 
	
	public Move(String desc, Board b, BufferedImage newSprite){
		
		name = ""; 
	}
	
	public void doMove(Player player)
	{
		
	}
	
	public String getName(){
		return name; 
	}
}
