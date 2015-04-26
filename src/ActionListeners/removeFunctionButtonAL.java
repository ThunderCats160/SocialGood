package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Panels.SelectPanel;

public class removeFunctionButtonAL implements ActionListener{

	private SelectPanel selectPanel; 
	
	public removeFunctionButtonAL(SelectPanel newSP)
	{
		selectPanel = newSP; 
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		selectPanel.setRemovingFunction(true); 
	}

}
