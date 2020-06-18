package javase.thread;

public class LambdaTest01 {
    public static void main(String[] args) {
        ILike like=new Like();
        like.lambda();
        like=()->{
            System.out.println("i don't like lambda");
        };
        like.lambda();
    }
}
interface ILike{
    void lambda();
}
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
