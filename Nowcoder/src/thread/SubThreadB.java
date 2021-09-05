package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author AceDJH
 * @date 2021/9/3 10:22 下午
 */
public class SubThreadB extends Thread{
    CountDownLatch countDownLatch;
    Integer num;

    public SubThreadB(CountDownLatch countDownLatch, Integer num) {
        this.countDownLatch = countDownLatch;
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(this.getName() + "___" + num);
        countDownLatch.countDown();
    }
}
