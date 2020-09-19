package javabasic.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/16--11:42
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 */
public class Anno02 {
    public static void main(String[] args) {
        try {
            Class clazz=Class.forName("javabasic.annotation.GuguStudent");
            //获得类的所有有效注解
            Annotation[] annotations=clazz.getAnnotations();
            for (Annotation a:annotations){
                System.out.println(a);
            }
            //获得类的指定的注解
            GuguTable gt=(GuguTable)clazz.getAnnotation(GuguTable.class);
            System.out.println(gt.value());
            //获得类的属性的注解
            Field f=clazz.getDeclaredField("studentName");
            GuguField gf=f.getAnnotation(GuguField.class);
            System.out.println(gf.columnName()+gf.type()+gf.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
