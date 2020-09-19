package javabasic.dynamiccompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/17--16:38
 */
public class Dynamic01 {
    public static void main(String[] args) throws IOException {
        String a="D:\\programming\\programming_workingspace\\exercise\\java\\src\\javase\\loop\\For02.java";
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        int result= compiler.run(null,null,null,a);
        System.out.println(result==0?"编译成功":"编译失败");

        Runtime run=Runtime.getRuntime();
        Process process=run.exec("java -cp D:\\programming\\programming_workingspace\\exercise\\java\\src\\javase\\loop For02");
        InputStream in=process.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String info="";
        while ((info=reader.readLine())!=null){
            System.out.println(info);
        }
    }
}