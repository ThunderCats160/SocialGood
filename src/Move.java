import java.awt.image.BufferedImage;


public class Move {

	private BufferedImage sprite; 
	protected String name; 
	public Board board; 
	
	public Move(String desc, Board b, BufferedImage newSprite){
		
		name = ""; 
		board = b; 
	}
	
	public void doMove(Player player)
	{
		
	}
	
	public String getName(){
		return name; 
	}
}
