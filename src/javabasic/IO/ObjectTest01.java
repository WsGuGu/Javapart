package javabasic.IO;

import java.io.*;
import java.util.Date;

public class ObjectTest01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream dos=new ObjectOutputStream(baos);
        dos.writeUTF("太对了");
        dos.writeInt(213);
        dos.writeBoolean(false);
        dos.writeChar('a');
        //对象
        dos.writeObject("谁解其中味");
        dos.writeObject(new Date());
        dos.flush();
        byte[] datas=baos.toByteArray();
        //读取
        ObjectInputStream dis=new ObjectInputStream(new ByteArrayInputStream(datas));
        //顺序与写出一致
        String msg=dis.readUTF();
        int age=dis.readInt();
        boolean flag=dis.readBoolean();
        char ch=dis.readChar();
        Object str = dis.readObject();
        Object date=dis.readObject();
        if (str instanceof String){
            String strObj=(String)str;
            System.out.println(strObj);
        }
        if (date instanceof Date){
            Date dateObj=(Date)date;
            System.out.println(dateObj);
        }
        System.out.println(flag);
        System.out.println(age);
    }
}
