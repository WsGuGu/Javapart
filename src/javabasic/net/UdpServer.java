package javabasic.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**接收端，指定端口，创建接收端*/
public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中。。。");;
        //指定端口、创建发送端
        DatagramSocket server=new DatagramSocket(9999);
        byte[] container=new byte[1024*60];
        DatagramPacket packet=new DatagramPacket(container,0,container.length);
        server.receive(packet);
        byte[] datas=packet.getData();
        int len=packet.getLength();
        System.out.println(new String(datas,0,len));
        server.close();
    }
}
