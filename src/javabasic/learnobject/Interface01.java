package javabasic.learnobject;

public interface Interface01 {
    int MAX=100;//public static final
    void add();//public abstract
}
class test01 implements Interface01{

    @Override
    public void add() {
        System.out.println("123");
    }
}