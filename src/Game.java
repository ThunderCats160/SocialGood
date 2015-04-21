import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Game extends Applet implements ActionListener {

	SelectPanel selectPanel;
	Board board;
	StratPanel stratPanel;
	JButton goButton;

	public void init()
	{
		setLayout(new BorderLayout());


		board = new Board();

		Level l = new Level(40);

		board.setCurrentLevel(l);

		stratPanel = new StratPanel();
		selectPanel = new SelectPanel(stratPanel);

		selectPanel.add(new JButton("A"));
		//jp2.add(new JButton("B"));
		//stratPanel.add(new JButton("C"));


		selectPanel.setSelectOptions(l.getAvailableMoves());

		goButton = new JButton("GO!");
		goButton.addActionListener(this);

		add(selectPanel, "West");
		add(board, "Center");
		add(stratPanel, "East");
		add(goButton, "South");

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		board.testStrategy(stratPanel.getCurrentStrat());

	}


}
