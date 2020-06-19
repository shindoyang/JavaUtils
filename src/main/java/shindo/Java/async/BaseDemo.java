package shindo.Java.async;

/**
 * 抽象类，提取了demo的公共方法
 * 有两个方法：
 * call方法，用于发起同步调用
 * callback方法，需要每个demo实现，主要在回调中进行相应的处理来达到异步调用转同步的目的。
 */
public abstract class BaseDemo {
    protected AsyncCall asyncCall = new AsyncCall();

    public abstract void callback(long response);

    public void call(){
        System.out.println("发起调用");
        asyncCall.call(this);
        System.out.println("调用返回");
    }
}
