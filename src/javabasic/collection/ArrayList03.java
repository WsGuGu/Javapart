package javabasic.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayList03 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(1,"1");
        System.out.println(list);
        System.out.println(list.get(3));
        System.out.println("位置："+list.indexOf("b"));
        System.out.println("位置："+list.lastIndexOf("b"));
    }
}