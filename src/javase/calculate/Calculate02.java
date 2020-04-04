package javase.calculate;

public class Calculate02 {
    public static void main(String[] args) {
        int a=3;
        int b=a++;
        System.out.println("a="+a+"\tb="+b);
        a=3;
        b=++a;
        System.out.println("a="+a+"\tb="+b);
    }
}