import java.awt.Color;
import java.awt.image.BufferedImage;


public class Goal extends Unit{
	
	public Goal(Color newColor, BufferedImage newSprite)
	{
		super(newColor, newSprite); 
		isgoal = true; 
	}
}
