package Main;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionListeners.InstructionPanelGoBackAL;
import ActionListeners.TeacherPanelGoBackAL;
import ActionListeners.instructionsPanelButtonAL;
import ActionListeners.introPanelButtonAL;
import ActionListeners.teacherPanelButtonAL;
import Buttons.TitlePageButton;
import Panels.DescriptionPanel;
import Panels.InstructionsPanel;
import Panels.MainGamePanel;
import Panels.TeacherPanel;
import Panels.TitlePanel;


//The game class is the underlying class for the entire game. It runs on an Applet, and implements ActionListener which takes in mouse movements.
public class Game extends Applet {

	
	// PROPERTIES
	DescriptionPanel descriptionPanel; 	//Instantiates the Panel which displays the description of the level. 
	public MainGamePanel mainGamePanel;				//Instantiates the main JPanel where the game will be played 
	JPanel introScreenPanel;			//Instantiates the introduction page, which explains the basics of how the game is played and serves as an instructional page for Teachers to explain the value of this game.
	JPanel instructionalPanel;
	JPanel teacherPanel; 				//The Teacher's panel, explains to teachers how to use the game to educate kids
	String activeView;
	
	public final int FRAME_WIDTH = 700;	// width of our frame
	public final int FRAME_HEIGHT = 503;// height of our frame
	
	/* PUBLIC SETTINGS */
	public final String FONT_NAME = "Helvetica";
	public static final int APPLET_WIDTH = 960;
	public static final int APPLET_HEIGHT = 600;
	
	// Image sources	
	public static final String goalImage = "doghouseGrassSuperLight.png";
	public static final String userImage = "r.png";
	public static final String trailImage = "pawPrintsGrassSuperLight.png";
	public static final String welcomeBackgroundImage = "titleBkg.png";
	public static final String instructionsImage = "pawPrintsGrassSuperLight.png";
	public static final String teacherImage = "pawPrintsGrassSuperLight.png";
	
	private static URL base; 							//the location of the Applet
	
	public Game(){
		initGUI();
	}
	
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
		
		
		//HOW TO ADD AN IMAGE TO THE INSTRUCTIONS SCREEN
		Image instructionsPic = getImage(base, Game.instructionsImage); 
		JLabel instructionsPicLabel = new JLabel(new ImageIcon(instructionsPic));
	
		instructionalPanel.add(instructionsPicLabel); 
		
		//HOW TO ADD AN IMAGE TO THE TEACHER'S SCREEN
	
		Image teacherPic = getImage(base, Game.teacherImage); 
		JLabel teacherPicLabel = new JLabel(new ImageIcon(teacherPic));
					
		teacherPanel.add(teacherPicLabel); 
		
		
		
		
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
		initIntroScreen(); 
		activeView = "Intro Screen";
	}
	
	/* Function to start a new game */
	public void startNewGame(){
		//Create the main game panel and set its layout.
		mainGamePanel = new MainGamePanel(this); 
		
		Image i = getImage(base, "r.png"); 
		if(i == null)
			System.out.println("I NULL"); 
		
		mainGamePanel.setPlayerImage(getBufferedImage("r.png")); 
		mainGamePanel.setPlayerVisitedMark(getBufferedImage(Game.trailImage)); 
		
		// add the panel to our applet
		add(mainGamePanel);
		activeView = "Main Game";
		
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
	}
	
	
	public void createInstructionPanel() {
		instructionalPanel = new InstructionsPanel(this);
		
		
	}
	
	public void createTeacherPanel(){
		teacherPanel = new TeacherPanel(this); 
		activeView = "Teacher Panel";
		
	}
	
	@Override
	public void paint(Graphics theGraphic) {
		super.paint(theGraphic);
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
		validate();
		repaint();
	}
}
