package Units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

//The Unit class is the super class for the Goal, Obstacle, and Player.
public class Unit {

	protected Color color; 
	protected BufferedImage sprite; 
	
	//a Unit can be a goal or an obstacle, but is default to be neither.
	public Boolean isgoal; 
	public Boolean isObstacle; 
	
	//Constructor 
	public Unit(Color newColor, BufferedImage newSprite) {
		color = newColor;
		sprite = newSprite; 
		isgoal = false; 
		isObstacle = false; 
	}
	
	
	public Color getColor() {
		return color; 
	}
	
}
