package callback;

/**
 * @Author AceDJH
 * @Date 2020/8/16 15:42
 */
public class Teacher implements Callback{
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        System.out.println("老师提出问题");
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}
