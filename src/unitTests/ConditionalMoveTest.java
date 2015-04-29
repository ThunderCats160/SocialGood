package unitTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import moves.ConditionalMove;
import moves.LeftMove;
import moves.Move;
import moves.RightMove;
import moves.UpMove;

import org.junit.Before;
import org.junit.Test;

public class ConditionalMoveTest {

	ConditionalMove move;
	
	@Before
	public void setUp()
	{
		move = new ConditionalMove("",null,null);
	}
	
	
	@Test
	public void setConditionalMoveTest()
	{
		//creates the string that the condition will be set to
		String statement = new String("TESTER");
		
		//sets condition using the setConditionalMove function
		move.setConditionalMove(statement);
		
		assertEquals(statement, move.getConditionalMove());
		
	}
	
	@Test
	public void addMoveTest()
	{
		//creates the moves that will be added
		RightMove right = new RightMove("", null, null);
		LeftMove left = new LeftMove("", null, null);
		UpMove up = new UpMove("", null, null);
		
		//adds the moves using the function being tested
		move.addMove(right);
		move.addMove(left);
		move.addMove(up);
		
		//creates the two arrays that will be checked to see if they equal each other
		Object[] actualMoveList = new Move[3];
		Move[] expectedMoveList = new Move[3];

		//makes the array list become an array
		actualMoveList = move.moveList.toArray();
		
		//adds the moves to the expected array
		expectedMoveList[0] = right;
		expectedMoveList[1] = left;
		expectedMoveList[2] = up;
		
		//checks to make sure they equal each other
		assertArrayEquals(actualMoveList, expectedMoveList);
		
	}

}
