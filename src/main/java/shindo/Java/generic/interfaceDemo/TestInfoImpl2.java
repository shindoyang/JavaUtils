package shindo.Java.generic.interfaceDemo;

public class TestInfoImpl2 {
    public static void main(String[] args) {
        Info i = null;
        i = new InfoImpl2("shindo");
        System.out.println("content:" + i.getVar());

    }
}
