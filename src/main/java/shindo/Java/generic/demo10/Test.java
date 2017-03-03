package shindo.Java.generic.demo10;

public class Test {
    public static void main(String[] args) {
        Demo<Info<String, Integer>> d = null;// 将Info作为Demo的泛型类型
        Info<String, Integer> i = null;// Info指定两个泛型类型
        i = new Info<String, Integer>("shindo", 18);// 实例化Info对象
        d = new Demo<Info<String, Integer>>(i);// 在Demo类中设置Info类的对象
        System.out.println("内容一：" + d.getInfo().getVar());
        System.out.println("内容二：" + d.getInfo().getValue());

    }
}
