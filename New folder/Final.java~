import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.MouseInfo;
import java.awt.PointerInfo;

public class Final implements ActionListener {
    JPanel titlePanel,  buttonPanel;
    JLabel titleLabel, turnLabel, oneTypeLabel, twoTypeLabel;
    JButton newGameButton;
    int turn,time;
    String oneType,twoType;
    boolean start = false;
    JPanel gamePanel = new gamePanel();

    public JPanel createContentPane() {
	turn = 0;
	oneType = "";
	twoType = "";

	JPanel totalGUI = new JPanel();
	totalGUI.setLayout(null);
	
	titlePanel = new JPanel();
	titlePanel.setLayout(null);
	titlePanel.setLocation(10,0);
	titlePanel.setSize(500,100);
	totalGUI.add(titlePanel);
	titleLabel = new JLabel("8-ball Pool");
	titleLabel.setLocation(25,10);
	titleLabel.setSize(100,20);
	titleLabel.setHorizontalAlignment(0);
	titleLabel.setForeground(Color.red);
	titlePanel.add(titleLabel);

	gamePanel.setLayout(null);
	gamePanel.setLocation(200,250);
	gamePanel.setSize(864,432); //this needs to be turned into 864x432 later
	gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
	totalGUI.add(gamePanel);

	buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout());
	buttonPanel.setLocation(900,40);
	buttonPanel.setSize(200,40);
	totalGUI.add(buttonPanel);
	turnLabel = new JLabel("" + turn);
	turnLabel.setHorizontalAlignment(0);
	titlePanel.add(turnLabel);	
	oneTypeLabel = new JLabel(oneType);
	oneTypeLabel.setHorizontalAlignment(0);
	oneTypeLabel.setForeground(Color.red);
	buttonPanel.add(oneTypeLabel);
	twoTypeLabel = new JLabel(twoType);
	twoTypeLabel.setHorizontalAlignment(0);
	twoTypeLabel.setForeground(Color.blue);
	buttonPanel.add(twoTypeLabel);
	newGameButton = new JButton("New Game");
	newGameButton.addActionListener(this);
	buttonPanel.add(newGameButton);
	
	return totalGUI;
    }

    public void actionPerformed(ActionEvent e) {
	start = true;
    }

    public void start() {
	for (int time = 0;time != -1;time++) {
	    if (time % 1000 == 0) {
		stick s = new stick();
		gamePanel.repaint();
	    }
	    /* System.out.println("Got this far");
	    System.out.println("Loop: " + time);
	    System.out.println("Start: " + start); */
	}
    }	

    public static void createAndShowGUI() {
	JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("8-ball Pool!");

        //Create and set up the content pane.
        Final gui = new Final();
        frame.setContentPane(gui.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1500);
        frame.setVisible(true);
    }

    public static void main (String[] args) {
	try {
	    Final obj = new Final ();
	    obj.run (args);
	}
	catch (Exception e) {
	    e.printStackTrace ();
	}
    }


    public void run (String[] args) throws Exception {
	createAndShowGUI();
	start();
    }
}

	    
