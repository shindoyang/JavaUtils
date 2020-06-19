package shindo.Java.async;

import org.bouncycastle.jce.provider.symmetric.Grainv1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 主要验证异步转同步的5种方法：
 * 本类为异步调用模型
 */
public class AsyncCall {
    private Random random = new Random(System.currentTimeMillis());

    private ExecutorService tp = Executors.newSingleThreadExecutor();

    //demo 1，2，4，5的调用方法
    public void call(BaseDemo demo){
        new Thread(()->{
            long res = random.nextInt(10);
            try {
                Thread.sleep(res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.callback(res);
        }).start();
    }

    //demo3调用方法
    public Future<Long> futureCall(){
        return tp.submit(()->{
            long res = random.nextInt(10);
            try {
                Thread.sleep(res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return res;
        });
    }

    public void shutdown(){
        tp.shutdown();
    }
}
