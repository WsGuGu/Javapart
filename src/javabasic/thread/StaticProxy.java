package javabasic.thread;

public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }
}
interface Marry{
    void happyMarry();
}
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("you and 嫦娥终于奔月了");
    }
}
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target=target;
    }
    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }
    private void ready(){
        System.out.println("布置。。。");
    }
    private void after(){
        System.out.println("闹玉兔");
    }
}