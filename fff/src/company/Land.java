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
			// ����ȫ�����弰����
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e); }
	  	Image icon = Toolkit.getDefaultToolkit().getImage("d://picture//3.jpg");
	  	this.setIconImage(icon);//��Ӵ���ͼ��
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("d://picture//4.jpg"); //��ӱ���ͼƬ
		JLabel background = new JLabel(img); 
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// ���ñ���
		setTitle("��ҵ���ʹ���ϵͳ");
		// ���Բ���
		setLayout(null);
		// ����һ������
		Container c = getContentPane();
		// ����"�û���:"��ǩ
		JLabel jl1 = new JLabel("�û�����");
		// �����ı���
		final JTextField jtf1 = new JTextField();
		// ����"����:"��ǩ
		JLabel jl2 = new JLabel("����:");
		// ���������
		final JPasswordField jpf1 = new JPasswordField();
		// ���������ַ�Ϊ*
		jpf1.setEchoChar('*');
		// ����"�ύ"��ť
		JButton jb1 = new JButton("�ύ");
		// ����"����"��ť
		JButton jb2 = new JButton("����");
		// ���������ӵ�������
				c.add(jl1);
				c.add(jtf1);
				c.add(jl2);
				c.add(jpf1);
				c.add(jb1);
				c.add(jb2);
				// ���ø������λ���Լ���С
				jl1.setBounds(10, 20, 90, 30);
				jtf1.setBounds(60, 20, 210, 30);
				jl2.setBounds(25, 60, 90, 30);
				jpf1.setBounds(60, 60, 210, 30);
				jb1.setBounds(80, 100, 70, 50);
				jb2.setBounds(150, 100, 70, 50);
				// ���ô����С���رշ�ʽ����������
				setSize(300, 220);
				setLocationRelativeTo(null); //���ô��ھ�����ʾ 	
				setVisible(true);
				setResizable(false);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// ���û���Ϊ"user",����Ϊ"123456"ʱ���"�ύ"��ť����"��¼�ɹ�"��ʾ�Ի���
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((jtf1.getText().trim().equals("user") && new String(jpf1.getPassword()).trim().equals("123456"))) {
					JOptionPane.showMessageDialog(null, "��½�ɹ���");
					setVisible(false);
					new User();	
				} else if (jtf1.getText().trim().length() == 0 || new String(jpf1.getPassword()).trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "����Ϊ��!");
				} else {
					JOptionPane.showMessageDialog(null, "����");
					// ����
					jtf1.setText("");
					jpf1.setText("");
				}
			}
		});
		// ʵ��"����"��ť����
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
