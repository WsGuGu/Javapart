package javabasic.IO;

import java.io.*;

public class Io06 {
    public static void main(String[] args) {
        byte[] src="talk is cheap show me the code".getBytes();
        InputStream is=null;
        try {
            is=new ByteArrayInputStream(src);
            int len=-1;
            byte[] car=new byte[5];
            while ((len=is.read(car))!=-1){
                String str=new String(car,0,len);
                System.out.print(str);
            }
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