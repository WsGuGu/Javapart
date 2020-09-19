package javabasic.IO;

public class ContentEncode {
    public static void main(String[] args) {
        String msg="姓名";
        byte[] datas=msg.getBytes();
        System.out.println(datas.length);
    }
}
