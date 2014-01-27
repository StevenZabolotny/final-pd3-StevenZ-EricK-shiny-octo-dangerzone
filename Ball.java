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
    private int dir,dirx,diry;
    private boolean striped,collided,wallescape;
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
	this.wallescape = true;
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
    public void setCol(boolean x) {
	collided = x;
    }
    public boolean getCol() {
	return collided;
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
	dirx = -1;
	diry = -1;
	if (dir == 3 || dir == 2)
	    dirx = 1;
	if (dir > 2)
	    diry = 1;
	x = x + (int)(vx * dirx / 10);
	y = y + (int)(vy * diry / 10);
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
	collided = false;
    }

    public boolean isCollide(Ball b) {
	double difx = b.getX() - x;
	double dify = b.getY() - y;
	if (difx < 0) 
	    difx = difx * -1;
	if (dify < 0)
	    dify = dify * -1;
	return ((difx <= 18) && (dify <= 18) && !collided);
    }

    public void wall() {
	if (wallescape) {
	    if (x <= 29 || x >= 835) {
		vx = vx * 0.75;
		vy = vy * 0.75;
		dirx = dirx * -1;
		collided = true;
	    }
	    if (y <= 29 || y >= 403) {
		vx = vx * 0.75;
		vy = vy * 0.75;
		diry = diry * -1;
		collided = true;
	    }
	}
	if ((x <= 29 || x >= 835) || (y <= 29 || y >= 403))
	    wallescape = false;
	else
	    wallescape = true;
    }
}
