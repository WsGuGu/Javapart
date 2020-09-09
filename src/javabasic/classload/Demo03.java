package javabasic.classload;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/8--16:07
 * 测试filesystemclassloader
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException {
//        FileSystemClassLoader fsc=new FileSystemClassLoader("xxxxx");
//        Class<?> c=fsc.loadClass("xxxx");
        FileSystemClassLoader loader=new FileSystemClassLoader("c:/");
        Class<?> c=loader.loadClass("java.lang.String");
        System.out.println(c);
    }
}
