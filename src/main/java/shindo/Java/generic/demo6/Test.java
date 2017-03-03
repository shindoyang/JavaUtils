package shindo.Java.generic.demo6;

public class Test {
    public static void main(String[] args) {
        Demo d = new Demo();
        String str = d.fun("shindo");
        int i = d.fun(30);
        System.out.println(str);
        System.out.println(i);

    }
}
