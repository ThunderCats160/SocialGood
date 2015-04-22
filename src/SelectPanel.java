import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

//The Select Panel holds an ArrayList of the move options for the level
//It also holds a copy of the strategy panel (which gets inputs from the select Panel)
//It also holds buttons to display the move options
public class SelectPanel extends JPanel implements ActionListener {


	ArrayList<Move> selectOptions;

	StratPanel stratPanel;

	JButton goButton;

	//Initiate a SelectPanel with a StratPanel
	public SelectPanel(StratPanel newStratPanel)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		stratPanel = newStratPanel;

		initGUI();

	}

	//Iterate through the ArrayList of Moves to create the buttons in the SelectPanel
	public void setSelectOptions(ArrayList<Move> newOptions){

		removeAll();
		selectOptions = newOptions;
		//Iterates through
		for(int i = 0; i < selectOptions.size(); i ++)
		{
			//Create a new button for each option in the ArrayList
			JButton b = new JButton();
			b.setText(selectOptions.get(i).getName());
			b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel));
			
			
			add(b);
		}

	}

	//InitGUI must be called as a default
	public void initGUI()
	{
		JButton b1 = new JButton();
		b1.setText("DSFHDSFKJS");

		add(b1);


	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub



	}




}
