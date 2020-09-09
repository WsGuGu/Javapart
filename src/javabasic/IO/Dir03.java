package javabasic.IO;

import java.io.File;

public class Dir03 {
    public static void main(String[] args) {
        File dir =new File("D:/programming/programming_workingspace/exercise/java/src/javase/IO");
        printName(dir,0);
    }
    public static void  printName(File src,int deep){
        for (int i=0;i<deep;i++){
            System.out.print("-");
        }
        System.out.println(src.getName());
        if (null==src ||!src.exists()){
            return;
        }else if(src.isDirectory()) {
            for (File s:src.listFiles()){
                printName(s,deep+1);
            }
        }

    }
}
