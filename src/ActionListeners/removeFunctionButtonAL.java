package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panels.SelectPanel;

public class RemoveFunctionButtonAL implements ActionListener{

	private SelectPanel selectPanel; 
	
	public RemoveFunctionButtonAL(SelectPanel newSP)
	{
		selectPanel = newSP; 
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		selectPanel.setRemovingFunction(true); 
	}

}
