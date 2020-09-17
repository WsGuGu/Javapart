package jdbc;

import java.sql.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/17--15:37
 * 测试批处理
 */
public class Demo05 {
    public static void main(String[] args) {
            Connection conn=null;
            Statement stmt=null;
            ResultSet rs=null;
            try {
                //加载驱动类
                Class.forName("com.mysql.cj.jdbc.Driver");
                //建立连接,是一个远程的连接，比较耗时
                conn = DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");
                conn.setAutoCommit(false);//设为手动提交
                stmt=conn.createStatement();
                for (int i=0;i<20000;i++){
                    stmt.addBatch("insert into t_user (username,pwd,regTime) values ('mark"+i+"',666666,now())");
                }
                stmt.executeBatch();
                conn.commit();//提交事务
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if (rs!=null) {
                        rs.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    if (stmt!=null) {
                        stmt.close();
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
