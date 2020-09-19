package javabasic.thread;

public class Thread01 extends Thread{
    @Override
    public void run() {
       for (int i=0;i<20;i++){
           System.out.println("一遍又一遍");;
       }
    }

    public static void main(String[] args) {
        //创建子类对象
        Thread01 a=new Thread01();
        a.start();
        for (int i=0;i<20;i++){
            System.out.println("二遍又二遍");;
        }
    }
}
