package callback;

/**
 * @Author AceDJH
 * @Date 2020/8/16 15:45
 */
public class XiaoMing implements Student {
    @Override
    public void resolveQuestion(Callback callback) {
        try {
            System.out.println("小明开始解决问题");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.tellAnswer(5);
    }
}
