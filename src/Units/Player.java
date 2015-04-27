package Units;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

//The player class houses the xy coordinates of the user's character.
//stored as x and y
//dim = dimension holds the size of the xy "block" that makes up the game world.
public class Player extends Unit implements ImageObserver{

	public final int NORTH = 117; 
	public final int SOUTH = 0; 
	public final int WEST = 39; 
	public final int EAST = 39*2; 
	
	private int xPos;
	private int yPos;

	private int dim;
	
	private final Color traceColor = Color.LIGHT_GRAY;
	private final Color playerColor = Color.blue;
	
	private int direction; 
	
	private BufferedImage visitedMark; 

	public Player(Color newColor, int xPos, int yPos, int newDim)
	{
		super(newColor, null);

		xPos = xPos;
		yPos = yPos;
		dim = newDim;
		
		direction = EAST; 

		visitedMark = null; 
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
	
	// paints the player on the board	
	public void paint(Graphics g) {
		draw((Graphics2D) g);
	}
	
	public void drawVisitedMark(Graphics g){
		
		
		int x = xPos*dim +1; 
		int y = yPos*dim +1; 
		int w = dim -2; 
		int h = dim - 2; 
		
		if(visitedMark == null)
		{
			g.setColor(traceColor);
			g.fillRect(xPos*dim + 1,  yPos*dim + 1,  dim -2, dim - 2);
		}
		else
		{
			BufferedImage subImg = null; 
			if(direction == NORTH)
				subImg = visitedMark.getSubimage(600, 0, 200, 200); 
			if(direction == SOUTH)
				subImg = visitedMark.getSubimage(0, 0, 200, 200); 
			if(direction == WEST)
				subImg = visitedMark.getSubimage(200, 0, 200, 200);
			if(direction == EAST)
				subImg = visitedMark.getSubimage(400, 0, 200, 200); 
			g.drawImage(subImg, x, y, w, h, null); 
		}
		
	}
	
	//Code to draw the player's character.
	//Drawing is based off creating a rectangle. The top left corner of the rectangle is passed in and a rectangle is painted.
	public void draw(Graphics g) {
		//g.setColor(color);
		//g.fillRect(xPos*dim + 1,  yPos*dim + 1,  dim - 2, dim -2);
		
		int x = xPos*dim +1; 
		int y = yPos * dim +1; 
		int w = dim -2; 
		int h = dim -2; 
		
		Image subI = image.getSubimage(0,  direction,  38, 39); 
		/*
		 BufferedImage tempsubI = new BufferedImage(subI.getWidth(null), subI.getHeight(null), 
                  BufferedImage.TYPE_INT_ARGB);
		 Graphics2D g2d = (Graphics2D) tempsubI.getGraphics();
		 g2d.setComposite(AlphaComposite.SrcOver.derive(0.0f)); 
		 // set the transparency level in range 0.0f - 1.0f 
		 //g2d.drawImage(subI, 0, 0, null);
		 subI = tempsubI;
		 */
		 g.drawImage(subI, x, y, w, h, this); 
	}
	
	
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setDirection(int dir)
	{
		direction = dir; 
	}
	public void setVisitedMark(BufferedImage img)
	{
		visitedMark = img; 
	}
	
	



}
