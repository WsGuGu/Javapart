package javase.IO;

import java.io.File;

public class Dir01 {
    public static void main(String[] args) {
        File dir =new File("src/javase/IO/dir/test");
        boolean flag=dir.mkdirs();
        System.out.println(flag);
    }
}
