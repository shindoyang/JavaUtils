package shindo.Java.generic.demo3;

//通配符
public class Info<T> {
    private T var;

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }

    @Override
    public String toString() {
        return this.var.toString();
    }
}
