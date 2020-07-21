package javase.testjavaassist;

import javassist.*;
import java.util.Arrays;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/21--16:19
 * 测试javassist的API
 */
public class Javassist02 {
    public static void test01() throws Exception{
        ClassPool pool=ClassPool.getDefault();
        ClassPath path=new ClassClassPath(Emp.class);//解决找不到class文件的问题
        pool.appendClassPath(path);//解决找不到class文件的问题
        CtClass cc=pool.get("javase.testjavaassist.Emp");
        byte[] bytes=cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getName());
        System.out.println(cc.getSimpleName());//获取简要类名
        System.out.println(cc.getSuperclass());//获取父类
        System.out.println(cc.getInterfaces());//获得接口
    }
    public static void test02(){
        /*测试产生新的方法*/

    }

    public static void main(String[] args) throws Exception {
        test01();
    }
}
