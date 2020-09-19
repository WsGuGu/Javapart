package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/13--16:14
 */
public class Demo01 {
    public static void main(String[] args) {
        //表达式对象
        Pattern p=Pattern.compile("\\w+");
        //创建matcher对象
        Matcher m=p.matcher("asdasdsd&&213123232");
//        boolean yesorno=m.matches();//尝试将整个字符序列与该模式匹配
//        boolean nooryes=m.find();//查找匹配的下一个子序列
//        System.out.println(yesorno);
        while (m.find()){
            System.out.println(m.group());//group和group(0)表示匹配的字符串
        }
    }
}
