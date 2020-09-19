package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/18--17:23
 * 测试二进制大对象的使用
 */
public class Demo10 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        InputStream is=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接,是一个远程的连接，比较耗时
            conn = DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");
//            ps=conn.prepareStatement("insert into t_user (username,headImg) values (?,?)");
//            ps.setString(1,"dkp");
//            ps.setBlob(2,new FileInputStream("d/xxxxx"));
//            ps.execute();
            ps= conn.prepareCall("select * from t_user where id=?");
            ps.setObject(1,20010);
            rs=ps.executeQuery();
            while (rs.next()){
                Blob b=rs.getBlob("headImg");
                is=b.getBinaryStream();
                int temp=0;
                while ((temp=is.read())!=-1){
                    System.out.print((char)temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null) {
                    is.close();
                }
            } catch (IOException throwables) {
                throwables.printStackTrace();
            }
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
