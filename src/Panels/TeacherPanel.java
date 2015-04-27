package Panels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionListeners.InstructionPanelGoBackAL;
import ActionListeners.TeacherPanelGoBackAL;
import Main.Game;

public class TeacherPanel extends JPanel{

	public TeacherPanel(Game g){
		initGUI(g); 
	}
	
	public void initGUI(Game g)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(new JLabel("Here is where the instructions for teachers goes")); 
		
		JButton b = new JButton("Go back"); 
		b.addActionListener(new TeacherPanelGoBackAL(g)); 
		add(b);
		
	}
}
