package NiuKe;

/**
 * @Author AceDJH
 * @Date 2020/4/22 15:38
 * 选择题中的一个，问这样运行，输出是什么
 */
public class ThreadTest {
    public static void main(String[] args) {
        Object a = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        a.wait();
                        System.out.println("aaaaaaaaa");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    a.notifyAll();
                    System.out.println("bbbbbb");
                }
            }
        }).start();
    }
}
