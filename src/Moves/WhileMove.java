package moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Board;
import units.Player;


public class WhileMove extends Move{

	
	//the constructor
	//no returns
	//the parameters are the parameters that are used by the MOVE class which is extended here
	public WhileMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "LOOP"; 
		//moveList.add(new LeftMove("d", b, s)); 
		
		isWhileMove = true; 
	}
	
	//this function is not used here
	public void doMove(Player player, Graphics g)
	{	
		
	}
	
	//this function adds the move passed in to the move list
	//there are no returns
	//the parameter is the move that is being added
	public void addMove(Move m)
	{
		moveList.add(m); 
	}
	
}