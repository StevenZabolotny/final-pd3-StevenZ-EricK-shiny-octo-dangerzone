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

public class gamePanel extends JPanel {
    int x = 0;
    int y = 0;
    ArrayList<Ball> balls = new ArrayList<Ball>();

    public gamePanel() {
	setOpaque(true);
	setBackground(Color.GREEN);
	makeBalls();
	addMouseMotionListener(new MouseMotionAdapter() {
	    @Override
	    public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		x = (int)p.getX();
		y = (int)p.getY();
		repaint();
	    }
	});
    }

    public double angletoCue() {
	Ball cue = balls.get(0);
	double hyp = Math.pow(Math.pow(cue.getX() - x,2) + Math.pow(cue.getY() - y,2),0.5);
	double side1 = cue.getX() - x;
	double side2 = cue.getY() - y;
	//the angle between side1 and hyp is referred to as C.
	double C = Math.acos((Math.pow(hyp,2) + Math.pow(side1,2) - Math.pow(side2,2)) / (2 * hyp * side1));
	return C;
    }

    public void makeBalls() {
	Ball ball1 = new Ball(1,624,206);
	balls.add(ball1);
	//this.update(this.getGraphics()); this breaks everything yay

	//column 2
	//6
	Ball ball6 = new Ball(6,644,196);
	balls.add(ball6);
	//12
	Ball ball12 = new Ball(12,644,216);
	balls.add(ball12);

	//column 3
	//13
	Ball ball13 = new Ball(13,664,186);
	balls.add(ball13);
	//8
	Ball ball8 = new Ball(8,664,206);
	balls.add(ball8);
	//5
	Ball ball5 = new Ball(5,664,226);
	balls.add(ball5);

	//column 4
	//11
	Ball ball11 = new Ball(11,684,176);
	balls.add(ball11);
	//2
	Ball ball2 = new Ball(2,684,196);
	balls.add(ball2);
	//4
	Ball ball4 = new Ball(4,684,216);
	balls.add(ball4);
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g.setColor(Color.BLACK);
	g.fillRect(0,0,864,20);
	g.setColor(Color.BLACK);
	g.fillRect(0,0,20,432);
	g.setColor(Color.BLACK);
	g.fillRect(0,412,864,20);
	g.setColor(Color.BLACK);
	g.fillRect(844,0,20,432);
	for (Ball ball: balls) {
	    ball.drawBall(g);
	}
	g2d.setPaint(Color.ORANGE.darker().darker().darker().darker().darker());
	g2d.rotate(angletoCue(),x/2,y/2);
	g2d.drawRect(x-3,y-100,3,100);
	g2d.fillRect(x-3,y-100,3,100);

	/*
	Graphics2D g2 = (Graphics2D) g;
	Ellipse2D circle = new Ellipse2D.Double(100 - 18,100 -18,18,18);
	g2.setColor(Color.BLUE);
	g2.draw(circle);
	Rectangle2D rect = new Rectangle2D.Double(100 - 18,100 -5,18,5);
	g2.setColor(Color.WHITE);
	g2.draw(rect); */
	//column 1
	//1
	/*g.setColor(Color.BLACK);
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
	g.fillOval(305,207,18,18);*/
    }
}	
