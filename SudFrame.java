import java.awt.*;
import javax.swing.*;


public class SudFrame extends JFrame {

    private int buttonCount = 81;
    private JButton[] buttons;
    
    public void init() {
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container ct = getContentPane();
	
	ct.setLayout(new GridLayout(9,9));

	buttons = new JButton [buttonCount];

	Solver solve = new Solver(new SudokuGame(), "evilsudoku.txt");
	Spot [] [] matrix = solve.getMatrix();
	solve.fillSpots();
	solve.label(0);
	
	
	for (int row=0; row< 9; row++) {
	    for (int column=0; column<9; column++){
		Color a = new Color(250, 200, 250);
		Color b = new Color(250, 250, 200);
		Color c = new Color(200, 250, 250);
		
		int val = matrix[row][column].getValue();
		int box = matrix[row][column].getBox();
		
		if(box==1 || box==3 || box==7 || box==9){
		    JButton jb = new JButton(String.valueOf(val));
		    jb.setBackground(a);
		    jb.setOpaque(true);
		    ct.add(jb);
		}
		if(box==2 || box==4 || box==6 || box==8){
		    JButton jb = new JButton(String.valueOf(val));
		    jb.setBackground(b);
		    jb.setOpaque(true);
		    ct.add(jb);
		}
		if (box ==5){
		    JButton jb = new JButton(String.valueOf(val));
		    jb.setBackground(c);
		    jb.setOpaque(true);
		    ct.add(jb);
		}
		
		
		
	    }
	}
    }
    
}

