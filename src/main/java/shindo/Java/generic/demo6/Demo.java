package shindo.Java.generic.demo6;

//泛型方法
public class Demo {
    public <T> T fun(T t) {// 可以接收任意类型的数据
        return t;// 直接把参数返回
    }
}
