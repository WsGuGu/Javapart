package javabasic.cooperation;
/**生产消费者模式,实现方式----管程法*/
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i=0;i<100;i++){
            System.out.println("生产--->"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        //消费
        for (int i=0;i<100;i++){
            System.out.println("消费--->"+container.pop().id+"个馒头");

        }
    }
}
//缓冲区
class SynContainer{
    Steamedbun[] buns=new Steamedbun[10];
    int count=0;//计数器
    //存储生产
    public synchronized void push(Steamedbun bun){
        //何时生产--->容器存在空间
        if (count==buns.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count]=bun;
        count++;
        this.notifyAll();
    }
    //获取
    public synchronized Steamedbun pop(){
        if (count==0)
        {
            try {
                this.wait();//线程阻塞，生产者通知消费者
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun bun=buns[count];
        this.notifyAll();
        return bun;
    }
}
//馒头
class Steamedbun{
    int id;
    public Steamedbun(int id) {
        this.id = id;
    }
}