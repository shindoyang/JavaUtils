package shindo.Java.async;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * java异步转同步第5种方法：CyclicBarrier 满人发车
 */
public class Demo5 extends BaseDemo{

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    @Override
    public void callback(long response) {
        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结束");

        try {
            cyclicBarrier.await();//这里栅栏是第二次计数，加上main方法的，一共2次，栅栏会被放倒，主线程就会继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        demo5.call();

        try {
            demo5.cyclicBarrier.await();//这里栅栏是第一次计数
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("主线程内容");
    }
}
