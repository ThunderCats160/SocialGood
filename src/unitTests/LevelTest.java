package unitTests;

import main.Level;
import moves.ConditionalMove;
import moves.DownMove;
import moves.LeftMove;
import moves.RightMove;
import moves.UpMove;
import moves.WhileMove;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevelTest {
	
	Level level; 
	
	@Before
	public void setup(){
		level = new Level(40, null); 
	}
	
	@Test
	public void makeRightMoveAvailableTest(){
		level.makeRightMoveAvailable();
		RightMove rightMove = new RightMove("", null, null); 
		
		assertEquals(rightMove.getClass().getName(), level.getAvailableMoves().get(0).getClass().getName()); 
		
	}
	@Test
	public void makeDownMoveAvailableTest(){
		level.makeDownMoveAvailable();
		DownMove DownMove = new DownMove("", null, null); 
		
		assertEquals(DownMove.getClass().getName(), level.getAvailableMoves().get(0).getClass().getName()); 
		
	}
	@Test
	public void makeUpMoveAvailableTest(){
		level.makeUpMoveAvailable();
		UpMove UpMove = new UpMove("", null, null); 
		
		assertEquals(UpMove.getClass().getName(), level.getAvailableMoves().get(0).getClass().getName()); 
		
	}
	@Test
	public void makeLeftMoveAvailableTest(){
		level.makeLeftMoveAvailable();
		LeftMove LeftMove = new LeftMove("", null, null); 
		
		assertEquals(LeftMove.getClass().getName(), level.getAvailableMoves().get(0).getClass().getName()); 
		
	}
	@Test
	public void makeWhileMoveAvailableTest(){
		level.makeWhileMoveAvailable();
		WhileMove WhileMove = new WhileMove("", null, null); 
		
		assertEquals(WhileMove.getClass().getName(), level.getAvailableMoves().get(0).getClass().getName()); 
		
	}
	@Test
	public void makeConditionalMoveAvailableTest(){
		level.makeConditionalMoveAvailable();
		ConditionalMove ConditionalMove = new ConditionalMove("", null, null); 
		
		assertEquals(ConditionalMove.getClass().getName(), level.getAvailableMoves().get(0).getClass().getName()); 
		
	}
	
	@Test
	public void addGoalAtPositionTest(){
		level.addGoalAtPosition(3, 6); 
		assertEquals(level.getLayout().get(6).get(3).getClass().getName(), "units.Goal"); 
	}
	
	@Test
	public void setPlayerSpawnPositionTest(){
		level.setPlayerSpawnPosition(12, 14);
		assertEquals(12, level.getPlayerSpawnX()); 
		assertEquals(14, level.getPlayerSpawnY()); 
	}
	
	@Test
	public void addObstacleAtPositionTest(){
		level.addObstacleAtPosition(2, 4); 
		assertEquals("units.Obstacle", level.getLayout().get(4).get(2).getClass().getName());
	}
	
	@Test
	public void addRedSquareAtPositionTest(){
		level.addRedSquareAtPosition(6,3); 
		assertEquals(true, level.getLayout().get(3).get(6).isRedSquare); 
	}
}
