package callback;

/**
 * @Author AceDJH
 * @Date 2020/8/16 15:46
 */
public class CallbackTest {
    public static void main(String[] args) {
        Student student = new XiaoMing();
        Teacher teacher = new Teacher(student);

        teacher.askQuestion();
    }
}
