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
	    // �����
	    private ResultSet set;
	Change(){
		Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
	  	this.setIconImage(icon);//��Ӵ���ͼ��
		setTitle("��ҵ���ʹ���ϵͳ");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(480, 350);
		setLocationRelativeTo(null); //���ô��ھ�����ʾ 
		setResizable(false);//���ô��ڴ�С���ɱ�
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font1 = new Font("����", Font.BOLD, 24);
		Font font2 = new Font("����", Font.BOLD, 15);
		JLabel biaoTi = new JLabel("�޸�������Ϣ");
		biaoTi.setFont(font1);
		JLabel q1 = new JLabel("======================================================================");
		biaoTi.setBounds(150, 10, 500, 25);
		JButton b1 = new JButton("ȷ��");// ��ť1
		JButton b2 = new JButton("�޸�����");// ��ť2
		JButton b3 = new JButton("�޸����");// ��ť3
		JButton b4= new JButton("�޸ĵ���");// ��ť4
		JButton b5 = new JButton("�޸�����");// ��ť5
		JButton b6 = new JButton("�޸Ŀ���");// ��ť6
		JButton b7 = new JButton("����");// ��ť7
		JButton b8 = new JButton("ȫ���޸�");// ��ť7
		JLabel c1 = new JLabel("����������ʱ�ţ�");
		JLabel c3 = new JLabel("���Ӧ������Ϣѡ���޸�");
		JTextField j1 = new JTextField("���"+"\t"+"����"+"\t"+"�������"
		+"\t"+"����"+"\t"+"����"+"            "+"��������");
		final JTextField d1 = new JTextField();
		JLabel c2 = new JLabel("��ѯ��������ϢΪ��");
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
		j1.setEditable(false);//�ı�������Ϊ���ɱ༭
		d1.setBounds(150,60,50,25);
		d2.setBounds(00,150,470,25);
		d2.setEditable(false);//�ı�������Ϊ���ɱ༭
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
		 b1.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					d2.setText("");
					try {
						conn = DBHerpel.getConnection();
					      if (conn == null)
					 		 return ;
					String Sql1 = "select * from Material where ���ʱ��="+d1.getText()+";";
					 stt = conn.createStatement();
				        set = stt.executeQuery(Sql1);
				        while (set.next()) {  	 
				        	d2.append(set.getString(1) + "\t"+ set.getString(2) +"\t" + set.getString(3)+ 
				        			"\t"+ set.getString(4)+ "\t" + set.getString(5)+"\t" + set.getString(6)+"\n");
				        	} 
				        if (d2.getText().trim().length() == 0){
							JOptionPane.showMessageDialog(null,  "���ʱ�Ų����ڣ�");
						}
				        } catch (Exception e1) {
					            e1.printStackTrace();	 
					            JOptionPane.showMessageDialog(null, "���ʱ�Ų����ڣ�");
					        }
						}});
		 b2.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					  try {  
						  if (d3.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "���Ʋ���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() != 0&&d3.getText().trim().length() != 0){
					        //��ȡ����
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET �������� = '"+d3.getText()+"' WHERE ���ʱ�� = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "�����������޸ĳɹ���");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "�����޸�ʧ�ܣ�");
			        }}});
		 b3.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					  try {  
						  if (d4.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "�����Ϊ�գ�");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() != 0&&d4.getText().trim().length() != 0){
					        //��ȡ����
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET ������� = '"+d4.getText()+"' WHERE ���ʱ�� = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();	
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "����������޸ĳɹ���");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "����޸�ʧ�ܣ�");
			        }}});
		 b4.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					  try {  
						  if (d5.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "���۲���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
							}
				        	 if (d1.getText().trim().length() != 0&&d5.getText().trim().length() != 0){
					        //��ȡ����
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET ���� = '"+d5.getText()+"' WHERE ���ʱ�� = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "�����ʵ����޸ĳɹ���");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "�����޸�ʧ�ܣ�");
			        }}});
		 b5.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					  try {  
						  if (d6.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() != 0&&d6.getText().trim().length() != 0){
					        //��ȡ����
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET ���� = '"+d6.getText()+"' WHERE ���ʱ�� = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "�����������޸ĳɹ���");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "�����޸�ʧ�ܣ�");
			        }}});
		 b6.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					  try {  
						  if (d7.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "�������Ҳ���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() != 0&&d7.getText().trim().length() != 0){
					        //��ȡ����
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET �������� = '"+d7.getText()+"' WHERE ���ʱ�� = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        	 
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "���������������޸ĳɹ���");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "���������޸�ʧ�ܣ�");
			        }}});
		 b8.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					  try {  
						  if (d7.getText().trim().length() == 0||d6.getText().trim().length() == 0||d5.getText().trim().length() == 0||
								  d4.getText().trim().length() == 0||d3.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "������Ϣ����Ϊ�գ�");
							}
						  if (d1.getText().trim().length() == 0){
								JOptionPane.showMessageDialog(null, "��Ų���Ϊ�գ�");
							}
						  if (d1.getText().trim().length() != 0&&d7.getText().trim().length() != 0){
					        //��ȡ����
					        conn = DBHerpel.getConnection();
					        if(conn==null)
					        return;
					        String UpdateSql1 = "UPDATE Material SET �������� = '"+d7.getText()+"' " +",����='"+d6.getText()+"'"
					        		+",����='"+d5.getText()+"'"+",�������='"+d4.getText()+"'"+",��������='"+d3.getText()+"'"+
					        		"WHERE ���ʱ�� = "+"'"+d1.getText()+"'"+";";
				        	java.sql.PreparedStatement ps = conn.prepareStatement(UpdateSql1);
				        	ps.executeUpdate();
				        		 JOptionPane.showMessageDialog(null,d1.getText()+ "��������Ϣ�޸ĳɹ���");
								}
			        }catch (Exception e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(null, "������Ϣ�޸�ʧ�ܣ�");
			        }}});
		 b7.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					setVisible(false);
					new User();
						}});
}
	public static void main(String[] args) {
		new Change();
		
	}
}
