package javase.serverbasic;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/13--10:33
 *封装请求协议:获取method uri及请求参数
 */
public class Request {
    //协议信息
    private String requestInfo;
    //请求方式
    private String method;
    //请求url
    private String url;
    //请求参数
    private String queryStr;
    private final String CRLF="\r\n";
    public Request(Socket client) throws IOException {
    this(client.getInputStream());
}
    public Request(InputStream is){
        byte[] datas=new byte[1024*1024];
        int len= 0;
        try {
            len = is.read(datas);
            this.requestInfo=new String(datas,0,len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }
    private void parseRequestInfo(){
        System.out.println("------分解-------");
        System.out.println("----1.获取请求方式----");
        this.method=this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase();
        this.method=this.method.trim();
        System.out.println("----2.获取请求的url----");
        int startldx=this.requestInfo.indexOf("/");
        int endldx=this.requestInfo.indexOf("HTTP/");
        this.url=this.requestInfo.substring(startldx,endldx);
        int queryldx=this.url.indexOf("?");
        if (queryldx>=0){
            String[] urlArray=this.url.split("\\?");
            this.url=urlArray[0];
            this.queryStr=urlArray[1];
        }
        System.out.println(this.url);
        if (method.equals("post")){
            String qStr=this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if (queryStr==null){
                queryStr=qStr;
            } else {
                queryStr+="&"+qStr;
            }
        }
        queryStr=queryStr==null?"":queryStr;
        System.out.println(method+"---->"+url+"--->"+queryStr);
    }
}