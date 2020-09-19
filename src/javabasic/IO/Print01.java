package javabasic.IO;

import java.io.*;

public class Print01 {
    public static void main(String[] args) throws FileNotFoundException {
        //打印流
        PrintStream ps=System.out;
        ps.println("打印流");
        ps.println(true);
        ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("src/javase/IO/test04.txt")),true);
        ps.println("打印流");
        ps.println(true);
        //重定向输出端
        System.setOut(ps);
        System.out.println("change");
        ps.close();
        //重定向控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("回来的");
    }
}
