package shindo.Java.corejava;

/**
 * java虚拟机中可以安装多个类加载器，系统默认三个主要类加载器，每个类加载器负责加载特定位置的类:
 * Bootstrap,ExtClassLoader,AppClassLoader
 *
 * 类加载器也是java类，因为其是java类，所以类加载器本身也要被类加载器加载，显然必须有第一个类加载器不是java类，这正是BootStrap
 * 其使用C++实现，嵌套在虚拟机内核里。
 *
 * 类加载器使用的父子继承的树状组织结构，加载类时，使用委托机制，优先由上级类加载器加载。继承关系如下
 * BootStrap(JRE/lib/rt.jar)-->ExtClassLoader(JRE/lib/ext/*.jar)-->APPClassLoader(CLASSPATH指定的所有jar或目录)
 * -->自定义类加载器（比如，要加载自己重写System类，需避开委托机制，使用自己写的类加载器加载，不然永远都会被顶级类加载器加载rt包中的System类）
 *
 * Created by shindo on 2017/10/8.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println(System.class.getClassLoader());//null ,其使用BootStrap加载

        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while(loader != null){
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
        System.out.println(loader);

    }
}
