package javase.learnobject;

public class Student {
    int id;
    String name;
    int age;
    Computer comp;
    void study(){
        System.out.println("学习中");
    }
    void play(){
        System.out.println("在玩中"+comp.brand);
    }

    public static void main(String[] args) {
        Student a=new Student();
        a.id=1001;
        a.name="123";
        a.age=23;
        Computer b=new Computer();
        b.brand="HP";
        a.comp=b;
        a.study();
        a.play();
    }
}
class Computer{
    String brand;
}