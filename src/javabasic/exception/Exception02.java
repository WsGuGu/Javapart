package javabasic.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception02 {
    public static void main(String[] args) {
        FileReader reader=null;
        try {
          reader=new FileReader("D:\\programming\\programming_workingspace\\exercise\\java\\src\\javase\\exception\\a.txt");
            char c=(char)reader.read();
            System.out.print(c);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}