package shindo.Java.corejava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * ArrayList<E>类定义和ArrayList<Integer>类引用中涉及如下术语：
 * 整个称为ArrayList<E>泛型类型
 * ArrayList<E>中E称为类型变量或类型参数
 * 整个ArrayList<Integer>称为参数化的类型
 * ArrayList<Integer>中的Integer称为类型参数的实例或实际类型参数
 * ArrayList<Integer>中的<>念typeof
 * ArrayList称为原始类型
 *
 * 参数化类型与原始类型的兼容性
 * 参数化类型可以引用一个原始类型的对象，编译报告警告，例如，
 * Collection<String> c =  new Vector();
 * 原始类型可以引用一个参数化类型的对象，编译报告警告，例如，
 * Collection c =  new Vector<String>();
 *
 * 参数化类型不考虑类型参数的继承关系
 * Vector<String> v = new Vector<Object>();//错误
 * Vector<Object> v = new Vector<String>();//错误
 *
 * 在创建数组实例的时候，数组的元素不能使用参数化的类型，例如，下面语句有错误，
 * Vector<Integer> vectorList[] = new Vector<Integer>[10];
 * 
 *
 * Created by shindo on 2017/10/5.
 */
public class GenericTest {
    public static void main(String[] args) throws Exception{
        ArrayList collection1 = new ArrayList();
        collection1.add(1);
        collection1.add(1L);
        collection1.add("abc");
        //int i = (Integer) collection1.get(1);//即使强制类型转换，转换的结果也是不对的

        ArrayList<String> collection2 = new ArrayList<String>();
        //collection2.add(1);
        //collection2.add(1L);
        collection2.add("abc");
        String element = collection2.get(0);//即使强制类型转换，转换的结果也是不对的

        Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
        String str2 = constructor.newInstance(new StringBuffer("abc"));//使用反射创建一个String对象
        System.out.println(str2.charAt(2));

        //泛型是提供给编译器识别的，到虚拟机的时候就是同一份字节码，所以下面的比较结果为true
        ArrayList<Integer> collection3 = new ArrayList<Integer>();
        System.out.println(collection2.getClass() == collection3.getClass());

        //由于编译生成的代码会去掉泛型的类型信息，只要跳过编译器，j就可以往某个泛型集合中j加入其它类型的数据，例如，
        //用反射得到集合，再调用其add方法
//        collection3.add("efg");//编译器报错
        collection3.getClass().getMethod("add",Object.class).invoke(collection3,"efg");
        System.out.println(collection3.get(0));

        //定义一个方法，该方法用于打印出任意参数化类型的集合中的所有数据。
        printCollection(collection3);

        //限定通配符总是包括自己
        //限定通配符的上边界
        Vector<? extends Number> x1 = new Vector<Integer>();//正确
        //Vector<? extends Integer> x1 = new Vector<Number>();//错误
        //Vector<? extends Integer> x1 = new Vector<String>();//错误

        //限定通配符的下边界
        Vector<? super Integer> x2 = new Vector<Number>();//正确
        //Vector<? super Number> x2 = new Vector<Integer>();//错误
        //Vector<? super Number> x2 = new Vector<Byte>();//错误

        //泛型的综合应用
        HashMap<String,Integer> maps = new HashMap<String, Integer>();
        maps.put("zxx",28);
        maps.put("lhm",35);
        maps.put("flx",33);
        Set<Map.Entry<String,Integer>> entrySet = maps.entrySet();
        for(Map.Entry<String,Integer> entry :entrySet){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        add(3,2);
        //类型推断为两个参数的最大公约数
        Number x3 = add(3.5,4);
        Object x4 = add(3,"abc");

        String[] arr1 = new String[]{"abc","xyz","itcast"};
        swap(arr1,1,2);
        for(String arr : arr1){
            System.out.println(arr);
        }
//        swap(new int[]{1,2,3,4,5},3,4);//只有引用类型才能作为泛型的实际参数，所以这里编译报错。

        /*在应用泛型的时候可以使用extands限定符，在定义泛型的时候也可以使用extengds限定符
        如Class.getAnnotation()方法的定义。并且可以使用&来指定多个边界，如
        <V extends Serializable&cloneable> void method(){}

        普通方法、构造方法、静态方法中都可以使用泛型。编译器不允许创建类型变量的数组。
         */

        Object obj = "abc";
        String x6 = autoConvert(obj);

        copy1(new Vector<String>(),new String[10]);
        copy2(new Date[10],new String[10]);//Date和String的交集是Object，所以没问题
        //copy1(new Vector<Date>(),new String[10]);//已经限定了泛型的T是Date,不能转Object了，所以编译报错

        GenericDao<ReflectPoint> genericDao = new GenericDao<ReflectPoint>();
        genericDao.add(new ReflectPoint(3,3));
        genericDao.update(new ReflectPoint(3,3));

        //Vector<Date> v1 = new Vector<Date>();//这种方式是没有办法获取对象泛型的参数类型
        //使用泛型获得对象的参数类型
        Method applyMethod = GenericTest.class.getMethod("applyVector", Vector.class);
        Type[] types = applyMethod.getGenericParameterTypes();
        ParameterizedType pType = (ParameterizedType) types[0];
        System.out.println(pType.getRawType());//java.util.Vector
        System.out.println(pType.getActualTypeArguments()[0]);//java.util.Date


    }

    public static void applyVector(Vector<Date> v1){

    }

    //定义一个方法，把任意参数类型的集合中的数据安全地复制到相应类型的数组中（这个要用泛型的方法来做，保证类型安全）
    public static <T> void copy1(Collection<T> dest, T[] src){}

    //定义一个方法，把任意参数类型的一个数组中的s护具安全地复制到相应类型的另一个数组中。
    public static <T> void copy2(T[] dest,T[] arc){}

    //定义一个方法，可以将任意类型数组中的所有元素填充为相应类型的某个对象。
    private static <T> void fillArray(T[] a , T obj){
        for(int i = 0; i< a.length;i++){
            a[i] = obj;
        }

    }

    //编写一个泛型方法，自动将Object类型的对象转换成其他类型
    private static <T> T autoConvert(Object obj){
        return (T)obj;
    }

    //交换数组中两个元素的位置
    private static <T> void swap(T[] a ,int i , int j){
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

    }

    //自定义类型必须在返回值之前，使用< >表示，如下add方法的返回值前的<T>
    private static <T> T add(T x ,T y){
        return null;
    }

    public static void printCollection(Collection<?> collection ){
//        collection.add(1);//不能调用与参数类型有关的方法
        System.out.println(collection.size());
        for(Object obj : collection){
            System.out.println(obj);
        }
    }

    //打印任意类型集合里面的类型(使用泛型)，但是通配符方法比泛型方法更有效
    public static <T> void printCollection2(Collection<T> collection ){
        System.out.println(collection.size());
        for(Object obj : collection){
            System.out.println(obj);
        }
    }

}
