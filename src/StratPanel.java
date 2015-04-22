import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
public class StratPanel extends JPanel implements ActionListener{

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
		JButton clearButton = new JButton();
		clearButton.setText("CLEAR");
		clearButton.addActionListener(this);

		add(clearButton);
	}

	public ArrayList<Move> getCurrentStrat(){
		return  currentStrat;
	}

	public void addMove(Move toAdd)
	{
		currentStrat.add(toAdd);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clearCurrentStrat(); 
		
		
	}


}
