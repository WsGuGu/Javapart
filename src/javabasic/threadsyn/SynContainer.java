package javabasic.threadsyn;

//vector也可以
import java.util.concurrent.CopyOnWriteArrayList;

/**线程安全操纵容器*/
public class SynContainer {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
        for (int i=0;i<10000;i++){
            //同步块
            new Thread(()->{
                    list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(list.size());
    }
}
