package cyclic;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Author AceDJH
 * @Date 2021/3/16 17:54
 * 给定1万个数字，多个个线程并发计算这1万个数字的和，输出最终的结果（可查资料，可借助IDE）
 */
public class Test {
    public static void main(String[] args) {
        int threadCount = 5;
        ArrayList<Long> list = new ArrayList<>(threadCount);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount + 1);
        // 存储需要计算的1W个数字
        int[] num = new int[10000];
        for (int i = 0; i < 10000; i++) {
            num[i] = (int) (Math.random() * 100);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadCount, threadCount, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
        for (int start = 0, end = 1999, index = 0; start < 8000; start += 2000, end += 2000, index++){
            threadPoolExecutor.execute(new Thread1(num, start, end, list, index, cyclicBarrier));
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("计算总和为：" + sum);
    }
}
