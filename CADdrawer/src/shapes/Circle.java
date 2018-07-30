package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

public class Circle extends Shape implements MouseListener,FocusListener{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int radius;
	
	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		super.myname="circle "+ (x-radius)+ " "+(y-radius);
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
		this.x+=x;
		this.y+=y;
		setbound();
		this.repaint();
	}
	@Override
	protected void setbound() {
		this.setBounds(x-(int)(radius*super.multi), y-(int)(radius*super.multi), (int)(radius*super.multi)*2+10, (int)(radius*super.multi)*2+10);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		if (super.focus==true) {
			// outside highlight
			int i=2;
			g2.setStroke(new BasicStroke(i*2));
			g2.setColor(Color.BLUE);
			g2.drawOval(5-i, 5-i, (int)(radius*super.multi)*2+i*2, (int)(radius*super.multi)*2+i*2);
		}
		g2.setStroke(new BasicStroke(super.strokeWidth));
		g2.setColor(super.c);
		g2.drawOval(5, 5, (int)(radius*super.multi)*2, (int)(radius*super.multi)*2);
	}

}
