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

public class gamePanel extends JPanel {
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
    }
}	
