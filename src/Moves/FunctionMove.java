package moves;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Board;
import units.Player;


public class FunctionMove extends Move{

	
	
	public FunctionMove(String d, Board b, BufferedImage s, ArrayList<Move> newMoveList, String newName)
	{
		super(d, b, s); 
		name = newName; 	
		moveList = newMoveList;
		isFunctionMove = true; 
	}
	
	public void doMove(Player player, Graphics g)
	{	
		//Do every move in the function
		for(int i =0; i< moveList.size(); i++){
			System.out.println(moveList.get(i).name);
		}
	}
	
	public void addMove(Move m)
	{
		moveList.add(m); 
	}
	
}