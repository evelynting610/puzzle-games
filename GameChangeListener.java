import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameChangeListener implements ActionListener{

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("Sudoku")){
	    UserSudoku us = new UserSudoku();
	    us.init();
	    us.pack();
	    us.setVisible(true);
	    us.setSize(new Dimension(600,600));
	    us.repaint();
	}
	if (action.equals("KenKen")){
	    UserKen uk = new UserKen();
	    uk.init();
	    uk.pack();
	    uk.setVisible(true);
	    uk.setSize(new Dimension(600,600));
	    uk.repaint();
	}
	
	if (action.equals("Color Game")){
	    UserColor uc = new UserColor();
	    uc.init();
	    uc.pack();
	    uc.setVisible(true);
	    uc.setSize(new Dimension(600,600));
	    uc.repaint();
	}
    }
}