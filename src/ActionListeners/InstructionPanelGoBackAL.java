package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Game;

public class InstructionPanelGoBackAL implements ActionListener{

	Game game; 
	
	public InstructionPanelGoBackAL(Game g)
	{
		game = g; 
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game.getInstructionPanel().setVisible(false); 
		game.getIntroScreenPanel().setVisible(true); 
		
	}

}
