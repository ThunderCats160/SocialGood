import java.awt.Color;
import java.awt.Graphics;


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
	public int getX()
	{
		return xPos;

	}
	public int getY(){
		return yPos;
	}

	public void setY(int newY)
	{
		yPos = newY;
	}
	public void setX(int newX)
	{
		xPos= newX;
	}

	public int getDim()
	{
		return dim;
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(xPos*dim,  yPos*dim,  dim, dim);
	}



}
