package javabasic.IO;
import java.io.*;
import java.net.URL;

public class Convert02 {
    public static void main(String[] args) {
        //操作网络流 下载百度的源代码
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"))){
            //操作
            String msg;
            while ((msg=reader.readLine())!=null){
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("操作异常");
        }
    }
    public static void test01(){
        //操作网络流 下载百度的源代码
        try (InputStreamReader is=new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8")){
            //操作
            int temp;
            while ((temp=is.read())!=-1){
                System.out.print((char) temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("操作异常");
        }
    }
}