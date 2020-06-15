package javase.thread;

public class StartRun01 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        StartRun01 st=new StartRun01();
        Thread t=new Thread(st);
        t.start();
        for (int i=0;i<20;i++){
            System.out.println("一边跳舞");
        }
    }
}
