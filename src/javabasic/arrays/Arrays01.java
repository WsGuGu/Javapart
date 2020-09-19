package javabasic.arrays;

public class Arrays01 {
    public static void main(String[] args) {
        int[] arr01=new int[10];
        String[] arr02=new String[10];
        for(int i=0;i<arr01.length;i++){
            arr01[i]=10*i;
        }
        for(int i=0;i<arr01.length;i++){
            System.out.println("arr01[]:"+arr01[i]);
        }
    }
}