import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Game extends Applet implements ActionListener {

	SelectPanel selectPanel;
	Board board;
	StratPanel stratPanel;
	JButton goButton;
	DescriptionPanel descriptionPanel; 
	
	ArrayList<Level> levels; 

	public void init()
	{
		setLayout(new BorderLayout());


		board = new Board();

		initLevels(); 

		stratPanel = new StratPanel();
		selectPanel = new SelectPanel(stratPanel);

		selectPanel.add(new JButton("A"));
		//jp2.add(new JButton("B"));
		//stratPanel.add(new JButton("C"));


		
		
		selectPanel.setSelectOptions(levels.get(0).getAvailableMoves());

		goButton = new JButton("GO!");
		goButton.addActionListener(this);
		
		descriptionPanel = new DescriptionPanel(goButton, "HELLO"); 
		descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.PAGE_AXIS));
		//descriptionPanel.add(goButton); 
		//descriptionPanel.add(new JLabel("HELLP")); 
		

		add(selectPanel, "West");
		add(board, "Center");
		add(stratPanel, "East");
		add(descriptionPanel, "South");
		

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(board.testStrategy(stratPanel.getCurrentStrat()))
		{
			System.out.println("YOU WIN"); 
			board.setCurrentLevel(levels.get(1));
			stratPanel.clearCurrentStrat(); 
			
			descriptionPanel.setDescription(levels.get(1).getDescription());
			
		}

	}

	
	public void initLevels()
	{
		levels = new ArrayList<Level>(); 
		
		Level l1 = new Level(40, board);
		l1.addGoalAtPosition(5,5); 
		levels.add(l1); 
		
		Level l2 = new Level(40, board); 
		l2.addGoalAtPosition(3,  2);
		levels.add(l2); 
		
		

		board.setCurrentLevel(levels.get(0));
	}

}
