package javabasic.thread;

public class Web12306 implements Runnable{
    //票数
    private int ticketNums=99;

    @Override
    public void run() {
        while (true){
            if (ticketNums<0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web=new Web12306();
        //多个代理
        new Thread(web,"one").start();
        new Thread(web,"two").start();
        new Thread(web,"three").start();
    }
}
