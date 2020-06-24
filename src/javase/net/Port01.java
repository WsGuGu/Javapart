package javase.net;

import java.net.InetSocketAddress;

/**
 * 端口区分软件
 * 端口两个字节
 * 同一协议端口不能冲突
 * */
public class Port01 {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress=new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress inetSocketAddress2=new InetSocketAddress("localhost",9080);
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress2.getAddress());
        System.out.println(inetSocketAddress2.getPort());
    }
}
