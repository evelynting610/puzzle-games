import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColSpot extends JButton implements ActionListener{

    private int value = 0;
    private JButton button= new JButton("Should not hit");

    public ColSpot(JButton jb){
	this.button = jb;
    }
    
    public void actionPerformed(ActionEvent e){
	
	Object [] possibilities = {"B", "G", "R", "V", "Y"};
	JDialog inputBox = new JDialog();
	JOptionPane input = new JOptionPane();
	String entry = (String) input.showInputDialog( inputBox,
						       "Choose a color", "Color",
						       input.PLAIN_MESSAGE, null, possibilities, "B" );
	
	inputBox.setDefaultCloseOperation(inputBox.DISPOSE_ON_CLOSE);
	inputBox.add(input);
	inputBox.setSize( new Dimension (300, 300));
	button.setLabel(entry);
	repaint();
    }
}