package javabasic.thread;

public class LambdaTest02 {
    public static void main(String[] args) {
        ILove love=new Love();
        love.lambda(5);
        love=(int a)->{
            System.out.println("i don't like lambda"+a);
        };
        love.lambda(4);
        //省略
        love=(a)->{
            System.out.println("i don't like lambda"+a);
        };
//        love=a -> System.out.println("i don't like lambda"+a);
    }
}

interface ILove{
    void lambda(int a);
}

class Love implements ILove{

    @Override
    public void lambda(int a) {
        System.out.println("i like lambda"+a);
    }
}
