package thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author AceDJH
 * @date 2021/9/3 10:13 下午
 */
public class ThreadB extends Thread{
    BlockingQueue<List<Integer>> blockingQueue;
    CountDownLatch countDownLatch;
    public ThreadB(BlockingQueue<List<Integer>> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("B线程开始");
            List<Integer> list = blockingQueue.take();
            countDownLatch = new CountDownLatch(list.size());
            for (Integer integer : list) {
                new SubThreadB(countDownLatch, integer).start();
            }
            countDownLatch.await();
            System.out.println("B子线程运行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
