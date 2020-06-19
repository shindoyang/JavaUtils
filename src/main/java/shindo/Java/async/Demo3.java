package shindo.Java.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步转同步方案：试用线程的future特性
 * 在call方法中调用futureCall方法，方法中会向线程池tp提交一个Callable，然后返回一个Future。
 * 这个futurej就是我们demo3中得到的，得到Future对象之后就可以关闭线程池拉。
 */
public class Demo3 {
    private AsyncCall asyncCall = new AsyncCall();

    public Future<Long> call(){
        Future<Long> future = asyncCall.futureCall();
        asyncCall.shutdown();
        return future;
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        System.out.println("发起调用");
        Future<Long> future = demo3.call();
        System.out.println("调用结果");

        //判断执行状态，知道执行完或被取消，才往下执行。
        while (!future.isDone() && !future.isCancelled());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程内容");


    }
}
