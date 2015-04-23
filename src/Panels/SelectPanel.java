package Panels;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Moves.Move;
import Moves.moveAdderAL;
import Moves.whileMoveAdderAL;

//The Select Panel holds an ArrayList of the move options for the level
//It also holds a copy of the strategy panel (which gets inputs from the select Panel)
//It also holds buttons to display the move options
public class SelectPanel extends JPanel implements ActionListener {


	ArrayList<Move> selectOptions;

	StratPanel stratPanel;

	
	private Boolean addingToWhile; 
	

	
	

	//Initiate a SelectPanel with a StratPanel
	public SelectPanel(StratPanel newStratPanel)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		stratPanel = newStratPanel;
		
		addingToWhile = false; 

		initGUI();

	}
	
	public void setAddToWhile(boolean value){
		addingToWhile = value;
	}

	public boolean getAddToWhile(){
		return addingToWhile;
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
			
			if(!selectOptions.get(i).isWhileMove)
				b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel, this));
			else
			{
				b.addActionListener(new whileMoveAdderAL(selectOptions.get(i), stratPanel, this));
			}
				 
			
			add(b);
		}
		
	}
	
	//To reset what the whileMove holds. 
	public void resetSelectOptions()
	{
		for(int i = 0; i< selectOptions.size(); i++)
		{
		
			selectOptions.get(i).clearMoveList(); 
			//System.out.println(selectOptions.get(i).getMoveList().size()); 
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