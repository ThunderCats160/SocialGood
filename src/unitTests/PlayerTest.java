package unitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import main.Board;
import main.Game;

import org.junit.Before;
import org.junit.Test;

import panels.SelectPanel;
import panels.StratPanel;
import units.Player;

public class PlayerTest {
	
	Player player;

	@Before
	public void setUp()
	{
		player = new Player(Color.blue, 5, 10, Board.unitDimension);
	}
	
	
	@Test
	public void setXandsetYTest()
	{
	
		player.setX(10);
		player.setY(11);
		
		assertEquals(10,player.getX());
		assertEquals(11,player.getY());
	}

}
