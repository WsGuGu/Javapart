package javabasic.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/16--17:22
 * 通过反射API动态的操作:构造器、方法、属性
 */
public class Reflect03 {
    public static void main(String[] args) {
        //动态操作构造器
        String path="javase.reflection.User";
        try {
            Class clazz=Class.forName(path);
            //构造对象
            User u= (User) clazz.newInstance();//调用了User的无参构造方法
            System.out.println(u);
            Constructor<User> c=clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2=c.newInstance(1001,18,"一二三");
            System.out.println(u2.getUname()+u2.getAge()+u2.getId());
            //通过反射API调用普通方法
            User u3=(User) clazz.newInstance();
            Method method=clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"投影仪");
            //操作属性
            User u4=(User) clazz.newInstance();
            Field f=clazz.getDeclaredField("uname");
            f.setAccessible(true);//private可以直接访问
            f.set(u4,"马慧慧");
            System.out.println(u4.getUname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}