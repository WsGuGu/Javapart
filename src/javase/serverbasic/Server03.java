package javase.serverbasic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/11 14 33
 * 目标：封装响应信息
 * 1.内容可以动态添加
 * 2.关注状态码，拼接好响应的协议信息
 */
public class Server03 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server03 server=new Server03();
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
            InputStream is=client.getInputStream();
            byte[] datas=new byte[1024*1024];
            int len=is.read(datas);
            String requestInfo=new String(datas,0,len);
            System.out.println(requestInfo);
            Response01 response01=new Response01(client);
            //关注了内容
            response01.print("<html>");
            response01.print("<head>");
            response01.print("<title>");
            response01.print("服务器响应成功");
            response01.print("</title>");
            response01.print("</head>");
            response01.print("<body>");
            response01.print("终于回来了.....");
            response01.print("</body>");
            response01.print("</html>");
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
