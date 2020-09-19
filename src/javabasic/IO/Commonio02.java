package javabasic.IO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;


public class Commonio02 {
    public static void main(String[] args) {
        Collection<File> files=FileUtils.listFiles(new File("src/javase/IO"), EmptyFileFilter.NOT_EMPTY,null);
        for (File file:files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
