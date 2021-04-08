package cyclic;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author AceDJH
 * @Date 2021/3/16 17:55
 * 将1W个数字进行计算
 */
public class Thread1 implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    // 存储要计算的数字
    private int[] num;
    // 要计算的数字下标（左）
    private int start;
    // 要计算的数字下标（右），左右闭区间
    private int end;
    // 保存结果
    private ArrayList<Long> list;
    // 相应下标
    private int index;

    private CyclicBarrier cyclicBarrier;

    public Thread1(int[] num, int start, int end, ArrayList<Long> list, int index, CyclicBarrier cyclicBarrier) {
        this.num = num;
        this.start = start;
        this.end = end;
        this.list = list;
        this.index = index;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = start; i <= end; i++){
            sum += num[i];
        }
        list.add(index, sum);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
