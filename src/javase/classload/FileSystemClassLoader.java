package javase.classload;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/9/7--17:45
 * 自定义文件系统类加载器
 */
public class FileSystemClassLoader extends ClassLoader{
    private String rootDir;
    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c=findLoadedClass(name);
        //应该查询是否加载过此类
        if (c!=null){
            return c;
        }
        else {
            ClassLoader parent=this.getParent();
            return c;//删掉重写
        }
    }
}
