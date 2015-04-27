package Panels;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Buttons.RunButton;
import Main.Game;

//The Description Panel holds a JLabel which is used to display text describing the 
//Programming concepts used for this level. 
public class DescriptionPanel extends JPanel{

	// The description panel holds a "go" jbutton, and the jlabel to display the text.
	//RunButton goButton; 
	JLabel currentDesc; 
	JPanel descPanel;
	JPanel goButtonPanel;
	
	//Constructor to add a button and description to the DescriptionPanel
	public DescriptionPanel(RunButton jb, String desc) {
		//String buttonText = jb.getText(); 
		//goButton = new RunButton();
		//goButton = jb;
		//jb = (JButton) goButton;
		
		currentDesc = new JLabel(desc); 
		Dimension descP = new Dimension((int)(Game.APPLET_WIDTH/.66), (int)(Game.APPLET_HEIGHT/9.6));
		Dimension goBP = new Dimension((int)(Game.APPLET_WIDTH/.32), (int)(Game.APPLET_HEIGHT/9.6));
		JPanel descPanel = new JPanel();
		//descPanel.setPreferredSize(descP);
		descPanel.add(currentDesc);
		
		JPanel goButtonPanel = new JPanel();
		//goButtonPanel.setPreferredSize(goBP);
		goButtonPanel.add(jb);
		
		add(descPanel,BorderLayout.PAGE_START); 
		
		add(goButtonPanel,BorderLayout.PAGE_END); 
		
	}
	
	//Allows us to set the currentDescription displayed on the Description Panel.
	public void setDescription(String newDesc) {
		currentDesc.setText("<html>" + newDesc + "</html>"); 
	}
	
}
