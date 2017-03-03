package shindo.Java.generic.demo3;

public class Test3 {
    public static void main(String[] args) {
        Info<String> i = new Info<String>();// 使用String为泛型类型
        i.setVar("shindo");// 设置内容
        fun(i);
    }

    public static void fun(Info<?> temp) {// 泛型中使用？通配符，标识可以接收任意泛型对象
        System.out.println("内容：" + temp);

    }
}
