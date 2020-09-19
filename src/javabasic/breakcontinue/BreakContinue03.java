package javabasic.breakcontinue;

public class BreakContinue03 {
    public static void main(String[] args) {
        outer:for (int i=101;i<150;i++){
        for (int j=2;j<i/2;j++){
            if(i%j==0){
                continue outer;
            }
        }
            System.out.print(i+"  ");
        }
    }
}
