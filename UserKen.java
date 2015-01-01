import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserKen extends JFrame implements ActionListener{

    private int buttonCount = 16;
    private JButton[] buttons;
    
    public void init() {

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container ct = getContentPane();
	ct.setLayout(new GridLayout(5,4));
	setPreferredSize(new Dimension(500, 400));
	setResizable(false);
	
	buttons = new JButton [buttonCount];

	KenGame kg = new KenGame();
	kg.addFile("kenken.txt");

	int [] [] kenMatrix = kg.kenMatrix;
	
	JButton gameType = new JButton("Ken-Ken!");
	ct.add(gameType);

	JButton empty = new JButton();
	ct.add(empty);

	JButton gswitch = new JButton("Menu");
	StartToMenuListener fl = new StartToMenuListener(gswitch);
	gswitch.addActionListener(fl);
	ct.add(gswitch);

	JButton solution = new JButton ("Solution");
	solution.addActionListener(this);
	ct.add(solution);

	int num = 0;
       

	for (int row = 0; row<4; row++){
	    for(int col = 0; col<4; col++){
		Color a = new Color(250, 200, 250);
		Color b = new Color(250, 250, 200);
		Color c = new Color(200, 250, 250);
		Color d = new Color(250, 150, 200);
		String operation = "should not hit";
		int result = kenMatrix[row][col+4];
		int o = kenMatrix[row][col+8];
		if(o==6){
		    operation = "+";}
		if(o==7){
		    operation = "-";}
		if(o==8){
		    operation = "x";}
		if(o==9){
		    operation = "/";}
		
		
		if (kenMatrix[row][col]==1){
		    JButton jb = new JButton();
		    jb.setBackground(a);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if (num ==0){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel(String.valueOf(result)+operation);
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num = num+1;}
		    
		    
		}else if (kenMatrix[row][col]==2){
		    JButton jb = new JButton();
		    jb.setBackground(b);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if (num ==1){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel(String.valueOf(result)+operation);
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num=num+1;}
		    
		}else if (kenMatrix[row][col]==3){
		    JButton jb = new JButton();
		    jb.setBackground(c);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if(num ==2){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel(String.valueOf(result)+operation);
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num=num+1;}
		 
		}else if (kenMatrix[row][col]==4){
		    JButton jb = new JButton();
		    jb.setBackground(d);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if(num==3){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel("5+");
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num=num+1;}

		}else if (kenMatrix[row][col]==5){
		    JButton jb = new JButton();
		    jb.setBackground(a);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if(num==4){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel(String.valueOf(result)+operation);
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num=num+1;}
		}else if (kenMatrix[row][col]==6){
		    JButton jb = new JButton();
		    jb.setBackground(d);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if(num==5){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel(String.valueOf(result)+operation);
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num= num+1;}
		    }
	    if (kenMatrix[row][col]==7){
		    JButton jb = new JButton();
		    jb.setBackground(c);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if(num==6){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel(String.valueOf(result)+operation);
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num = num+1;}
	    }
	    if (kenMatrix[row][col]==8){
		    JButton jb = new JButton();
		    jb.setBackground(b);
		    jb.setOpaque(true);
		    jb.addActionListener(new KenSpot(jb));
		    ct.add(jb);
		    if(num==7){
			JPanel above = new JPanel(new GridLayout(5,4));
			above.setSize(new Dimension(10,10));
			above.setOpaque(false);
			jb.add(above);
			JLabel label = new JLabel(String.valueOf(result)+operation);
			label.setHorizontalAlignment(JLabel.LEFT);
			above.add(label, BorderLayout.NORTH);
			num=num+1;}
	    }
	    
	    }
	}
	

    }

    public void actionPerformed(ActionEvent e){
	KenFrame kf = new KenFrame();
	kf.init();
	kf.pack();
	kf.setVisible(true);
	kf.setSize(new Dimension(600,600));
	kf.repaint();
    }
}

