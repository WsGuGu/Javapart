package javase.thread;

public class BlockedJoin01 {
    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟的故事");
        new Thread(new Father()).start();
    }
}
class Father extends Thread{
    public void run(){
        System.out.println("想抽烟，发现没有了");
        System.out.println("让孩子去买烟");
        Thread t=new Thread(new Son());
        t.start();
        try {
            t.join();
            System.out.println("接过烟");
        } catch (InterruptedException e) {
            System.out.println("孩子走丢了");
        }
    }
}
class Son extends Thread{
    public void run(){
        System.out.println("接过钱，出去了");
        System.out.println("等待10秒");
        for (int i=0;i<10;i++){
            System.out.println(i+"秒过去了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("赶紧买烟");
        System.out.println("手拿一包烟回家了");
    }
}