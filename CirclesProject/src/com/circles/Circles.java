/**
 * @Author : BEYZA YÜKSEL 
**/
package com.circles;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class Circles extends Frame implements ActionListener, MouseListener {

	private int click_count;
	//Queue<Point2D.Float> points;
	List<Point2D.Float> points;
	public Circles() {
		click_count = 0;
		points = new ArrayList<Point2D.Float>();
		addWindowListener(new MyFinishWindow());
		addMouseListener(this);
	}
	
	public class MyFinishWindow extends WindowAdapter
	{
	     public void windowClosing(WindowEvent e) {
	       System.exit(0);
	     }
	}

	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
	
		//List<Point2D.Float> list = new ArrayList(points);
		
		for(Point2D.Float point : points) {
			drawCircle(g2d, (int) point.x, (int)point.y, 20);
		}
	}	
	
	public void mouseClicked(MouseEvent arg0) {
		//clicked =  true;
		//x = arg0.getX();
		//y = arg0.getY();
		int x = arg0.getX();  // get x coordinate from user
		int y = arg0.getY();  // get y coordinate from user
		System.out.println(x);
		System.out.println(y);
		Point2D.Float point = new Point2D.Float(x, y);
		points.add(point);
		//Iterator<Point2D.Float> iter = points.iterator();
	
		click_count++;
		if(click_count >= 50)  // draw most 50 circles
			points.remove(0);
		repaint();
		
	}
	private void drawCircle(Graphics2D g2d, int x, int y, int r) {
		// draw circle using Graphics2D class.
		g2d.drawOval(x - r, y - r, 5*r, 5*r);
	}
	
	public static void main(String[] argv)
	{
		Circles f = new Circles();
		f.setTitle("2D Circles Program");		
		f.setSize(500,500);
		f.setVisible(true);
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
	
}