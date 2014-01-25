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

    /*
    public double angletoCue() {
	Ball cue = balls.get(0);
	double hyp = Math.pow(Math.pow(cue.getX() - x,2) + Math.pow(cue.getY() - y,2),0.5);
	double side1 = cue.getX() - x;
	if (side1 < 0)
	    side1 = side1 * -1;
	double side2 = cue.getY() - y;
	if (side2 < 0)
	    side2 = side2 * -1;
	//the angle between side1 and hyp is referred to as C.
	double C = Math.acos((Math.pow(hyp,2) + Math.pow(side1,2) - Math.pow(side2,2)) / (2 * hyp * side1));
	if (cue.getY() > y)
	    C = -C;;
	if (cue.getX() > x)
	    C = C + Math.PI;
	return C;
    }
    */

public void makeBalls() {
	//1 and 9 are yellow (255,215,0)
	//2 and 10 are blue (0,0,238)
	//3 and 11 are red (205,0,0)
	//4 and 12 are purple (85,26,139)
	//5 and 13 are orange (255,127,0)
	//6 and 14 are green (34,139,34)
	//7 and 15 are brown (138,51,36)
	//8 is black (0,0,0)
	//0 aka cue is white (245,245,245)

	//cue ball
	balls.add(new Ball(305,207,0,245,245,245,false));

	//column 1: 1
	balls.add(new Ball(625,207,1,255,215,0,false));

	//column 2: 6,12
	balls.add(new Ball(643,198,6,34,139,34,false));
	balls.add(new Ball(643,216,12,85,26,139,true));

	//column 3: 13,8,5
	balls.add(new Ball(661,189,13,255,127,0,true));
	balls.add(new Ball(661,207,8,0,0,0,false));
	balls.add(new Ball(661,225,5,255,127,0,false));

	//column 4: 11,2,4,9
	balls.add(new Ball(679,180,11,205,0,0,true));
	balls.add(new Ball(679,198,2,0,0,238,false));
	balls.add(new Ball(679,216,4,85,26,139,false));
	balls.add(new Ball(679,234,9,255,215,0,true));

	//column 5: 7,10,15,3,14
	balls.add(new Ball(697,171,7,138,51,3,false));
	balls.add(new Ball(697,189,10,0,0,238,true));
	balls.add(new Ball(697,207,15,138,51,3,true));
	balls.add(new Ball(697,225,3,205,0,0,false));
	balls.add(new Ball(697,243,14,34,139,34,true));
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
	g.setColor(Color.ORANGE.darker().darker().darker().darker());
	g.fillRect(x - 3,y - 100,6,100);
	/*
	g2d.setPaint(Color.ORANGE.darker().darker().darker().darker().darker());
	g2d.translate(this.getWidth() / 2, this.getHeight());
	g2d.rotate(angletoCue());
	g2d.translate(-this.getWidth() / 2, -this.getHeight());
	//g2d.rotate(angletoCue(),balls.get(0).getX(),balls.get(0).getY());
	g2d.drawRect(x - 3,y - 100,6,100);
	g2d.fillRect(x - 3,y - 100,6,100);
	*/
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
