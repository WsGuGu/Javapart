package regular;

import java.util.Arrays;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/13--16:53
 */
public class Demo04 {
    public static void main(String[] args) {
        String str="a2133b2133c";
        String[] arrs=str.split("\\d+");
        System.out.println(Arrays.toString(arrs));
    }
}
