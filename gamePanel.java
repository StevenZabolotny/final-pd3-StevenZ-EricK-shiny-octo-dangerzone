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
import java.awt.geom.AffineTransform;

public class gamePanel extends JPanel implements MouseListener {
    int x,y;
    int cuerx = 314;
    int cuery = 216;
    int pullx,pully,lastpullx,lastpully,xdis,ydis; //all pulling variables
    ArrayList<Ball> balls = new ArrayList<Ball>();
    String action = "turning"; //should be empty until new game button is hit
    public void setAction(String action) {
	this.action = action;}
    double theta;
    
    public gamePanel() {
	setOpaque(true);
	setBackground(Color.GREEN);
	makeBalls();
	addMouseMotionListener(new MouseMotionAdapter() {
	    @Override
	    public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		x = (int)(p.getX());
		y = (int)(p.getY());
		repaint();
	    }	    
	});
	addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {

	if (action.equals("turning")) {
	    //when the stick is rotating around the ball and the mouse is pressed
	    int xdis = Math.abs(x - cuerx);
	    int ydis = Math.abs(y - cuery);
	    if ((Math.pow(xdis,2) + Math.pow(ydis,2)) < 25281) { //100 px circle around the ball 
		theta = angletoCue();
		//the stick can't be moved wherever, it has to be in a straight line between the cue and where it is first clicked
		pullx = x;
		pully = y;
		lastpullx = x;
		lastpully = y;
		action = "pulling";
		//the stick is no longer rotating but rather being pulled back)
	    }
	}

	if (action.equals("pulling")) {
	    if (SwingUtilities.isRightMouseButton(e)) {
		//right click resets the pull
		action = "turning";
	    }
       
		
	    //stick has been pulled back and is now being shot (USE XDIS AND YDIS NOT X AND Y)
	    

	    //animation of the stick using a = k, vi = 0, d = (calculated from x,y to cue) to find vf 
	    //hit(); when the stick hits the ball and transfers all of its momentum (that big equation I came up with that one day)
	}
    }

    public void hit() {
	Ball cue = balls.get(0);
	double vx = cue.getX() - x;
	if (vx < 0)
	    cue.setVx(vx * -1);
	else
	    cue.setVx(vx);
	double vy = cue.getY() - y;
	if (vy < 0)
	    cue.setVy(vy * -1);
	else
	    cue.setVy(vy);
	if (x <= 0 && y <= 0)
	    cue.setDir(1);
	else if (x > 0 && y <= 0)
	    cue.setDir(2);
	else if (x > 0 && y > 0)
	    cue.setDir(3);
	else
	    cue.setDir(4);
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
            C = -1*C;
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

	if (balls.get(0).getVx() > 0 || balls.get(0).getVy() > 0) {
	    Ball b = balls.get(0);
	    b.moveBall(g);
	}

	if (action.equals("turning")) {
	    //rotating the stick around the cue ball 
	    g2d.setColor(Color.ORANGE.darker().darker().darker().darker());
	    Shape rectangle = new Rectangle(cuerx - 3,cuery - 100,6,100);

	    AffineTransform rotatetransform = new AffineTransform();
	    rotatetransform.rotate(angletoCue()+(Math.PI/2),cuerx,cuery);
	    Shape rotated = rotatetransform.createTransformedShape(rectangle);

	    AffineTransform transtransform = new AffineTransform();
	    transtransform.translate(9*Math.cos(angletoCue()),9*Math.sin(angletoCue()));
	    Shape transformed = transtransform.createTransformedShape(rotated);
	    
	    g2d.fill(transformed);
	}

	if (action.equals("pulling")) {
	    //pulling the stick back to hit the ball
	    //the stick must be pulled back straight (line defined by points cuerx,cuery and pullx,pully)
	    double m = ((double)(pully-cuery))/((double)(pullx-cuerx));
	    if ((Math.pow((x-cuerx),2) + Math.pow((y-cuery),2)) < 43681) {
		    lastpullx = x;
		    lastpully = y;
		    g2d.setColor(Color.ORANGE.darker().darker().darker().darker());
		    Shape rectangle = new Rectangle(cuerx - 3,cuery - 100,6,100);
		    
		    AffineTransform rotatetransform = new AffineTransform();
		    rotatetransform.rotate(theta+(Math.PI/2),cuerx,cuery);
		    Shape rotated = rotatetransform.createTransformedShape(rectangle);
		    
		    AffineTransform transtransform1 = new AffineTransform();
		    transtransform1.translate(9*Math.cos(theta),9*Math.sin(theta));
		    Shape translated = transtransform1.createTransformedShape(rotated);
		    
		    double dis = (Math.pow((Math.pow(x-cuerx,2)+Math.pow(y-cuery,2)),0.5));

		    //the stick must be pulled back in a straight line 
		    xdis = (int)(dis/(Math.abs(m)+1));
		    ydis = (int)((m*(xdis)));
		    
		    if (Math.cos(theta) < 0) {
			xdis = -1*xdis;
			ydis = -1*ydis;
		    }
		    
		    AffineTransform transtransform2 = new AffineTransform();
		    transtransform2.translate(0.75*(xdis),0.75*(ydis));
		    Shape transformed = transtransform2.createTransformedShape(translated);
		    g2d.fill(transformed);
	    } 
	    else {
		//if the user comes out of the circle
		g2d.setColor(Color.ORANGE.darker().darker().darker().darker());
		Shape rectangle = new Rectangle(cuerx - 3,cuery - 100,6,100);
		
		AffineTransform rotatetransform = new AffineTransform();
		rotatetransform.rotate(theta+(Math.PI/2),cuerx,cuery);
		Shape rotated = rotatetransform.createTransformedShape(rectangle);

		AffineTransform transtransform1 = new AffineTransform();
		transtransform1.translate(9*Math.cos(theta),9*Math.sin(theta));
		Shape translated = transtransform1.createTransformedShape(rotated);
		
		double dis = (Math.pow((Math.pow(lastpullx-cuerx,2)+Math.pow(lastpully-cuery,2)),0.5));
	 
		//the stick must be pulled back in a straight line 
		xdis = (int)(dis/(Math.abs(m)+1));
		ydis = (int)((m*(xdis)));
		
		if (Math.cos(theta) < 0) {
		    xdis = -1*xdis;
		    ydis = -1*ydis;
		}
		
		AffineTransform transtransform2 = new AffineTransform();
		transtransform2.translate(0.75*(xdis),0.75*(ydis));
		Shape transformed = transtransform2.createTransformedShape(translated);
		g2d.fill(transformed);
	    }	
	}
    }	    

    public boolean sameSign(double a, double b) {
	return (a >= 0) ^ (b < 0);}
 
}
