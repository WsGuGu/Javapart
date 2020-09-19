package javabasic.reflection;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/16--16:07
 * 测试java.lang.Class对象的获取方式
 */
public class Reflect01 {
    public static void main(String[] args) {
        String path="javase.reflection.User";
        try {
            Class clazz=Class.forName(path);
            System.out.println(clazz);
            Class clazz1=String.class;//同一个对象
            Class clazz2=path.getClass();//同一个对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
