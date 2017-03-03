package shindo.Java.generic.demo4;

public class Test5 {
    public static void main(String[] args) {
        Info<String> i1 = new Info<String>();
        Info<Object> i2 = new Info<Object>();
        i1.setVar("hello");
        i2.setVar(new Object());
        fun(i1);
        fun(i2);
    }

    public static void fun(Info<? super String> temp) {// 只能接收String 或Object类型的泛型
        System.out.println(temp);
    }

}
