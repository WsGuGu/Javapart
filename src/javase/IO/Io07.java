package javase.IO;

import java.io.*;

public class Io07 {
    public static void main(String[] args) {
        byte[] dest=null;
        ByteArrayOutputStream os=null;
        try {
                os=new ByteArrayOutputStream();
                String msg="show me the code";
                byte[] datas=msg.getBytes();
                os.write(datas,0,datas.length);
                os.flush();
                dest=os.toByteArray();
                System.out.println(new String(dest,0,dest.length));
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