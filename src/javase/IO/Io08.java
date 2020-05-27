package javase.IO;

import java.io.*;

public class Io08 {
    public static void main(String[] args) {
        //图片转成字节数组
        byte[] datas=fileToByteArray("src/javase/IO/youni.jpg");
        System.out.println(datas.length);
        byteArrayToFile(datas,"src/javase/IO/youni1.jpg");
    }

    /**
     * 图片读取到字节数组
     */
    public static byte[] fileToByteArray(String filelPath) {
        File src = new File(filelPath);
        InputStream is = null;
        ByteArrayOutputStream baos=null;
        byte[] dest=null;
        try {
            is = new FileInputStream(src);
            baos=new ByteArrayOutputStream();
            int len = -1;
            byte[] flush = new byte[1024*10];
            while ((len = is.read(flush)) != -1) {
                baos.write(flush,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 字节数组到图片
     */
    public static void byteArrayToFile(byte[] src, String filePath) {
        File dest=new File(filePath);
        InputStream is=null;
        OutputStream os=null;
        try {
            is =new ByteArrayInputStream(src);
            os =new FileOutputStream(dest);
            byte[] flush=new byte[5];
            int len=-1;
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}