package javabasic.IO;

import java.io.*;

public class Io01 {
    public static void main(String[] args) {
        File src=new File("src/javase/IO/test01.txt");
        InputStream is=null;
        try {
            is=new FileInputStream(src);
            int temp=0;
            while ((temp=is.read())!=-1){
                System.out.print((char) temp);
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