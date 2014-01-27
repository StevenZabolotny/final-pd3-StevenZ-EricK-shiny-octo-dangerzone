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
    private double vx,vy;
    private int dir;
    private boolean striped;
    private int t;
    
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
    public double getVx() {
	return vx;
    }
    public double getVy() {
	return vy;
    }
    public int getDir() {
	return dir;
    }
    public void setVx(double x) {
	vx = x;
    }
    public void setVy(double x) {
	vy = x;
    }
    public void setDir(int x) {
	dir = x;
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

    public void moveBall() {
	if (t % 15 == 0) {
	    int dirx = -1;
	    int diry = -1;
	    if (dir == 3 || dir == 2)
		dirx = 1;
	    if (dir > 2)
		diry = 1;
	    x = x + (int)(vx * dirx);
	    y = y + (int)(vy * diry);
	}
	t = t + 1;
	/*
	if (striped) {
	    g.setColor(Color.WHITE);
	    g.fillOval((int)xpos,(int)ypos,18,18);
	    g.setColor(new Color(R,G,B));
	    g.fillRect((int)xpos+7,(int)ypos,5,18);
	}
	else {
	    g.setColor(new Color(R,G,B));
	    g.fillOval((int)xpos,(int)ypos,18,18);
	    } */
	vx = vx - 5;
	vy = vy - 5;
    }

    public boolean isCollide(Ball b) {
	return ((b.getX() - x <= 18 || b.getX() - x >= -18) && (b.getY() - y <= 18 || b.getY() - y >= -18));
    }
}
