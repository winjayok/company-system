package company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBHerpel {
    private static Connection Conn; // 数据库连接对象
    static String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
    // 数据库连接地址
    private static String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Material";
    // 数据库的用户名
    private static String UserName = "winjay";
    // 数据库的密码
    private static String Password = "123456";
    public static Connection getConnection() {
        try {
            Class.forName(JDriver); // 加载驱动
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try {
            //通过DriverManager类的getConenction方法指定三个参数,连接数据库
            Conn = DriverManager.getConnection(URL, UserName, Password);
            //返回连接对象
            return Conn;
      } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
	
}