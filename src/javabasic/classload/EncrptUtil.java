package javabasic.classload;

import java.io.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/8--16:47
 */
public class EncrptUtil {
    public static void main(String[] args) {
        encrpt("xxxxx.class","xxxxx.class");
    }
    public static void encrpt(String src,String dest){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(src);
            fos=new FileOutputStream(dest);
            int temp=-1;
            while ((temp=fis.read())!=-1){
                fos.write(temp^0xff);//取反操作
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis!=null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fos!=null){
                    fos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
