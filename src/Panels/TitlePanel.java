package panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import main.Game;
import actionListeners.InstructionsPanelButtonAL;
import actionListeners.introPanelButtonAL;
import actionListeners.TeacherPanelButtonAL;
import buttons.TitlePageButton;

//The titlepanel shows the first page. It has 3 buttons: Play game, Instructions, and Teaching Page.

public class TitlePanel extends JPanel {
	
	Game game;
	BufferedImage background;
	
	public TitlePanel(Game g) {
		game = g;
		initGUI();
	}
	
	public void initGUI(){
		setLayout(null);
		background = null;
		
		TitlePageButton getStartedButton = new TitlePageButton("Play Game", 42);
		TitlePageButton instructionsPageButton = new TitlePageButton("Instructions", 40);
		TitlePageButton teacherPageButton = new TitlePageButton("Teaching", 49);
		
		//Make sure that the button on the JPanel has a listener.
		getStartedButton.addActionListener(new introPanelButtonAL(game));
		instructionsPageButton.addActionListener(new InstructionsPanelButtonAL(game));
		teacherPageButton.addActionListener(new TeacherPanelButtonAL(game)); 
		
		Insets insets = getInsets();
		
		//adds these two buttons to the Intro Screen Panel
		add(getStartedButton); 
		add(instructionsPageButton);
		add(teacherPageButton);
		
		//	Absolutely Position our buttons	
		Dimension size = getStartedButton.getPreferredSize();
		getStartedButton.setBounds((Game.APPLET_WIDTH / 2) - (size.width / 2), 300 + insets.top, size.width, size.height);
		
		size = instructionsPageButton.getPreferredSize();
		instructionsPageButton.setBounds((Game.APPLET_WIDTH / 2) - (size.width / 2), 365 + insets.top, size.width, size.height);
		
		size = teacherPageButton.getPreferredSize();
		teacherPageButton.setBounds((Game.APPLET_WIDTH / 2) - (size.width / 2), 430 + insets.top, size.width, size.height);
	}
	
	public void setBackgroundImg(BufferedImage img){
		try {
			background = resizeImage(img, 960, 600, img.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
