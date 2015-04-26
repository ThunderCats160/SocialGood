package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class instructionPanelAL implements ActionListener{

	Game game; 
	
	public instructionPanelAL(Game g)
	{
		game = g; 
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game.getInstructionPanel().setVisible(false); 
		game.getIntroScreenPanel().setVisible(true); 
		
	}

}
