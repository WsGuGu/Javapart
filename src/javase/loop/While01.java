package javase.loop;

public class While01 {
    public static void main(String[] args) {
        int i=1;
        int sum=0;
        String a="pack";
        while (i<=100){
            sum=sum+i;
            i++;
        }
        System.out.println("sum = " + sum);
    }
}