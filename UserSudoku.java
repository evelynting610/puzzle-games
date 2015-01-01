import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserSudoku extends JFrame implements ActionListener{

    private int buttonCount = 81;
    private JButton[] buttons;
    
    public void init() {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container ct = getContentPane();
	ct.setLayout(new GridLayout(10, 9));
	setPreferredSize(new Dimension(850, 720));
	setResizable(false);
	
	buttons = new JButton [buttonCount];

	SudokuGame sg = new SudokuGame();
	sg.addFile("evilsudoku.txt");
	int [] [] sudokuMatrix = sg.sudokuMatrix;
	
	for(int i =0; i<3; i++){
	    JButton first = new JButton();
	    ct.add(first);
	}
	
	JButton gswitch = new JButton("Menu");
	
	StartToMenuListener fl = new StartToMenuListener(gswitch);
	
	gswitch.addActionListener(fl);
	ct.add(gswitch);

	JButton gameType = new JButton("Sudoku!");
	ct.add(gameType);
	
	JButton solution = new JButton ("Solution");
	
	solution.addActionListener(this);
	ct.add(solution);

	for (int j = 6; j<9; j++){
	    JButton last = new JButton();
		ct.add(last);
	}

	int [] boxes = new int [81];
	int boxcount = 1;
	int j = 0;

	int count = 0;
	
	for (int row=0; row< 9; row++) {
	    for (int column=0; column<9; column++){	    
		int i = sudokuMatrix[row][column];
		if (i==0){
		    JButton jb = new JButton();
		    jb.addActionListener(new SudSpot(jb));
		    buttons[count]=jb;
		    count = count+1;}
		
		else if (i>0){
		    JButton jb = new JButton(String.valueOf(i));
		    buttons[count]=jb;
		    count = count+1;}
		if (column<=2){
		    boxes[j]=boxcount;
		}
		else if(column>2 && column <6){
		    boxes[j]=boxcount+1;}
		else if (column>=6){
		    boxes[j]=boxcount+2;}
		j = j+1;
	    }
	    if (row==2 || row==5)
		boxcount=boxcount+3;
	    
	}
   
    
    for(int i=0; i<buttonCount; i++){
	Color a = new Color(250, 200, 250);
	Color b = new Color(250, 250, 200);
	Color c = new Color(200, 250, 250);

	if (boxes[i]==1 || boxes[i]==3 || boxes[i]==7 || boxes[i]==9){
	    buttons[i].setBackground(a);
	    buttons[i].setOpaque(true);
	    ct.add(buttons[i]);}
	else if (boxes[i]==2 || boxes[i]==4 || boxes[i]==6 || boxes[i]==8){
	    buttons[i].setBackground(b);
	    buttons[i].setOpaque(true);
	    ct.add(buttons[i]);
	}
	else if (boxes[i]==5){
	    buttons[i].setBackground(c);
	    buttons[i].setOpaque(true);
	    ct.add(buttons[i]);
	}

    }
    }
    
    public void actionPerformed(ActionEvent e){
	SudFrame sf = new SudFrame();
	sf.init();
	sf.pack();
	sf.setVisible(true);
	sf.setSize(new Dimension(600,600));
	sf.repaint();
    }
}

