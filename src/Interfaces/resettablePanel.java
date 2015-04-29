package interfaces;

public interface ResettablePanel {

	//An interface, many panels need to refresh and go back to a base state, this
	//adds that function
	public void reset(Boolean all); 
}
