
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Color;

public class Ball extends JPanel {
    private int xcor,ycor;
    private int rxcor,rycor,radius;
    private int num;
    
    public Ball(int n,int x,int y) {
	num = n;
	xcor = x;
	ycor = y;
	radius = 9;
	this.setVisible(true);
	
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	boolean isStriped = (num > 8);
	int color = num%8;
	
	if (color == 0) {
	    if (isStriped) {
		//8ball
		g.setColor(Color.BLACK);
		g.drawOval(xcor,ycor,20,20);
		g.setColor(Color.BLACK);
		g.fillOval(xcor+1,ycor+1,18,18);
	    }
	    else { 
		//cue ball is 16
		g.setColor(Color.BLACK);
		g.drawOval(xcor,ycor,20,20);
		g.setColor(Color.WHITE);
		g.fillOval(xcor+1,ycor+1,18,18);
	    }	
	}	
	else {
	    if (color == 1) {
		if (isStriped) {
		    //9ball
		    g.setColor(Color.BLACK);
		    g.drawOval(xcor,ycor,20,20);
		    g.setColor(Color.WHITE);
		    g.fillOval(xcor+1,ycor+1,18,18);
		    g.setColor(Color.YELLOW);
		    g.fillOval(xcor+8,ycor+1,5,18);
		}
		else {
		    //1ball
		    g.setColor(Color.BLACK);
		    g.drawOval(xcor,ycor,20,20);
		    g.setColor(Color.YELLOW);
		    g.fillOval(xcor+1,ycor+1,18,18);
		}
	    }
	    else {
		if (color == 2) {
		    if (isStriped) {
			//10ball
			g.setColor(Color.BLACK);
			g.drawOval(xcor,ycor,20,20);
			g.setColor(Color.WHITE);
			g.fillOval(xcor+1,ycor+1,18,18);
			g.setColor(Color.BLUE);
			g.fillOval(xcor+8,ycor+1,5,18);
		    }
		    else {
			//2ball
			g.setColor(Color.BLACK);
			g.drawOval(xcor,ycor,20,20);
			g.setColor(Color.BLUE);
			g.fillOval(xcor+1,ycor+1,18,18);
		    }
		}
		else {
		    if (color == 3) {
			if (isStriped) {
			    //11ball
			    g.setColor(Color.BLACK);
			    g.drawOval(xcor,ycor,20,20);
			    g.setColor(Color.WHITE);
			    g.fillOval(xcor+1,ycor+1,18,18);
			    g.setColor(Color.RED);
			    g.fillOval(xcor+8,ycor+1,5,18);
			}
			else {
			    //3ball
			    g.setColor(Color.BLACK);
			    g.drawOval(xcor,ycor,20,20);
			    g.setColor(Color.RED);
			    g.fillOval(xcor+1,ycor+1,18,18);
			}
		    }
		    else{
			if (color == 4) {
			    if (isStriped) {
				//12ball
				g.setColor(Color.BLACK);
				g.drawOval(xcor,ycor,20,20);
				g.setColor(Color.WHITE);
				g.fillOval(xcor+1,ycor+1,18,18);
				g.setColor(Color.MAGENTA);
				g.fillRect(xcor+8,ycor+1,5,18);
			    }
			    else {
				//4ball
				g.setColor(Color.BLACK);
				g.drawOval(xcor,ycor,20,20);
				g.setColor(Color.MAGENTA);
				g.fillRect(xcor+1,ycor+1,18,18);
			    }
			}
			else {
			    if (color == 5) {
				if (isStriped) {
				    //13ball
				    g.setColor(Color.BLACK);
				    g.drawOval(xcor,ycor,20,20);
				    g.setColor(Color.WHITE);
				    g.fillOval(xcor+1,ycor+1,18,18);
				    g.setColor(Color.ORANGE.darker());
				    g.fillRect(xcor+8,ycor+1,5,18);
				}
				else {
				    //5ball
				    g.setColor(Color.BLACK);
				    g.drawOval(xcor,ycor,20,20);
				    g.setColor(Color.ORANGE.darker());
				    g.fillOval(xcor+1,ycor+1,18,18);
				}
			    }
			    else {
				if (color == 6) {
				    if (isStriped) {
					//14ball
					g.setColor(Color.BLACK);
					g.drawOval(xcor,ycor,20,20);
					g.setColor(Color.WHITE);
					g.fillOval(xcor+1,ycor+1,18,18);
					g.setColor(Color.GREEN);
					g.fillOval(xcor+8,ycor+1,5,18);
				    }
				    else {
					//6ball
					g.setColor(Color.BLACK);
					g.drawOval(xcor,ycor,20,20);
					g.setColor(Color.GREEN);
					g.fillOval(xcor+1,ycor+1,18,18);
				    }
				}
				else {
				    if (color == 7) {
					if (isStriped) {
					    //15ball
					    g.setColor(Color.BLACK);
					    g.drawOval(xcor,ycor,20,20);
					    g.setColor(Color.WHITE);
					    g.fillOval(xcor+1,ycor+1,18,18);
					    g.setColor(Color.ORANGE.darker().darker().darker().darker());
					    g.fillOval(xcor+8,ycor+1,5,18);
					}
					else {
					    //7ball
					    g.setColor(Color.BLACK);
					    g.drawOval(xcor,ycor,20,20);
					    g.setColor(Color.ORANGE.darker().darker().darker().darker());
					    g.fillOval(xcor+1,ycor+1,18,18);
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}
    }

}
