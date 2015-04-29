package moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Board;
import units.Player;


public class FunctionMove extends Move{

	
	//this is the constructor
	//there is no returns
	//the parameters are the same as the MOVE class since it is extended here
	//and it also includes a move list that will be added to this move
	public FunctionMove(String d, Board b, BufferedImage s, ArrayList<Move> newMoveList, String newName)
	{
		super(d, b, s); 
		name = newName; 	
		moveList = newMoveList;
		isFunctionMove = true; 
	}
	
	//this function adds the move to the move list
	//there are no returns
	//the one parameter is the move you would like to add
	public void addMove(Move m)
	{
		moveList.add(m); 
	}
	
}