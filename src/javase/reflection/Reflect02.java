package javase.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/16--16:50
 * 应用反射的API
 */
public class Reflect02 {
    public static void main(String[] args) {
        String path="javase.reflection.User";
        try {
            Class clazz=Class.forName(path);
            //获取类的名字
            System.out.println(clazz.getName());//获得包名+类名
            System.out.println(clazz.getSimpleName());//获得类名
            //获取属性
//          Field[] fields=clazz.getFields();//只能获得public修饰的field
            Field[] fields=clazz.getDeclaredFields();//获得所有的属性(field)
            Field f=clazz.getDeclaredField("uname");
            System.out.println(fields.length);
            for (Field field:fields){
                System.out.println(field);
            }
            //获取方法
//          Method[] methods=clazz.getMethods();//获得public修饰的method
            Method[] methods=clazz.getDeclaredMethods();
            Method m1=clazz.getDeclaredMethod("getUname",null);
            Method m2=clazz.getDeclaredMethod("setUname", String.class);
            for (Method m:methods){
                System.out.println("方法"+m);
            }
            //获取构造信息
            Constructor[] constructors=clazz.getDeclaredConstructors();
            for (Constructor c:constructors){
                System.out.println("构造器"+c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
