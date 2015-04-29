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
		//sets the x and y using the set method
		player.setX(10);
		player.setY(11);
		
		//checks to make sure the x and y are correct and also checks
		//the get x and get y functions
		assertEquals(10,player.getX());
		assertEquals(11,player.getY());
	}
	
	@Test
	public void setDirectionTest()
	{
		//sets the direction of the player using ints
		player.setDirection(15);
		
		//checks to make sure the int that was passed in is the same
		assertEquals(15, player.getDirection());
	}

}
