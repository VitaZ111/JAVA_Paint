package shapes;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;

public class Shape extends JComponent implements MouseListener,FocusListener,MouseMotionListener,KeyListener{
	private static final long serialVersionUID = 1L;
	protected boolean focus=false;
	protected Color c=Color.BLACK;
	protected String myname;
	protected float strokeWidth=1.0f;
	protected float multi=1.0f;
	
	private Point p1;
	private Point p2;
	
	public void changeColor(Color c) {
		this.c=c;
		this.repaint();
	}
	public void increaseWidth() {
		strokeWidth+=1.0f;
		this.repaint();
	}
	public void reduceWidth() {
		if(strokeWidth>1.0f) {
			strokeWidth-=1.0f;}
		this.repaint();
	}
	protected void setbound() {}
	public void changeSize() {
		this.setbound();
		this.repaint();
	}
	public void move(int x,int y) {}

	@Override
	public void mouseClicked(MouseEvent e) {
		//set focus
		this.requestFocusInWindow();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// start point
		p1=e.getPoint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void focusGained(FocusEvent e) {
		focus=true;
		this.repaint();
		System.out.println("shape "+myname+" gain focus");
	}
	@Override
	public void focusLost(FocusEvent e) {
		focus=false;
		this.repaint();
		System.out.println("shape "+myname+" lose focus");
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// move
		p2=e.getPoint();
		System.out.println("draged to "+p2);
		this.move(p2.x-p1.x, p2.y-p1.y);
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		// change line width
		Shape s;
		System.out.println(e.getKeyCode()+" "+e.getComponent().getClass());
		if (e.getComponent().getClass().getName().substring(0, 7).equals("shapes.")) {
			s=(Shape)e.getComponent();
			if(e.getKeyCode()==38) {
				s.increaseWidth();
			}
			else if(e.getKeyCode()==40) {
				s.reduceWidth();
			}
			else if(e.getKeyCode()==37) {
				// for smaller
				s.multi=s.multi-0.1f;
				s.changeSize();
			}
			else if(e.getKeyCode()==39) {
				// for bigger
				s.multi=s.multi+0.1f;
				s.changeSize();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}

}
