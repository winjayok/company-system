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
	// ���Ӷ���
    private Connection conn;
    private Statement stt;
    // �����
    private ResultSet set;
	 All(){
		Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
		 this.setIconImage(icon);//��Ӵ���ͼ��
		setTitle("��ҵ���ʹ���ϵͳ");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(650, 400);
		setLocationRelativeTo(null); //���ô��ھ�����ʾ 
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font1 = new Font("����", Font.BOLD, 24);
		JLabel biaoTi = new JLabel("��ѯ��������");
		biaoTi.setFont(font1);
		JLabel q1 = new JLabel("==================================================================================================");
		biaoTi.setBounds(230, 10, 500, 25);
		JTextField a1 = new JTextField("���"+"\t"+"����"+"\t"+"�������"+"\t"+"����"+"\t"+"����"+"\t"+"��������");
		JButton b1 = new JButton("����");// ��ť1
		JButton b2 = new JButton("��һ��ѯ");// ��ť2
		JLabel c1 = new JLabel("���������ʱ��");
		final JTextField c2 = new JTextField();
		q1.setBounds(0,40,800,25);
		a1.setBounds(0,55,550,25);
		a1.setEditable(false);//�ı�������Ϊ���ɱ༭
		b1.setBounds(550,300,100,25);
		b1.setSize(100, 65);
		b2.setBounds(550,80,100,25);
		b2.setSize(100, 85);
		c1.setBounds(550,165,100,25);
		c2.setBounds(550,185,80,25);
		final JTextArea j1 = new JTextArea();
		final JTextArea j2 = new JTextArea();
		j1.setEditable(false);//�ı�������Ϊ���ɱ༭
		j2.setBounds(0,340,550,25);
		j2.setEditable(false);//�ı�������Ϊ���ɱ༭
		JScrollPane jsp = new JScrollPane(j1);//�½�һ�����������棬���ı�����
		jsp.setBounds(0,80,550,250);
		c.add(jsp);//ע�⣺��������������ӵ��齨�У�����������ı�	
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
	            System.out.print("��ѯʧ�ܣ�");
	        }
		 b1.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					setVisible(false);
					new User();
						}});
		 b2.addActionListener(new ActionListener() {// ����ť����¼�������
				public void actionPerformed(ActionEvent e) {// ���ܵ��¼���,��������Ĵ���
					j2.setText("");
					try {
						conn = DBHerpel.getConnection();
					      if (conn == null)
					 		 return ;
					String Sql1 = "select * from Material where ���ʱ��="+c2.getText()+";";
					 stt = conn.createStatement();
				        set = stt.executeQuery(Sql1);
				        while (set.next()) {  	 
				        	j2.append(set.getString(1) + "\t" + set.getString(2) +"\t" + set.getString(3)+ 
				             		"\t" + set.getString(4)+ "\t" + set.getString(5)+"\t" + set.getString(6)+"\n");
				        	} 
				        if (j2.getText().trim().length() == 0){
							JOptionPane.showMessageDialog(null, "���ʱ�Ų����ڣ�");
						}
				        } catch (Exception e1) {
					            e1.printStackTrace();	 
					            JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
					        }
						}});
	}
}
