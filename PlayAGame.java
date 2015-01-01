import java.awt.*;


public class PlayAGame {
	
	public static void main(String[] args) {
		
	    StartFrame sf = new StartFrame();
	    sf.init();
	    sf.pack();
	    sf.setVisible(true);
	    sf.setSize(new Dimension(500,500));
		
		// this method must finish and return before GUI handling begins
	}
	
}