package shindo.Java.generic.demo8;

//使用泛型统一传入的参数类型
public class Info<T> {
    private T var;

    public T getVar() {
        return this.var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return this.var.toString();
    }
}
