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
import java.awt.geom.AffineTransform;
import java.awt.MouseInfo;
import java.awt.PointerInfo;

public class gamePanel extends JPanel {
    int x = 0;
    int y = 0;
    int cuerx = 314;
    int cuery = 216;

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
	double side1 = cuerx - x;
	if (side1 < 0)
	    side1 = side1 * -1;
	double side2 = cuery - y;
	if (side2 < 0)
	    side2 = side2 * -1;
	//the angle between side1 and hyp is referred to as C.
	double C = Math.atan(Math.pow(side2,2)/Math.pow(side1,2));
	if (cuerx > x)
	    C = Math.PI - C;
	if (cuery > y)
	    C = -C;
	return C;
    }

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
	
	g2d.setColor(Color.ORANGE.darker().darker().darker().darker());
	Shape rectangle = new Rectangle(cuerx - 3,cuery - 100,6,100);
	AffineTransform transform = new AffineTransform();
	transform.rotate(angletoCue()+(Math.PI /2),cuerx,cuery);
	Shape transformed = transform.createTransformedShape(rectangle);
	g2d.fill(transformed);
    }
}	
