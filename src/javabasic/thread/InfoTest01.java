package javabasic.thread;

public class InfoTest01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        //设置名称：真实角色+代理角色
        Myinfo info=new Myinfo("zdj");
        Thread t=new Thread(info);
        t.setName("321");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}
class Myinfo implements Runnable{
    private String name;

    public Myinfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+name);
    }
}