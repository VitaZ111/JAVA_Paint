package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Words;


// for backup
public class Test {

	public static void main(String[] args) {
		Circle l=new Circle(100,300,20);
		Circle l2=new Circle(300,300,20);
		JLayeredPane lp=new JLayeredPane();
		
		JFrame frame=new JFrame();
		frame.setPreferredSize(new Dimension(800, 600));
		frame.add(lp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		
		lp.add(l, new Integer(1));
		lp.add(l2, new Integer(2));
		l.setFocusable(true);
		l2.setFocusable(true);
		
		Line ll=new Line(150, 20, 10, 200);
		lp.add(ll, new Integer(4));
//		ll.setBounds(10, 20, 150, 190);
		
		Rectangle r=new Rectangle(30, 60, 200, 143);
		lp.add(r, new Integer(5));
		
		Words w=new Words(170, 450, "中文");
//		w.setBounds(170, 450, 100, 100);
		lp.add(w, new Integer(6));
		
	}

}
