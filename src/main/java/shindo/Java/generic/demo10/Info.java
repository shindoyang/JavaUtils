package shindo.Java.generic.demo10;

//泛型的嵌套设置
public class Info<T, V> {// 接收两个泛型类型
    private T var;
    private V value;

    public Info(T var, V value) {
        this.setVar(var);
        this.setValue(value);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public T getVar() {
        return this.var;
    }

    public V getValue() {
        return this.value;
    }

}
