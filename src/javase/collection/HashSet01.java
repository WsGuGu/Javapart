package javase.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSet01 {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("aa");
        set.add("bb");
        System.out.println(set);
        set.remove("bb");
        System.out.println(set);
    }
}
