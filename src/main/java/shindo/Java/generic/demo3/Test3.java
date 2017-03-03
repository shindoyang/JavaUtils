package shindo.Java.generic.demo3;

public class Test3 {
    public static void main(String[] args) {
        Info<String> i = new Info<String>();
        i.setVar("shindo");
        fun(i);
    }

    public static void fun(Info<?> temp) {
        System.out.println("内容：" + temp);

    }
}
