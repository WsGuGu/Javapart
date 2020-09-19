package javabasic.IO;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class Commonio01 {
    public static void main(String[] args) {
        //文件大小
        long len= FileUtils.sizeOf(new File("src/javase/IO/test01.txt"));
        System.out.println(len);
        //目录大小
        len=FileUtils.sizeOf(new File("src/javase/IO"));
        System.out.println(len);
    }
}
