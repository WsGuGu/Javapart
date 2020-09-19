package regular;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/14--16:06
 */
public class WebSpiderTest {
    public static String getURLContent(String urlString,String charset){
        StringBuilder stringBuilder=new StringBuilder();
        try {
            URL url=new URL(urlString);
            BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream(), charset));
            String temp="";
            while ((temp=reader.readLine())!=null){
               stringBuilder.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String destStr=getURLContent("https://tieba.baidu.com/f?kw=%E5%85%AC%E4%B8%BB%E8%BF%9E%E7%BB%93","utf8");
        Pattern p=Pattern.compile("<a rel=\"noreferrer\" href=.{15} title=\"(.*?)\"");
        Matcher m=p.matcher(destStr);
        while (m.find()){
            System.out.println(m.group(1));
        }
    }
}
