package javase.serverbasic.basicservlet;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/13--17:32
 */
public class RegisterServlet implements Servlet{
    @Override
    public void service(Request2 request,Response01 response01) {
        System.out.println("RegisterServlet");
    }
}