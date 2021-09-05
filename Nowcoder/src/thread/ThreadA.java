package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author AceDJH
 * @date 2021/9/3 10:07 下午
 */
public class ThreadA extends Thread{
    BlockingQueue<List<Integer>> blockingQueue;

    public ThreadA(BlockingQueue<List<Integer>> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("A线程开始");
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(i);
        }
        try {
            blockingQueue.put(lists);
            System.out.println("A线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
