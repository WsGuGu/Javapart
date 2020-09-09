package javabasic.classload;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/6--17:02
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(System.getProperty("java.class.path"));
    }
}
