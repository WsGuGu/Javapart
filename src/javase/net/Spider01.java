package javase.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Spider01 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url=new URL("https://www.jd.com");
        //下载资源
        InputStream is=url.openStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg=null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }
}
