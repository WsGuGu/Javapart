package javase.allscript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/18--16:58
 * 测试脚本引擎执行js代码
 */
public class Script01 {
    public static void main(String[] args) throws Exception {
        //获得脚本引擎对象
        ScriptEngineManager sem=new ScriptEngineManager();
        ScriptEngine engine=sem.getEngineByName("javascript");
        //定义变量,存储到引擎上下文中
        engine.put("msg","123,321");
        String str="var user = {name:'gugu',age:18,schools:['大学','机构的我']};";
        str +="print(user.name);";
        //执行脚本
        engine.eval(str);
        System.out.println(engine.get("msg"));
        engine.eval("msg='www.qc,co'");
        System.out.println(engine.get("msg"));
        //定义函数
        engine.eval("function add(a,b){var sum=a+b;return sum;}");
        //取得调用接口
        Invocable jsInvoke=(Invocable) engine;
        //执行脚本中定义的方法
        Object result1 =jsInvoke.invokeFunction("add",new Object[]{13,20});
        System.out.println(result1);
        //导入其他的java包，使用其他包中的java类
        String jsCode="var list=java.util.Arrays.asList([\"试试就试试\",\"家里蹲\",\"无理由\"]);";
        engine.eval(jsCode);
        List<String> list2=(List<String>)engine.get("list");
        for (String temp:list2){
            System.out.println(temp);
        }
        //执行一个文件
//        URL url=Script01.class.getClassLoader().getResource("xxx.js");
//        FileReader fileReader=new FileReader(url.getPath());
//        engine.eval(fileReader);
//        fileReader.close();
    }
}
