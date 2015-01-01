import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserColor extends JFrame implements ActionListener{

    private int buttonCount = 25;
    private JButton[] buttons;
    
    public void init() {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container ct = getContentPane();
	ct.setLayout(new GridLayout(6,5));
	setPreferredSize(new Dimension(600,500));
	setResizable(false);
	
	buttons = new JButton [buttonCount];
	
	ColorGame cg = new ColorGame();
	cg.addFile("color.txt");
	int [] [] colorMatrix = cg.colorMatrix;

	String [] [] stringMatrix = new String [5][5];

	for (int row=0; row<5; row++){
	    for(int col=0; col<5; col++){
		if (colorMatrix[row][col]==1){
		    stringMatrix[row][col]="B";}
		else if (colorMatrix[row][col]==2){
		    stringMatrix[row][col]="G";}
		else if (colorMatrix[row][col]==3){
		    stringMatrix[row][col]="R";}
		else if (colorMatrix[row][col]==4){
		    stringMatrix[row][col]="V";}
		else if (colorMatrix[row][col]==5){
		    stringMatrix[row][col]="Y";}
		else{
		    stringMatrix[row][col]="";}
	    }
	}

	JButton first = new JButton();
	ct.add(first);

	JButton gswitch = new JButton("Menu");
	
	StartToMenuListener fl = new StartToMenuListener(gswitch);
	
	gswitch.addActionListener(fl);
	ct.add(gswitch);

	JButton gameType = new JButton("Color Game!");
	ct.add(gameType);
	
	JButton solution = new JButton ("Solution");
	
	solution.addActionListener(this);
	ct.add(solution);

	JButton last = new JButton();
	ct.add(last);

	for (int row =5; row<10; row++) {
	    for (int col =0; col<5; col++){
		Color a = new Color(250, 200, 250);
		Color b = new Color(250, 250, 200);
		Color c = new Color(200, 250, 250);
		Color d = new Color(250, 150, 200);
		int box = colorMatrix[row][col];
		if(box==1){
		    JButton jb = new JButton(stringMatrix[row-5][col]);
		    jb.setBackground(a);
		    jb.setOpaque(true);
		    jb.addActionListener(new ColSpot(jb));
		    ct.add(jb);}
		if(box==2 || box==5){
		    JButton jb = new JButton(stringMatrix[row-5][col]);
		    jb.setBackground(b);
		    jb.setOpaque(true);
		    jb.addActionListener(new ColSpot(jb));
		    ct.add(jb);}
		if(box==3){
		    JButton jb = new JButton(stringMatrix[row-5][col]);
		    jb.setBackground(c);
		    jb.setOpaque(true);
		    jb.addActionListener(new ColSpot(jb));
		    ct.add(jb);}
		if(box==4){
		    JButton jb = new JButton(stringMatrix[row-5][col]);
		    jb.setBackground(d);
		    jb.setOpaque(true);
		    jb.addActionListener(new ColSpot(jb));
		    ct.add(jb);}

	    }
	}
    }

    public void actionPerformed(ActionEvent e){
	ColFrame cf = new ColFrame();
	cf.init();
	cf.pack();
	cf.setVisible(true);
	cf.setSize(new Dimension(600,600));
	cf.repaint();
	}
}

