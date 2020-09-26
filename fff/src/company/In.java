package company;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class In extends JFrame{
	 private Connection conn;
	    private Statement stt;
	In(){
		Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
	  	this.setIconImage(icon);//添加窗口图标
		setTitle("企业物资管理系统");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(310, 460);
		setLocationRelativeTo(null); //设置窗口居中显示 
		setResizable(false);//设置窗口大小不可变
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font1 = new Font("宋体", Font.BOLD, 24);
		Font font2 = new Font("宋体", Font.BOLD, 15);
		JLabel biaoTi = new JLabel("物资入库");
		biaoTi.setFont(font1);
		JLabel q1 = new JLabel("==================================================================");
		biaoTi.setBounds(100, 10, 500, 25);
		JButton b1 = new JButton("确定");// 按钮1
		JButton b2 = new JButton("重置");// 按钮2
		JButton b3 = new JButton("返回");// 按钮3
		JLabel c1 = new JLabel("请输入以下入库物资信息：");
		JLabel c3 = new JLabel("编号：");
		JLabel c4 = new JLabel("名称：");
		JLabel c5 = new JLabel("类别：");
		JLabel c6 = new JLabel("单价：");
		JLabel c7 = new JLabel("数量：");
		JLabel c8 = new JLabel("所属科室：");
		final JTextField c2 = new JTextField();
		final JTextField d1 = new JTextField();
		final JTextField d2 = new JTextField();
		final JTextField d3 = new JTextField();
		final JTextField d4 = new JTextField();
		final JTextField d5 = new JTextField();
		q1.setBounds(0,40,800,25);
		b1.setBounds(10,350,100,25);
		b2.setBounds(110,350,100,25);
		b3.setBounds(210,350,100,25);
		b1.setSize(80, 50);
		b2.setSize(80, 50);
		b3.setSize(80, 50);
		c1.setBounds(0,60,200,25);
		c1.setFont(font2);
		c3.setBounds(0,100,200,25);
		c4.setBounds(0,140,200,25);
		c5.setBounds(0,180,200,25);
		c6.setBounds(0,220,200,25);
		c7.setBounds(0,260,200,25);
		c8.setBounds(0,300,200,25);
		c2.setBounds(60,100,230,25);
		d1.setBounds(60,140,230,25);
		d2.setBounds(60,180,230,25);
		d3.setBounds(60,220,230,25);
		d4.setBounds(60,260,230,25);
		d5.setBounds(60,300,230,25);
		c.add(biaoTi);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.add(c7);
		c.add(c8);
		c.add(d1);
		c.add(d2);
		c.add(d3);
		c.add(d4);
		c.add(d5);
		c.add(q1);
		 b1.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					try {
						if (c2.getText().trim().length() == 0||d1.getText().trim().length() == 0||d2.getText().trim().length() == 0
								||d3.getText().trim().length() == 0||d4.getText().trim().length() == 0||d5.getText().trim().length() == 0){
							JOptionPane.showMessageDialog(null, "不能存在空值！！");}
						else{			            //获取连接
			            conn = DBHerpel.getConnection();
			            if(conn==null)
			            return;
					 String sql = "insert into Material values("+c2.getText()+" , '"+d1.getText()+"', '"+d2.getText()+
							 "', '"+d3.getText()+"', '"+d4.getText()+"', '"+d5.getText()+"');";
			            stt = conn.createStatement();
			            stt.executeUpdate(sql);
			            JOptionPane.showMessageDialog(null, c2.getText()+"号物资编入库成功！");}
					} 
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null,c2.getText()+"号物资编号已存在！");
			                e1.printStackTrace();  
			                c2.setText("");
							d1.setText("");
							d2.setText("");
							d3.setText("");
							d4.setText("");
							d5.setText("");		          
			            }}});
		 b2.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					c2.setText("");
					d1.setText("");
					d2.setText("");
					d3.setText("");
					d4.setText("");
					d5.setText("");
			        }});
		 b3.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					setVisible(false);
					new User();
						}});
}

}
