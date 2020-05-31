package javase.IO;

import java.io.*;

public class Buffered03 {
    public static void main(String[] args) {
        File dest =new File("src/javase/IO/test03.txt");
        BufferedWriter writer=null;
        try {
            writer=new BufferedWriter(new FileWriter(dest));
//            String msg="凯露、佩可";
//            char[] datas=msg.toCharArray();
//            writer.write(datas,0,datas.length);
            writer.append("UE");
            writer.newLine();
            writer.append("可可萝");
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
