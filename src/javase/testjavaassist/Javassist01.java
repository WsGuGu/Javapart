package javase.testjavaassist;

import javassist.ClassPool;
import javassist.CtClass;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/20--17:40
 * 测试使用javassist创建一个新的类
 */
public class Javassist01 {
    public static void main(String[] args) {
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.makeClass("javase.testjavaassist.Emp");
    }
}
