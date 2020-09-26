package company;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class All extends JFrame{
	private static final long serialVersionUID = 1L;
	// 连接对象
    private Connection conn;
    private Statement stt;
    // 结果集
    private ResultSet set;
	 All(){
		Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
		 this.setIconImage(icon);//添加窗口图标
		setTitle("企业物资管理系统");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(650, 400);
		setLocationRelativeTo(null); //设置窗口居中显示 
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font1 = new Font("宋体", Font.BOLD, 24);
		JLabel biaoTi = new JLabel("查询所有物资");
		biaoTi.setFont(font1);
		JLabel q1 = new JLabel("==================================================================================================");
		biaoTi.setBounds(230, 10, 500, 25);
		JTextField a1 = new JTextField("编号"+"\t"+"名称"+"\t"+"物资类别"+"\t"+"单价"+"\t"+"数量"+"\t"+"所属科室");
		JButton b1 = new JButton("返回");// 按钮1
		JButton b2 = new JButton("单一查询");// 按钮2
		JLabel c1 = new JLabel("请输入物资编号");
		final JTextField c2 = new JTextField();
		q1.setBounds(0,40,800,25);
		a1.setBounds(0,55,550,25);
		a1.setEditable(false);//文本框设置为不可编辑
		b1.setBounds(550,300,100,25);
		b1.setSize(100, 65);
		b2.setBounds(550,80,100,25);
		b2.setSize(100, 85);
		c1.setBounds(550,165,100,25);
		c2.setBounds(550,185,80,25);
		final JTextArea j1 = new JTextArea();
		final JTextArea j2 = new JTextArea();
		j1.setEditable(false);//文本框设置为不可编辑
		j2.setBounds(0,340,550,25);
		j2.setEditable(false);//文本框设置为不可编辑
		JScrollPane jsp = new JScrollPane(j1);//新建一个滚动条界面，将文本框传入
		jsp.setBounds(0,80,550,250);
		c.add(jsp);//注意：将滚动条界面添加到组建中，而不是添加文本	
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		c.add(a1);
		c.add(b1);
		c.add(b2);
		c.add(c1);
		c.add(c2);
		c.add(q1);
		c.add(biaoTi);
		c.add(j2);
		 try {
		conn = DBHerpel.getConnection();
	      if (conn == null)
	 		 return ;
		String Sql = "select * from Material"; 
        stt = conn.createStatement();
        set = stt.executeQuery(Sql);
        while (set.next()) {  	 
        	j1.append(set.getString(1) + "\t" + set.getString(2) +"\t" + set.getString(3)+ 
             		"\t" + set.getString(4)+ "\t" + set.getString(5)+"\t" + set.getString(6)+"\n");
        	}
        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.print("查询失败！");
	        }
		 b1.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					setVisible(false);
					new User();
						}});
		 b2.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					j2.setText("");
					try {
						conn = DBHerpel.getConnection();
					      if (conn == null)
					 		 return ;
					String Sql1 = "select * from Material where 物资编号="+c2.getText()+";";
					 stt = conn.createStatement();
				        set = stt.executeQuery(Sql1);
				        while (set.next()) {  	 
				        	j2.append(set.getString(1) + "\t" + set.getString(2) +"\t" + set.getString(3)+ 
				             		"\t" + set.getString(4)+ "\t" + set.getString(5)+"\t" + set.getString(6)+"\n");
				        	} 
				        if (j2.getText().trim().length() == 0){
							JOptionPane.showMessageDialog(null, "物资编号不存在！");
						}
				        } catch (Exception e1) {
					            e1.printStackTrace();	 
					            JOptionPane.showMessageDialog(null, "不能为空！");
					        }
						}});
	}
}
