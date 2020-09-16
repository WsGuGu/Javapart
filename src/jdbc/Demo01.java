package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/16--16:19
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接,是一个远程的连接，比较耗时
            Connection conn =DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
