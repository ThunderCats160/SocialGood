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
	}

	public Boolean testStrategy(ArrayList<Move> moveList){

		//currentStrat = moveList;


		Graphics g = getGraphics();


		for(int i = 0; i < moveList.size(); i++){

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			moveList.get(i).doMove(player);

			paint(g);

			System.out.println("HERE");
			System.out.println(player.getX());

		}


		moveList.clear();

		return false;


	}



	public void paint(Graphics g)
	{
		currentLevel.draw(g);
		player.draw(g);

	}

}
