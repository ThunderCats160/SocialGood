import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
public class StratPanel extends JPanel{

	ArrayList<Move> currentStrat;

	public StratPanel()
	{
		initGUI();

		currentStrat = new ArrayList<Move>();

	}

	public void clearCurrentStrat()
	{
		currentStrat.clear(); 
		removeAll(); 
		initGUI(); 
		
		setVisible(false); 
		setVisible(true); 
	}
	
	public void initGUI()
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JButton b1 = new JButton();
		b1.setText("HOLA");

		add(b1);
	}

	public ArrayList<Move> getCurrentStrat(){
		return  currentStrat;
	}

	public void addMove(Move toAdd)
	{
		currentStrat.add(toAdd);
	}


}
