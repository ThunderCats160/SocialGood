package Moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList; 

import Main.Board;
import Units.Player;

public class conditionalMove extends Move{

	private String conditional;
	
	public conditionalMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "Conditional"; 
		//moveList.add(new LeftMove("d", b, s)); 
		
		isConditionalMove = true;
	}
	
	public String getConditionalMove()
	{
		return conditional;
	}
	
	public void doMove(Player player, Graphics g)
	{	
		
	}
	
	public void addMove(Move m)
	{
		moveList.add(m); 
	}

	
}
