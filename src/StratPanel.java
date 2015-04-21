import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
public class StratPanel extends JPanel{

	ArrayList<Move> currentStrat;

	public StratPanel()
	{
		initGUI();

		currentStrat = new ArrayList<Move>();

	}

	public void initGUI()
	{
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
