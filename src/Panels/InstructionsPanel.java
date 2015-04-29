package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import main.Game;
import actionListeners.InstructionPanelGoBackAL;
import buttons.TitlePageButton;

//The Instructions Panel is the Panel displayed when the Instructions Button is pressed.
//It is basically a text image, and a button that returns it to the menu.
public class InstructionsPanel extends JPanel{
	
	//The image that will be the background for the panel
	BufferedImage background;
	
	public InstructionsPanel(Game g){
		initGUI(g); 
	}
	
	//Init
	public void initGUI(Game g){
		background = null;
		
		setLayout(null);
		//Returns the Player to the home page.
		TitlePageButton gotItButton = new TitlePageButton("Home", 50);
		
		//The button needs an action listener
		gotItButton.addActionListener(new InstructionPanelGoBackAL(g));
		add(gotItButton); 
		
		
		//The button is given some style
		Insets insets = getInsets();
		
		gotItButton.setButtonColor(Color.getHSBColor((float).57,(float) .30,(float) .37));
		gotItButton.setFontColor(Color.WHITE);
		gotItButton.setSize(160, 50);
		//	Absolutely Position our button	
		Dimension size = gotItButton.getPreferredSize();
		gotItButton.setBounds(Game.APPLET_WIDTH - 20 - size.width, 15 + insets.top, size.width, size.height);
	}
	
	//Puts the instructions image onto the background
	public void setBackgroundImg(BufferedImage img){
		try {
			background = resizeImage(img, 960, 600, img.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Resizes the instructions image if needed
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();
        return resizedImage;  
    }
	
	@Override
    public void paintComponent(Graphics g) {     
          super.paintComponent(g);
          if (background != null){
        	  g.drawImage(background, 0, 0, null);
          }
    }
}
