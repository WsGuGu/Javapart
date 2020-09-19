package javabasic.arrays;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] values={13,2,5,3,98,23,100,211,232,215,203};
        int temp=0;
        for (int i=0;i<values.length-1;i++){
        for(int j=0;j<values.length-1-i;j++){//
            if(values[j]>values[j+1]){//比较大小，大的往后
                temp=values[j+1];
                values[j+1]=values[j];
                values[j]=temp;
            }

        }}
        System.out.println(Arrays.toString(values));
    }
}
