package window;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import shapes.Shape;

public class Buttonpanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> buttons=new ArrayList<JButton>();
	private ArrayList<JButton> colorbuts=new ArrayList<JButton>();
	private String shapename;  
	private Color color;
	private Shape lastShape;
	
	private class colorBar extends JPanel {
		private static final long serialVersionUID = 1L;

		public colorBar(int rows ,int cols) {
			super();
			this.setLayout(new GridLayout(rows, cols));
		}

		public void addcolor(Color cc) {
			JButton but =new JButton();
//			Border b=BorderFactory.createLoweredBevelBorder();
			Border b=new EtchedBorder();
			but.setBackground(cc);
			but.setBorder(b);
			but.setOpaque(true);
			this.add(but);
			colorbuts.add(but);
		}
	}
	public void addactlis() {
		for(JButton but:buttons) {
			but.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					shapename=but.getText();
					System.out.println("but:"+shapename+" pressed");
					if(shapename.equals("Help")) {
						JOptionPane.showMessageDialog(null, "这是一个简单的画图板程序。"
								+ "\n功能1：单击右边面板按钮后可以在画图板上拖动插入对应的图形"
								+"\n功能2：在图形上单击可以选中该图形，拖动鼠标可以移动"
								+"\n功能3：选中图形后，向上向下方向键可以改变线条粗细，向左向右方向键可以改变形状大小"
								+"\n功能4：选中图形后，单击右下角色彩板可以更改选中图形为对应的颜色", "画图板帮助", JOptionPane.INFORMATION_MESSAGE);
						shapename=null;
					}
				}
			});
		}
		for(JButton but:colorbuts) {
			but.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					shapename=null;
					color=but.getBackground();
					System.out.println("color:"+color+"choosed");
					if(lastShape!=null) {
						lastShape.changeColor(color);
					}
				}
			});
			but.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					lastShape=null;
				}
				@Override
				public void focusGained(FocusEvent e) {
//					System.out.println(e.getOppositeComponent());
					if(e.getOppositeComponent().getClass().getName().substring(0, 7).equals("shapes.")) {
						lastShape=(Shape)e.getOppositeComponent();
						System.out.println("laseShape "+lastShape+" wrote");
					}
				}
			});
		}
	}
	public String choosedShape() {
		return shapename;
	}
	
	public Buttonpanel(ArrayList<String> names) {
		for(String n:names) {
			buttons.add(new JButton(n));
		}
		buttons.add(new JButton("Help"));
		this.setLayout(new GridLayout(buttons.size()+1, 1));
		for ( JButton but:buttons) {
			this.add(but);
		}
		colorBar cb=new colorBar(3, 3);
		cb.addcolor(Color.white);
		cb.addcolor(Color.black);
		cb.addcolor(Color.red);
		cb.addcolor(Color.yellow);
		cb.addcolor(Color.cyan);
		cb.addcolor(Color.gray);
		cb.addcolor(Color.green);
		cb.addcolor(Color.PINK);
		cb.addcolor(Color.ORANGE);
		this.add(cb);
		//add action listener
		this.addactlis();
	}

}
