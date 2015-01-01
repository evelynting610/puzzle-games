import java.awt.*;
import javax.swing.*;


public class KenFrame extends JFrame {

    private int buttonCount = 81;
    private JButton[] buttons;
    
    public void init() {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container ct = getContentPane();
	
	ct.setLayout(new GridLayout(4,4));

	buttons = new JButton [buttonCount];

	Solver solve = new Solver(new KenGame(), "kenken.txt");
	Spot [] [] matrix = solve.getMatrix();
	solve.fillSpots();
	solve.label(0);
	

	for (int row = 0; row<4; row++){
	    for(int col = 0; col<4; col++){
		int box = matrix[row][col].getBox();
		int val = matrix[row][col].getValue();
		Color a = new Color(250, 200, 250);
		Color b = new Color(250, 250, 200);
		Color c = new Color(200, 250, 250);
		Color d = new Color(250, 150, 200);
	    
		if (box==1 || box ==5){
		    JButton jb = new JButton(String.valueOf(val));
		    jb.setBackground(a);
		    jb.setOpaque(true);
		    ct.add(jb);}
		if(box==2 || box==8){
		    JButton jb = new JButton(String.valueOf(val));
		    jb.setBackground(b);
		    jb.setOpaque(true);
		    ct.add(jb);}
		if(box==3 || box==7){
		    JButton jb = new JButton(String.valueOf(val));
		    jb.setBackground(c);
		    jb.setOpaque(true);
		    ct.add(jb);}
		if(box==4 || box==6){
		    JButton jb = new JButton(String.valueOf(val));
		    jb.setBackground(d);
		    jb.setOpaque(true);
		    ct.add(jb);}
	    }
	}
    }



}

