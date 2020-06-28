package javase.net;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**接收端，指定端口，创建接收端，将字节数组还原成对应类型*/
public class UdpTypeServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中。。。");;
        //指定端口、创建发送端
        DatagramSocket server=new DatagramSocket(9999);
        byte[] container=new byte[1024*60];
        DatagramPacket packet=new DatagramPacket(container,0,container.length);
        server.receive(packet);
        byte[] datas=packet.getData();
        int len=packet.getLength();
        DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        char r1=dis.readChar();
        int r2=dis.readInt();
        System.out.println(r2);
        server.close();
    }
}
