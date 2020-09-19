package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/13--16:41
 */
public class Demo02 {
    public static void main(String[] args) {
        //表达式对象
        Pattern p=Pattern.compile("([a-z]+)(\\d+)");
        //创建matcher对象
        Matcher m=p.matcher("asd234&&sfg995&&sadwfe999999");
        while (m.find()){
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}
