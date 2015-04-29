package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panels.SelectPanel;

//this class creates the action listener for the remove function button
public class RemoveFunctionButtonAL implements ActionListener{

	//holds an instance of the select panel class
	private SelectPanel selectPanel; 
	
	//constructor, has no returns
	//the parameter is the instance of the select panel it holds
	public RemoveFunctionButtonAL(SelectPanel newSP)
	{
		selectPanel = newSP; 
	}
	
	//when this button is pressed, it allows the function that is clicked after
	//this to be deleted from the moves available to the user
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//sets the select panel remove function boolean to true
		selectPanel.setRemovingFunction(true); 
	}

}
