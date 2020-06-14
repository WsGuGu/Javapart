package javase.IO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Commonio03 {
    public static void main(String[] args) throws IOException {
        //读取文件
        String msg= FileUtils.readFileToString(new File("src/javase/IO/test01.txt"),"UTF-8");
        System.out.println(msg);
        //逐行读取
        List<String> msgs=FileUtils.readLines(new File("src/javase/IO/test01.txt"),"UTF-8");
        for (String str:msgs){
            System.out.println(str);
        }
    }
}
