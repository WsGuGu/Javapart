package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/17--10:34
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接,是一个远程的连接，比较耗时
            Connection conn = DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");
            String sql="insert into t_user (username,pwd,regTime) values (?,?,?) ";//?表示占位符
            PreparedStatement ps=conn.prepareStatement(sql);
//            ps.setString(1,"打个人");//参数索引从1开始计算
//            ps.setString(2,"123456");
            ps.setObject(1,"卡莲3");
            ps.setObject(2,"213sd");
            ps.setObject(3,new java.sql.Date(System.currentTimeMillis()));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
