package javabasic.net;

import java.net.MalformedURLException;
import java.net.URL;

/**统一资源定位符*/
public class URL01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("http://www.baidu.com:80/index.html?uname=231&age=18#a");
        //获取四个值
        System.out.println("协议"+url.getProtocol());
        System.out.println("域名或IP"+url.getHost());
        System.out.println("端口"+url.getPort());
        System.out.println("请求资源"+url.getFile());
        System.out.println("请求资源"+url.getPath());
        //参数
        System.out.println("参数"+url.getQuery());
        //锚点
        System.out.println("锚点"+url.getRef());
    }
}
