package javabasic.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayList02 {
    public static void main(String[] args) {
        test02();
    }
    public static void test02(){
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> list01=new ArrayList<>();
        list01.add("a");
        list01.add("d");
        list01.add("e");
        System.out.println("list:"+list);
        list.removeAll(list01);//删除一样的,containsAll为包含
        System.out.println("list:"+list);
    }
}