package javabasic.IO;
import java.io.*;

public class Convert01 {
    public static void main(String[] args) {
        //system.in和system.out
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out))){
        //循环获取键盘的输入，输出此内容
            String msg="";
            while (!msg.equals("exit")){
                msg=reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("操作异常");
        }
    }
}