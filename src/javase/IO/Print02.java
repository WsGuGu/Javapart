package javase.IO;

import java.io.*;

public class Print02 {
    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter pw=new PrintWriter(new BufferedOutputStream(new FileOutputStream("src/javase/IO/test04.txt")),true);
        pw.println("打印流");
        pw.println(true);
        pw.close();
    }
}
