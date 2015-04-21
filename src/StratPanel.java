import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
public class StratPanel extends JPanel{
	
	ArrayList<Move> currentStrategy; 
	
	public StratPanel()
	{
		initGUI(); 
		currentStrategy = new ArrayList<Move>(); 
	}
	public ArrayList<Move> getCurrentStrat(){
		return  currentStrategy;  
	}
	
	public void initGUI()
	{
		JButton b1 = new JButton();
		b1.setText("HOLA");
		
		add(b1); 
		 
	}
	
	public void addMove(Move toAdd)
	{
		currentStrategy.add(toAdd); 
	}

}
