package company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBHerpel {
    private static Connection Conn; // ���ݿ����Ӷ���
    static String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
    // ���ݿ����ӵ�ַ
    private static String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Material";
    // ���ݿ���û���
    private static String UserName = "winjay";
    // ���ݿ������
    private static String Password = "123456";
    public static Connection getConnection() {
        try {
            Class.forName(JDriver); // ��������
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try {
            //ͨ��DriverManager���getConenction����ָ����������,�������ݿ�
            Conn = DriverManager.getConnection(URL, UserName, Password);
            //�������Ӷ���
            return Conn;
      } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
	
}