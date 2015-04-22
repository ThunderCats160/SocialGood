import java.awt.image.BufferedImage;
import java.util.ArrayList;

//LeftMove is one of our move options
//The LeftMove is differentiated by its name "LEFT"
//The action doMove actually carries out the move- it changes the X coordinate of the player by  -1.
public class LeftMove extends Move{

	public LeftMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		//By setting the name of the move, we pass this name to the ArrayList storing the moves.
		name = "LEFT"; 
	}
	
	//Actually carries out the move when "moveList.get(i).doMove(player);" (Board 63) is called.
	public void doMove(Player player)
	{
		//Criteria for carrying out move:
			//If there is not an obstacle in the way, the move is carried out.
			
		//Get in the level currently being played.
		Level l = board.getCurrentLevel(); 
		ArrayList<ArrayList<Unit>> layout = l.getLayout();
		
		//If the move will make the Player pass through an obstacle, do not carry out the move.
		//Otherwise, carry out the move.
		if(player.getX() > 0 && !layout.get(player.getY()).get(player.getX() -1).isObstacle)
		{
			player.setX(player.getX()-1);
		}
		
		
		
	}
}
