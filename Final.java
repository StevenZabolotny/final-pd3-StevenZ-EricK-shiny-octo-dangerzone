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
    int turn,time;
    String oneType,twoType;
    boolean start = false;

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

<<<<<<< HEAD
=======
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
		g.setColor(Color.BLACK);
		g.drawOval(624,206,20,20);
		g.setColor(Color.YELLOW);
		g.fillOval(625,207,18,18);

		//column 2
		//14
		g.setColor(Color.BLACK);		
		g.drawOval(644,196,20,20);
		g.setColor(Color.GREEN);
		g.fillOval(645,197,18,18);
		
		//4
		g.setColor(Color.BLACK);
		g.drawOval(644,216,20,20);
		g.setColor(Color.MAGENTA);
		g.fillOval(645,217,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(645 + 7,217,5,18);

		//column 3
		//5
		g.setColor(Color.BLACK);
		g.drawOval(664,186,20,20);
		g.setColor(Color.ORANGE.darker());
		g.fillOval(665,187,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(665 + 7,187,5,18);

		//8
		g.setColor(Color.BLACK);
		g.drawOval(664,206,20,20);
		g.setColor(Color.BLACK);
		g.fillOval(665,207,18,18);

		//13
		g.setColor(Color.BLACK);
		g.drawOval(664,226,20,20);
		g.setColor(Color.ORANGE.darker());
		g.fillOval(665,227,18,18);
		
		//column 4
		//11
		g.setColor(Color.BLACK);
		g.drawOval(684,176,20,20);
		g.setColor(Color.RED);
		g.fillOval(685,177,18,18);
		g.setColor(Color.WHITE);
		g.fillRect(685 + 7,177,5,18);

		//2
		g.setColor(Color.BLACK);		
		g.drawOval(684,196,20,20);
		g.setColor(Color.BLUE);
		g.fillOval(685,197,18,18);

		//12
		g.setColor(Color.BLACK);		
		g.drawOval(684,216,20,20);
		g.setColor(Color.MAGENTA);
		g.fillOval(685,217,18,18);
		
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

		//6
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
		
		
		/*
		  Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		Rectangle rect2 = new Rectangle(0,0,6,8);
		g2d.rotate(Math.toRadians(45));
		g2d.draw(rect2);
		g2d.fill(rect2);
		g2d.translate(350,450);
		*/
		


	    }
	};
>>>>>>> 30f122508887d3a112691389520470ee53483cf6
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
	    start = true;
	}
	if(start) {
	    for (int time = 0;time != -1;time++) {
		class stick extends gamePanel {
		    public void paintComponent(Graphics g) {
			super.paintComponent(g);
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			g.setColor(Color.ORANGE.darker().darker().darker().darker().darker());
			g.fillRect((int)b.getX(),(int)b.getY(),5,18);
		    }
		};
	    }
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
	    
