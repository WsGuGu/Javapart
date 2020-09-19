package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/19--11:35
 */
public class Demo11 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getMysqlConn();
            ps=conn.prepareStatement("insert into t_user(username) values (?)");
            ps.setString(1,"321");
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }
}
