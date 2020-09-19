package javabasic.file;

import java.io.File;
import java.io.IOException;

public class File01 {
    public static void main(String[] args) throws IOException {
        File f=new File("D:\\programming\\programming_workingspace\\exercise\\java\\src\\javase\\file\\gg.txt");
        System.out.println(f);
        //f.renameTo(new File("D:/programming/programming_workingspace/exercise/java/src/javase/file/bb.txt"));
        System.out.println(System.getProperty("user.dir"));
        File f2=new File("D:\\programming\\programming_workingspace\\exercise\\java\\src\\javase\\file\\gg.txt");
        //f2.createNewFile();
        System.out.println(f2.exists());
        System.out.println(f2.getAbsolutePath());
        //boolean a2=f.mkdirs();
    }
}