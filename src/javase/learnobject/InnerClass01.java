package javase.learnobject;

public class InnerClass01 {
    public static void main(String[] args) {
        Outer01.Inner01 a=new Outer01().new Inner01();
        a.show();
    }
}
class Outer01{
    private int age=20;
    class Inner01{
        int a=32;
        public void show(){
            System.out.println("age:"+Outer01.this.age);
            System.out.println("a:"+this.a);
        }
    }
}