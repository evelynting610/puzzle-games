import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class StartToMenuListener implements ActionListener{

    private JButton myButton;
    JPopupMenu menu;

    public StartToMenuListener(JButton gswitch){
	myButton = gswitch;

	menu = new JPopupMenu("Which Game Would You Like To Play?");
	GameChangeListener gcl = new GameChangeListener();

	JMenuItem sudoku = new JMenuItem("Sudoku");
	JMenuItem kenken = new JMenuItem("KenKen");
	JMenuItem color = new JMenuItem("Color Game");

	menu.add(sudoku);
	menu.add(kenken);
	menu.add(color);

	sudoku.addActionListener(gcl);
	kenken.addActionListener(gcl);
	color.addActionListener(gcl);
    }

    public void actionPerformed(ActionEvent e){
	menu.show(myButton,myButton.getWidth(),myButton.getHeight());
    }
}