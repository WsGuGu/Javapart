package javase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/16--11:32
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuguField {
    String columnName();
    String type();
    int length();
}
