package javase.IO;

import java.io.*;

public class Io04 {
    public static void main(String[] args) {
        File src =new File("src/javase/IO/test03.txt");
        Reader reader=null;
        try {
            reader=new FileReader(src);
            char[] flush=new char[1024];
            int len=-1;
            while ((len=reader.read(flush))!=-1){
                String str=new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}