

import javax.swing.JFrame;

public class PizzaDriver {

	public static void main(String[] args) {
		PizzaDatabase pd = new PizzaDatabase();
		
		// init frame
		JFrame frame = new JFrame("Pizza"); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // init panel
	    PizzaWebAppPanel hp = new PizzaWebAppPanel(pd);
	    hp.createHomePanels();
	    
	    // finalize
	    frame.add(hp);
	    frame.pack();
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setVisible(true);
	    
	}
}
