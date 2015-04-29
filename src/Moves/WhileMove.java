package moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Board;
import units.Player;


public class WhileMove extends Move{

	
	
	public WhileMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "LOOP"; 
		//moveList.add(new LeftMove("d", b, s)); 
		
		isWhileMove = true; 
	}
	
	public void doMove(Player player, Graphics g)
	{	
		
	}
	
	public void addMove(Move m)
	{
		moveList.add(m); 
	}
	
}