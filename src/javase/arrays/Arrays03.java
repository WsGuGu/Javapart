package javase.arrays;

public class Arrays03 {
    public static void main(String[] args) {
        String[] s1={"aa","bb","cc","dd","ee"};
        String[] s2=new String[10];
        System.arraycopy(s1,2,s2,6,3);
        for(int i=0;i<s2.length;i++){
            System.out.println(s2[i]);
        }
    }
}
