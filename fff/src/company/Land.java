package company;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class Land extends JFrame {
	private static final long serialVersionUID = 1L;
	public Land() {	
	try {	
			// 设置全局字体及窗体
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e); }
	  	Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
	  	this.setIconImage(icon);//添加窗口图标
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("d://picture//4.jpg"); //添加背景图片
		JLabel background = new JLabel(img); 
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// 设置标题
		setTitle("企业物资管理系统");
		// 绝对布局
		setLayout(null);
		// 定义一个容器
		Container c = getContentPane();
		// 创建"用户名:"标签
		JLabel jl1 = new JLabel("用户名：");
		// 创建文本框
		final JTextField jtf1 = new JTextField();
		// 创建"密码:"标签
		JLabel jl2 = new JLabel("密码:");
		// 创建密码框
		final JPasswordField jpf1 = new JPasswordField();
		// 设置密码字符为*
		jpf1.setEchoChar('*');
		// 创建"提交"按钮
		JButton jb1 = new JButton("提交");
		// 创建"重置"按钮
		JButton jb2 = new JButton("重置");
		// 将各组件添加到容器中
				c.add(jl1);
				c.add(jtf1);
				c.add(jl2);
				c.add(jpf1);
				c.add(jb1);
				c.add(jb2);
				// 设置各组件的位置以及大小
				jl1.setBounds(10, 20, 90, 30);
				jtf1.setBounds(60, 20, 210, 30);
				jl2.setBounds(25, 60, 90, 30);
				jpf1.setBounds(60, 60, 210, 30);
				jb1.setBounds(80, 100, 70, 50);
				jb2.setBounds(150, 100, 70, 50);
				// 设置窗体大小、关闭方式、不可拉伸
				setSize(300, 220);
				setLocationRelativeTo(null); //设置窗口居中显示 	
				setVisible(true);
				setResizable(false);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// 当用户名为"user",密码为"123456"时点击"提交"按钮弹出"登录成功"提示对话框
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((jtf1.getText().trim().equals("user") && new String(jpf1.getPassword()).trim().equals("123456"))) {
					JOptionPane.showMessageDialog(null, "登陆成功！");
					setVisible(false);
					new User();	
				} else if (jtf1.getText().trim().length() == 0 || new String(jpf1.getPassword()).trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "不能为空!");
				} else {
					JOptionPane.showMessageDialog(null, "错误");
					// 清零
					jtf1.setText("");
					jpf1.setText("");
				}
			}
		});
		// 实现"重置"按钮功能
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtf1.setText("");
				jpf1.setText("");
			}
		});	 
	}	 
	public static void main(String[] args) {
		new Land();
		
	}
 
}
