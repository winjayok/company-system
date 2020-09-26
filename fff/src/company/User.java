package company;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
public class User extends JFrame{	
	private static final long serialVersionUID = 1L;
	User() {
		Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
	  	this.setIconImage(icon);//添加窗口图标
		setTitle("企业物资管理系统");
		Container c1 = getContentPane();	
		c1.setLayout(null);
		setSize(360, 300);
		setLocationRelativeTo(null); //设置窗口居中显示 
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font1 = new Font("宋体", Font.BOLD, 24);
		Font font2 = new Font("宋体", Font.BOLD, 20);
		Font font3 = new Font("宋体", Font.BOLD, 15);
		JLabel biaoTi = new JLabel("企业物资管理系统");
		biaoTi.setFont(font1);
		JButton a1 = new JButton("查询物资");// 按钮1
		JButton a3 = new JButton("修改物资信息");// 按钮3
		JButton a7 = new JButton("物资出库");// 按钮7
		JButton a8 = new JButton("物资入库");// 按钮8
		JLabel q1 = new JLabel("==================================================================");
		JLabel q2 = new JLabel("==================================================================");
		JLabel q3 = new JLabel("==================================================================");
		JLabel b1 = new JLabel("查询功能：");
		JLabel b2 = new JLabel("出库功能：");
		JLabel b3 = new JLabel("修改功能：");
		JLabel b4 = new JLabel("入库功能：");
		biaoTi.setBounds(80, 10, 500, 25);
		q2.setBounds(0, 40, 800, 25);
		q1.setBounds(0,140,800, 25);
		q3.setBounds(0,240,800, 25);
		b1.setBounds(0,55,500, 25);
		b1.setFont(font2);
		b2.setBounds(0,155,500, 25);
		b2.setFont(font2);
		b3.setBounds(200,55,500, 25);
		b3.setFont(font2);
		b4.setBounds(200,155,500, 25);
		b4.setFont(font2);
		a1.setBounds(0,80,150, 60);
		a3.setBounds(200,80, 150, 60);
		a7.setBounds(0,180, 150, 60);
		a8.setBounds(200,180,150, 60);
		a1.setFont(font3);
		a3.setFont(font3);
		a7.setFont(font3);
		a8.setFont(font3);
		c1.add(q1);
		c1.add(q2);
		c1.add(q3);
		c1.add(biaoTi);	
		c1.add(b1);
		c1.add(b2);
		c1.add(b3);
		c1.add(b4);
		c1.add(a1);
		c1.add(a3);
		c1.add(a7);
		c1.add(a8);
		a1.addActionListener(new ActionListener() {// 给按钮添加事件接收器
			public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
				setVisible(false);
				new All();
					}});
		a3.addActionListener(new ActionListener() {// 给按钮添加事件接收器
			public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
				setVisible(false);
				new Change();
					}});
		a7.addActionListener(new ActionListener() {// 给按钮添加事件接收器
			public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
				setVisible(false);
				new Out();
					}});
		a8.addActionListener(new ActionListener() {// 给按钮添加事件接收器
			public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
				setVisible(false);
				new In();
					}});
	}
	
	
}
