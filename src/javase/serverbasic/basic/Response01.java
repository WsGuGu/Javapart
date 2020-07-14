package javase.serverbasic.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/12 11 54
 */
public class Response01 {
    private BufferedWriter bw;
    //正文
    private StringBuilder content;
    //协议头信息
    private StringBuilder headInfo;
    private int len;
    private final String BLANK=" ";
    private final String CRLF="\r\n";
    private Response01(){
        content=new StringBuilder();
        headInfo=new StringBuilder();
        len=0;
    }
    public Response01(Socket client){
        this();
        try {
            bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo=null;
        }
    }
    public Response01(OutputStream os){
        this();
        bw=new BufferedWriter(new OutputStreamWriter(os));
    }
    //动态添加内容
    public Response01 print(String info){
        content.append(info);
        len+=info.getBytes().length;
        return this;
    }
    public Response01 println(String info){
        content.append(info).append(CRLF);
        len+=(info+CRLF).getBytes().length;
        return this;
    }
    //推送响应信息
    public void pushToBrowser(int code) throws IOException {
        if (headInfo==null){
            code=505;
        }
        createHeadInfo(code);
        bw.append(headInfo);
        bw.append(content);
        bw.flush();
    }
    //构建头信息
    private void createHeadInfo(int code){
        //1.响应行
        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(code).append(BLANK);
        switch (code){
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT Found").append(CRLF);
                break;
            case 505:
                headInfo.append("Server Error").append(CRLF);
                break;
        }
        //2.响应头
        headInfo.append("Date").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("gugu Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html:").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }
}
