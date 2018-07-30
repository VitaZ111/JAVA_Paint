package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Start;
import shapes.Line;
import shapes.Shape;


// for backup
public class PicsPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Shape s;
	private ArrayList<Shape> slist=new ArrayList<Shape>();
	
	public void changeColor(Shape s,Color c) {
		s.changeColor(c);
	}
	public void changePic(Shape s) {
		this.s=s;
	}
	public void addPic(Shape s) {
		slist.add(s);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape ss: slist) {
			ss.draw(g);
		}
		System.out.println("pic pained");
	}

//	public static void main(String[] args) {
//		Line l=new Line(10,300,20,19);
//		Line l2=new Line(10,300,200,19);
//		PicPanel p=new PicPanel();
//		
//		p.addPic(l);
//		p.addPic(l2);
//		p.repaint();
//		
//		JFrame frame=new JFrame();
//		frame.setPreferredSize(new Dimension(800, 600));
//		frame.add(p);
//		frame.addMouseListener(l);
//		frame.addMouseListener(l2);
//		frame.addWindowListener(new WindowAdapter() {});
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//		frame.pack();
//		frame.setVisible(true);
//	}
}
