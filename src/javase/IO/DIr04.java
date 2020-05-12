package javase.IO;

import java.io.File;

public class DIr04 {
    public static void main(String[] args) {
        File dir =new File("D:/programming/programming_workingspace/exercise/java/src/javase/IO");
        count(dir);
        System.out.println(len);
    }
    private static long len=0;
    public static void count(File src){
        if (null!=src&&src.exists())
        {
            if (src.isFile()){
                len+=src.length();
            }else {
                for (File s:src.listFiles()){
                   count(s);
                }
            }
        }
    }
}