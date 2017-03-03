package shindo.Java.generic.interfaceDemo;

public class InfoImpl2 implements Info<String> {// 定义泛型为string的接口子类
    private String var;

    public InfoImpl2(String var) {
        this.setVar(var);
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getVar() {
        return this.var;
    }

}
