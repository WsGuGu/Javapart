package javase.jsscript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

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
    }
}
