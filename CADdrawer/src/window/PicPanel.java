package window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Words;

public class PicPanel extends JLayeredPane{
	private static final long serialVersionUID = 1L;
	private int num=799;
	private int max=800;
	private Shape temp=null;
	private ArrayList<String> shapenames=new ArrayList<String>();
	
	public PicPanel() {
		shapenames.add("Line");
		shapenames.add("Circle");
		shapenames.add("Rectangle");
		shapenames.add("Text");
	}
	public ArrayList<String> getShapenames(){
		return shapenames;
	}
	public void changeColor(Shape s,Color c) {
		s.changeColor(c);
	}
	private Shape getShape(String shapename,int x1,int y1,int x2,int y2) {
		Shape s;
		switch(shapename) {
		case "Line":
			s=new Line(x1,y1,x2,y2);
			break;
		case "Circle":
			s=new Circle(x1, y1, (int)Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2)));
			break;
		case "Rectangle":
			int x;int y;int w;int h;
			if(x1<x2) {
				x=x1;w=x2-x1;
			}
			else {
				x=x2;w=x1-x2;
			}
			if(y1<y2) {
				y=y1;h=y2-y1;
			}
			else {
				y=y2;h=y1-y2;
			}
			s=new Rectangle(x, y, w, h);
			break;
		case "Text":
			String input=JOptionPane.showInputDialog("请输入文本：");
			s=new Words(x1, y1, input);
			break;
		default:
			s=null;
		}
		return s;
	}
	public void addPic(String shapename,int x1,int y1,int x2,int y2) {
		Shape s;
		s=getShape(shapename, x1, y1, x2, y2);
		if(s!=null) {
			this.add(s,new Integer(num));
			num-=1;
			System.out.println("paint a "+shapename);
		}
	}
	public void addTempPic(String shapename,int x1,int y1,int x2,int y2) {
		temp=getShape(shapename, x1, y1, x2, y2);
		this.add(temp, new Integer(max));
	}
	public void removeTempPic() {
		if(temp!=null) {
			this.remove(temp);
		}
	}
	public Shape focusShape() {
		Shape s=null;
		for(Component c:this.getComponents()) {
			if(c.isFocusOwner()) {
				s=(Shape)c;
				break;
			}
		}
		return s;
	}

//	public static void main(String[] args) {
//		Circle l=new Circle(100,300,20);
//		Circle l2=new Circle(300,300,20);
//		PicPanel p=new PicPanel();
//		
//		l.setBounds(0, 0, 800, 600);
//		l2.setBounds(0, 0, 800, 600);
//		l.setOpaque(true);
//		l2.setOpaque(true);
//		l.setBackground(Color.GREEN);
//		l2.setBackground(Color.BLUE);
//		p.add(l, new Integer(1));    //down layer
//		p.add(l2,new Integer(2));
//		
//	
//		
//		JFrame frame=new JFrame();
//		frame.setPreferredSize(new Dimension(800, 600));
//		frame.add(p);
////		frame.addMouseListener(l);
////		frame.addMouseListener(l2);
////		frame.addWindowListener(new WindowAdapter() {});
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//		frame.pack();
//		frame.setVisible(true);
//	}
}
