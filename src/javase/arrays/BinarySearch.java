package javase.arrays;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={13,2,5,3,98,23,100,211,232,215,203};
        Arrays.sort(arr);
        System.out.println(myBinarySearch(arr,5));

    }
    public static int myBinarySearch(int[] arr,int value){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(value==arr[mid]){
                return mid;
            }
            if (value>arr[mid]){
                low=mid+1;
            }
            if (value<arr[mid]){
                high    =mid-1;
            }
        }
        return -1;
    }
}