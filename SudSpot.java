import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudSpot extends JButton implements ActionListener{

    private JButton button= new JButton("Should not hit");

    public SudSpot(JButton jb){
	this.button = jb;
    }
    
    public void actionPerformed(ActionEvent e){
	
	Object [] possibilities = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	JDialog inputBox = new JDialog();
	JOptionPane input = new JOptionPane();
	String entry = (String) input.showInputDialog( inputBox,
						       "Choose a number", "Number",
						       input.PLAIN_MESSAGE, null, possibilities, "1" );
	
	inputBox.setDefaultCloseOperation(inputBox.DISPOSE_ON_CLOSE);
	inputBox.add(input);
	inputBox.setSize( new Dimension (300, 300));
	button.setLabel(entry);
	repaint();
    }
}