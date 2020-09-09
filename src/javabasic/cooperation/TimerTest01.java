package javabasic.cooperation;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new MyTask(),1000);//执行一次
//        timer.schedule(new MyTask(),1000,1000);//执行多次
//        timer.schedule(new MyTask(),date类型);//指定时间
    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("放空大脑休息一会儿");
        }
        System.out.println("end");
    }
}