package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Game;

public class TeacherPanelGoBackAL implements ActionListener{

	Game game; 
	
	public TeacherPanelGoBackAL(Game g)
	{
		game = g; 
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game.getTeacherPanel().setVisible(false); 
		game.getIntroScreenPanel().setVisible(true); 
		
	}

}
