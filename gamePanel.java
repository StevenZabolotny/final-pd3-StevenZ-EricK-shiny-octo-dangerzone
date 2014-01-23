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
	g.setColor(Color.BLACK);
	g.drawOval(199,199,20,20);
	g.setColor(Color.BLUE);
	g.fillOval(200,200,18,18);
	g.setColor(Color.WHITE);
	g.fillRect(200 + 7,200,5,18);

	g.setColor(Color.BLACK);
	g.drawOval(200,220,19,19);
	g.setColor(Color.BLUE);
	g.fillOval(200,220,18,18);

	g.setColor(Color.BLACK);
	g.drawOval(200,240,19,19);
	g.setColor(Color.BLUE);
	g.fillOval(200,240,18,18);
	g.setColor(Color.WHITE);
	g.fillRect(200 + 7,240,5,18);

	g.setColor(Color.BLACK);
	g.drawOval(200,180,19,19);
	g.setColor(Color.BLUE);
	g.fillOval(200,180,18,18);

	g.setColor(Color.BLACK);
	g.drawOval(200,160,19,19);
	g.setColor(Color.BLUE);
	g.fillOval(200,160,18,18);
	g.setColor(Color.WHITE);
	g.fillRect(200 + 7,160,5,18);
    }
}	