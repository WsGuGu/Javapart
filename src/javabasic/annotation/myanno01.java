package javabasic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/15--16:25
 * 自定义注解
 */
@Target(value = ElementType.METHOD)//只能用在方法前面
@Retention(RetentionPolicy.RUNTIME)//运行时有效
public @interface myanno01 {
    String studentName() default "";
    String[] schools() default {"123","321"};//value属性可以省略
}