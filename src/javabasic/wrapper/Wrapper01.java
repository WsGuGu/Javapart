package javabasic.wrapper;

public class Wrapper01 {
    public static void main(String[] args) {
        Integer a=new Integer(3);
        Integer b=Integer.valueOf(5);
        String c=b.toString();
        Integer d=Integer.valueOf("321");
        int e=d.intValue();
    }
}