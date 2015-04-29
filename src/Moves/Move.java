package moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Board;
import units.Player;

//The move class holds the data required to make a move.
//The data is stored primarily in the name string- each move gets its own unique name which tells us what to do.
//The specific moves implement this class.
public class Move {


	public String name; 
	public Board board; 
	public ArrayList<Move> moveList; 
	
	
	//booleans that tell you if it is while, function or conditional
	public Boolean isWhileMove; 
	public Boolean isFunctionMove;
	public Boolean isConditionalMove;
	
	//the constructor
	//there are no returns
	//the parameters are the board, a string and a sprite
	public Move(String desc, Board b, BufferedImage newSprite){
		
		isWhileMove = false; 
		isConditionalMove = false;
		isFunctionMove = false; 
		
		name = ""; 
		board = b; 
		moveList = new ArrayList<Move>(); 
	}
	
	//this should never run
	public void doMove(Player player, Graphics g)
	{
		System.out.println("This should never be run"); 
	}
	
	//this gets the name of the move
	//no parameters
	//the returns is the name of the move
	public String getName(){
		return name; 
	}
	
	//this function gets the move list of the move
	//no parameters
	//the return is the move list
	public ArrayList<Move> getMoveList()
	{
		return moveList; 
	}
	
	//this clears the move list
	//there are no returns or parameters
	public void clearMoveList()
	{
		moveList.clear(); 
	}
}