package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Game;


//this class creates a button that will take the user from the teacher page to the home screen
public class TeacherPanelGoBackAL implements ActionListener{

	//holds an instance of the game
	Game game; 
	
	//the constructor, has no returns
	//the parameter is the instance of the game that this class will hold
	public TeacherPanelGoBackAL(Game g)
	{
		game = g; 
	}
	
	//when the button is pressed, it takes you back to the home screen
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//this sets the teacher panel visibility to false
		//and the intro screen panel to true
		game.getTeacherPanel().setVisible(false); 
		game.getIntroScreenPanel().setVisible(true); 
		
		game.refreshApplet();
	}

}
