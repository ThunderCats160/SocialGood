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
	
	public Boolean isWhileMove; 
	public Boolean isFunctionMove;
	public Boolean isConditionalMove;
	
	public Move(String desc, Board b, BufferedImage newSprite){
		
		isWhileMove = false; 
		isConditionalMove = false;
		isFunctionMove = false; 
		
		name = ""; 
		board = b; 
		moveList = new ArrayList<Move>(); 
	}
	
	public void doMove(Player player, Graphics g)
	{
		System.out.println("This should never be run"); 
	}
	
	public String getName(){
		return name; 
	}
	
	public ArrayList<Move> getMoveList()
	{
		return moveList; 
	}
	
	public void clearMoveList()
	{
		moveList.clear(); 
	}
}