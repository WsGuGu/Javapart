package jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/17--15:10
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接,是一个远程的连接，比较耗时
            conn = DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");
            ps=conn.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values (?,?,?,?)");
            ps.setObject(1,"gkd");
            ps.setObject(2,"123456");
            Date date=new Date(System.currentTimeMillis());
            ps.setDate(3,date);
            ps.setTimestamp(4,new Timestamp(System.currentTimeMillis()));//如果需要指定，可以使用calendar,dateformat
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
