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

public class Final implements ActionListener {
    JPanel titlePanel, gamePanel, buttonPanel;
    JLabel titleLabel, turnLabel, oneTypeLabel, twoTypeLabel;
    JButton newGameButton;
    int turn;
    String oneType,twoType;

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
	titleLabel.setLocation(250,0);
	titleLabel.setSize(100,20);
	titleLabel.setHorizontalAlignment(0);
	titleLabel.setForeground(Color.red);
	titlePanel.add(titleLabel);

	class gamePanel extends JPanel {
	    public gamePanel() {
		setOpaque(true);
		setBackground(Color.GREEN);  
	    }
	    public void paintComponent(Graphics g) {
		/*
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(100 - 18,100 -18,18,18);
		g2.setColor(Color.BLUE);
		g2.draw(circle);
		Rectangle2D rect = new Rectangle2D.Double(100 - 18,100 -5,18,5);
		g2.setColor(Color.WHITE);
		g2.draw(rect); */
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(199,199,20,20);
		g.setColor(Color.BLUE);
		g.fillOval(200,200,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(200 + 7,200,5,18);

		g.setColor(Color.BLACK);
		g.drawOval(200,220,19,19);
		g.setColor(Color.BLUE);
		g.fillOval(200,220,18,18);

		g.setColor(Color.BLACK);
		g.drawOval(200,240,19,19);
		g.setColor(Color.BLUE);
		g.fillOval(200,240,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(200 + 7,240,5,18);

		g.setColor(Color.BLACK);
		g.drawOval(200,180,19,19);
		g.setColor(Color.BLUE);
		g.fillOval(200,180,18,18);

		g.setColor(Color.BLACK);
		g.drawOval(200,160,19,19);
		g.setColor(Color.BLUE);
		g.fillOval(200,160,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(200 + 7,160,5,18);
	    }
	};
	gamePanel = new gamePanel();
	gamePanel.setLayout(null);
	gamePanel.setLocation(400,250);
	gamePanel.setSize(800,400);
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
	if(e.getSource() == newGameButton) {
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

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    createAndShowGUI();
		}
	    });
    }
}
	    
