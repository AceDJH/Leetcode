package thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author AceDJH
 * @date 2021/9/3 10:10 下午
 */
public class TestAB {
    public static void main(String[] args) {
        BlockingQueue<List<Integer>> blockingQueue = new LinkedBlockingQueue<>();
        ThreadA threadA = new ThreadA(blockingQueue);
        ThreadB threadB = new ThreadB(blockingQueue);
        System.out.println("主线程开始");
        threadA.start();
        threadB.start();
        System.out.println("主线程结束");
    }
}
