import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Color;

public class Ball {
    private int x,y;
    private int rx,ry,r;
    private int n,R,G,B;
    private boolean striped;
    
    public Ball(int x,int y,int n,int R,int G,int B,boolean striped) {
	this.x = x;
	this.y = y;
	this.rx = x+9;
	this.ry = y+9;
	this.r = 9;
	this.n = n;
	this.R = R; 
	this.G = G;
	this.B = B;
	this.striped = striped;
    }

    public double getX() {
	return (double)x;
    }
    public double getY() {
	return (double)y;
    }

    public void drawBall(Graphics g) {
	if (striped) {
	    g.setColor(Color.WHITE);
	    g.fillOval(x,y,18,18);
	    g.setColor(new Color(R,G,B));
	    g.fillRect(x+7,y,5,18);
	}
	else {
	    g.setColor(new Color(R,G,B));
	    g.fillOval(x,y,18,18);
	}
    }
}
