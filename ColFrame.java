import java.awt.*;
import javax.swing.*;


public class ColFrame extends JFrame {

    private int buttonCount = 25;
    private JButton[] buttons;
    
    public void init() {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container ct = getContentPane();

	ct.setLayout(new GridLayout(5,5));

	buttons = new JButton [buttonCount];

	Solver solve = new Solver(new ColorGame(), "color.txt");
	Spot [] [] matrix = solve.getMatrix();
	solve.fillSpots();
	solve.label(0);

	String [] [] stringMatrix = new String [5][5];

	for (int row=0; row<5; row++){
	    for(int col=0; col<5; col++){
		int i = matrix[row][col].getValue();
		if (i==1){
		    stringMatrix[row][col]="B";}
		else if (i==2){
		    stringMatrix[row][col]="G";}
		else if (i==3){
		    stringMatrix[row][col]="R";}
		else if (i==4){
		    stringMatrix[row][col]="V";}
		else if (i==5){
		    stringMatrix[row][col]="Y";}
	    }
	}

	for(int row = 0; row<5; row++){
	    for(int col=0; col<5; col++){
		Color a = new Color(250, 200, 250);
		Color b = new Color(250, 250, 200);
		Color c = new Color(200, 250, 250);
		Color d = new Color(250, 150, 200);
		int box = matrix[row][col].getBox();
		String letter = stringMatrix[row][col];

		if(box==1){
		    JButton jb = new JButton(letter);
		    jb.setBackground(a);
		    jb.setOpaque(true);
		    ct.add(jb);}
		if(box==2 || box ==5){
		    JButton jb = new JButton(letter);
		    jb.setBackground(b);
		    jb.setOpaque(true);
		    ct.add(jb);}
		if(box==3){
		    JButton jb = new JButton(letter);
		    jb.setBackground(c);
		    jb.setOpaque(true);
		    ct.add(jb);}
		if(box==4){
		    JButton jb = new JButton(letter);
		    jb.setBackground(d);
		    jb.setOpaque(true);
		    ct.add(jb);}

		
	    }
	}
    }

}

