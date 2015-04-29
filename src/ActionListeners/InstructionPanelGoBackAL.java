package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Game;


public class InstructionPanelGoBackAL implements ActionListener{

	Game game; 
	//constructor which only takes the game
	//no returns
	public InstructionPanelGoBackAL(Game g)
	{
		game = g; 
	}
	
	//this takes you back to the home screen when the back button is pressed on the 
	//instructions screen
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		//sets the instructions panel visibility to false
		//and sets the home screen panel to true
		game.getInstructionPanel().setVisible(false); 
		game.getIntroScreenPanel().setVisible(true); 
		
		//refreshes the screen
		game.refreshApplet();
		
	}

}
