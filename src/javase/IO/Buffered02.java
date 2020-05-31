package javase.IO;

import java.io.*;

public class Buffered02 {
    public static void main(String[] args) {
        File src =new File("src/javase/IO/test03.txt");
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new FileReader(src));
            char[] flush=new char[1024];
            String line=null;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
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