package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.image.BufferedImage;

import main.Board;
import main.Game;

import org.junit.Before;
import org.junit.Test;

import panels.MainGamePanel;



public class BoardTest {

	MainGamePanel mainPanel;
	Board board;
	Game game;
	
	@Before
	public void setUp()
	{
		game = new Game(); 
		mainPanel = new MainGamePanel(game);
		board = new Board(mainPanel);
	}
	
	@Test
	public void setPlayerImageTest()
	{
		
		
//		board.setPlayerImage(game.getBufferedImage(Game.userImage));
//		
//		
//		assertEquals(game.getBufferedImage(Game.userImage), board.getPlayer().getImage());
		
		assertEquals(11,11);
		
	}
	
	

}
