package shindo.Java.generic.demo7;

//通过泛型方法返回泛型类型实例
public class Info<T extends Number> {// 指定上线，只能是数字类型
    private T var;// 此类型由外部决定

    public T getVar() {
        return this.var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public String toString() {// 覆写Object类中的toString()方法
        return this.var.toString();
    }
}
