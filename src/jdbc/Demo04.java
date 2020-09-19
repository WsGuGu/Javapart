package jdbc;

import java.sql.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/17--15:10
 */
public class Demo04 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接,是一个远程的连接，比较耗时
            conn = DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");

            String sql="select id,username,pwd from t_user where id>?";
            ps=conn.prepareStatement(sql);
            ps.setObject(1,2);
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"-----"+rs.getString(3));
            }
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
