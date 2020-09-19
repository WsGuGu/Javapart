package javabasic.classload;

import java.io.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/7--17:45
 * 自定义文件系统类加载器
 */
public class FileSystemClassLoader extends ClassLoader{
    private String rootDir;
    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }
    private byte[] getClassData(String classname){
        String path=rootDir+"/"+classname.replace('.','/')+".class";
        InputStream is=null;
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        try {
             is=new FileInputStream(path);
             byte[] buffer=new byte[1024];
             int temp=0;
             while ((temp=is.read(buffer))!=-1){
                 baos.write(buffer,0,temp);
             }
             return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c=findLoadedClass(name);
        //应该查询是否加载过此类
        if (c!=null){
            return c;
        }
        else {
            ClassLoader parent=this.getParent();
            try {
                parent.loadClass(name);//委派给父类加载
            } catch (Exception e) {
                //
            }
            if(c!=null){
                return c;
            }
            else {
                byte[] classData=getClassData(name);
                if (classData==null){
                    throw new ClassNotFoundException();
                }
                else {
                    c=defineClass(name,classData,0,classData.length);
                }
            }
            return c;
        }
    }
}
