package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/17--10:17
 * 测试执行sql语句
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接,是一个远程的连接，比较耗时
            Connection conn = DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");
            Statement stmt=conn.createStatement();
            String sql="select * from t_user";
            System.out.println(stmt.execute(sql));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
