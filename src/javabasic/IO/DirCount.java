package javabasic.IO;

import java.io.File;

public class DirCount {
    private long len;
    private String path;
    private File src;
    public DirCount(String path){
        this.path=path;
        this.src=new File(path);
        count(this.src);
    }
    private void count(File src){
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
    public long getLen() {
        return len;
    }
    public static void main(String[] args) {
        DirCount dir =new DirCount("D:/programming/programming_workingspace/exercise/java/src/javase/IO");
        System.out.println(dir.getLen());
    }
}
