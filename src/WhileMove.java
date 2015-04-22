import java.awt.image.BufferedImage;
import java.util.ArrayList; 


public class WhileMove extends Move{

	private ArrayList<Move> toDo; 
	
	public WhileMove(String d, Board b, BufferedImage s)
	{
		super(d, b, s); 
		name = "While"; 
	}
	
	public void doMove(Player player)
	{	
		for(int i = 0; i < toDo.size(); i++){
			toDo.get(i).doMove(player);
		}	
	}
	
	public void addMove(Move m)
	{
		toDo.add(m); 
	}
}
