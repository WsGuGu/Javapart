package javase.collection;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayList01 {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<>();
        System.out.println(c.size());
        c.add("123");
        c.add("asd");
        System.out.println(c);
        c.clear();
    }
}
