package jdbc;

import java.io.*;
import java.sql.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/18--17:23
 * 测试大文本对象的使用
 */
public class Demo09 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Reader r=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接,是一个远程的连接，比较耗时
            conn = DriverManager.getConnection("jdbc:mysql://120.26.185.115:3306/testjdbc?serverTimezone=UTC","root","密码你猜");
//            ps=conn.prepareStatement("insert into t_user (username,myInfo) values (?,?)");
//            ps.setString(1,"dkp");
//            ps.setClob(2,new FileReader(new File("文件路径")));
//            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("asdasda".getBytes()))));//将程序中的字符串输入到clob字段中
            ps= conn.prepareCall("select * from t_user where id=?");
            ps.setObject(1,20009);
            rs=ps.executeQuery();
            while (rs.next()){
                Clob c=rs.getClob("myInfo");
                r=c.getCharacterStream();
                int temp=0;
                while ((temp=r.read())!=-1){
                    System.out.print((char)temp);
                }
            }
//            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (r!=null) {
                    r.close();
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
