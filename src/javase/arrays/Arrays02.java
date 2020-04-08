package javase.arrays;

public class Arrays02 {
    public static void main(String[] args) {
        int[] arr01=new int[10];
        String[] arr02=new String[10];
        for(int i=0;i<arr01.length;i++){
            arr01[i]=10*i;
        }
        for(int i:arr01){
            System.out.println(i);
        }
    }
}
