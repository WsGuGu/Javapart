package javase.map;

import java.util.HashMap;
import java.util.Map;

public class Map01 {
    public static void main(String[] args) {
        Map<Integer,String> m1=new HashMap<>();
        m1.put(1,"one");
        m1.put(2,"two");
        System.out.println(m1.get(1));
        System.out.println(m1.containsKey(2));
    }
}