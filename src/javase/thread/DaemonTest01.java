package javase.thread;
/**守护线程：是为用户线程服务的
 * */
public class DaemonTest01 {
    public static void main(String[] args) {
        God god=new God();
        Your your=new Your();
        Thread t=new Thread(god);
        t.setDaemon(true);
        t.start();
        new Thread(your).start();
    }
}
class Your implements Runnable{
    @Override
    public void run() {
        for (int i=1;i<=365*100;i++){
            System.out.println("happy life...");
        }
        System.out.println("oooooo.....");
    }
}
class God implements Runnable{
    @Override
    public void run() {
        for (;true;){
            System.out.println("bless you...");
        }
    }
}