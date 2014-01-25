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

public class Stick extends gamePanel {
    int x = 0;
    int y = 0;

    public Stick() {
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

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g); 
	g.setColor(Color.ORANGE.darker().darker().darker().darker().darker());
	g.fillRect(x,y,5,100);
    }
}
    // public void mouseMoved(MouseEvent e)
    // {
    // 	this.update(this.getGraphics());
    // }
    // public void mouseDragged(MouseEvent e)
    // {
    // }
    // public void mouseEntered(MouseEvent e)
    // {
    // }
    // public void mouseExited(MouseEvent e)
    // {
    // }
    // public void mouseClicked(MouseEvent e)
    // {
    // }
    // public void mousePressed(MouseEvent e)
    // {
    // }
    // public void mouseReleased(MouseEvent e)
    // {
    // }

