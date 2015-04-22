import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//When the Player indicates that they are ready to start playing the game from the button on the
//introPanel, this class moves the display from the introPanel to the actual Game.
public class introPanelButtonAL implements ActionListener{
	//Holds an instance of the Game
	Game game; 
	
	//Constructor- Takes in the game so that when the button is called, it adds the maingamePanel to the display
	public introPanelButtonAL(Game g)
	{
		game = g; 
	}
	
	//When the button is pressed, this actionPerformed changes the display to the actual game.
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		//adds the mainGamePanel
		game.add(game.mainGamePanel); 
		
		//sets the intro screen panel to false
		game.introScreenPanel.setVisible(false);
		
		//sets the main game panel to visible
		game.mainGamePanel.setVisible(true);
		
		//Repaints the game, now with the mainGamePanel displaying.	
		game.repaint(); 		
	}

}
