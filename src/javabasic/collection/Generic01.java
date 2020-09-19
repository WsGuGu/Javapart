package javabasic.collection;

public class Generic01 {
    public static void main(String[] args) {
        MyCollection<String> mc=new MyCollection<>();
        mc.set("whj",0);
        String a=mc.get(0);
        System.out.println(a);



    }
}
class MyCollection<E>{
    Object[] objs=new Object[5];
    public void set(E obj,int index){
        objs[index]=obj;
    }
    public E get(int index){
        return (E)objs[index];
    }
}