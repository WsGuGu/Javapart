package javabasic.testjavaassist;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/24--17:28
 */
public class Emp {
    private int empno;
    private String ename;

    public Emp() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }
    public void sayHello(int a){
        System.out.println("sayHello,"+a);
    }
}
