package Units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

//The Unit class is the super class for the Goal, Obstacle, and Player.
public class Unit {

	protected Color color; 
	protected BufferedImage image; 
	
	//a Unit can be a goal or an obstacle, but is default to be neither.
	public Boolean isgoal; 
	public Boolean isObstacle; 
	
	public Boolean isRedSquare; 
	
	//Constructor 
	public Unit(Color newColor, BufferedImage newImage) {
		color = newColor;
		image = newImage; 
		isgoal = false; 
		isObstacle = false; 
		isRedSquare = false; 
	}
	public void setImage(BufferedImage newImage)
	{
		image = newImage; 
	}
	public Color getColor() {
		return color; 
	}
	
	public Image getImage()
	{
		return image; 
	}
	
	public void setColor(Color newColor){
		color = newColor; 
	}
}
