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
	
	int currentLevelIndex; 
	
	JPanel mainGamePanel; 
	JPanel introScreenPanel; 

	public void init()
	{
		
		
		currentLevelIndex = 0; 
		
		setLayout(new BorderLayout());


		board = new Board();
		goButton = new JButton("GO!");
		goButton.addActionListener(this);
		
		descriptionPanel = new DescriptionPanel(goButton, "HELLO"); 
		descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.PAGE_AXIS));

		initLevels(); 

		stratPanel = new StratPanel();
		selectPanel = new SelectPanel(stratPanel);

		
		
		selectPanel.setSelectOptions(levels.get(0).getAvailableMoves());

		mainGamePanel = new JPanel(); 
		mainGamePanel.setLayout(new BorderLayout());
		

		mainGamePanel.add(selectPanel, "West");
		mainGamePanel.add(board, "Center");
		mainGamePanel.add(stratPanel, "East");
		mainGamePanel.add(descriptionPanel, "South");
		
		//add(mainGamePanel); 
		
		//add(new JButton("DSJFHDSK")); 
		initIntroScreen(); 
		

	}

	public void initIntroScreen()
	{
		introScreenPanel = new JPanel(); 
		introScreenPanel.add(new JLabel("Welcome to the Game!!!")); 
		JButton b = new JButton("Get Started!");
		
		b.addActionListener(new introPanelButtonAL(this));
		
		introScreenPanel.add(b); 
		
		add(introScreenPanel); 
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(board.testStrategy(stratPanel.getCurrentStrat()))
		{
			System.out.println("YOU WIN"); 
			
			if(currentLevelIndex < levels.size() -1)
				currentLevelIndex ++; 
			
			board.setCurrentLevel(levels.get(currentLevelIndex));
			stratPanel.clearCurrentStrat(); 	
			descriptionPanel.setDescription(levels.get(currentLevelIndex).getDescription());		
		}
	}

	
	public void initLevels()
	{
		levels = new ArrayList<Level>(); 
		
		Level l1 = new Level(40, board); 
		l1.setPlayerSpawnPosition(4, 5);
		l1.addGoalAtPosition(7,5); 
		l1.setDescription("Welcome to the game! Add your commands to your strategy using"
						  +" the buttons on the right! Then, hit the GO! button and try and"
						  +" see if you reach the goal!"); 
		levels.add(l1); 
		
		Level l2 = new Level(40, board); 
		l2.setPlayerSpawnPosition(3, 5);
		l2.addGoalAtPosition(7,2); 
		l2.setDescription("OH FUCK! NOW YOU HAVE TO TURN!"); 
		
		levels.add(l2); 
		
		Level l3 = new Level(40, board); 
		l3.setPlayerSpawnPosition(3, 5);
		l3.addGoalAtPosition(7,5); 
		l3.addObstacleAtPosition(5, 5);
		l3.setDescription("HOLY SHIT AN OBSTACLE! TRY USING COMMANDS TO NAVIGATE AROUND IT"); 
		
		levels.add(l3); 
		
		

		board.setCurrentLevel(levels.get(0));
		descriptionPanel.setDescription(levels.get(0).getDescription()); 
	}

}
