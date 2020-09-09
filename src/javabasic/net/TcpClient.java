package javabasic.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**建立流程，创建客户端*/
public class TcpClient {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket client=new Socket("localhost",8888);
        //输出操作
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());
        String Data="hellp";
        dos.writeUTF(Data);
        dos.flush();
        //释放资源
        dos.close();
        client.close();
    }
}
