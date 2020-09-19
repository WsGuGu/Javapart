package javabasic.serverbasic.basic;

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
 */
public class Server02 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server02 server=new Server02();
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
            StringBuilder content=new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("终于回来了.....");
            content.append("</body>");
            content.append("</html>");
            int size=content.toString().getBytes().length;
            StringBuilder responseInfo=new StringBuilder();
            String blank=" ";
            String CRLF="\r\n";
            //返回
            //响应行
            responseInfo.append("HTTP/1.1").append(blank);
            responseInfo.append(200).append(blank);
            responseInfo.append("OK").append(CRLF);
            responseInfo.append("Date").append(new Date()).append(CRLF);
            responseInfo.append("Server:").append("gugu Server/0.0.1;charset=GBK").append(CRLF);
            responseInfo.append("Content-type:text/html:").append(CRLF);
            responseInfo.append("Content-length:").append(size).append(CRLF);
            responseInfo.append(CRLF);
            //正文
            responseInfo.append(content.toString());
            //写出到客户端
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(responseInfo.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
    public void stop(){

    }
}
