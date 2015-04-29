package units;
import java.awt.Color;
import java.awt.image.BufferedImage;

//The Obstacle class holds the graphical information for displaying the Obstacle.
//The Obstacle is a space where the Player cannot pass into.
public class Obstacle extends Unit{
	
	public Obstacle(Color newColor, BufferedImage image)
	{
		super(newColor, image); 
		isObstacle = true; 
	}
}
