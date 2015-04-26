package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Game;

public class teacherPanelButtonAL implements ActionListener{
	
	//Holds an instance of the Game
	Game game; 
	
	//Constructor- Takes in the game so that when the button is called, it adds the instructions panel to the display
	public teacherPanelButtonAL(Game g)
	{
		game = g; 
	}
	
	//When the button is pressed, this actionPerformed changes the display to the instructions page
	public void actionPerformed(ActionEvent arg0) {

		//adds the mainGamePanel
		game.add(game.getTeacherPanel()); 
		
		//sets the intro screen panel to false
		game.getIntroScreenPanel().setVisible(false);
		
		
		//sets the instructions panel to visible
		game.getTeacherPanel().setVisible(true);
		
		//Repaints the game, now with the instructions Panel displaying.	
		game.refreshApplet(); 		
	}

}
