package shindo.Java.generic.demo10;

public class Demo<S> {
    private S info;

    public Demo(S info) {
        this.setInfo(info);
    }

    public void setInfo(S info) {
        this.info = info;
    }

    public S getInfo() {
        return this.info;
    }
}
