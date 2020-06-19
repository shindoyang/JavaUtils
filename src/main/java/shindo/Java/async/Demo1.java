package shindo.Java.async;

/**
 * 异步转同步，方法一：wait + notify
 * 主线程发起调用后，利用wait进行阻塞，等待回调中调用notify或者notifyAll方法来进行阻塞。
 * 注意：要基于同一把锁
 */
public class Demo1 extends BaseDemo {

    private final Object lock = new Object();

    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结果");

        synchronized (lock){
            lock.notifyAll();
        }
    }

    public static void main(String[] args){
        Demo1 demo1 = new Demo1();
        demo1.call();
        synchronized (demo1.lock){
            try {
                demo1.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程内容");
    }
}
