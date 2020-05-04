package javase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collections01 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("wh"+i);
        }
        Collections.shuffle(list);
        System.out.println(list);
    }
}
