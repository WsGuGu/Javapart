package javase.thread;
import java.lang.Thread.State;
/**观察线程的状态*/
public class AllStatus {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            System.out.println(".....");
        });
        //观察状态
        State state=t.getState();
        System.out.println(state);//NEW
        t.start();
        state=t.getState();
        System.out.println(state);//RUNNABLE
    }
}
