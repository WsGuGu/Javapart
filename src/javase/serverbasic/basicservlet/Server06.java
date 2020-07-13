package javase.serverbasic.basicservlet;

import javase.serverbasic.Request2;
import javase.serverbasic.Response01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/11 14:33
 * 目标：封装请求信息
 *
 */
public class Server06 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server06 server=new Server06();
        server.start();
    }
    //启动服务
    public void start(){
        try {
            serverSocket=new ServerSocket(8888);
            receive();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
    //接受连接处理
    public void receive(){
        try {
            Socket client=serverSocket.accept();
            System.out.println("一个客户端建立了连接");
            //获取请求协议
            javase.serverbasic.basicservlet.Request2 request= new javase.serverbasic.basicservlet.Request2(client);
            //获取响应协议
            javase.serverbasic.basicservlet.Response01 response01=new javase.serverbasic.basicservlet.Response01(client);
            Servlet servlet=null;
            if (request.getUrl().equals("login")){
                servlet=new LoginServlet();
            }
            else if (request.getUrl().equals("reg")){
                servlet=new RegisterServlet();
            }
            else {
                //首页
            }
            servlet.service(request,response01);
            //关注了内容

            //关注了状态码
            response01.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
    public void stop(){
    }
}
