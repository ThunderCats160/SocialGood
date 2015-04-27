package Panels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionListeners.InstructionPanelGoBackAL;
import Main.Game;

public class InstructionsPanel extends JPanel{

	public InstructionsPanel(Game g){
		initGUI(g); 
	}
	
	public void initGUI(Game g)
	{
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		add(new JLabel("Instructions:"));
		
		JButton b = new JButton("Go back"); 
		b.addActionListener(new InstructionPanelGoBackAL(g));
		add(b); 
	}
}
