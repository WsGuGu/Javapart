package javabasic.IO;

import java.io.*;

public class Io02 {
    public static void main(String[] args) {
        File src=new File("src/javase/IO/test01.txt");
        InputStream is=null;
        try {
            is=new FileInputStream(src);
            int len=-1;
            byte[] car=new byte[3];
            while ((len=is.read(car))!=-1){
                String str=new String(car,0,len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}