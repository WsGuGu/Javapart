package javabasic.threadsyn;

import java.util.ArrayList;
import java.util.List;

/**操纵容器*/
public class SynTest02 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();
        for (int i=0;i<10000;i++){
            //同步块
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(list.size());
    }
}
