import java.awt.Color;
import java.awt.Graphics;

//The player class houses the xy coordinates of the user's character.
//stored as x and y
//dim = dimension holds the size of the xy "block" that makes up the game world.
public class Player extends Unit{

	private int xPos;
	private int yPos;

	private int dim;

	public Player(Color newColor, int xPos, int yPos, int newDim)
	{
		super(newColor, null);

		xPos = xPos;
		yPos = yPos;
		dim = newDim;

	}
	//Getter for X
	public int getX()
	{
		return xPos;

	}
	//Getter for Y
	public int getY(){
		return yPos;
	}
	//Setter for Y
	public void setY(int newY)
	{
		yPos = newY;
	}
	//Setter for X
	public void setX(int newX)
	{
		xPos= newX;
	}
	//Getter for Dim
	public int getDim()
	{
		return dim;
	}
	
	//Code to draw the player's character.
	//Drawing is based off creating a rectangle. The top left corner of the rectangle is passed in and a rectangle is painted.
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(xPos*dim,  yPos*dim,  dim, dim);
	}



}
