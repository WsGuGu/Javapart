package javase.thread;

public class BlockedSleep01 {
    public static void main(String[] args) {
        //一份资源
        Web123067 web=new Web123067();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"one").start();
        new Thread(web,"two").start();
        new Thread(web,"three").start();
    }
}
class Web123067 implements Runnable {
    //票数
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            //模拟网络延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNums--);
        }
    }
}