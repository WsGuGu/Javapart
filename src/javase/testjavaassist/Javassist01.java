package javase.testjavaassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/21--16:19
 * 测试javassist的API
 */
public class Javassist01 {
    public static void test01() throws Exception{
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.get("javassistcase.Emp");
        byte[] bytes=cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getName());
        System.out.println(cc.getSimpleName());//获取简要类名
        System.out.println(cc.getSuperclass());//获取父类
        System.out.println(cc.getInterfaces());//获得接口
    }
    public static void test02() throws Exception {
        /*测试产生新的方法*/
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.get("javassistcase.Emp");
//        CtMethod m=CtNewMethod.make("public int add(int a,int b){return a+b;}",cc);
        CtMethod m=new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{return $1+$2;}");
        cc.addMethod(m);
        //通过反射调用新生成的方法
        Class clazz=cc.toClass();
        Object obj=clazz.getDeclaredConstructor().newInstance();//通过调用emp无参构造器,创建对象
        Method method=clazz.getDeclaredMethod("add",int.class,int.class);
        Object result=method.invoke(obj,200,300);
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        test02();
    }
}
