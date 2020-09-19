package javabasic.thread;
/**线程的优先级
 * 1.NORM_PRIORITY=5
 * 2.MIN_PRIORITY=1
 * 3.MAX_PRIORITY=10
 * 优先级高只代表调度的概率高
* */
public class PriorityTest01 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());//5
        MyPriority mp=new MyPriority();
        Thread t1=new Thread(mp);
        Thread t2=new Thread(mp);
        Thread t3=new Thread(mp);
        Thread t4=new Thread(mp);
        Thread t5=new Thread(mp);
        Thread t6=new Thread(mp);
        //在启动前设置优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(7);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}