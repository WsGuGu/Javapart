package javase.collection;

import java.util.*;

public class Iterator01 {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorMap();
    }
    public static void testIteratorList(){
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
       for (Iterator<String> iter=list.iterator();iter.hasNext();){
           String temp=iter.next();
           System.out.println(temp);
       }
    }
    public static void testIteratorMap(){
        Map<Integer,String> map=new HashMap<>();
        map.put(100,"aa");
        map.put(200,"bb");
        map.put(300,"cc");
        Set<Map.Entry<Integer,String>> ss=map.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iter =ss.iterator(); iter.hasNext();){
            Map.Entry<Integer,String> temp=iter.next();
            System.out.println(temp.getKey());
        }
    }
}