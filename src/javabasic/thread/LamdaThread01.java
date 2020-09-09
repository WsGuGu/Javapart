package javabasic.thread;

public class LamdaThread01 {
    //静态内部类
    static class Test implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Test()).start();
        //lambda方式
        new Thread(()->{ for (int i = 0; i < 20; i++)
        {
            System.out.println("一边跳舞"); }}).start();
    }
}