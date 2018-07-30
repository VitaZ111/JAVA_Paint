package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;

public class Rectangle extends Shape implements MouseListener{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		super.myname="rectangle "+ (this.x)+ " "+(this.y);
		setbound();
		this.setOpaque(false);
		this.addMouseListener(this);
		this.setFocusable(true);
		this.addFocusListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
	@Override
	protected void setbound() {
		this.setBounds(x, y, (int)(width*super.multi)+10, (int)(height*super.multi)+10);
	}
	@Override
	public void move(int x,int y) {
		this.x+=x;
		this.y+=y;
		setbound();
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
			g2.drawRect(5-i, 5-i, (int)(width*super.multi)+2*i, (int)(height*super.multi)+2*i);
		}
		g2.setStroke(new BasicStroke(super.strokeWidth));
		g2.setColor(super.c);
		g2.drawRect(5, 5, (int)(width*super.multi), (int)(height*super.multi));
	}

}
