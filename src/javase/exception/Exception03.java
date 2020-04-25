package javase.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception03 {
    public static void main(String[] args) throws IOException {
        FileReader reader=null;
        reader=new FileReader("D:\\programming\\programming_workingspace\\exercise\\java\\src\\javase\\exception\\a.txt");
        char c=(char)reader.read();
        System.out.print(c);
        reader.close();
    }
}
