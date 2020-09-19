package javabasic.method;

public class Method02 {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }
    static long factorial(int n){
        if (n==1){
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }
}