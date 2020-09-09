package javabasic.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr=InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        //根据域名获取具体的IP地址
        addr=InetAddress.getByName("www.bilibili.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
