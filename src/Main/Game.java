package Main;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionListeners.InstructionPanelGoBackAL;
import ActionListeners.TeacherPanelGoBackAL;
import ActionListeners.instructionsPanelButtonAL;
import ActionListeners.introPanelButtonAL;
import ActionListeners.teacherPanelButtonAL;
import Panels.DescriptionPanel;
import Panels.MainGamePanel;

//The game class is the underlying class for the entire game. It runs on an Applet, and implements ActionListener which takes in mouse movements.
public class Game extends Applet {

	
	// PROPERTIES
	DescriptionPanel descriptionPanel; 	//Instantiates the Panel which displays the description of the level. 
	public JPanel mainGamePanel;				//Instantiates the main JPanel where the game will be played 
	JPanel introScreenPanel;			//Instantiates the introduction page, which explains the basics of how the game is played and serves as an instructional page for Teachers to explain the value of this game.
	JPanel instructionalPanel;
	JPanel teacherPanel; 				//The Teacher's panel, explains to teachers how to use the game to educate kids
	String activeView;
	
	public final int FRAME_WIDTH = 700;	// width of our frame
	public final int FRAME_HEIGHT = 503;// height of our frame
	
	/* PUBLIC SETTINGS */
	public final String FONT_NAME = "Helvetica";
	
	
	public Game(){
		initGUI();
	}

	//Init function to put values into the instantiated objects above.
	public void initGUI() {
		Dimension dim = new Dimension(50, 50);
		
		//sets the layout manager for this container
		setLayout(new BorderLayout());
		
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setSize(2000, 2000);
		
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
		
		// add the panel to our applet
		add(mainGamePanel);
		activeView = "Main Game";
		
		// repaint everything
		validate();
		repaint();
	}
	
	
	//The function to ensure that the Player sees the introduction screen before the mainGamePanel.
	public void initIntroScreen()
	{
		//Implement a new JPanel with a JLabel and JButton.
		//Here, we introduce the point of the game, and how to play.
		//We will also indicate to teachers the value of our game.
		
		//TODO:Put more text in the JLabel about the game & how to play.
		introScreenPanel = new JPanel(); 
		introScreenPanel.add(new JLabel("Welcome to the Game!!!")); 
		JButton getStartedButton = new JButton("Get Started!");
		JButton instructionsPageButton = new JButton("Instructions");
		JButton teacherPageButton = new JButton("Instructions For Teachers"); 
		
		//Make sure that the button on the JPanel has a listener.
		getStartedButton.addActionListener(new introPanelButtonAL(this));
		instructionsPageButton.addActionListener(new instructionsPanelButtonAL(this));
		teacherPageButton.addActionListener(new teacherPanelButtonAL(this)); 
		
		//adds these two buttons to the Intro Screen Panel
		introScreenPanel.add(getStartedButton); 
		introScreenPanel.add(instructionsPageButton);
		introScreenPanel.add(teacherPageButton); 
		
		add(introScreenPanel); 
	}
	
	
	public void createInstructionPanel() {
		instructionalPanel = new JPanel();
		instructionalPanel.add(new JLabel("Instructions:"));
		
		JButton b = new JButton("Go back"); 
		b.addActionListener(new InstructionPanelGoBackAL(this));
		instructionalPanel.add(b); 
	}
	
	public void createTeacherPanel(){
		teacherPanel = new JPanel(); 
		teacherPanel.add(new JLabel("Here is where the instructions for teachers goes")); 
		
		JButton b = new JButton("Go back"); 
		b.addActionListener(new TeacherPanelGoBackAL(this)); 
		teacherPanel.add(b);
		activeView = "Teacher Panel";
	}
	
	@Override
	public void paint(Graphics theGraphic) {
		super.paint(theGraphic);
//		if (activeView == "Teacher Panel"){
//			teacherPanel.repaint();
//		} else if (activeView == "Main Game"){
//			mainGamePanel.repaint();
//		} else if (activeView == "Intro Screen"){
//			introScreenPanel.repaint();
//		}
		
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

}
