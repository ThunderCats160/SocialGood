package Panels;

import java.awt.Dimension;

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
		TitlePageButton getStartedButton = new TitlePageButton("Play Game");
		TitlePageButton instructionsPageButton = new TitlePageButton("Instructions");
		TitlePageButton teacherPageButton = new TitlePageButton("Teaching");
		
		//Make sure that the button on the JPanel has a listener.
		getStartedButton.addActionListener(new introPanelButtonAL(game));
		instructionsPageButton.addActionListener(new instructionsPanelButtonAL(game));
		teacherPageButton.addActionListener(new teacherPanelButtonAL(game)); 
		
		//adds these two buttons to the Intro Screen Panel
		add(getStartedButton); 
		add(instructionsPageButton);
		add(teacherPageButton);
		
		//	Absolutely Position our buttons	
		Dimension size = getStartedButton.getPreferredSize();
//		getStartedButton.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
	}

}
