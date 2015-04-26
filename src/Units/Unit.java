package Units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

//The Unit class is the super class for the Goal, Obstacle, and Player.
public class Unit {

	protected Color color; 
	protected Image image; 
	
	//a Unit can be a goal or an obstacle, but is default to be neither.
	public Boolean isgoal; 
	public Boolean isObstacle; 
	
	//Constructor 
	public Unit(Color newColor, Image newImage) {
		color = newColor;
		image = newImage; 
		isgoal = false; 
		isObstacle = false; 
	}
	public void setImage(Image newImage)
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
	
}
