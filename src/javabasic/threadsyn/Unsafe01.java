package javabasic.threadsyn;

public class Unsafe01 {
    public static void main(String[] args) {
        //一份资源
        Web123067 web123067=new Web123067();
        //多个代理
        new Thread(web123067,"马1").start();
        new Thread(web123067,"马2").start();
        new Thread(web123067,"马3").start();
    }
}
class Web123067 implements Runnable {
    //票数
    private int ticketNums =10;
    private boolean flag=true;
    @Override
    public void run() {
        while (flag) {
            test();
        }
    }
    public void test(){
        if (ticketNums < 0) {
            flag=false;
            return;
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