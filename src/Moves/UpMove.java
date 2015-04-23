package Moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Main.Board;
import Main.Level;
import Units.Player;
import Units.Unit;


//UpMove is one of our move options
//The UpMove is differentiated by its name "UP"
//The action doMove actually carries out the move- it changes the Y coordinate of the player by -1.
public class UpMove extends Move{

	public UpMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		//By setting the name of the move, we pass this name to the ArrayList storing the moves.
		name = "UP"; 
	}
	
	//Actually carries out the move when "moveList.get(i).doMove(player);" (Board 63) is called.
	public void doMove(Player player, Graphics g)
	{
		//Criteria for carrying out move:
		//If there is not an obstacle in the way, the move is carried out.
		
		//Get in the level currently being played.
		Level l = board.getCurrentLevel(); 
		ArrayList<ArrayList<Unit>> layout = l.getLayout();
		//If the move will make the Player pass through an obstacle, do not carry out the move.
		//Otherwise, carry out the move.
		if(player.getY() > 0 && !layout.get(player.getY() - 1).get(player.getX()).isObstacle)
		{
			player.setY(player.getY()-1);
		}
	
	}
}