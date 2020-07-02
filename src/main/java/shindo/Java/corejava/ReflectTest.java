package shindo.Java.corejava;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * java 反射 ：反射就是把java类中各种成分映射成相应的java类
 * Created by shindo.yang on 2017/9/27.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        String str1 = "shindo";
        //获取Class（字节码）的三种方式  ，一份字节码可以创建出多个Class实例对象
        Class cls1 = String.class;
        Class cls2 = str1.getClass();
        Class cls3 = Class.forName("java.lang.String");
        System.out.println(cls1 == cls2);//true  指向同一份字节码
        System.out.println(cls1 == cls3);//true  指向同一份字节码

        //九个预定义的Class实例对象：八个基本类型 boolean,byte,char,shot,int,long,float,double 和void
        System.out.println(cls1.isPrimitive());// false 是否原子类型
        System.out.println(int.class.isPrimitive());//true
        System.out.println(int.class == Integer.class);//false
        System.out.println(int.class == Integer.TYPE); //true , Integer.TYPE : 代表包装类型所代表的基本类型的字节码
        System.out.println(int[].class.isPrimitive());//false
        System.out.println(int[].class.isArray());//true, 判断一个class是否数组

        //构造方法反射 new String(new StringBuffer("abc"))
        Constructor constructor = String.class.getConstructor(StringBuffer.class);
        String str2 = (String)constructor.newInstance(new StringBuffer("abc"));//使用反射创建一个String对象
        System.out.println(str2.charAt(2));

        //局部变量的反射
        ReflectPoint pt1 = new ReflectPoint(3,5);
        Field fieldY = pt1.getClass().getField("y");
        //fieldY的值是多少？ 5, 错。fieldY不是对象上的变量，而是类上，要用它去取某个对象上对应的值。
        System.out.println(fieldY.get(pt1));//通过指定局部变量y是属于哪个对象的，从而确定y的值

        //暴力反射：获取私有的变量并使用
        Field fieldX =  pt1.getClass().getDeclaredField("x");
        fieldX.setAccessible(true);//设置私有变量的可操作性
        System.out.println(fieldX.get(pt1));

        //将任意一个对象中的所有String类型的成员变量所对应的字符串内容中的'b'改为'a'。
        changeStringValue(pt1);
        System.out.println(pt1);

        //方法的反射 str1.chatAt(1)
        Method methodChatAt = String.class.getMethod("charAt", int.class);
        //如果传递给Method对象的invoke()方法的第一个参数为null，这意味着该Method对象对应的是一个静态方法！
        System.out.println(methodChatAt.invoke(str1,1));
        //按jdk1.4的语法调用:因为从1.5开始才支持可变参数，所以1.4要传多个参数的时候使用数组解决
        System.out.println(methodChatAt.invoke(str1,new Object[]{2}));


        //写一个程序，这个程序能够根据用户提供的类名，去执行该类中的main方法。
        //TestArguments.main(new String[]{"111","222","333"});
        String startingClassName = "TestArguments";
        Method mainMethod = Class.forName(startingClassName).getMethod("main",String[].class);
        //因为向下兼容jdk1.4，所以new String[]{"111","222","333"}会被当成3个参数，和main方法的接收一个参数对不上,故会出现参数类型不正确的错误。
        // 解决方法有两个：
        //1. (Object)new String[]{"111","222","333"} 把String[] 作为一个对象，告诉编译期这不是一个数组，是一个对象，不用拆分
        //2. new Object[]{new String[]{"111","222","333"}} 直接把Sting[] 作为Object[]的一个元素
        mainMethod.invoke(null,new Object[]{new String[]{"111","222","333"}});

        //数组的反射
        int[] a1 = new int[3];
        int[] a2 = new int[4];
        int[][] a3 = new int[2][3];
        String[] a4 = new String[3];
        System.out.println(a1.getClass() == a2.getClass());//true
        //System.out.println(a1.getClass() == a4.getClass()); 编译不通过
        //System.out.println(a1.getClass() == a3.getClass()); 编译不通过
        System.out.println(a1.getClass().getName());// [I 解读：[表示是一个数组，I表示是int类型
        System.out.println(a1.getClass().getSuperclass().getName());//java.lang.Object
        System.out.println(a4.getClass().getSuperclass().getName());//java.lang.Object

        Object obj1 = a1;
        Object obj2 = a4;
        //Object[] obj3 = a1;//因为int是原子类型，不属于Object
        Object[] obj4 = a3;//可以理解为Object数组里面的元素是int数组，所以编译通过
        Object[] obj5 = a4;//String是Object的子类

        int[] a5 = new int[]{1,2,3};
        String[] a6 = new String[]{"aaa","bbb","ccc"};
        System.out.println(Arrays.asList(a5));//无法输出数组内容, 只输出对象地址。int是原子类型，故无法输出
        System.out.println(Arrays.asList(a6));//可正确输出数组内容, jdk1.4，可接收数组

        //数组反射的应用
        printObject(a6);
        printObject("mmy");

    }

    /**
     * 判断传入的参数是单个元素还是数组，是数组就逐一打印里面的元素值，否则打印该元素
     * @param obj 参数对象
     */
    private static void printObject(Object obj) {
        Class clazz = obj.getClass();
        if(clazz.isArray()){
            int len = Array.getLength(obj);
            for(int i = 0 ; i < len ; i++){
                System.out.println(Array.get(obj,i));
            }
        }else{
            System.out.println(obj);
        }
    }

    /**
     * 将任意一个对象中的所有String类型的成员变量所对应的字符串内容中的'b'改为'a'。
     * @param obj 参数对象
     * @throws Exception 异常
     */
    private static void changeStringValue(Object obj) throws Exception {
        Field[] fields = obj.getClass().getFields();
        for(Field field:fields){
//            if(field.getType().equals(String.class)){
              //这里用==可以显示水平专业，因为是同一份字节码
              if(field.getType() == String.class){//field.getType() 获取成员变量的类型
                    String oldValue = (String)field.get(obj);
                    String newValue = oldValue.replace('b','a');
                    field.set(obj,newValue);
            }
        }
    }
}

class TestArguments{
    public static void main(String[] args){
        for(String arg :args){
            System.out.println(arg);
        }
    }
}