package javase.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSet01 {
    public static void main(String[] args) {
        Set<Integer> set=new TreeSet<>();
        set.add(300);
        set.add(200);
        set.add(600);
        for (Integer e:set){
            System.out.println(e);
        }
    }
}