import java.awt.Color;
import java.awt.image.BufferedImage;


public class Obstacle extends Unit{
	
	public Obstacle(Color newColor, BufferedImage newSprite)
	{
		super(newColor, newSprite); 
		isObstacle = true; 
	}
}
