package shindo.Java.corejava;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/**
 * Created by shindo.yang on 2017/9/29.
 */
public class ReflectTest2 {
    public static void main(String[] args) throws Exception{
        //反射的应用
        /*
         * getRealPath(); 金山词霸/内部路径
         * 一定记住要用完整的路径，但完整的路径不是硬编码，而是运算出来的
         */
        //InputStream ips = new FileInputStream("config.properties");//普通方法，在CLASSPATH类目录上加载

        //使用类加载器
        //方式一：推荐
        InputStream ips = Thread.currentThread().getContextClassLoader().getResourceAsStream("configClassLoader.properties");
        //方式二：
        //InputStream ips = ReflectTest2.class.getClassLoader().getResourceAsStream("configClassLoader.properties");

        //使用类的方式加载 : /表示类所在的根目录
        //InputStream ips = ReflectTest2.class.getResourceAsStream("/configClassLoader.properties");

        Properties props = new Properties();
        props.load(ips);
        ips.close();
        String className = props.getProperty("className");
        Collection collections = (Collection) Class.forName(className).newInstance();


        //Collection collections = new ArrayList();//size()=4,ArrayList是有序集合
        //Collection collections = new HashSet();//未重写hashCode()和equals()方法，size()=3，重写后size()=2
        //不重写equals()和hashCode()方法，HashSet对象比较的时候，默认是使用内存地址做hash值比较
        ReflectPoint pt1 = new ReflectPoint(3,3);
        ReflectPoint pt2 = new ReflectPoint(5,5);
        ReflectPoint pt3 = new ReflectPoint(3,3);

        collections.add(pt1);
        collections.add(pt2);
        collections.add(pt3);
        collections.add(pt1);


        /* 内存溢出的范例：
         * 当一个对象被存储进hashSet集合以后，就不能修改这个对象的那些参与进计算哈希值的字段了，
         * 否则，对象修改后的哈希值与最初存储进HashSet集合中时的哈希值就不同了，在这种情况下，
         * 即使在contains方法使用该对象的当前引用作为的参数去HashSet集合中检索对象，也将返回找不到对象的结果，
         * 这也会导致无法从HashSet集合中单独删除当前的对象。从而造成内存泄漏。
         */
        pt1.y = 7;
        collections.remove(pt1);//上一步改掉了pt1参数计算哈希值的y，所以pt1的hashCode的值变了，pt1已经不在原来的hash计算的区域了，所以删除不成功

        System.out.println(collections.size());
    }
}
