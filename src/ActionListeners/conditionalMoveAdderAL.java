package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Moves.Move;
import Panels.FunctionCreatingPanel;
import Panels.MainGamePanel;
import Panels.SelectPanel;
import Panels.StratPanel;

public class conditionalMoveAdderAL implements ActionListener {

	Move toAdd; 
	StratPanel stratPanel; 
	SelectPanel selectPanel; 
	MainGamePanel mgp; 
	private String conditional;
	private JButton redSquare = new JButton("Red Square");
	private JButton blueSquare = new JButton("Blue Square");
	private JButton bracket = new JButton("}");
	
	
	
	
	//Constructor
	public conditionalMoveAdderAL(Move m, StratPanel newStratPanel, SelectPanel newSelectPanel, MainGamePanel mainPanel)
	{
		toAdd = m; 
		stratPanel = newStratPanel; 
		selectPanel = newSelectPanel; 
		mgp = mainPanel; 
		conditional = null;
	
	}
	
	public void displayConditionalOptions()
	{
		selectPanel.removeAll();
		selectPanel.resetSelectOptions();
		
		
		redSquare.addActionListener(this);
		blueSquare.addActionListener(this);
		bracket.addActionListener(this);
	
		selectPanel.add(redSquare);
		selectPanel.add(blueSquare);
		
		selectPanel.revalidate();
		selectPanel.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource().equals(redSquare))
		{
			conditional = "Red Square";
			stratPanel.addMove(toAdd); 
			stratPanel.add(new JLabel("Conditional(" + conditional + ") {")); 
			selectPanel.removeAll();
			selectPanel.resetButtonsOnSelectPanel(false);
			selectPanel.add(bracket);
			selectPanel.revalidate();
			selectPanel.repaint();
			
		}
		else if(e.getSource().equals(blueSquare))
		{
			conditional = "Blue Square";
			stratPanel.addMove(toAdd); 
			stratPanel.add(new JLabel("Conditional(" + conditional + ") {")); 
			selectPanel.removeAll();
			selectPanel.resetButtonsOnSelectPanel(false);
			selectPanel.add(bracket);
			selectPanel.revalidate();
			selectPanel.repaint();
			
		}
		else if(e.getSource().equals(bracket))
		{
			stratPanel.add(new JLabel("}"));
			selectPanel.removeAll();
			selectPanel.resetSelectOptions();
			selectPanel.resetButtonsOnSelectPanel(true);
			selectPanel.revalidate();
			selectPanel.repaint();
			
		}
		else{
		//Only add the move if the user has moves available
			if(stratPanel.currentNumberMovesAvailable > 0)
			{
				//Add the selected move to the Strategy Panel
				
			
				
			
				selectPanel.setAddToConditional(true); 
				selectPanel.resetSelectOptions();
			
				displayConditionalOptions();
				
				stratPanel.revalidate();
				selectPanel.revalidate();
			}
		}
		
		
		
		
		
	}

	



	
}
