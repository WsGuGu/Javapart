package javase.IO;

import java.io.File;

public class Dir02 {
    public static void main(String[] args) {
        File dir =new File("D:/programming/programming_workingspace/exercise/java/src/javase/IO");
        String[] str=dir.list();
        for (String a:str){
            System.out.println(a);
        }
        //所有盘符
        File[] roots=dir.listRoots();
        for (File r:roots){
            System.out.println(r.getAbsolutePath());
        }

    }
}