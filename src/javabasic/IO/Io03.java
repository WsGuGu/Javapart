package javabasic.IO;

import java.io.*;

public class Io03 {
    public static void main(String[] args) {
        File dest =new File("src/javase/IO/test02.txt");
        OutputStream os=null;
        try {
                os=new FileOutputStream(dest,true);
                String msg="io is so easy\n";
                byte[] datas=msg.getBytes();
                os.write(datas,0,datas.length);
                os.flush();
        }catch (FileNotFoundException e){
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}