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

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class Out extends JFrame{
	 private Connection conn;
	    private Statement stt;
	    // 结果集
	    private ResultSet set;
	Out(){
		Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
	  	this.setIconImage(icon);//添加窗口图标
		setTitle("企业物资管理系统");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(550, 300);
		setLocationRelativeTo(null); //设置窗口居中显示 
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font1 = new Font("宋体", Font.BOLD, 24);
		JLabel biaoTi = new JLabel("物资出库");
		biaoTi.setFont(font1);
		JLabel q1 = new JLabel("==================================================================================================");
		biaoTi.setBounds(200, 10, 500, 25);
		JTextField j1 = new JTextField("编号"+"\t"+"名称"+"\t"+"物资类别"+"\t"+"单价"+"\t"+"数量"+"\t"+"所属科室");
		JButton b1 = new JButton("确定");// 按钮1
		JButton b2 = new JButton("确认出库");// 按钮2
		JButton b3 = new JButton("返回");// 按钮3
		JLabel c1 = new JLabel("请输入出库物资编号：");
		final JTextField c2 = new JTextField();
		final JTextArea j2 = new JTextArea();
		JLabel c3 = new JLabel("查询到出库物资信息为：");
		q1.setBounds(0,40,800,25);
		b1.setBounds(250,60,100,25);
		b2.setBounds(150,200,100,25);
		b2.setSize(100, 50);
		b3.setBounds(300,200,100,25);
		b3.setSize(100, 50);
		c1.setBounds(0,60,200,25);
		c2.setBounds(150,60,80,25);
		c3.setBounds(0,100,200,25);	
		j2.setBounds(0,155,550,25);
		j2.setEditable(false);//文本框设置为不可编辑
		j1.setBounds(0,125,550,25);
		j1.setEditable(false);//文本框设置为不可编辑
		c.add(biaoTi);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(q1);
		c.add(j1);
		c.add(j2);
		 b1.addActionListener(new ActionListener() {// 给按钮添加事件接收器
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
		 b2.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					  try {  
					        //获取连接
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String deleteSql = "DELETE FROM Material WHERE 物资编号="+"'"+c2.getText()+"'"+";";     
					        stt = conn.createStatement();
					        stt.executeUpdate(deleteSql);
					        if (j2.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "不能为空！");
							}
					        else{JOptionPane.showMessageDialog(null, c2.getText()+"号物资编出库成功！");}
			        } 
					  catch (Exception e1) {
			            e1.printStackTrace();
			            System.out.print("出库失败！");
			        }}});
		 b3.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					setVisible(false);
					new User();
						}});
	}
	
}
