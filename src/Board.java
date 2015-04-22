import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Board extends JPanel{



	private Level currentLevel;
	private Player player;


	public Board(){
		player = new Player(Color.blue, 5, 10, 40);

	}

	public void setCurrentLevel(Level newLevel)
	{
		currentLevel = newLevel;
		player.setX(currentLevel.playerSpawnX);
		player.setY(currentLevel.playerSpawnY);
		
		setVisible(false); 
		setVisible(true); 
		
	}
	public Level getCurrentLevel()
	{
		return currentLevel; 		
	}

	public Boolean testStrategy(ArrayList<Move> moveList){

		Graphics g = getGraphics();


		for(int i = 0; i < moveList.size(); i++){

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			moveList.get(i).doMove(player);

			paint(g);
			 

			//check if the player is overlapping the goal
			if(currentLevel.getLayout().get(player.getY()).get(player.getX()).isgoal)
			{
				return true; 
			}
			
			setVisible(false); 
			setVisible(true); 
			
			

		}
		
		player.setX(currentLevel.playerSpawnX);
		player.setY(currentLevel.playerSpawnY);
		
		paint(g); 

		return false;


	}



	public void paint(Graphics g)
	{
		currentLevel.draw(g);
		player.draw(g);

	}

}
