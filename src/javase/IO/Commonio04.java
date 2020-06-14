package javase.IO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Commonio04 {
    public static void main(String[] args) throws IOException {
        //写出文件
        FileUtils.write(new File("src/javase/IO/happy.txt"),"o(*￣︶￣*)o开心","UTF-8",true);

    }
}
