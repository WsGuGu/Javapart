package javase.learnobject;

public abstract class Abstract01 {
    abstract public void shout();
    public void run(){
        System.out.println("11111");
    }
}
class Dog extends Abstract01{
    @Override
    public void shout() {
        System.out.println("呜呜呜呜呜");
    }
}
