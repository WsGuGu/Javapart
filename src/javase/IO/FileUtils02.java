package javase.IO;

import java.io.*;

public class FileUtils02 {
    public static void main(String[] args) {
        //文件到文件
        try {
            InputStream is=new FileInputStream("src/javase/IO/test01.txt");
            OutputStream os=new FileOutputStream("src/javase/IO/test01_copy.txt");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件到字节数组
        byte[] datas=null;
        try {
            InputStream is=new FileInputStream("src/javase/IO/test01.txt");
            ByteArrayOutputStream os=new ByteArrayOutputStream();
            copy(is,os);
            datas=os.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //字节数组到文件
        try {
            InputStream is=new ByteArrayInputStream(datas);
            OutputStream os=new FileOutputStream("src/javase/IO/test01_copylst.txt");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copy(InputStream is,OutputStream os) {
        try(is;os) {
            byte[] car = new byte[1024];
            int len = -1;
            while ((len = is.read(car)) != -1) {
                os.write(car, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}