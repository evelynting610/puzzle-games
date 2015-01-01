import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame{

    public void init(){
    Container ct = getContentPane();
    JButton gswitch = new JButton("Which Game Would You Like To Play?");
    StartToMenuListener fl = new StartToMenuListener(gswitch);
   
    gswitch.addActionListener(fl);
    ct.add(gswitch);
    }
    

    
}