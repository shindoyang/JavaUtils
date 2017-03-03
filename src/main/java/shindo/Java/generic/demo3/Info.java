package shindo.Java.generic.demo3;

//通配符
public class Info<T> {
    private T var;// 定义泛型变量

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }

    /*
     * 重写是指从父类继承后，子类对父类某方法的具体实现进行修改，不能修改其方法名
                当System.out.println(对象)时，默认使用toString()方法，将对象转为字符串输出
      toString()方法继承于所有类的隐性基类（所有类的大哥大 Object类）
                如果某类无重写toString()方法，这时调用toString()将得到（类名+地址名名）这样的字符串
                改成别的方法名应该是不会出错的，是否你添加了重写标记
                改成别的方法名是不能称为“重写”的
     */
    @Override
    public String toString() { // 直接打印
        return this.var.toString();
    }
}
