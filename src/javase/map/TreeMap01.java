package javase.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMap01 {
    public static void main(String[] args) {
        Map<Integer,String> treemap01=new TreeMap<>();
        treemap01.put(20,"aa");
        treemap01.put(3,"bb");
        treemap01.put(12,"cc");
        //按照key递增方向排序
        for (Integer key:treemap01.keySet()){
            System.out.println(key+"---"+treemap01.get(key));
        }
    }
}
