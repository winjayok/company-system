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
public class Change extends JFrame{
	private static final long serialVersionUID = 1L;
	private Connection conn;
	    private Statement stt;
	    // 结果集
	    private ResultSet set;
	Change(){
		Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
	  	this.setIconImage(icon);//添加窗口图标
		setTitle("企业物资管理系统");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(480, 350);
		setLocationRelativeTo(null); //设置窗口居中显示 
		setResizable(false);//设置窗口大小不可变
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font1 = new Font("宋体", Font.BOLD, 24);
		Font font2 = new Font("宋体", Font.BOLD, 15);
		JLabel biaoTi = new JLabel("修改物资信息");
		biaoTi.setFont(font1);
		JLabel q1 = new JLabel("======================================================================");
		biaoTi.setBounds(150, 10, 500, 25);
		JButton b1 = new JButton("确定");// 按钮1
		JButton b2 = new JButton("修改名称");// 按钮2
		JButton b3 = new JButton("修改类别");// 按钮3
		JButton b4= new JButton("修改单价");// 按钮4
		JButton b5 = new JButton("修改数量");// 按钮5
		JButton b6 = new JButton("修改科室");// 按钮6
		JButton b7 = new JButton("返回");// 按钮7
		JButton b8 = new JButton("全部修改");// 按钮7
		JLabel c1 = new JLabel("请输入库物资编号：");
		JLabel c3 = new JLabel("请对应下列信息选择修改");
		JTextField j1 = new JTextField("编号"+"\t"+"名称"+"\t"+"物资类别"
		+"\t"+"单价"+"\t"+"数量"+"            "+"所属科室");
		final JTextField d1 = new JTextField();
		JLabel c2 = new JLabel("查询到物资信息为：");
		final JTextArea d2 = new JTextArea();
		final JTextField d3 = new JTextField();
		final JTextField d4 = new JTextField();
		final JTextField d5 = new JTextField();
		final JTextField d6 = new JTextField();
		final JTextField d7 = new JTextField();
		q1.setBounds(0,40,800,25);
		b1.setBounds(210,60,100,25);
		b2.setBounds(90,210,100,25);
		b3.setBounds(90,240,100,25);
		b4.setBounds(90,270,100,25);
		b5.setBounds(360,210,100,25);
		b6.setBounds(360,240,100,25);
		b7.setBounds(380,270,100,25);
		b7.setSize(80,25);
		b8.setBounds(270,270,100,25);
		b8.setSize(100,25);
		c1.setBounds(0,60,200,25);
		c1.setFont(font2);
		c2.setBounds(0,90,230,25);
		c2.setFont(font2);
		c3.setBounds(0,180,200,25);
		c3.setFont(font2);
		j1.setBounds(0,120,470,25);
		j1.setEditable(false);//文本框设置为不可编辑
		d1.setBounds(150,60,50,25);
		d2.setBounds(00,150,470,25);
		d2.setEditable(false);//文本框设置为不可编辑
		d3.setBounds(0,210,80,25);
		d4.setBounds(0,240,80,25);
		d5.setBounds(0,270,80,25);
		d6.setBounds(270,210,80,25);
		d7.setBounds(270,240,80,25);
		c.add(biaoTi);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		c.add(b6);
		c.add(b7);
		c.add(b8);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(d1);
		c.add(d2);
		c.add(d3);
		c.add(d4);
		c.add(d5);
		c.add(d6);
		c.add(d7);
		c.add(q1);
		c.add(j1);
		 b1.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					d2.setText("");
					try {
						conn = DBHerpel.getConnection();
					      if (conn == null)
					 		 return ;
					String Sql1 = "select * from Material where 物资编号="+d1.getText()+";";
					 stt = conn.createStatement();
				        set = stt.executeQuery(Sql1);
				        while (set.next()) {  	 
				        	d2.append(set.getString(1) + "\t"+ set.getString(2) +"\t" + set.getString(3)+ 
				        			"\t"+ set.getString(4)+ "\t" + set.getString(5)+"\t" + set.getString(6)+"\n");
				        	} 
				        if (d2.getText().trim().length() == 0){
							JOptionPane.showMessageDialog(null,  "物资编号不存在！");
						}
				        } catch (Exception e1) {
					            e1.printStackTrace();	 
					            JOptionPane.showMessageDialog(null, "物资编号不存在！");
					        }
						}});
		 b2.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					  try {  
						  if (d3.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "名称不能为空！");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "编号不能为空！");
							}
						  if (d1.getText().trim().length() != 0&&d3.getText().trim().length() != 0){
					        //获取连接
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET 物资名称 = '"+d3.getText()+"' WHERE 物资编号 = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "号物资名称修改成功！");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "名称修改失败！");
			        }}});
		 b3.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					  try {  
						  if (d4.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "类别不能为空！");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "编号不能为空！");
							}
						  if (d1.getText().trim().length() != 0&&d4.getText().trim().length() != 0){
					        //获取连接
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET 物资类别 = '"+d4.getText()+"' WHERE 物资编号 = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();	
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "号物资类别修改成功！");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "类别修改失败！");
			        }}});
		 b4.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					  try {  
						  if (d5.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "单价不能为空！");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "编号不能为空！");
							}
				        	 if (d1.getText().trim().length() != 0&&d5.getText().trim().length() != 0){
					        //获取连接
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET 单价 = '"+d5.getText()+"' WHERE 物资编号 = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "号物资单价修改成功！");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "单价修改失败！");
			        }}});
		 b5.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					  try {  
						  if (d6.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "数量不能为空！");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "编号不能为空！");
							}
						  if (d1.getText().trim().length() != 0&&d6.getText().trim().length() != 0){
					        //获取连接
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET 数量 = '"+d6.getText()+"' WHERE 物资编号 = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "号物资数量修改成功！");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "数量修改失败！");
			        }}});
		 b6.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					  try {  
						  if (d7.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "所属科室不能为空！");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "编号不能为空！");
							}
						  if (d1.getText().trim().length() != 0&&d7.getText().trim().length() != 0){
					        //获取连接
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET 所属科室 = '"+d7.getText()+"' WHERE 物资编号 = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        	 
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "号物资所属科室修改成功！");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "所属科室修改失败！");
			        }}});
		 b8.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					  try {  
						  if (d7.getText().trim().length() == 0||d6.getText().trim().length() == 0||d5.getText().trim().length() == 0||
								  d4.getText().trim().length() == 0||d3.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "所填信息不能为空！");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "编号不能为空！");
							}
						  if (d1.getText().trim().length() != 0&&d7.getText().trim().length() != 0){
					        //获取连接
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET 所属科室 = '"+d7.getText()+"' " +",数量='"+d6.getText()+"'"
					        		+",单价='"+d5.getText()+"'"+",物资类别='"+d4.getText()+"'"+",物资名称='"+d3.getText()+"'"+
					        		"WHERE 物资编号 = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "号物资信息修改成功！");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "物资信息修改失败！");
			        }}});
		 b7.addActionListener(new ActionListener() {// 给按钮添加事件接收器
				public void actionPerformed(ActionEvent e) {// 接受到事件后,进行下面的处理
					setVisible(false);
					new User();
						}});
}
	public static void main(String[] args) {
		new Change();
		
	}
}
