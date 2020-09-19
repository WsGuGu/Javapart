package javabasic.annotation;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/16--11:07
 */
@GuguTable("gugu_student")
class GuguStudent {
    @GuguField(columnName = "id",type = "int",length = 10)
    private int id;
    @GuguField(columnName = "sname",type = "varchar",length = 10)
    private String studentName;
    @GuguField(columnName = "age",type = "int",length = 10)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
