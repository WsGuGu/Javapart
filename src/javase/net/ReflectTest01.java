package javase.net;

import java.lang.reflect.InvocationTargetException;

public class ReflectTest01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //三种方式
        //1.对象.getClass()
        Iphone iphone=new Iphone();
        Class clz=iphone.getClass();
        //类.class()
        clz=Iphone.class;
        //Class.forName("包名.类名");
        clz=Class.forName("javase.net.Iphone");
        //创建对象
        Iphone iphone2=(Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone2);
    }
}
class Iphone{
    public Iphone(){}

}