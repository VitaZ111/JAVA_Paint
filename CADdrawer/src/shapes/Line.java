package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

public class Line extends Shape implements MouseListener,FocusListener {
	private static final long serialVersionUID = 1L;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Line(int x1, int y1, int x2, int y2)
	{
		// x1<x2
		if(x1<x2) {
			this.x1 = x1;  this.x2 = x2;
			this.y1=y1; this.y2=y2;
		}
		else {
			this.x1 =x2;  this.x2 = x1;
			this.y1=y2;  this.y2=y1;
		}
		super.myname="line "+ (this.x1)+ " "+(this.y1);
		setbound();
		this.setOpaque(false);
		this.addMouseListener(this);
		this.setFocusable(true);
		this.addFocusListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
	@Override
	public void move(int x ,int y) {
		this.x1=this.x1+x;
		this.y1=this.y1+y;
		this.x2=this.x2+x;
		this.y2=this.y2+y;
		setbound();
		this.repaint();
	}
	@Override
	protected void setbound() {
		if(this.y1<this.y2) {
			this.setBounds(x1, y1, (int)((x2-x1)*super.multi)+10, (int)((y2-y1)*super.multi)+10);
		}
		else {
			this.setBounds(x1, y2, (int)((x2-x1)*super.multi)+10, (int)((y1-y2)*super.multi)+10);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		if (super.focus==true) {
			// outside highlight
			int i=1;
			g2.setStroke(new BasicStroke(i));
			g2.setColor(Color.BLUE);
			if(y1<y2) {
				g2.drawLine(5-i, 5-i, (int)((x2-x1)*super.multi)+5-i, (int)((y2-y1)*super.multi)+5-i);
				g2.drawLine(5+i, 5+i, (int)((x2-x1)*super.multi)+5+i, (int)((y2-y1)*super.multi)+5+i);
			}
			else {
				g2.drawLine(5-i, 5-i+(int)((y1-y2)*super.multi), (int)((x2-x1)*super.multi)+5-i, 5-i);
				g2.drawLine(5+i, 5+i+(int)((y1-y2)*super.multi), (int)((x2-x1)*super.multi)+5+i, 5+i);
			}
		}
		g2.setStroke(new BasicStroke(super.strokeWidth));
		g2.setColor(super.c);
		if(y1<y2) {
			g2.drawLine(5, 5, (int)((x2-x1)*super.multi)+5, (int)((y2-y1)*super.multi)+5);
		}
		else {
			g2.drawLine(5, 5+(int)((y1-y2)*super.multi), (int)((x2-x1)*super.multi)+5, 5);
		}
	}
	
	
}
