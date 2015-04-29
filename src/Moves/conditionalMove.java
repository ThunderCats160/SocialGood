package moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Board;
import units.Player;

//this is the conditional move 
public class ConditionalMove extends Move{

	//this is a string that tells the user what condition is being checked
	private String conditional;
	
	//the constructor
	//no returns
	//the parameters are the parameters that are used by the MOVE class which is extended here
	public ConditionalMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		//the name of this move is conditional
		name = "Conditional"; 
		//to make show that this is a conditional move
		this.isConditionalMove = true;
	}
	
	//this function returns the conditional statement
	//there are no parameters
	public String getConditionalMove()
	{
		return conditional;
	}
	
	//this function sets the conditional statement
	//there are no returns
	//the string is the new condition you would like the move to have
	public void setConditionalMove(String condition)
	{
		conditional = condition;
	}
	
	//function is not implemented here
	public void doMove(Player player, Graphics g)
	{	
		
	}
	
	//this adds the move to the move list
	public void addMove(Move m)
	{
		moveList.add(m); 
	}

	
}
