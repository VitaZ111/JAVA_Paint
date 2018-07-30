package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

public class Words extends Shape implements MouseListener,FocusListener{
	private static final long serialVersionUID = 1L;
	private String words;
	private int x;
	private int y;
	private int width=12;
	private int fontSize=13;
	
	public Words(int x,int y,String s) {
		this.words=s;
		this.x=x;
		this.y=y;
		super.myname="words "+ (this.words);
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
		this.setBounds(x, y, (int)(words.length()*width*super.multi)+6, (int)(width*super.multi)+6);
	}
	@Override
	public void move(int x,int y) {
		super.move(x, y);
		this.x+=x;
		this.y+=y;
		setbound();
		this.repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		if (super.focus==true) {
			// outside highlight
//			int i=2;
//			g2.setStroke(new BasicStroke(i*2));
//			g2.setColor(Color.BLUE);
//			g2.drawRect(5-i, 5-i, words.length()*width+2*i, width+2*i);
			this.setBackground(Color.BLUE);
			this.setOpaque(true);
		}
		else {
			this.setOpaque(false);
			this.setBackground(null);
		}
		g2.setFont(new Font(g2.getFont().getName(), g2.getFont().getStyle(), (int)(fontSize*super.multi)));
		g2.setStroke(new BasicStroke(super.strokeWidth));
		g2.setColor(super.c);
		g2.drawString(words, 3, 3+(int)(width*super.multi));
	}
}
