package Panels;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JPanel;

import ActionListeners.instructionsPanelButtonAL;
import ActionListeners.introPanelButtonAL;
import ActionListeners.teacherPanelButtonAL;
import Buttons.TitlePageButton;
import Main.Game;

public class TitlePanel extends JPanel {
	
	Game game;
	
	public TitlePanel(Game g) {
		game = g;
		initGUI();
	}
	
	public void initGUI(){
		setLayout(null);
		
		TitlePageButton getStartedButton = new TitlePageButton("Play Game");
		TitlePageButton instructionsPageButton = new TitlePageButton("Instructions");
		TitlePageButton teacherPageButton = new TitlePageButton("Teaching");
		
		//Make sure that the button on the JPanel has a listener.
		getStartedButton.addActionListener(new introPanelButtonAL(game));
		instructionsPageButton.addActionListener(new instructionsPanelButtonAL(game));
		teacherPageButton.addActionListener(new teacherPanelButtonAL(game)); 
		
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
	
	

}
