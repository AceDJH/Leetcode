import java.util.concurrent.*;

/**
 * @Author AceDJH
 * @Date 2020/6/18 10:15
 */
public class ThreadDemo1 implements Runnable {
    // static很关键
    private char name;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    private char[] chars = new char[]{'a', 'b', 'c'};
    private static int count = 0;
    private static final Integer MAX_COUNT = 30;

    public ThreadDemo1(char name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (count < MAX_COUNT) {
            if (name == chars[count % 3]) {
                System.out.println(name + " " + count);
                count++;
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 20, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new ThreadDemo1('a'));
        threadPoolExecutor.execute(new ThreadDemo1('b'));
        threadPoolExecutor.execute(new ThreadDemo1('c'));
        threadPoolExecutor.shutdown();
    }
}
