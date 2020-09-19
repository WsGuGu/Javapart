package javabasic.classload;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/8--16:42
 * 简单的加密解密操作
 */
public class Demo04 {
    public static void main(String[] args) {
        int a=3;//00000011
        System.out.println(Integer.toBinaryString(a^0xff));
    }
}
