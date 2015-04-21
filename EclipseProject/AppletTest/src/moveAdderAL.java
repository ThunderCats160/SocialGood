import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
		
		
		
	}

}
