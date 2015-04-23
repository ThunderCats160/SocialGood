package Panels;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//The Description Panel holds a JLabel which is used to display text describing the 
//Programming concepts used for this level. 
public class DescriptionPanel extends JPanel{

	// The description panel holds a "go" jbutton, and the jlabel to display the text.
	JButton goButton; 
	JLabel currentDesc; 
	
	//Constructor to add a button and description to the DescriptionPanel
	public DescriptionPanel(JButton jb, String desc) {
		goButton = jb; 
		currentDesc = new JLabel(desc); 
		
		add(jb); 
		add(currentDesc); 
		
	}
	
	//Allows us to set the currentDescription displayed on the Description Panel.
	public void setDescription(String newDesc) {
		currentDesc.setText("<html>" + newDesc + "</html>"); 
	}
	
}
