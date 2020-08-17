package javase.testjavaassist;

import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/29--18:13
 */
public class Javassist02 {
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
    /**册数产生新的方法*/
    public static void test02() throws Exception {
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.get("javassistcase.Emp");
        CtMethod m=new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"我的\");return $1+$2;}");
        cc.addMethod(m);
        //通过反射调用新生成的方法
        Class clazz=cc.toClass();
        Object obj=clazz.newInstance();
        Method method=clazz.getDeclaredMethod("add",int.class,int.class);
        Object result=method.invoke(obj,200,300);
        System.out.println(result);
    }
    public static void test03() throws Exception{
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.get("javassistcase.Emp");
        CtMethod cm=cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        //通过反射调用新的方法
        Class clazz=cc.toClass();
        Object obj=clazz.newInstance();
        Method method=clazz.getDeclaredMethod("sayHello",int.class);
        method.invoke(obj,300);
    }
    public static void test04() throws Exception{
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.get("javassistcase.Emp");
        CtField f1=new CtField(CtClass.intType,"salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
//        cc.addField(f1,"1000");
        cc.addField(f1);
        //增加相应的get和set方法
        cc.addMethod(CtNewMethod.getter("getSalary",f1));
        cc.addMethod(CtNewMethod.setter("setSalary",f1));

    }
    public static void main(String[] args) throws Exception {
        test04();
    }
}
