import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class moveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	
	public moveAdderAL(Move m, StratPanel newStratPanel)
	{
		
		toAdd = m; 
		stratPanel = newStratPanel; 
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		stratPanel.addMove(toAdd); 
		stratPanel.add(new JLabel(toAdd.name)); 
		stratPanel.setVisible(false); 
		stratPanel.setVisible(true); 
		
		
		
	}

}
