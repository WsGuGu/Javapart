package javabasic.IO;

import java.io.*;

public class DataTest01 {
    public static void main(String[] args) throws IOException {
        //写出
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(baos);
        dos.writeUTF("太对了");
        dos.writeInt(213);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas=baos.toByteArray();
        //读取
        DataInputStream dis=new DataInputStream(new ByteArrayInputStream(datas));
        //顺序与写出一致
        String msg=dis.readUTF();
        int age=dis.readInt();
        boolean flag=dis.readBoolean();
        char ch=dis.readChar();
        System.out.println(flag);
        System.out.println(age);
    }
}
