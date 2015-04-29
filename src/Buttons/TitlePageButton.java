package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

public class TitlePageButton extends JButton {
	
	//these are the properties for the buttons that will be on the title page
	public Color buttonColor = Color.getHSBColor((float).58, (float)0.42, (float)0.9);
	public Color fontColor = Color.BLACK;
	private String button_text;
	private int xStagger;
	private int button_width = 200;
	private int button_height = 50;
	
	//the constructor
	//has no returns
	//the parameters are the button text and a variable that will be used
	//to draw the button text
	public TitlePageButton(String text, int staggerX) {
		super(text);
		button_text = text;
		xStagger = staggerX;
		initGUI();
	}
	
	//this function sets the button color
	//this function has no returns
	//the one parameter is the color you would like the button to be
	public void setButtonColor(Color c){
		buttonColor = c;
	}
	
	//this function sets the font color
	//this function has no returns
	//this one parameter is the color you would like the font to be
	public void setFontColor(Color c){
		fontColor = c;
	}
	
	//this function sets the size of the of the button
	//this function has no returns
	//the two parameters are the width and height you would like the button to have
	public void setSize(int width, int height){
		button_width = width;
		button_height = height;
		Dimension dim = new Dimension(button_width, button_height);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
	}
	
	//this function sets the dimensions of the button
	//there are no returns or parameters
	public void initGUI(){
		//the dimensions the button will have
		Dimension dim = new Dimension(button_width, button_height);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
		setContentAreaFilled(false);
	}
	
	//this function paints the button onto the screen
	//there are no returns
	//the parameter is the graphics which will be used
	//to draw the button onto the screen
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(buttonColor);
		g.fillRect(0, 0, button_width, button_height);
		g.setColor(fontColor);
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		g.drawString(button_text, xStagger, 33);
	}
}
