package Panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
	
	//Constructor to add a button and description to the DescriptionPanel
	public DescriptionPanel(String desc) {
		
		currentDesc = new JLabel(desc);
		initGUI();
		
		
	}
	
	public void initGUI(){
		Dimension descP = new Dimension((int)((Game.APPLET_WIDTH/5) * 4), (int)(Game.APPLET_HEIGHT/5) - 20);
		setPreferredSize(descP);
		setSize(descP);
		setMaximumSize(descP);
		setMinimumSize(descP);
		
		setBackground(Color.WHITE);
		
		Dimension labelP = new Dimension((int)((Game.APPLET_WIDTH/5) * 4) -40, (int)(Game.APPLET_HEIGHT/5) - 60);
		currentDesc.setPreferredSize(labelP);
		
		
		JLabel title = new JLabel("Tips and Tricks");
		add(title);
		add(currentDesc, BorderLayout.SOUTH); 
	}
	
	//Allows us to set the currentDescription displayed on the Description Panel.
	public void setDescription(String newDesc) {
		currentDesc.setText("<html>" + newDesc + "</html>"); 
	}
	
}
