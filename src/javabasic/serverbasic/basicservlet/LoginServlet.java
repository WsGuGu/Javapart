package javabasic.serverbasic.basicservlet;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/13--17:34
 */
public class LoginServlet implements Servlet{
    @Override
    public void service(Request2 request,Response01 response01) {
        response01.print("<html>");
        response01.print("<head>");
        response01.print("<title>");
        response01.print("第一个servlet");
        response01.print("</title>");
        response01.print("</head>");
        response01.print("<body>");
        response01.print("终于回来了....."+request.getParameter("uname"));
        response01.print("</body>");
        response01.print("</html>");
    }
}