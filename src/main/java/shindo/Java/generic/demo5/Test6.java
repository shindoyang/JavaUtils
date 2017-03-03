package shindo.Java.generic.demo5;

public class Test6 {
    public static void main(String[] args) {
        Info<String> i1 = new Info<String>();
        Info<Object> i2 = null;
//        i2 = i1;// 这句会出错 incompatible types
    }
}
