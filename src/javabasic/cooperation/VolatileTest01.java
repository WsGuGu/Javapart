package javabasic.cooperation;
/**volatile用来保证数据的可见性*/
public class VolatileTest01 {
    private volatile static int num=0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num==0){

            }
        }).start();
        Thread.sleep(1000);
        num=1;
    }
}
