package control;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import shapes.Line;
import shapes.Shape;
import window.Buttonpanel;
import window.PicPanel;
import window.PicsPanel;


public class Start implements MouseListener,MouseMotionListener {
	private Point p1=null;
	private Point p2=null;
	private int width;
	private int height;
	private JFrame frame=new JFrame();
	private PicPanel picpanel;
	private Buttonpanel butspanel;
	private JComponent preowner;
	
	public Start(int width,int height,String title) {
		this.width=width;
		this.height=height;
		picpanel=new PicPanel();
		butspanel=new Buttonpanel(picpanel.getShapenames());
		frame.setPreferredSize(new Dimension(this.width, this.height));
		frame.setTitle(title);
		frame.add(picpanel);
		frame.add(butspanel,BorderLayout.EAST);
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
		frame.addWindowListener(new WindowAdapter() {});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// add a temp shape
		p2=e.getPoint();
		System.out.println("draged to "+p2);
		picpanel.removeTempPic();
		picpanel.addTempPic(butspanel.choosedShape(), p1.x, p1.y, p2.x, p2.y);
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {
		// select a pic
		System.out.println("clicked");
		// may change color
		System.out.println(frame.getFocusOwner());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// record start point
		p1=e.getPoint();
		System.out.println("pressed");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Shape s;
		System.out.println("released");
		// remove temp
		picpanel.removeTempPic();
		// add a shape
		p2=e.getPoint();
		if(butspanel.choosedShape()!=null) {
			picpanel.addPic(butspanel.choosedShape(), p1.x, p1.y, p2.x, p2.y);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	
	public static void main(String[] args) {
		new Start(800,600,"Mini-CAD");
	}
}
