package shindo.Java.generic.demo5;

//泛型无法想法转型
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
