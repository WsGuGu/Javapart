package javase.IO;

import java.io.*;

public class Io05 {
    public static void main(String[] args) {
        File dest =new File("src/javase/IO/test03.txt");
        Writer writer=null;
        try {
            writer=new FileWriter(dest);
//            String msg="凯露、佩可";
//            char[] datas=msg.toCharArray();
//            writer.write(datas,0,datas.length);
            writer.append("UE").append("可可萝");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}