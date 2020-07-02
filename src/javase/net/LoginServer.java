package javase.net;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        //指定端口
        ServerSocket sever=new ServerSocket(8888);
        //阻塞式等待连接
        Socket client=sever.accept();
        System.out.println("一个客户端建立了连接");
        //输入流操作
        DataInputStream dis=new DataInputStream(client.getInputStream());
        String datas=dis.readUTF();
        //分析数据
        String[] dataArray=datas.split("&");
        System.out.println(dataArray[0]+"--->"+dataArray[1]);
        //释放资源
        dis.close();
        client.close();
    }
}
