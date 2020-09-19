package javabasic.threadsyn;
/**死锁*/
public class DeadLock {
    public static void main(String[] args) {
        Makeup girl1=new Makeup(1,"喵喵喵");
        Makeup girl0=new Makeup(0,"汪汪汪");
        girl0.start();
        girl1.start();
    }
}
class Lipstick{

}
class Mirror{

}
class Makeup extends Thread{
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();
    //选择
    int choice;
    //名字
    String girl;

    public Makeup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        //化妆
        makeup();
    }
    //相互持有对方的对象锁-->可能造成死锁
    private void makeup(){
        if (choice==0){
            synchronized (lipstick){//获得口红的锁
                System.out.println(this.girl+"获得口红");
                //一秒后想获得镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girl+"获得镜子");
                }
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girl+"获得镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(this.girl+"获得口红");
                }
            }

        }
    }
}