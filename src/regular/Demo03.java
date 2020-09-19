package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/13--16:49
 */
public class Demo03 {
    public static void main(String[] args) {
        //表达式对象
        Pattern p=Pattern.compile("\\d");
        //创建matcher对象
        Matcher m=p.matcher("asd234&&sfg995&&sadwfe999999");
        //替换
        String newStr=m.replaceAll("#");
        System.out.println(newStr);
    }
}
