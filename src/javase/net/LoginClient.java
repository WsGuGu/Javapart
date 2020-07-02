package javase.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class LoginClient {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket client=new Socket("localhost",8888);
        //输出操作
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name=console.readLine();
        System.out.println("请输入密码");
        String pwd=console.readLine();
        dos.writeUTF(name+"&"+pwd);
        dos.flush();
        //释放资源
        dos.close();
        client.close();
    }
}
