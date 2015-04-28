package panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import main.Game;
import buttons.RunButton;

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
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		Dimension labelP = new Dimension((int)((Game.APPLET_WIDTH/5) * 4) -40, (int)(Game.APPLET_HEIGHT/5) - 60);
		currentDesc.setPreferredSize(labelP);
		
		JLabel title = new JLabel("Tips and Tricks");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		add(title);
		currentDesc.setFont(new Font("Arial", Font.PLAIN, 16));
		add(currentDesc, BorderLayout.SOUTH); 
	}
	
	//Allows us to set the currentDescription displayed on the Description Panel.
	public void setDescription(String newDesc) {
		currentDesc.setText("<html>" + newDesc + "</html>"); 
	}
	
}
