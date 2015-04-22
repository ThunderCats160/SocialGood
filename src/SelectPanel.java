import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SelectPanel extends JPanel implements ActionListener {

	ArrayList<Move> selectOptions;

	StratPanel stratPanel;

	JButton goButton;


	public SelectPanel(StratPanel newStratPanel)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		stratPanel = newStratPanel;

		initGUI();

	}

	public void setSelectOptions(ArrayList<Move> newOptions){

		removeAll();
		selectOptions = newOptions;

		for(int i = 0; i < selectOptions.size(); i ++)
		{
			JButton b = new JButton();
			b.setText(selectOptions.get(i).getName());
			b.addActionListener(new moveAdderAL(selectOptions.get(i), stratPanel));
			
			
			add(b);
		}

	}

	public void initGUI()
	{
		JButton b1 = new JButton();
		b1.setText("DSFHDSFKJS");

		add(b1);


	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub



	}




}
