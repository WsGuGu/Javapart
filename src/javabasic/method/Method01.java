package javabasic.method;

public class Method01 {
    public static void main(String[] args) {
        Method01 mh= new Method01();
        mh.printMsg();
        System.out.println(mh.sum(1,2,3));
    }
    void printMsg(){
        System.out.println("123123");
    }
    int sum(int a,int b,int c){
        int sum=a+b+c;
        return sum;
    }
}