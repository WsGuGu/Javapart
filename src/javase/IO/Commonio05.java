package javase.IO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Commonio05 {
    public static void main(String[] args) throws IOException {
        //复制文件
        FileUtils.copyFile(new File("src/javase/IO/youni1.jpg"),new File("src/javase/IO/youni2.jpg"));
//        FileUtils.copyFileToDirectory(new File("src/javase/IO/youni1.jpg"),new File("src/javase/"));

    }
}
