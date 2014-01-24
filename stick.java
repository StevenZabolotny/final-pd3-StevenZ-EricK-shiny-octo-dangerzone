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
import java.awt.image.*;
import javax.imageio.*;

public class stick extends gamePanel implements MouseListener, MouseMotionListener {
    public void paintComponent(Graphics g) {
	super.paintComponent(g); 
	PointerInfo a = MouseInfo.getPointerInfo();
	Point b = a.getLocation();
	g.setColor(Color.ORANGE.darker().darker().darker().darker().darker());
	g.fillRect((int)b.getX(),(int)b.getY(),5,18);
    }
    public void mouseMoved(MouseEvent e)
    {
	this.update(this.getGraphics());
    }
    public void mouseDragged(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
};
