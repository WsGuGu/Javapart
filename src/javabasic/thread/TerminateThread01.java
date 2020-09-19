package javabasic.thread;

public class TerminateThread01 implements Runnable{
    //加入标识，标记线程体是否可以运行
    private boolean flag=true;
    private String name;
    public TerminateThread01(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println(name+"---->"+i++);
        }
    }
    public void terminate(){
        this.flag=false;
    }
    public static void main(String[] args) {
        TerminateThread01 tt=new TerminateThread01("huasheng");
        new Thread(tt).start();
        for (int i=0;i<=99;i++){
            if (i==88){
                tt.terminate();
                System.out.println("tt game over");
            }
            System.out.println("main-->"+i);
        }
    }
}
