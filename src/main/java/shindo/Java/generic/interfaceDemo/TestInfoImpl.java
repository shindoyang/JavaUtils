package shindo.Java.generic.interfaceDemo;

public class TestInfoImpl {
    public static void main(String[] args) {
        Info<String> i = null;// 声明接口对象
        i = new InfoImpl<String>("shindo");// 通过子类实例化对象
        System.out.println("内容：" + i.getVar());
    }

}
