import java.awt.image.BufferedImage;

//The move class holds the data required to make a move.
//The data is stored primarily in the name string- each move gets its own unique name which tells us what to do.
//The specific moves implement this class.
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
