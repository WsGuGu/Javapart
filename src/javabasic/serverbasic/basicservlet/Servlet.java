package javabasic.serverbasic.basicservlet;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/13--17:29
 */
public interface Servlet {
    void service(Request2 request,Response01 response01);
//    void doGet(Request request,Response01 response01);
//    void doPost(Request request,Response01 response01);
}