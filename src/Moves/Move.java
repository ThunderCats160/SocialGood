package Moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Main.Board;
import Units.Player;

//The move class holds the data required to make a move.
//The data is stored primarily in the name string- each move gets its own unique name which tells us what to do.
//The specific moves implement this class.
public class Move {

	private BufferedImage sprite; 
	protected String name; 
	public Board board; 
	protected ArrayList<Move> moveList; 
	
	public Boolean isWhileMove; 
	
	public Move(String desc, Board b, BufferedImage newSprite){
		
		isWhileMove = false; 
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