
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Unit {

	protected Color color; 
	protected BufferedImage sprite; 
	
	public Boolean isgoal; 
	public Boolean isObstacle; 
	
	public Unit(Color newColor, BufferedImage newSprite)
	{
		color = newColor; 
		sprite = newSprite; 
		isgoal = false; 
		isObstacle = false; 
	}
	
	public void draw(Graphics g)
	{
		
	}
	public Color getColor()
	{
		return color; 
	}
	
}
