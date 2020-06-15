package javase.thread;

public class Racer implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int steps=1;steps<=100;steps++){
            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            //比赛是否可以结束
            boolean flag=gameOver(steps);
            if (flag){
                break;
            }
        }
    }
    private boolean gameOver(int steps){
        if (winner!=null){
            return true;
        }else {
            if (steps==100){
                winner=Thread.currentThread().getName();
                System.out.println("winner==>"+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer=new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }
}
