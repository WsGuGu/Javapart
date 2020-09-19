package javabasic.IO;

import java.io.*;

public class FileCopy01 {
    public static void main(String[] args) {
        File src =new File("src/javase/IO/test02.txt");
        File dest =new File("src/javase/IO/copy01.txt");
        InputStream is=null;
        OutputStream os=null;
        try {
            is=new FileInputStream(src);
            os=new FileOutputStream(dest);
            byte[] car=new byte[1024];
            int len=-1;
            while ((len=is.read(car))!=-1){
               os.write(car,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}