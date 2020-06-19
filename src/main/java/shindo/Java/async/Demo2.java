package shindo.Java.async;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 异步转同步，方法一：Conndition
 * 主线程发起调用后，利用wait进行阻塞，等待回调中调用notify或者notifyAll方法来进行阻塞。
 * 注意：要基于同一把锁
 */
public class Demo2 extends BaseDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition con = lock.newCondition();

    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结果");
        lock.lock();
        try {
            con.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        Demo2 demo2 = new Demo2();

        demo2.call();
        demo2.lock.lock();
        try {
            demo2.con.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            demo2.lock.unlock();
        }
        System.out.println("主线程内容");
    }
}
