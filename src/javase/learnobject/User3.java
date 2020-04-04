package javase.learnobject;

public class User3 {
    int id;
    String name;
    static String comp;
    static {
        System.out.println("执行类的初始化");
        comp="我的公司";
        print();
    }
    public static void print(){
        System.out.println(comp);
    }

    public static void main(String[] args) {
        User3 a=null;
    }
}
