package javase.arrays;

import java.util.Arrays;

public class Arrays04 {
    public static void main(String[] args) {
        int[] a={1,21,3};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a,3));
        Arrays.fill(a,1,3,3);
        System.out.println(Arrays.toString(a));
    }
}
