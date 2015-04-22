import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DescriptionPanel extends JPanel{

	JButton goButton; 
	JLabel currentDesc; 
	
	public DescriptionPanel(JButton jb, String desc)
	{
		goButton = jb; 
		currentDesc = new JLabel(desc); 
		
		add(jb); 
		add(currentDesc); 
		
	}
	public void setDescription(String newDesc)
	{
		currentDesc.setText(newDesc); 
	}
	
}
