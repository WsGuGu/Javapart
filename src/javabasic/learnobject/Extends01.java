package javabasic.learnobject;

public class Extends01 {
    public static void main(String[] args) {
    Student1 st1=new Student1();
    st1.name="123";
    st1.height=123;
    st1.rest();
        System.out.println(st1 instanceof Student1);
        System.out.println(st1 instanceof Person);
    }
}
class Person{
    String name;
    int height;
    public void rest(){
        System.out.println("休息一哈");
    }
}
class Student1 extends Person{
    String major;
    public void study(){
        System.out.println("学一哈");
    }
}