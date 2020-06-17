package javase.thread;
/**了解即可*/
import java.util.concurrent.*;

public class CDownLoader implements Callable<Boolean> {
    private String url;
    private String name;
    public CDownLoader(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader wd=new WebDownLoader();
        wd.download(url,name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownLoader cd1=new CDownLoader("","");
        CDownLoader cd2=new CDownLoader("","");
        CDownLoader cd3=new CDownLoader("","");
        ExecutorService ser= Executors.newFixedThreadPool(3);
        Future<Boolean> result1=ser.submit(cd1);
        Future<Boolean> result2=ser.submit(cd2);
        Future<Boolean> result3=ser.submit(cd3);
        boolean r1=result1.get();
        boolean r2=result2.get();
        boolean r3=result3.get();
        ser.shutdown();
    }
}
