package units;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

//The Goal class holds the graphical information for displaying the Goal.
//The Goal is the location that the player must reach to complete the level.
public class Goal extends Unit{
	
	public Goal(Color newColor, BufferedImage newImage)
	{
		super(newColor, newImage); 
		isgoal = true; 
	}
}
