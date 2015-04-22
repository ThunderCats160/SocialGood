import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

//Action listener linked to each button
//When a button is pressed, it adds a move to the current strategy list in stratPanel
public class moveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	
	//Constructor
	public moveAdderAL(Move m, StratPanel newStratPanel)
	{
		
		toAdd = m; 
		stratPanel = newStratPanel; 
	}
	//When the button is pressed to add the move to the strategylist:
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Add the selected move to the Strategy Panel
		stratPanel.addMove(toAdd); 
		//Add the name of the Strategy to display
		stratPanel.add(new JLabel(toAdd.name)); 
		stratPanel.setVisible(false); 
		stratPanel.setVisible(true); 
		
		
		
	}

}
