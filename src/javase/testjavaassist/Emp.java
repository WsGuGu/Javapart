package javase.testjavaassist;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/20--17:52
 */
public class Emp {
    private int empno;
    private String ename;

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
}
