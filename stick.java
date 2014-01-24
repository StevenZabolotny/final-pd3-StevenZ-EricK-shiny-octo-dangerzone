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

public class stick extends gamePanel {
    public void paintComponent(Graphics g) {
	super.paintComponent(g); 
	PointerInfo a = MouseInfo.getPointerInfo();
	Point b = a.getLocation();
	g.setColor(Color.ORANGE.darker().darker().darker().darker().darker());
	g.fillRect((int)b.getX(),(int)b.getY(),5,18);
    }
};