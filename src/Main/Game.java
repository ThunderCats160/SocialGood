package main;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import panels.DescriptionPanel;
import panels.InstructionsPanel;
import panels.MainGamePanel;
import panels.TeacherPanel;
import panels.TitlePanel;
import buttons.TitlePageButton;
import actionListeners.InstructionPanelGoBackAL;
import actionListeners.TeacherPanelGoBackAL;
import actionListeners.InstructionsPanelButtonAL;
import actionListeners.IntroPanelButtonAL;
import actionListeners.TeacherPanelButtonAL;


//The game class is the underlying class for the entire game. It runs on an Applet, and implements ActionListener which takes in mouse movements.
public class Game extends Applet {

	
	// PROPERTIES
	DescriptionPanel descriptionPanel; 	//Instantiates the Panel which displays the description of the level. 
	public MainGamePanel mainGamePanel;				//Instantiates the main JPanel where the game will be played 
	TitlePanel introScreenPanel;			//Instantiates the introduction page, which explains the basics of how the game is played and serves as an instructional page for Teachers to explain the value of this game.
	InstructionsPanel instructionalPanel;
	TeacherPanel teacherPanel; 				//The Teacher's panel, explains to teachers how to use the game to educate kids
	String activeView;
	private BufferedImage background;
	
	/* PUBLIC SETTINGS */
	public final String FONT_NAME = "Helvetica";
	public static final int APPLET_WIDTH = 960;
	public static final int APPLET_HEIGHT = 600;
	
	// Image sources	
	public static final String goalImage = "img/doghouseGrassSuperLight.png";
	public static final String userImage = "img/dogSpriteSheetGreen3.png";
	public static final String trailImage = "img/pawPrints.png";
	public static final String welcomeBackgroundImage = "img/titleBkg.png";
	public static final String instructionsImage = "img/instructionsBkg.png";
	public static final String teacherImage = "img/teachingBkg.png";
	public static final String enemyImage = "img/enemyEvil.png";
	public static final String natureImage = "img/natureBkg1.png";
	public static final String tileImage = "img/grass4.jpg";
	
	private static URL base; 							//the location of the Applet
	
	
	public void init()
	{
		
		
		//Manipulate base to get it to be the full directory of the applet
		//basically so we can store images in places other than the bin
		//directory
		
		base = getDocumentBase(); 
		String path = base.toString(); 
		int index = path.indexOf("bin");
		String substr = path.substring(0,index); 
		
		try {
			base = new URL(substr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		
		initGUI();
		
		//HOW TO ADD AN IMAGE TO THE INSTRUCTIONS SCREEN
		Image instructionsPic = getImage(base, Game.instructionsImage); 
		JLabel instructionsPicLabel = new JLabel(new ImageIcon(instructionsPic));
	
		instructionalPanel.add(instructionsPicLabel); 
		
		//HOW TO ADD AN IMAGE TO THE TEACHER'S SCREEN
	
		Image teacherPic = getImage(base, Game.teacherImage); 
		JLabel teacherPicLabel = new JLabel(new ImageIcon(teacherPic));
					
		teacherPanel.add(teacherPicLabel); 
		
		initIntroScreen();
	}

	//Init function to put values into the instantiated objects above.
	public void initGUI() {
		Dimension dim = new Dimension(50, 50);
		
		//sets the layout manager for this container
		setLayout(new BorderLayout());
		
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setSize(APPLET_WIDTH,APPLET_HEIGHT);
		
		//creates the instructions page
		createInstructionPanel();
		
		//creates the teacher's page
		createTeacherPanel(); 
		
		//Show the introduction Screen
		
		activeView = "Intro Screen";
	}
	
	/* Function to start a new game */
	public void startNewGame(){
		//Create the main game panel and set its layout.
		mainGamePanel = new MainGamePanel(this, true); 
		
		Image i = getImage(base, Game.userImage); 
		if(i == null)
			System.out.println("I NULL"); 
		
		mainGamePanel.setPlayerImage(getBufferedImage(Game.userImage)); 
		mainGamePanel.setPlayerVisitedMark(getBufferedImage(Game.trailImage)); 
		
		// add the panel to our applet
		add(mainGamePanel);
		activeView = "Main Game";
		
		mainGamePanel.setVisible(true);
		// repaint everything
		refreshApplet();
	}
	
	
	//The function to ensure that the Player sees the introduction screen before the mainGamePanel.
	public void initIntroScreen()
	{
		//Implement a new JPanel with a JLabel and JButton.
		//Here, we introduce the point of the game, and how to play.
		//We will also indicate to teachers the value of our game.
		
		introScreenPanel = new TitlePanel(this);
		
		
		add(introScreenPanel); 
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				introScreenPanel.setBackgroundImg(getBufferedImage(welcomeBackgroundImage));
			}
		});
	}
	
	
	public void createInstructionPanel() {
		instructionalPanel = new InstructionsPanel(this);
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				instructionalPanel.setBackgroundImg(getBufferedImage(instructionsImage));
			}
		});
	}
	
	public void createTeacherPanel(){
		teacherPanel = new TeacherPanel(this); 
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				teacherPanel.setBackgroundImg(getBufferedImage(teacherImage));
			}
		});
		
	}
	
	// GETTERS FOR OUR PRIMARY PANELS	
	public JPanel getInstructionPanel() {
		return instructionalPanel;
	}
	
	public JPanel getTeacherPanel(){
		return teacherPanel; 
	}
	
	public JPanel getIntroScreenPanel(){
		return introScreenPanel;
	}
	
	public JPanel getMainGamePanel(){
		return mainGamePanel;
	}

	public URL getBase()
	{
		return base;
	}
	public static BufferedImage getBufferedImage(String imageName)
	{
		try {
			URL newU = new URL(base, imageName);
			return ImageIO.read(newU); 	
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null; 
	}
	
	public void refreshApplet(){
		if (SwingUtilities.isEventDispatchThread()){
			validate();
			repaint();
		} else {
			try {
				SwingUtilities.invokeAndWait(new Runnable(){
					public void run(){
						validate();
						repaint();
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}		
	}
}
