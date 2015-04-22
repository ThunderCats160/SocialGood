import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class introPanelButtonAL implements ActionListener{

	Game game; 
	
	
	public introPanelButtonAL(Game g)
	{
		game = g; 
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		game.removeAll(); 
		game.add(game.mainGamePanel); 

		game.setVisible(false); 
		game.setVisible(true); 
		game.repaint(); 		
	}

}
