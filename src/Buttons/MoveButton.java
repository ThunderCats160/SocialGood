package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

import main.Game;

public class MoveButton extends JButton {
	
	public Color buttonColor = Color.getHSBColor((float).58, (float)0.42, (float)0.46);
	public Color fontColor = Color.WHITE;
	private String button_text;
	private int xStagger;
	private int button_width = ((int)(Game.APPLET_WIDTH / 5) - 15);
	private int button_height = 30;
	
	//this is the constructor, no returns
	//the parameters are a string of text and an int 
	//which are used for the button text
	public MoveButton(String text, int staggerX) {
		super(text);
		button_text = text;
		xStagger = staggerX;
		initGUI();
	}
	
	//this function sets the button color to the color that is passed in
	//no returns
	//the parameter is the color you would like the button to be
	public void setButtonColor(Color c){
		buttonColor = c;
	}
	
	//this function sets the font color of the button
	//no returns
	//the parameter is the color you would like to font to be
	public void setFontColor(Color c){
		fontColor = c;
	}
	
	//this function sets the size of the button
	//there are no returns
	//the parameters are the width and height that you would 
	public void setSize(int width, int height){
		button_width = width;
		button_height = height;
		Dimension dim = new Dimension(button_width, button_height);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
	}
	
	public void initGUI(){
		Dimension dim = new Dimension(button_width, button_height);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
		setContentAreaFilled(false);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(buttonColor);
		g.fillRect(0, 0, button_width, button_height);
		g.drawRect(0, 0, button_width - 1, button_height - 1);
		g.setColor(fontColor);
		g.setFont(new Font("Arial", Font.PLAIN, 18));
		g.drawString(button_text, xStagger, 20);
	}
}
