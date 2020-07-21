package javase.testjavaassist;

import javassist.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/20--17:40
 * 测试使用javassist创建一个新的类
 */
public class Javassist01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool=ClassPool.getDefault();
        CtClass cc=pool.makeClass("javase.testjavaassist.Emp");
        //创建属性
        CtField f1=CtField.make("private int empno;",cc);
        CtField f2=CtField.make("private String ename;",cc);
        cc.addField(f1);
        cc.addField(f2);
        CtMethod m1=CtMethod.make("public int getEmpno() {return empno;}",cc);
        CtMethod m2=CtMethod.make("public void setEmpno(int empno) { this.empno = empno; }",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);
        //添加构造器
        CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        constructor.setBody("{this.empno=empno;this.ename=ename;}");
        cc.addConstructor(constructor);
        //输出
        cc.writeFile("c:/");
    }
}
