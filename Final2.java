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
	titleLabel.setLocation(25,10);
	titleLabel.setSize(100,20);
	titleLabel.setHorizontalAlignment(0);
	titleLabel.setForeground(Color.red);
	titlePanel.add(titleLabel);

	class gamePanel extends JPanel {
	    public gamePanel() {
		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());  
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

		//the coordinates are relative to the top left of the table
		super.paintComponent(g);

		//column 1
		//1
		Ball ball1 = new Ball(1,624,206);
		this.add(ball1);
		this.update(this.getGraphics()); //this breaks everything yay

		//column 2
		//6
		Ball ball6 = new Ball(6,644,196);
		//12
		Ball ball12 = new Ball(12,644,216);

		//column 3
		//13
		Ball ball13 = new Ball(13,664,186);
		//8
		Ball ball8 = new Ball(8,664,206);
		//5
		Ball ball5 = new Ball(5,664,226);
		
		//column 4
		//11
		Ball ball11 = new Ball(11,684,176);
		//2
		Ball ball2 = new Ball(2,684,196);
		//4
		Ball ball4 = new Ball(4,684,216);
		//9 (looks suspiciously like solid yellow)
		g.setColor(Color.BLACK);
		g.drawOval(684,236,20,20);
		g.setColor(Color.YELLOW);
		g.fillOval(685,237,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(685 + 7,237,5,18);

		//column 5
		//7
		g.setColor(Color.BLACK);		
		g.drawOval(704,166,20,20);
		g.setColor(Color.ORANGE.darker().darker().darker().darker());
		g.fillOval(705,167,18,18);
		
		//10
		g.setColor(Color.BLACK);
		g.drawOval(704,186,20,20);
		g.setColor(Color.BLUE);
		g.fillOval(705,187,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(705 + 7,187,5,18);

		//15
		g.setColor(Color.BLACK);
		g.drawOval(704,206,20,20);
		g.setColor(Color.ORANGE.darker().darker().darker().darker());
		g.fillOval(705,207,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(705 + 7,207,5,18);

		//3
		g.setColor(Color.BLACK);
		g.drawOval(704,226,20,20);
		g.setColor(Color.RED);
		g.fillOval(705,227,18,18);

		//14
		g.setColor(Color.BLACK);
		g.drawOval(704,246,20,20);
		g.setColor(Color.GREEN);
		g.fillOval(705,247,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(705 + 7,247,5,18);

		//the almighty cue ball
		g.setColor(Color.BLACK);
		g.drawOval(304,206,20,20);
		g.setColor(Color.WHITE);
		g.fillOval(305,207,18,18);
		
		Graphics2D g2d = (Graphics2D)g;
		//g2d.setColor(Color.WHITE);
		g2d.setColor(Color.ORANGE.darker().darker().darker().darker().darker());
		Rectangle rect2 = new Rectangle(0,0,60,800);
		//Rectangle rect2 = new Rectangle((int)b.getX(),(int)b.getY(),5,18);

		//PointerInfo a = MouseInfo.getPointerInfo();
		//Point b = a.getLocation();
		g2d.draw(rect2);
		g2d.fill(rect2);

		g2d.rotate(Math.toRadians(45));
		


	    }
	};
	gamePanel = new gamePanel();
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
	    
