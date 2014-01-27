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

    public int getX() {
	return x;}
    public int getY() {
	return y;}
    public void setX(int x) {		 
	this.x = x;
	this.rx = x+9;}
    public void setY(int y) {
	this.y = y;
	this.ry = y+9;}
    
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

    public boolean isCollide(Ball b) {
	return ((b.getX() - x <= 18 || b.getX() - x >= -18) && (b.getY() - y <= 18 || b.getY() - y >= -18));
    }
}
