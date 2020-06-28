package javase.net;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**将基本类型转为数组*/
public class UdpTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。");
        //指定端口、创建发送端
        DatagramSocket client=new DatagramSocket(7777);
        //准备数据 一定转成字节数组
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeChar('h');
        dos.writeInt(123);
        dos.writeBoolean(false);
        dos.flush();
        byte[] datas=baos.toByteArray();
        //封装成datagram包裹，需要指定目的地
        DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",
                9999));
        //发送包裹
        client.send(packet);
        //释放资源
        client.close();
    }
}
